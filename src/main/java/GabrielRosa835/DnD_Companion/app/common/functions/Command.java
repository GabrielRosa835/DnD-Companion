package app.common.functions;

@FunctionalInterface
public interface Command
	extends
		Operation<Void, Void>,
		Runnable
{
	void resolve();

	@Override default Void process(Void ___) {resolve(); return null;}
	@Override default void run() {resolve();}
}
