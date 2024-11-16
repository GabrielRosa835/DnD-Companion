package atomic;

import java.util.Collection;
import java.util.Map;
import java.lang.reflect.Array;
import java.util.*;

public abstract class GroupManager<MapKey, IGroup, IManager extends GroupManager<MapKey, IGroup, IManager>> 
{
    protected Map<MapKey, IGroup> mapping;
    public Map<MapKey, IGroup> mapping() {return this.mapping;}
    
    protected abstract void add_element(IGroup group);
    protected abstract void remove_element(IGroup group);

    public GroupManager() {
        this.mapping = new HashMap<MapKey, IGroup>();
    }
    public GroupManager(Collection<IGroup> groups) {
    	this.mapping = new HashMap<MapKey, IGroup>();
    	this.gather(groups);
    }
    public GroupManager(IManager manager) {
        this.mapping = new HashMap<MapKey, IGroup>(manager.mapping());
    }

    @SuppressWarnings("unchecked")
	public IGroup[] to_array(Class<IGroup> element_class) {
        return this.mapping.values().toArray((IGroup[]) Array.newInstance(element_class, this.mapping.size()));
    }
    
	@SuppressWarnings("unchecked")
	public IManager remove(Collection<IGroup> groups) {
        for (IGroup element : groups)
        	this.remove_element(element);
        return (IManager) this;
    }

    @SuppressWarnings("unchecked")
	public IManager gather(Collection<IGroup> groups) {
        for (IGroup element : groups)
        	this.add_element(element);
        return (IManager) this;
    }

    @SuppressWarnings("unchecked")
	public IManager merge(Collection<IManager> managers) {
        for (IManager manager : managers)
        	this.gather(manager.mapping().values());
        return (IManager) this;
    }
}
