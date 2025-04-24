package app.rpg.elements.models;

import app.common.*;

public interface Actor<Element> extends IEntity, Replicable<Element>
{
	Element update(Element clone);
}
