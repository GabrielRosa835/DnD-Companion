package elements.components.character;

import elements.components.*;
import elements.entities.Character;
import fundamentals.*;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

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
