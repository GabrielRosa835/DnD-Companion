package atomic;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class ElementCluster<IElement extends Element, IElementCollection extends ElementCluster<IElement, IElementCollection>>
{
	protected Set<IElement> values;
	public Set<IElement> values() {return this.values;}
	
	public ElementCluster() {
		this.values = new HashSet<IElement>();
	}
	public ElementCluster(Collection<IElement> elements) {
		for (IElement element : elements) {
			this.values.add(element);
		}
	}
	public ElementCluster(IElementCollection element_cluster) {
		for (IElement tag : element_cluster.values) {
			this.values.add(tag);
		}
	}

	public boolean contains(String element_name) {
	    for (IElement element : this.values) {
	        if (element.name().equals(element_name)) {
	            return true;
	        }
	    }
	    return false;
	}
	public IElement get(String element_name) {
	    for (IElement element : this.values) {
	        if (element.name().equals(element_name)) {
	            return element;
	        }
	    }
	    return null;
	}

	
	@SuppressWarnings("unchecked")
	public IElement[] to_array(Class<IElement> element_class) {
        return this.values.toArray((IElement[]) Array.newInstance(element_class, this.values.size()));
    }
    
	@SuppressWarnings("unchecked")
	public IElementCollection remove(Collection<IElement> elements) {
		this.values.removeAll(elements);
		return (IElementCollection) this;
    }

    @SuppressWarnings("unchecked")
	public IElementCollection gather(Collection<IElement> elements) {
    	this.values.addAll(elements);
		return (IElementCollection) this;
    }

    @SuppressWarnings("unchecked")
	public IElementCollection merge(Collection<IElementCollection> element_clusters) {
    	for (IElementCollection element_cluster : element_clusters) {
    		this.values.addAll(element_cluster.values());
    	}
        return (IElementCollection) this;
    }
}
