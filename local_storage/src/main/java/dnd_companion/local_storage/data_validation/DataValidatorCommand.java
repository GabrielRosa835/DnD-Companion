package dnd_companion.local_storage.data_validation;

import dnd_companion.local_storage.system_components.Command;

public abstract class DataValidatorCommand extends Command 
{
	protected Object result;
	public Object result() {return this.result;}
	
	protected String message;
	public String message() {return this.message;}
	
	public DataValidatorCommand() {
		this.result = null;
		this.message = null;
	}
}
