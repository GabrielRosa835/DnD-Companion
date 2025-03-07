package elements.models;

public interface Composition<C extends Composed> {
	void get(Object type);
	void add(Composed component);
}
