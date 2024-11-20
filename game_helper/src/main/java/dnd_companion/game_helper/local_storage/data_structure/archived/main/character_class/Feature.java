package dnd_companion.game_helper.local_storage.data_structure.archived.main.character_class;

public class Feature {
	public Character character;
	
	public int level_requirement;
	public String name;
	public String description;
	
	public enum Common {
		ASI;
		
		public int[] aplicable_levels;
		public String name;
		public String description;

		private Fixed() {
			
		}
		
		
	}
}
