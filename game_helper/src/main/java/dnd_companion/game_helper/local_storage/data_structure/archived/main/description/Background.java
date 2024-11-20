package dnd_companion.game_helper.local_storage.data_structure.archived.main.description;

import dnd.characters.habilities.Feat;
import dnd_companion.game_helper.local_storage.data_structure.archived.items.Item;
import dnd_companion.game_helper.local_storage.data_structure.archived.main.attributes.Skill;

public class Background {
	private String[] ability_scores;
	private Feat feat;
	private Skill[] skill_proficiencies;
	private Tool[] tool_proficiencies;
	private Item[] equipment;
}
