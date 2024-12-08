package dnd_companion.local_storage.common.command;

public abstract class CommandManager
{
	protected Command<?> last_command;
	public Command<?> last_command() {return this.last_command;}
	
	public boolean status() {return this.last_command.status();}
	public String message() {return this.last_command.message();}
	public Object result() {return this.last_command.result();}
}
