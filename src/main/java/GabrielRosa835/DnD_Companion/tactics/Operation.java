package tactics;

import elements.models.*;

import java.util.List;

@FunctionalInterface
public interface Operation<ReturnType, Parameters>
{
	ReturnType execute(List<Parameters> parameters);
}
