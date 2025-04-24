package app.rpg.elements.compositions;

import app.rpg.snippets.models.Catalyst;
import app.rpg.elements.models.Composition;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(staticName = "empty")
@Accessors(fluent = true)
@Builder(setterPrefix = "with")
@Getter
public class CatalystComposition implements Composition<CatalystComposition> // "Resistances"
{
	@Singular("catalyst")
	private Set<Catalyst> content = new HashSet<>();

	@Override public CatalystComposition update(CatalystComposition clone) {
		this.content.clear();
		this.content.addAll(clone.content);
		return this;
	}
}
