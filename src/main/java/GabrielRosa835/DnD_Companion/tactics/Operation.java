package tactics;

@FunctionalInterface
public interface Operation<ReturnType>
{
	ReturnType execute();
}
