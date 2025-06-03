package app.domain.elements.variants;

import app.infrastructure.storage.*;

public interface DomainEntity extends Persistent<String> {
	String name();
	default String id() {
		return name();
	}
}
