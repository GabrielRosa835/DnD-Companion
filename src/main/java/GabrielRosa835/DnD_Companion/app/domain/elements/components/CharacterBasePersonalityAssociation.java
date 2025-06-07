package app.domain.elements.components;

import jakarta.persistence.*;

import java.util.*;

@Embeddable
public record CharacterBasePersonalityAssociation(
		@ElementCollection (fetch = FetchType.LAZY)
		List<String> personalityTraits,

		@ElementCollection (fetch = FetchType.LAZY)
		List<String> ideals,

		@ElementCollection (fetch = FetchType.LAZY)
		List<String> bonds,

		@ElementCollection (fetch = FetchType.LAZY)
		List<String> flaws
) {}
