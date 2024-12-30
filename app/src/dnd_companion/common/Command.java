package dnd_companion.common;

public abstract class Command<Result>
{
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
			ToolBox.print(e);
		}
		return (T) this;
	}
	
	protected abstract void code() throws Exception;
}
