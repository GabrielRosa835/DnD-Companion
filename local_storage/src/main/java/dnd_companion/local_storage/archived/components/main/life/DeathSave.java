package dnd_companion.local_storage.archived.components.main.life;

public class DeathSave
{
	private Type type;
	public Type type() {return this.type;}

	public DeathSave(Type type) {
		this.type = type;
	}

	public enum Type {
		SUCCESS, FAILURE;
	}
}