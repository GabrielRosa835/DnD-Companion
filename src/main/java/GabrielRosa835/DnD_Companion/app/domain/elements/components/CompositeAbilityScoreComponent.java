package app.domain.elements.components;

import app.domain.elements.options.system.*;
import jakarta.persistence.*;
import lombok.*;

@Embeddable
@With
public record CompositeAbilityScoreComponent(
		ProficiencyType savingThrowProficiencyType,
		AbilityScoreType type,
		int value
) {}
