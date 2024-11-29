package dnd_companion.local_storage.data_structure.java.archived.main.description;

import javax.tools.Tool;

import dnd.characters.habilities.Feat;
import dnd_companion.local_storage.data_structure.java.archived.main.attributes.Skill;
import dnd_companion.local_storage.data_structure.json.templates.Item;

public class Background {
	private String[] ability_scores;
	private Feat feat;
	private Skill[] skill_proficiencies;
	private Tool[] tool_proficiencies;
	private Item[] equipment;
}
