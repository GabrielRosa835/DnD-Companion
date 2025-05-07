package app.domain.elements.components.playerCharacter;

import lombok.*;

@With
public record DeathSaveComponent(boolean result) {
	public String toString() {
		return result? "Success" : "Failure";
	}
}
