package app.experimental.actions;

import app.strategies.*;

import java.util.function.Consumer;

public class HandlerChain<Input, Result>
{
   private HandlerChain<Input, Result> next;
   private Strategy<Input, Result> strategy;

   private Input input;
   private Result result;

   public static <Input, Result> HandlerChain<Input, Result> startWith (Strategy<Input, Result> strategy) {
      var handler = new HandlerChain<Input, Result>();
      handler.strategy = strategy;
      return handler;
   }

   public HandlerChain<Input, Result> compose (Strategy<Input, Result> strategy) {
      var next = HandlerChain.startWith(strategy);
      this.next = next;
      return next;
   }

   public void start() {
      this.handle();
   }
   public HandlerChain<Input, Result> saveResultIn(Consumer<Result> fieldSetter) {
      fieldSetter.accept(result);
      return this;
   }
   private void handle() {
      if (strategy != null)
         result = strategy.execute(input);

      if (strategy == null && next != null)
         next.handle();
   }
}
