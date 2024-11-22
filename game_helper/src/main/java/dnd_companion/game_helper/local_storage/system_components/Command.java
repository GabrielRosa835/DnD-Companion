package dnd_companion.game_helper.local_storage.system_components;

public abstract class Command 
{
	protected boolean status;
	public boolean status() {return this.status;}
	
	public abstract Command execute();
	
	public Command() {
		this.status = false;
	}
}
