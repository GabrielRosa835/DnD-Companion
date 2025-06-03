package app.domain.elements.components;

import app.domain.elements.options.system.DamageType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Embeddable
@With
public record DamageComponent (
		List<DiceGroupComponent> dices,
		DamageType type,
		int modifier
) {}
