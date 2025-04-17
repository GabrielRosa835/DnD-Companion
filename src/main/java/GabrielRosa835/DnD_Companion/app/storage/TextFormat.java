package app.storage;

import dev.turingcomplete.textcaseconverter.StandardTextCases;
import dev.turingcomplete.textcaseconverter.StandardWordsSplitters;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TextFormat
{
   private static final String fileExtension = ".json";

   public String folder (String name) {
      String altName = name.replace("_", " ");
      return StandardTextCases.KEBAB_CASE.convert(altName, StandardWordsSplitters.SPACES);
   }
   public String collection (String name) {
      String altName = name.replace("_", " ");
      return StandardTextCases.KEBAB_CASE.convert(altName, StandardWordsSplitters.SPACES);
   }
   public String file (String name) {
      String file = StandardTextCases.SNAKE_CASE.convert(name);
      return file.endsWith(fileExtension)? file : file.concat(fileExtension);
   }
}
