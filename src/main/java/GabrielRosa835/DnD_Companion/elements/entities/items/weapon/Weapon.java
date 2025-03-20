package elements.entities.items.weapon;

import common.Replicable;
import elements.components.DamageGroup;
import elements.entities.system.Measure;
import elements.components.groups.WeaponPropertyGroup;
import elements.entities.items.ItemTag;
import elements.models.Item;
import lombok.*;
import lombok.experimental.Accessors;
import tactics.Effect;

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
