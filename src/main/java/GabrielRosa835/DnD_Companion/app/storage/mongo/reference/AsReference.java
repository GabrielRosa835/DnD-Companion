package app.storage.mongo.reference;

import com.fasterxml.jackson.databind.annotation.*;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
//@JsonSerialize(using = ReferenceSerializer.class)
//@JsonDeserialize(using = ReferenceDeserializer.class)
public @interface AsReference {
}
