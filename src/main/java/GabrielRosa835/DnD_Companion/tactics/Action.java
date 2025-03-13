package tactics;

import java.util.List;

@FunctionalInterface
public interface Action<Target>
{
	void act(List<Target> targets);
}
