package app.storage;

import app.rpg.elements.models.IEntity;
import app.rpg.elements.options.*;
import app.rpg.elements.options.actionTypes.*;
import app.rpg.elements.options.dices.*;
import app.rpg.elements.options.weaponProperties.*;

import java.util.*;

public class CoreContainers {
	private CoreContainers() {
	}

	private static CoreContainers instance;

	public static CoreContainers get() {
		return instance == null ? new CoreContainers() : instance;
	}

	protected Map<Container, String> names;
	protected Map<Container, Class<? extends IEntity>> types;

	private CoreContainers setup() {
		add(ContainerPrototype.create("damage types", DamageTypeOption.class));
		add(ContainerPrototype.create("dice types", DiceOption.class));
		add(ContainerPrototype.create("action types", ActionTypeOption.class));

		add(ContainerPrototype.create("unit types", UnitTypeOption.class));
		add(ContainerPrototype.create("currency units", UnitOption.class));
		add(ContainerPrototype.create("length units", UnitOption.class));
		add(ContainerPrototype.create("weight units", UnitOption.class));
		add(ContainerPrototype.create("time units", UnitOption.class));

		add(ContainerPrototype.create("item tags", ItemTagOption.class));
		add(ContainerPrototype.create("generic items", GenericItemOption.class));
		add(ContainerPrototype.create("ammunition", AmmunitionOption.class));

		add(ContainerPrototype.create("armors", ArmorOption.class));
		add(ContainerPrototype.create("armor categories", ArmorCategoryOption.class));

		add(ContainerPrototype.create("weapons", WeaponOption.class));
		add(ContainerPrototype.create("weapon types", WeaponTypeOption.class));
		add(ContainerPrototype.create("weapon categories", WeaponCategoryOption.class));
		add(ContainerPrototype.create("weapon masteries", WeaponMasteryOption.class));
		add(ContainerPrototype.create("weapon properties", WeaponPropertyOption.class));

		return this;
	}

	private void add(Container container) {
		names.put(container, container.name());
		types.put(container, container.type());
	}
}
