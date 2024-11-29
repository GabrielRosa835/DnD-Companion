package dnd_companion.local_storage.data_structure.java.system;

public class Damage
{
	private int dice_amount;
	public int dice_amount() {return this.dice_amount;}

	private Dice dice;
	public Dice dice() {return this.dice;}

	private String type;
	public String type() {return this.type;}

	public Damage(int dice_amount, Dice dice, String type) {
		this.dice_amount = dice_amount;
		this.dice = dice;
		this.type = type;
	}
}
