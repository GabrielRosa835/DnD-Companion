package app.experimental;

import app.display.Display;
import app.rpg.elements.options.UnitOption;
import app.rpg.elements.options.UnitTypeOption;
import app.storage.local.LocalFolderData;
import app.storage.local.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor (staticName = "use")
public class Canva
{
   private final LocalStorageService storage = LocalStorageService.use();

   public void test () {
      Display.display(LocalFolderData.use().setupCoreFolders().tree().keySet());
      Display.blank();
      Display.display(LocalFolderData.use().setupCoreFolders().types());

      var type = new UnitTypeOption("Length");
      var unit = UnitOption.builder()
            .withName("Meters")
            .withAbbreviation("m")
            .withSingularForm("Meter")
            .withNormalizingFactor(1)
            .withType(type)
            .build();
      storage.initialize();
      storage.save(type);
      storage.save(unit);
   }
}
