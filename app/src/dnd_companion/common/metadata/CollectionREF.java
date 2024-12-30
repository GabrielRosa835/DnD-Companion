package dnd_companion.common.metadata;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import dnd_companion.local_storage.structure.models.Data;

public class CollectionREF
{
	private String name;
	public String name() {return this.name;}
	
	private CollectionREF parent;
	public CollectionREF parent() {return this.parent;}
	
	private Class<? extends Data> type;
	public Class<? extends Data> type() {return this.type;}
	
	private Collection<CollectionREF> children;
	public CollectionREF[] children() {return this.children.toArray(CollectionREF[]::new);}
	
	public CollectionREF(CollectionREF parent, String name, Class<? extends Data> type, CollectionREF... children) {
		this.parent = parent;
		this.name = name;
		this.type = type;
		this.children = Arrays.stream(children).collect(Collectors.toList());
		if (parent != null) {
			parent.add_child(this);
		}
	}
	public CollectionREF(CollectionREF parent, String name) {
		this(parent, name, Data.class, new CollectionREF[] {});
	}
	public CollectionREF(CollectionREF parent, String name, Class<? extends Data> type) {
		this(parent, name, type, new CollectionREF[] {});
	}
	
	public CollectionREF child(String child_name) {
		return this.children.stream()
				.filter(c -> c.name.equals(child_name))
				.findFirst()
				.orElse(null);
	}
	public CollectionREF add_child(CollectionREF child) {
		this.children.add(child);
		return this;
	}
	public String path() {
		String path = this.name;
		CollectionREF next_parent = this.parent;
		do {
			path = String.format("%s\\%s", next_parent.name(), path);
			next_parent = next_parent.parent();
		} while(next_parent != null);
		return path;
	}
	@Override
    public String toString() {
        return String.format("Collection[name=%s,parent=%s,children=%s]", 
                this.name(), this.parent != null ? this.parent.name() : "null", Arrays.toString(this.children()));
    }
}
