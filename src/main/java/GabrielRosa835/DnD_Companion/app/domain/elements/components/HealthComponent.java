package app.domain.elements.components;

import lombok.*;

@With
public record HealthComponent (
		int maximumHitPoints,
		int currentHitPoints,
		int temporaryHitPoints
) {}