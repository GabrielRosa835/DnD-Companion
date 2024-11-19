package atomic;

import main.Character;

public abstract class Technique<TechniqueElement extends Element> extends Group<TechniqueElement>
{
	protected Character character;
	
	protected Proficiency proficiency;
	public Proficiency proficiency() {return this.proficiency;}
	
	public Technique(Character character, TechniqueElement element, Proficiency proficiency) {
		this.character = character;
		this.element = element;
		this.proficiency = proficiency;
	}
}
