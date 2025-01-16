package dnd_companion.game_helper.actors.models;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractManager<MapKey, IGroup, IManager extends AbstractManager<MapKey, IGroup, IManager>>
{
    protected Map<MapKey, IGroup> mapping;
    public Map<MapKey, IGroup> mapping() {return this.mapping;}

    protected abstract void add(IGroup group);
    protected abstract void remove(IGroup group);

    public AbstractManager() {
        this.mapping = new HashMap<>();
    }
    public AbstractManager(Collection<IGroup> groups) {
    	this.mapping = new HashMap<>();
    	this.gather(groups);
    }
    public AbstractManager(IManager manager) {
        this.mapping = new HashMap<>(manager.mapping());
    }

    @SuppressWarnings("unchecked")
	public IGroup[] to_array(Class<IGroup> element_class) {
        return this.mapping.values().toArray((IGroup[]) Array.newInstance(element_class, this.mapping.size()));
    }

	@SuppressWarnings("unchecked")
	public IManager remove(Collection<IGroup> groups) {
        for (IGroup element : groups) {
			this.remove(element);
		}
        return (IManager) this;
    }

    @SuppressWarnings("unchecked")
	public IManager gather(Collection<IGroup> groups) {
        for (IGroup element : groups) {
			this.add(element);
		}
        return (IManager) this;
    }

    @SuppressWarnings("unchecked")
	public IManager merge(Collection<IManager> managers) {
        for (IManager manager : managers) {
			this.gather(manager.mapping().values());
		}
        return (IManager) this;
    }
}
