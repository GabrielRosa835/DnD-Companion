package GabrielRosa835.dnd_companion.app.elements.components.character;

import GabrielRosa835.dnd_companion.app.elements.entities.character.Character;
import GabrielRosa835.dnd_companion.app.elements.entities.system.*;
import GabrielRosa835.dnd_companion.app.fundamentals.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder (setterPrefix = "with")
@Accessors(fluent = true)
@ToString
@Getter
public class CharacterDecorationProperties implements
		Effect.Applicable<CharacterDecorationProperties>,
		Character.Property
{
	private final Character character;

	private String behavioralDescription;
	private String visualDescription;
	private Alignment alignment;
	private Measure height;
	private Measure weight;
	private String name;
	private int age;

	@Override public CharacterDecorationProperties applyEffect(Effect<CharacterDecorationProperties> effect) {
		var result = effect.applyTo(this);
		this.behavioralDescription = result.behavioralDescription;
		this.visualDescription = result.visualDescription;
		this.alignment = result.alignment;
		this.height = result.height;
		this.weight = result.weight;
		this.name = result.name;
		this.age = result.age;
		return this;
	}
}
