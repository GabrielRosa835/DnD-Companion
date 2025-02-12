package dnd_companion.effects;

public interface IEffect
{
	public <O extends Object> void loadObject(O object);
	public void run();
}
