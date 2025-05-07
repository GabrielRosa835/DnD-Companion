package app.storage.mongo.reference;

import com.fasterxml.jackson.databind.annotation.*;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
//@JsonSerialize(contentUsing = ReferenceSerializer.class)
//@JsonDeserialize(contentUsing = ReferenceDeserializer.class)
public @interface AsContentReference {
}
