package app.experimental.actions;

import app.strategies.Operation;

import java.util.function.Function;

@FunctionalInterface
public interface Handler<Element>
   extends Function<Operation<Element>, Element>
{
   Element handle (Operation<Element> input);

   default Element apply (Operation<Element> input) {
      return handle(input);
   }
}
