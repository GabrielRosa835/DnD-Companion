package behaviors;

import elements.compositions.ResistanceComposition;

import java.util.List;
import java.util.Set;

public interface Effectable<Element extends Effectable<Element>> {
   void applyEffect(Effect<Element> effect, ResistanceComposition<Element> resistances);
   ResistanceComposition<Element> resistances();
}
