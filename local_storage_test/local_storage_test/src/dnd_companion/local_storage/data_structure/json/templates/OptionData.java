package src.data_structure.json.templates;

public interface OptionData<T> extends Data {
    @Override
    public String collection();

    @Override
    public String file_name();

    public T[] options();
}
