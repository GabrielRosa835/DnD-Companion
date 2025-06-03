package app.domain.elements.options.system;

import app.domain.elements.variants.*;
import app.infrastructure.exceptions.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor (staticName = "create")
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@FieldDefaults (level = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@Getter
@Setter (AccessLevel.PRIVATE)
@Entity
@Table (name = "opt_dices")
public class Dice implements DomainEntity {
	int maxValue;

	@Column (columnDefinition = "TEXT")
	String description;

	@Id
	@Column (name = "name")
	@Override public String name () {
		return "D" + maxValue;
	}

	public double average () {
		return (double) (maxValue + 1) / 2;
	}

	public static Result<Dice, IllegalArgumentException> of (String name, String description) {
		if (name == null || !name.matches("D\\d+")) {
			return Result.failure(new IllegalArgumentException("Not a valid dice: " + name));
		}
		int maxValue = Integer.parseInt(name.substring(1));
		return Result.success(new Dice(maxValue, description));
	}
}