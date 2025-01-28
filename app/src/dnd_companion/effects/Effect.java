package dnd_companion.effects;

public interface Effect
{
	public <O extends Object> void loadObject(O object);
	public void run();
}
