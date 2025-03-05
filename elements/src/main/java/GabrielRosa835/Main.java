package GabrielRosa835;

import GabrielRosa835.entities.Armor;

public class Main {
	public static void main(String[] args) {
		Armor armor = Armor.builder()
				.category(Armor.Category.UNARMORED)
				.build();

	}
}