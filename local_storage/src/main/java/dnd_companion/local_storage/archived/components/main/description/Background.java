package dnd_companion.local_storage.archived.components.main.description;

import javax.tools.Tool;

import dnd.characters.habilities.Feat;
import dnd_companion.local_storage.archived.components.main.attributes.Skill;
import dnd_companion.local_storage.structure.data.templates.Item;

public class Background {
	private String[] ability_scores;
	private Feat feat;
	private Skill[] skill_proficiencies;
	private Tool[] tool_proficiencies;
	private Item[] equipment;
}
