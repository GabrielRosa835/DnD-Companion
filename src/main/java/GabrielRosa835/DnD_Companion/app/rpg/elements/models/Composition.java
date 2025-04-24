package app.rpg.elements.models;

public interface Composition<Element> {
	Element update(Element clone);
}
