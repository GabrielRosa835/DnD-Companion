package dnd_companion.java_api.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "options")
public class AtomicOptions 
{
    @Id private String id;
    private String name;
    private Object[] options;
    
    public String id() {return this.id;}
    public void set_id(String id) {this.id = id;}

    public String name() {return this.name;}
    public void set_name(String name) {this.name = name;}

    public Object[] options() {return this.options;}
    public void set_options(Object[] options) {this.options = options;}
}
