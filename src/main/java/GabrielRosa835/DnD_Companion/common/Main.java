package common;

import elements.entities.system.*;
import org.springframework.beans.factory.annotation.Autowired;

public class Main
{
   @Autowired
   private UnitType.Repository unitTypeRepository;

   @Autowired
   private Unit.Repository unitRepository;

   @Autowired
   private Measure.Repository measureRepository;

   public void test () {
      UnitType type = UnitType.create(null, "Length");

      Unit unit = Unit.builder()
            .withName("Meters")
            .withType(type)
            .withSingularForm("Meter")
            .withAbbreviation("m")
            .withNormalizingFactor(1)
            .build();

      Measure measure = Measure.builder()
            .withUnit(unit)
            .withValue(10)
            .build();

      this.unitTypeRepository.save(type);
      this.unitRepository.save(unit);
      this.measureRepository.save(measure);
   }

   public static void main (String[] args) {
      new Main().test();
   }
}