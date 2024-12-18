package dnd_companion.local_storage.structure.components.system;

public class Dice
{
	private int max;
	public int max() {return this.max;}

	public Dice(String type) {
		this.max = Integer.parseInt(type.substring(1));
	}

	public int roll() {
		return (int) Math.ceil(Math.random()*max);
	}
}
