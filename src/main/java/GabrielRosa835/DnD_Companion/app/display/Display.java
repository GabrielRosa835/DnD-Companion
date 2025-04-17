package app.display;

import lombok.experimental.UtilityClass;

import java.util.*;

@UtilityClass
public class Display
{
   public void blank() {
      System.out.println();
   }

   public void display(String message) {
      System.out.println(message);
   }

   public void display(String main_message, Object... params) {
      System.out.printf(main_message, params);
   }

   public static <T> void display(Set<T> set) {
      if (set == null || set.isEmpty()) {
         System.out.println("The set is empty or null.");
         return;
      }

      for (T element : set) {
         System.out.println("Element: " + element);
      }
   }

   public <K, V> void display(Map<K, V> map) {
      if (map == null || map.isEmpty()) {
         System.out.println("The map is empty or null.");
         return;
      }
      for (Map.Entry<K, V> entry : map.entrySet()) {
         System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
      }
   }

   String input () {
      Scanner reader = new Scanner(System.in);
      return reader.nextLine();
   }
}
