package dnd_companion.local_storage.common;

public abstract class Command<Result>
{
	protected boolean status = false;
	public boolean status() {return this.status;}

	protected String message = null;
	public String message() {return this.message;}
	
	protected Result result;
	public Result result() {return this.result;}

	public abstract Command<Result> execute();
}
