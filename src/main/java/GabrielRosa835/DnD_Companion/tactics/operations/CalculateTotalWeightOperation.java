package tactics.operations;

import elements.models.types.Item;
import tactics.Operation;

import java.util.List;

public class CalculateTotalWeightOperation implements Operation<Double, Item>
{
   @Override public Double execute (List<Item> items) {
      double sum = 0.0;
      for (Item item : items) {
         sum += item.price().value();
      }
      return sum;
   }
}
