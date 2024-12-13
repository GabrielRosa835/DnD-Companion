package dnd_companion.local_storage.common.command;

import dnd_companion.local_storage.common.ToolBox;

public abstract class Command<T extends Command<T, Result>, Result>
{
	protected boolean status = false;
	public boolean status() {return this.status;}

	protected Result result = null;
	public Result result() {return this.result;}
	
	protected String message = null;
	public String message() {return this.message;}

	@SuppressWarnings("unchecked")
	public T execute() {
		try {
			this.code();
			this.status = true;
		} catch (Exception e) {
			ToolBox.print(e);
		}
		return (T) this;
	}
	
	protected abstract void code() throws Exception;
}
