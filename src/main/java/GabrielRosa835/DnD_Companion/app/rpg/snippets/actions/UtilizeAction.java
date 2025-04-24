package app.rpg.snippets.actions;

import app.experimental.*;

public class UtilizeAction {
	interface UtilizeItemAction extends Decision.UtilizeAction {
		Object item();
	}
}
