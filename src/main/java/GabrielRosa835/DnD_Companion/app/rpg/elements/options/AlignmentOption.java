package app.rpg.elements.options;

import app.rpg.elements.models.Option;

public record AlignmentOption(
		String name
) implements Option {
	//LAWFUL_GOOD, 	LAWFUL_NEUTRAL, 	LAWFUL_EVIL,
	//NEUTRAL_GOOD, 	TRUE_NEUTRAL, 		NEUTRAL_EVIL,
	//CHAOTIC_GOOD, 	CHAOTIC_NEUTRAL, 	CHAOTIC_EVIL
}
