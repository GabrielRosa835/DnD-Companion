package behaviors;

@FunctionalInterface
public interface Catalyst<IEffect extends Effect<?>>
{
   IEffect applyTo (IEffect e);
}
