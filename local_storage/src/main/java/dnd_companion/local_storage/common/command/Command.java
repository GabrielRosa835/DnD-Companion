package dnd_companion.local_storage.common.command;

public abstract class Command<Result>
{
	protected boolean status = false;
	public boolean status() {return this.status;}

	protected Result result = null;
	public Result result() {return this.result;}
	
	protected String message = null;
	public String message() {return this.message;}

	public abstract Command<Result> execute();
	
	public Command<Result> clear() {
		this.status = false;
		this.message = null;
		this.result = null;
		return this;
	}
}
