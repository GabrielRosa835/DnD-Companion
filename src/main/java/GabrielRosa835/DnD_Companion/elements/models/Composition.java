package elements.models;

public interface Composition<Element> {
	Element get(Object type);
	Composition<Element> add(Element... elements);
	Composition<Element> remove(Element... elements);
}
