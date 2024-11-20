package dnd_companion.game_helper.local_storage.data_structure.archived.main.life;

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