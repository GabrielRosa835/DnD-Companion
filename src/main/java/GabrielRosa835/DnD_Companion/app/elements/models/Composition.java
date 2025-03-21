package GabrielRosa835.dnd_companion.app.elements.models;

public interface Composition<Key, Element> {
	Element get(Key key);
	Composition<Key, Element> add(Element element);
	Composition<Key, Element> remove(Key key);
}
