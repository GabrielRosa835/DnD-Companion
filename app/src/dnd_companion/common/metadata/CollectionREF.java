package dnd_companion.common.metadata;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import dnd_companion.archives.local_storage.structure.models.Data;

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
		while(!next_parent.name().equals("seed")) {
			path = next_parent.name() + File.separator + path;
			next_parent = next_parent.parent();			
		}
		return path;
	}
	
	@Override public String toString() {
		List<String> children = Arrays.stream(this.children())
						.map(c -> c.name())
						.collect(Collectors.toList());
		String children_text = children.isEmpty()? "none" : Arrays.toString(children.toArray());
		String parent_text = this.parent != null ? this.parent.name() : "none"; 
        return String.format("Collection[name=%s,parent=%s,children=%s]", 
                this.name(), 
                parent_text,
                children_text);
    }
	@Override public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    CollectionREF other = (CollectionREF) obj;
	    return this.name.equals(other.name());
	}
}
