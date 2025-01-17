package dnd_companion.archives.effects;

import dnd_companion.archives.local_storage.models.common.Command;

public abstract class Effect extends Command<Effect> 
{
	protected Target target;
	
	public interface Target {
		
	}
}
