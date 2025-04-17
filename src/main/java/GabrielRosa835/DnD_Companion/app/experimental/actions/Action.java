package app.experimental.actions;

import java.util.Optional;

public interface Action
{
   Optional<Boolean> perform();
}
