package app.rpg.strategies.operations;

import app.strategies.Operation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetRandomInteger
   implements Operation<Integer>
{
   private int min;
   private int max;

   public static GetRandomInteger with (int min, int max) {
      return new GetRandomInteger(min, max);
   }

   @Override public Integer process() {
      return (int) ((max - min) * Math.random()) + min;
   }
}
