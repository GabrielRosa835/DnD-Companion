package app.rpg.strategies.operations;

import app.strategies.Operation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetDiceMaxValueOperation
   implements Operation<Integer>
{
   private String name;

   public static GetDiceMaxValueOperation with(String name) {
      return new GetDiceMaxValueOperation(name);
   }

   @Override public Integer process () {
      if (name == null || !name.matches("D\\d+")) {
         throw new IllegalArgumentException("Invalid dice:" + name);
      }
      return Integer.parseInt(name.substring(1));
   }
}
