package app.rpg.snippets.operations;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetDiceMaxValueOperation
		implements Operation<Integer> {
	private String name;

	public static GetDiceMaxValueOperation with(String name) {
		return new GetDiceMaxValueOperation(name);
	}

	@Override
	public Integer process() {

	}
}
