package GabrielRosa835.entities;

import GabrielRosa835.annotations.AutoCloneable;
import GabrielRosa835.models.EntityActor;
import GabrielRosa835.models.EntityData;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;

@AutoCloneable
/*
 * automatic implementation of clone() method,
 * checking if a field is simple or if it can be loned
 */
@AutoEffectable
/*
 * automatic implementation of effect-related needs,
 * such as the applyEffect() method and a Effect interface with needed getters
 */

//Lombok annotations
@AllArgsConstructor (access = AccessLevel.PRIVATE)
@NoArgsConstructor (access = AccessLevel.PROTECTED) //Needed for SpringJPA
@EqualsAndHashCode (of = "id")
@Builder
@ToString

//SpringJPA annotations
@Table (name = "tbl_armors")
@Entity (name = "Armor")

public class Armor implements EntityActor, Cloneable
{
   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   private Long id;

   @Enumerated (EnumType.STRING)
   private Category category;
   public Category category() {return category;}

   private int baseArmorClass;
   public int baseArmorClass() {return baseArmorClass;}

   @Override public Armor clone () {
      return null;
   }

   public static enum Category
   {
      UNARMORED, LIGHT, MEDIUM, HEAVY;
   }

   public enum Data implements EntityData
   {
      CHAIN_MAIL(null);

      private final Armor data;
      private Data(Armor data) {
         this.data = data;
      }

      public Armor use () {
         return this.data.clone();
      }
   }

   public static interface Repository extends JpaRepository<Armor, Long>
   {

   }
}