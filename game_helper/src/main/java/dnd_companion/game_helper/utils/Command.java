package dnd_companion.game_helper.utils;

public abstract class Command 
{
	protected boolean status;
	public boolean status() {return this.status;}
	
	public abstract Command execute();
}
