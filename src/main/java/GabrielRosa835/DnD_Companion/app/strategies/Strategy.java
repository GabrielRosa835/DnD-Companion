package app.strategies;

import java.util.function.Function;

public interface Strategy<InputType, ReturnType>
   extends Function<InputType, ReturnType>
{
   ReturnType execute(InputType input);

   default ReturnType apply (InputType input) {
      return execute(input);
   }
}
