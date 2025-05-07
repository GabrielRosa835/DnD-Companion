package app.domain.effects;

public interface ActionEffects {

	static void attack() {
//		return CharacterHasItemOnHandCheck.validateWith()
//				.orElseProcess(CharacterHasItemOnInventoryPredicate::test)
//				.orElseProcess(CharacterCanEquipItemPredicate::test)
//				.orElseProcess(EquipItemOnCharacterBiFunction.apply(character, item))
//				.then(character -> RollAttackWithWeaponBiFunction.apply(character, weaponOption))
//				.then((attack, defense) -> CompareAttackAndDefenseBiPredicate.test(attack, defense))
//				.then(character -> ApplyEffectBiFunction.apply(character, effect))
//				.onFailure(error -> {
//					// Handle failure case
//					System.out.println("An error occurred: " + error);
//					return Result.failure(error);
//				});
	}
	static void dash(){}
	static void disengage(){}
	static void dodge(){}
	static void help(){}
	static void hide(){}
	static void influence(){}
	static void magic(){}
	static void move(){}
	static void ready(){}
	static void search(){}
	static void study(){}
	static void utilize(){}
}
