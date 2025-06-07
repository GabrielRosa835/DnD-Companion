package app.domain.elements.components;

import app.domain.elements.entities.options.characterOptions.*;
import app.experimental.*;
import jakarta.persistence.*;

@Embeddable
public record CharacterIdentityComponent(
		@ManyToOne
		Race race,

		@ManyToOne
		Background background,

		@ManyToOne
		SizeCategory size,

		@ManyToOne
		Sex sex,

		@ManyToOne
		Gender gender,

		@ManyToOne
		Religion faith,

		@Column (columnDefinition = "TEXT")
		String behavioralDescription,

		@Column (columnDefinition = "TEXT")
		String visualDescription,

		@Column (columnDefinition = "TEXT")
		String backstory,

		@ManyToOne
		Alignment alignment,

		@Embedded
		MeasureComponent height,

		@Embedded
		MeasureComponent weight,

		int age
) {}
