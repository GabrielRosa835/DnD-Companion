package app.rpg.elements.components;

import app.rpg.models.Component;
import app.rpg.elements.options.AlignmentOption;
import lombok.*;
import lombok.experimental.Accessors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Accessors(fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
public class CharacterDecorationPropertiesComponent
	implements Component<CharacterDecorationPropertiesComponent>
{
	private String behavioralDescription;
	private AlignmentOption alignment;
	private String visualDescription;
	private MeasureComponent height;
	private MeasureComponent weight;
	private int age;

	@Override public void update (CharacterDecorationPropertiesComponent clone) {
		this.behavioralDescription = clone.behavioralDescription;
		this.visualDescription = clone.visualDescription;
		this.alignment = clone.alignment;
		this.height = clone.height;
		this.weight = clone.weight;
		this.age = clone.age;
	}
}
