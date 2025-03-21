package GabrielRosa835.dnd_companion.app.common;


import GabrielRosa835.dnd_companion.app.elements.entities.system.*;
import lombok.*;

@AllArgsConstructor
public class Main
{
   private UnitTypeRepository unitTypeRepository;

   private UnitRepository unitRepository;

   private MeasureRepository measureRepository;

   public void test () {
      UnitType type = UnitType.builder()
            .withName("Length")
            .build();
      System.out.println(type.toString());

      Unit unit = Unit.builder()
            .withName("Meters")
            .withType(type)
            .withSingularForm("Meter")
            .withAbbreviation("m")
            .withNormalizingFactor(1)
            .build();
      System.out.println(unit.toString());

      Measure measure = Measure.builder()
            .withUnit(unit)
            .withValue(10)
            .build();
      System.out.println(measure.toString());

      this.unitTypeRepository.save(type);
      this.unitRepository.save(unit);
      this.measureRepository.save(measure);
   }
}