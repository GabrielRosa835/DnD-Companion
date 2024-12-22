package dnd_companion.local_storage.effects;

import dnd_companion.local_storage.models.common.Command;

public abstract class Effect extends Command<Effect> 
{
	protected Target target;
	
	public interface Target {
		
	}
}
