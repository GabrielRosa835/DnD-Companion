package dnd_companion.local_storage.common.archived;

import java.util.Collection;

import dnd_companion.local_storage.common.Command;
import dnd_companion.local_storage.common.ToolBox;

public abstract class History 
{
	public Collection<Command<?>> commands;
	protected abstract String manager_class_name();
	
	public void print_command_trace() {
		ToolBox.print("%s command stack trace:", this.manager_class_name());
		for (Command<?> command : commands) {
			ToolBox.print("Command: %s", command.getClass().getSimpleName());
		}
	}
	public void print_status_trace() {
		ToolBox.print("%s status stack trace:", this.manager_class_name());
		for (Command<?> command : commands) {
			ToolBox.print("%s: %b", command.getClass().getSimpleName(), command.status);
		}
	}
	public void print_message_trace() {
		ToolBox.print("%s message stack trace:", this.manager_class_name());
		for (Command<?> command : commands) {
			ToolBox.print("%s: %s", command.getClass().getSimpleName(), command.message);
		}
	}
	public void print_result_trace() {
		ToolBox.print("%s result stack trace:", this.manager_class_name());
		for (Command<?> command : commands) {
			ToolBox.print("%s: %s", command.getClass().getSimpleName(), command.result.toString());
		}
	}
}
