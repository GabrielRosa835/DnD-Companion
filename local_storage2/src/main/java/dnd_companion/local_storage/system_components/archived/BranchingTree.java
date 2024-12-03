package dnd_companion.local_storage.system_components.archived;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

import dnd_companion.local_storage.system_components.ToolBox;

public class BranchingTree<T> {
    private TreeMap<T, Node> tree = new TreeMap<>();
    public TreeMap<T, Node> tree() { return this.tree; }

    private Class<T> tree_type;

    private Map.Entry<T, Node> root;
    public Map.Entry<T, Node> root() { return this.root; }

    private Map.Entry<T, Node> current;
    public Map.Entry<T, Node> current() { return this.current; }

    public BranchingTree(Class<T> tree_type) {
        this.tree = new TreeMap<>();
        this.root = null;
        this.current = null;
        this.tree_type = tree_type;
    }

    @SuppressWarnings("unchecked")
    public BranchingTree(Node root, Collection<Node> nodes) {
        if (root.prev() != null) {
            throw new InvalidNodeException("The root-node can't have any previous-pointer");
        }
        this.root = new SimpleEntry<>(root.object(), root);
        this.tree_type = (Class<T>) root.object().getClass();
        this.tree.put(this.root.getKey(), this.root.getValue());
        for (Node node : nodes) {
            try {
                Node validated_node = validate_node(node);
                this.tree.put(validated_node.object(), validated_node);
            } catch (InvalidNodeException e) {
                ToolBox.print_err(e);
            }
        }
    }

    public TreeMap<T, Node> add_node(Node node) {
        if (this.tree.isEmpty()) {
            // Adding a root node
            if (node.prev() != null) {
                throw new InvalidNodeException("The root node can't have any previous pointer");
            }
            this.root = new SimpleEntry<>(node.object(), node);
            this.current = this.root;
        } else {
            // Adding a non-root node
            if (node.prev() == null) {
                throw new InvalidNodeException("The tree already has a root-node");
            }
            validate_node(node);
        }
        this.tree.put(node.object(), node);
        return this.tree;
    }

    public Node create_node(T object, T prev_pointer, Collection<T> next_pointers) {
        return new Node(object, prev_pointer, next_pointers);
    }

    @SuppressWarnings("unchecked")
    public Collection<Node> collect(Node... nodes) {
        boolean allNodes = Arrays.stream(nodes).allMatch(node -> node instanceof Node);
        if (!allNodes) {
            throw new IllegalArgumentException("All elements must be instances of Node");
        }
        return Arrays.stream(nodes).collect(Collectors.toList());
    }

    // Every node must not have a null previous-pointer, except the root,
    // it can't have duplicate next-pointers,
    // and two nodes can't have the same next-pointer
    private Node validate_node(Node node) throws InvalidNodeException {
        Collection<T> next_pointers = node.next();
        HashSet<T> next_pointer_set = new HashSet<>(next_pointers);

        if (node.prev() == null) {
            throw new InvalidNodeException(String.format("Node must have a previous pointer: %s", node.toString()));
        }
        if (!this.tree.containsKey(node.prev())) {
            throw new InvalidNodeException(String.format("Previous pointer does not point to a valid node in the tree: %s", node.toString()));
        }
        if (next_pointer_set.size() != next_pointers.size()) {
            throw new InvalidNodeException(String.format("Duplicate next pointers found: %s", node.toString()));
        }
        for (T next_pointer : next_pointers) {
            if (this.tree.values().stream().anyMatch(n -> n.next().contains(next_pointer))) {
                throw new InvalidNodeException(String.format("Next pointer already exists in another node: %s", node.toString()));
            }
        }
        return node;
    }

    public TreeMap<T, Node> remove_node(T pointer) {
        Node node = this.tree.get(pointer);
        if (node == null) {
            throw new IllegalArgumentException("Node not found in the tree");
        }
        if (node.prev() == null) {
            throw new IllegalArgumentException("Can't remove the tree root");
        }

        // Update the previous-node's next pointers
        T prev_pointer = node.prev();
        if (prev_pointer != null) {
            Node prev_node = this.tree.get(prev_pointer);
            Collection<T> updated_next_pointers = prev_node.next().stream()
                    .filter(p -> !p.equals(pointer))
                    .collect(Collectors.toList());
            prev_node.next(updated_next_pointers);
        }

        // Update the next-nodes' previous pointers
        Collection<T> next_pointers = node.next();
        for (T next_pointer : next_pointers) {
            Node next_node = this.tree.get(next_pointer);
            next_node.prev(prev_pointer);
        }

        // Remove the node from the tree
        this.tree.remove(pointer);

        return this.tree;
    }

    public TreeMap<T, Node> next(T pointer) {
        Collection<T> pointers = this.current.getValue().next();
        Optional<T> next_pointer = pointers.stream().filter(t -> t.equals(pointer)).findFirst();

        if (next_pointer.isPresent()) {
            Node next_node = this.tree.get(next_pointer.get());
            this.current = new SimpleEntry<>(next_pointer.get(), next_node);
        } else {
            throw new NullPointerException("There's no next node for the current one");
        }

        return this.tree;
    }

    public TreeMap<T, Node> prev() {
        Optional<T> prev_pointer = Optional.ofNullable(this.current.getValue().prev());

        if (prev_pointer.isPresent()) {
            Node prev_node = this.tree.get(prev_pointer.get());
            this.current = new SimpleEntry<>(prev_pointer.get(), prev_node);
        } else {
            throw new NullPointerException("There's no previous node for the current one");
        }
        return this.tree;
    }

    public boolean has_next() {
        return !this.current.getValue().next().isEmpty();
    }

    @Override public String toString() {
        String string = String.format("BranchingTree<%s>: ", tree_type.getSimpleName());
        BranchingTree<T> decoy_tree = this.clone();
        Node root = this.root().getValue();
        String root_text = String.format("[Root-Node: [object=%s, previous=%s, next=(%s)]", root.object(), root.prev(), root.next().toString());

        string = string.concat(root_text);

        for (Node node : decoy_tree.tree().values()) {
            String node_text = String.format(", Node: [object=%s, previous=%s, next=(%s)]", node.object(), node.prev(), node.next().toString());
            string = string.concat(node_text);
        }

        return string;
    }

    @Override public BranchingTree<T> clone() {
        TreeMap<T, Node> tree = new TreeMap<>(this.tree());
        tree.remove(this.root().getKey());

        Collection<Node> nodes = tree.values();

        return new BranchingTree<>(this.root().getValue(), nodes);
    }

    public class Node {
        private T object;
        public T object() { return this.object; }
        public T object(T object) { return this.object = object; }

        private T prev_pointer;
        public T prev() { return this.prev_pointer; }
        public T prev(T prev_pointer) { return this.prev_pointer = prev_pointer; }

        private Collection<T> next_pointers;
        public Collection<T> next() { return this.next_pointers; }
        public Collection<T> next(Collection<T> next_pointers) { return this.next_pointers = next_pointers; }

        public Node(T object, T prev_pointer, Collection<T> next_pointers) {
            this.object = object;
            this.prev_pointer = prev_pointer;
            this.next_pointers = next_pointers;
        }
    }
}