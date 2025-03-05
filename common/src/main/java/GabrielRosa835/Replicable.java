package GabrielRosa835;

import java.lang.reflect.*;
import java.util.*;

public interface Replicable {
	default Replicable replicate() {
		try {
			Constructor<?> constructor = this.getClass().getDeclaredConstructor();
			constructor.setAccessible(true);
			Object replicated = constructor.newInstance();

			Field[] fields = this.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				Object fieldValue = field.get(this);
				field.set(replicated, replicateField(fieldValue));
			}

			return (Replicable) replicated;
		} catch (Exception e) {
			throw new RuntimeException("Replication failed", e);
		}
	}

	private Object replicateField(Object fieldValue) {
		return switch (fieldValue) {
			case Replicable replicable -> replicable.replicate();
			case List<?>list -> replicateList(list);
			case Map<?, ?> map -> replicateMap(map);
			case Set<?> set -> replicateSet(set);
			case Optional<?> optional -> replicateOptional(optional);
			case Object array when array.getClass().isArray() -> replicateArray(array);
			case Enum<?> enumValue -> enumValue; // Enums are immutable
			case null, default -> fieldValue; // Handle null and other immutable types
		};
	}

	private List<Object> replicateList(List<?> originalList) {
		List<Object> replicatedList = new ArrayList<>();
		for (Object item : originalList) {
			replicatedList.add(replicateField(item));
		}
		return replicatedList;
	}

	private Map<Object, Object> replicateMap(Map<?, ?> originalMap) {
		Map<Object, Object> replicatedMap = new HashMap<>();
		for (Map.Entry<?, ?> entry : originalMap.entrySet()) {
			Object replicatedKey = replicateField(entry.getKey());
			Object replicatedValue = replicateField(entry.getValue());
			replicatedMap.put(replicatedKey, replicatedValue);
		}
		return replicatedMap;
	}

	private Set<Object> replicateSet(Set<?> originalSet) {
		Set<Object> replicatedSet = new HashSet<>();
		for (Object item : originalSet) {
			replicatedSet.add(replicateField(item));
		}
		return replicatedSet;
	}

	private Optional<Object> replicateOptional(Optional<?> originalOptional) {
		return originalOptional.map(this::replicateField);
	}

	private Object replicateArray(Object originalArray) {
		int length = java.lang.reflect.Array.getLength(originalArray);
		Object replicatedArray = java.lang.reflect.Array.newInstance(originalArray.getClass().getComponentType(), length);
		for (int i = 0; i < length; i++) {
			Object item = java.lang.reflect.Array.get(originalArray, i);
			java.lang.reflect.Array.set(replicatedArray, i, replicateField(item));
		}
		return replicatedArray;
	}
}
