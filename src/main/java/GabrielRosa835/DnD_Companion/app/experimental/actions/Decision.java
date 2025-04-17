package app.experimental.actions;

import app.rpg.elements.options.ActionTypeOption;

public interface Decision
{
   enum Type {
      Attack, Dodge, Dash, Help, Disengage, Hide, Influence, Magic, Ready, Search, Study, Utilize
   }

   class MoveAction {
      // private final ActionTypeOption type = ActionTypeOption.INSTANT;
   }

   interface UtilizeAction extends Decision {
      interface UtilizeItemAction extends UtilizeAction {
         Object item();
      }
      interface UtilizeFeatureAction extends UtilizeAction {
         Object feature();
      }
   }

   interface AttackAction extends Decision {
      Object weapon();
   }

   interface HelpAction extends Decision {
      Object target();
   }

   interface InfluenceAction extends Decision {
      Object target();
   }

   interface MagicAction extends Decision {
      interface CastSpellAction extends MagicAction {}
      interface CastLongSpellAction extends MagicAction {}
      interface UseMagicItem extends MagicAction, UtilizeAction.UtilizeItemAction {}
   }
}
