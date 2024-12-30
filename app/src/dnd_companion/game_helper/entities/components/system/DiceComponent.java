package dnd_companion.game_helper.entities.components.system;

import dnd_companion.game_helper.entities.data.system.DiceData;
import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.models.components.Component;

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
	private DiceComponent(DiceTypeData data) {
		this(data.max_value());
	}
	public DiceComponent() {
		this(0);
	}
	public DiceComponent (String name) {
		this(new DiceComponent().retrieve(name));
	}
	
	@Override public DiceTypeData retrieve(String name) {
		return (DiceTypeData) new DataHandler()
				.retrieve(new DataKey(new DiceTypeData().collection(), name, DiceTypeData.class))
				.result();
	}
	@Override public DiceComponent copy() {
		return new DiceComponent(this.max_value);
	}
}
