package app.domain.elements.components;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@With
public record HealthComponent(
		int maximumHitPoints,
		int currentHitPoints,
		int temporaryHitPoints
) {}