package app.strategies;

@FunctionalInterface
public interface Command
   extends
      Strategy<Void, Void>,
      Runnable
{
   Void resolve();

   default Void execute(Void unused) {
      return resolve();
   }
   default void run() {
      resolve();
   }
}
