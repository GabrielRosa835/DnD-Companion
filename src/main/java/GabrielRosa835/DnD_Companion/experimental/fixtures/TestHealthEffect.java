package experimental.fixtures;

import elements.components.Health;
import behaviors.EffectModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestHealthEffect	extends EffectModel<Health>
{
   public final int damage;

   private int temporaryHitPointsBuffer;
   private int currentHitPointsBuffer;

   @Override protected void setup () {
      currentHitPointsBuffer = target.currentHitPoints();
      temporaryHitPointsBuffer = target.temporaryHitPoints();
   }
   @Override protected void execute () {
      temporaryHitPointsBuffer -= damage;
      if (temporaryHitPointsBuffer < 0) {
         currentHitPointsBuffer += temporaryHitPointsBuffer;
         temporaryHitPointsBuffer = 0;
      }
   }
   @Override protected Health assemble () {
      return Health.builder()
            .withCurrentHitPoints(currentHitPointsBuffer)
            .withTemporaryHitPoints(temporaryHitPointsBuffer)
            .withMaximumHitPoints(target.maximumHitPoints())
            .build();
   }
}
