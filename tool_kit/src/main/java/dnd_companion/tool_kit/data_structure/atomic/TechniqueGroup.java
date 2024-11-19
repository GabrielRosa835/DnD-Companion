package dnd_companion.tool_kit.data_structure.atomic;

public abstract class TechniqueGroup<TechniqueElement extends Element> extends Group<TechniqueElement>
{
	protected Character character;
	
	protected boolean proficiency;
	public boolean proficiency() {return this.proficiency;}
	
	public TechniqueGroup(Character character, TechniqueElement element, boolean proficiency) {
		this.character = character;
		this.element = element;
		this.proficiency = proficiency;
	}
}
