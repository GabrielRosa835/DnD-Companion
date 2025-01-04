package dnd_companion.common.tools;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;

import dnd_companion.common.Command;
import dnd_companion.common.exceptions.ObjectsNotEqualException;

public class DeepEqualsCommand extends Command<Boolean>
{
	private final Object[] objects;
	
	public DeepEqualsCommand(Object[] objects) {
		this.objects = objects;
		this.result = false;
		this.message = "There was a problem when comparing objects: " + Arrays.toString(objects);
	}
	
	@Override protected void code() throws ObjectsNotEqualException, IllegalArgumentException {
		if (objects == null || objects.length < 2) {
            throw new IllegalArgumentException("At least two objects are required for comparison.");
        }
        for (int i = 0; i < objects.length - 1; i++) {
            if (!equalsPair(objects[i], objects[i + 1])) {
                return;
            }
        }
        this.result = true;
        this.message = "All objects were deeply equal: " + Arrays.toString(objects);
	}

	private static boolean equalsPair(Object obj1, Object obj2) {
        if (obj1 == obj2) {
            return true;
        }
        if (obj1 == null || obj2 == null || obj1.getClass() != obj2.getClass()) {
            return false;
        }

        Field[] fields = obj1.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value1 = field.get(obj1);
                Object value2 = field.get(obj2);

                if (field.getType().isPrimitive() || 
                		value1 instanceof String || 
                		value1 instanceof Number || 
                		value1 instanceof Boolean) {
                    if (!Objects.equals(value1, value2)) {
                        return false;
                    }
                } else if (value1 != null && value2 != null && value1.getClass().isArray()) {
                    if (!Arrays.deepEquals((Object[]) value1, (Object[]) value2)) {
                        return false;
                    }
                } else {
                    if (!equalsPair(value1, value2)) {
                        return false;
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
}
