package behaviors;

@FunctionalInterface
public interface Effect<Target extends Effectable<Target>>
{
	Target applyTo(Target element);
}