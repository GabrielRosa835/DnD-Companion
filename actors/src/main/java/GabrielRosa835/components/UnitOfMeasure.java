package GabrielRosa835.components;

import GabrielRosa835.models.Component;
import GabrielRosa835.models.EntityActor;

public class UnitOfMeasure implements Component
{
   private Type type;
   private String name;
   private String singularForm;
   private String abbreviation;
   private double normalizingFactor;

   @Override public EntityActor clone () {
      return null;
   }

   public enum Type
   {
      LENGTH, TIME, CURRENCY, MASS;
   }
}
