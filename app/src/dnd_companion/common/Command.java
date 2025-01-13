package dnd_companion.common;

import dnd_companion.common.tools.ToolBox;

public abstract class Command<Result>
{
	private static ToolBox tools = new ToolBox();
	
	protected boolean status = false;
	public boolean status() {return this.status;}

	protected Result result = null;
	public Result result() {return this.result;}
	
	protected String message = null;
	public String message() {return this.message;}

	@SuppressWarnings("unchecked")
	public <T extends Command<Result>> T execute() {
		try {
			this.code();
			this.status = true;
		} catch (Exception e) {
			tools.print(e);
		}
		return (T) this;
	}
	
	protected abstract void code() throws Exception;
}
