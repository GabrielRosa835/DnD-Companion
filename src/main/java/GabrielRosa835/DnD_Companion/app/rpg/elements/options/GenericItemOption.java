package app.rpg.elements.options;

import app.rpg.elements.components.MeasureComponent;
import app.rpg.elements.options.types.Item;
import app.rpg.models.Option;
import lombok.Builder;

@Builder (setterPrefix = "with")
public record GenericItemOption(
      String name,
      MeasureComponent price,
      MeasureComponent weight,
      ItemTagOption[] tags,
      String description
) implements Option, Item {}
