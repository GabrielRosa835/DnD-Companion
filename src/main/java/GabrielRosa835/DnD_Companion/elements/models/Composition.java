package elements.models;

public interface Composition<Key, Element> {
	Composition<Key, Element> add(Element element);
	Composition<Key, Element> remove(Key key);
	Element get(Key key);
}
