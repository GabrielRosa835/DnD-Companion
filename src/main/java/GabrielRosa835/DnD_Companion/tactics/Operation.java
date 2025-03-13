package tactics;

import elements.models.*;

import java.util.List;

@FunctionalInterface
public interface Operation<ReturnType>
{
	ReturnType execute();
}
