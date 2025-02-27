package GabrielRosa835.models.types;

public interface Item
{
   String name ();
   Price price ();
   Weight weight ();
   Tags[] tags ();
   String description ();

   public static enum Tags
   {
      ADVENTURING_GEAR, AMMUNITION, ARMOR, FOOD_AND_DRINK, INSTRUMENT, MAGICAL, TOOL, WEAPON;
   }
}