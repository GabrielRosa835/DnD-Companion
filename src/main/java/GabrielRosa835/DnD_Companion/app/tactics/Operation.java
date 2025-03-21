package GabrielRosa835.dnd_companion.app.tactics;

@FunctionalInterface
public interface Operation<ReturnType>
{
	ReturnType execute();
}
