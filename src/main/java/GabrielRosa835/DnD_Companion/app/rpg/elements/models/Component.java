package app.rpg.elements.models;

public interface Component<Element> {
	Element update(Element clone);
}
