package GabrielRosa835.dnd_companion.app.elements.entities.items.weapon;

import GabrielRosa835.dnd_companion.app.common.*;
import GabrielRosa835.dnd_companion.app.elements.components.*;
import GabrielRosa835.dnd_companion.app.elements.components.groups.*;
import GabrielRosa835.dnd_companion.app.elements.entities.items.*;
import GabrielRosa835.dnd_companion.app.elements.entities.system.*;
import GabrielRosa835.dnd_companion.app.elements.models.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
public class Weapon implements
      Effect.Applicable<Weapon>,
      Replicable,
      Item
{
   private String description;
   private ItemTag[] tags;
   private Measure weight;
   private Measure price;
   private String name;

   private WeaponPropertyGroup properties;
   private WeaponCategory category;
   private WeaponMastery mastery;
   private DamageGroup damage;
   private WeaponType type;

   @Override public Weapon applyEffect (Effect<Weapon> effect) {
      var result = effect.applyTo(this);
      this.description = result.description;
      this.properties = result.properties;
      this.category = result.category;
      this.mastery = result.mastery;
      this.damage = result.damage;
      this.weight = result.weight;
      this.price = result.price;
      this.name = result.name;
      this.tags = result.tags;
      this.type = result.type;
      return this;
   }
}
