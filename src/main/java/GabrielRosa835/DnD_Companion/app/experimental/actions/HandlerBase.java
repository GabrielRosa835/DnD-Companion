package app.experimental.actions;

import app.strategies.Operation;

public abstract class HandlerBase<Element>
   implements Handler<Element>
{
   private Handler<Element> next;

   public Handler<Element> compose (Handler<Element> next) {
      this.next = next;
      return next;
   }

   @Override public abstract Element handle (Operation<Element> operation);

   protected Element handleNext (Operation<Element> operation) throws Exception {
      if (next == null)
         return operation.process();
      return next.handle(operation);
   }
}
