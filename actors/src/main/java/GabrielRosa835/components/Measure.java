package GabrielRosa835.components;

import GabrielRosa835.models.Component;
import GabrielRosa835.models.EntityActor;
import lombok.*;

@NoArgsConstructor (access = AccessLevel.PACKAGE)
@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Builder
@ToString
public class Measure<T extends Measure.MeasureType> implements Component
{
   private T type;
   private double value;
   private UnitOfMeasure unit;

   public T type() {return type;}
   public double value() {return value;}
   public UnitOfMeasure unit() {return unit;}

   @Override public EntityActor clone () {
      return null;
   }

   public enum Type
   {
      DISTANCE, PERIOD, PRICE, WEIGHT;
   }
   public interface MeasureType {}
   public interface DISTANCE extends MeasureType {}
   public interface PERIOD extends MeasureType {}
   public interface PRICE extends MeasureType {}
   public interface WEIGHT extends MeasureType {}
}
