package tactics;

public interface Effect<Target>
{
	Target apply(Target element);

	interface Applicable<Self extends Applicable<Self>> {
		void applyEffect(Effect<Self> effect);
	}
}
