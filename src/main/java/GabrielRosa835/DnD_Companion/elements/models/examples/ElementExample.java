package elements.models.examples;

import common.*;
import elements.models.*;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Accessors(fluent = true)
@ToString
@Builder
@Getter
public abstract class ElementExample implements
		Entity, Replicable, Action.Applicable, Effect.Applicable, Service.Applicable
{
	private int intField;
	private String stringField;
	private Object objectField;

	@Override public Action actWith(Action action) {
		return action.source(this);
	}

	@Override public Effect.Applicable applyEffect(tactics.Effect effect) {
		Effect e = (Effect) effect.target(this).execute();
		this.intField = e.changeIntField();
		this.stringField = e.changeStringField();
		this.objectField = e.changeObjectField();
		return this;
	}

	@Override public Service<?> useService(Service<?> service) {
		return service.loadElements(this);
	}

	public interface Effect extends tactics.Effect {
		int changeIntField();
		String changeStringField();
		Object changeObjectField();
	}
}
