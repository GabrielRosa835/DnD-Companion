package dnd_companion.local_storage.structure.components.system;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.models.components.Component;
import dnd_companion.local_storage.structure.data.system.DiceData;

public class DiceComponent implements Component
{	
	private int max_value;
	public int max_value() {return this.max_value;}
	
	public String name() {return String.format("d%d", this.max_value);}

	public int roll() {
		return (int) Math.ceil(Math.random()*this.max_value);
	}
	
	private DiceComponent(int max_value) {
		this.max_value = max_value;
	}
	private DiceComponent(DiceData data) {
		this(data.max_value());
	}
	public DiceComponent() {
		this(0);
	}
	public DiceComponent (String name) {
		this(new DiceComponent().retrieve(name));
	}
	
	@Override public DiceData retrieve(String name) {
		return (DiceData) new DataHandler()
				.retrieve(new DataKey(new DiceData().collection(), name, DiceData.class))
				.result();
	}
	@Override public DiceComponent copy() {
		return new DiceComponent(this.max_value);
	}
}
