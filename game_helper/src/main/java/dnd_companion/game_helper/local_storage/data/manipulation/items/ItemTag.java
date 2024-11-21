package dnd_companion.game_helper.local_storage.data.manipulation.items;

public interface ItemTag extends Element
{
	public enum Standard implements ItemTag {
		ADVENTURING_GEAR, TOOLS, WEAPON, ARMOR, MAGICAL, CONSUMABLE,
		INGESTABLE, AMMUNITION, TREASURE, TRADE_GOODS, VEHICLE, WONDROUS;
	}
	
	public class Custom implements ItemTag {
		private String name;
		public String name() {return name;}
		
		public Custom(String name) {
			this.name = name.toUpperCase();
		}
	}
}