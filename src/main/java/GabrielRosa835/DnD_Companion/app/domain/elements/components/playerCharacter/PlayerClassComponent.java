package app.domain.elements.components.playerCharacter;

import app.domain.elements.options.*;
import lombok.*;

@With
public record PlayerClassComponent(
		PlayerClass type,
		Subclass subclass,
		int level
) {}