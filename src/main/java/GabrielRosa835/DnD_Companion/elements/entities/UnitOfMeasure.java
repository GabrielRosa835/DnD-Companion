package elements.entities;

import common.*;
import elements.models.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@ToString
@Getter
public class UnitOfMeasure<T extends UnitOfMeasure.Types> implements Entity, Replicable {
	private Class<T> type;
	private String name;
	private String singularForm;
	private String abbreviation;
	private double normalizingFactor;

	@Override
	public UnitOfMeasure<T> replicate() {
		return new UnitOfMeasure<T>(type, name, singularForm, abbreviation, normalizingFactor);
	}

	public interface Types {
		class LENGTH implements Types {
		}

		class TIME implements Types {
		}

		class CURRENCY implements Types {
		}

		class MASS implements Types {
		}
	}
}
