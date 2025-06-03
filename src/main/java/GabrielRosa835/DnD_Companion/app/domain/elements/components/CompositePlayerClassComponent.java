package app.domain.elements.components;

import app.domain.elements.options.characterOptions.*;
import jakarta.persistence.*;

@Embeddable
public record CompositePlayerClassComponent(
		CharacterClass type,
		Subclass subclass,
		int level
) {}