package GabrielRosa835.dnd_companion.app.tactics;

@FunctionalInterface
public interface Effect<Target>
{
	Target applyTo(Target element);

	interface Applicable<Self extends Applicable<Self>> {
		Applicable<Self> applyEffect(Effect<Self> effect);
	}
}
