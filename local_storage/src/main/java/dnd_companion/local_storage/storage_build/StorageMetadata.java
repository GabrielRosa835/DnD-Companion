package dnd_companion.local_storage.storage_build;

import java.util.LinkedHashMap;

public abstract class StorageMetadata
{
	public static final LinkedHashMap<String, DirRef> directory_hierarquy = new LinkedHashMap<>();

	private static void add(DirRef dir_ref) {
		directory_hierarquy.put(dir_ref.dir_name(), dir_ref);
	}

	static {
		add(new DirRef(null, "data"));

		add(new DirRef("data", "items"));
		add(new DirRef("data", "system"));
		add(new DirRef("data", "campaigns"));

		add(new DirRef("items", "armors"));
		add(new DirRef("items", "weapons"));

		add(new DirRef("system", "units"));
	}

	public record DirRef(String parent_dir, String dir_name) {
		public String path(){
			DirRef current = this;
			String path = current.dir_name;
			String parent_dir = path;

			while (parent_dir != "data") {
				current = StorageMetadata.directory_hierarquy.get(parent_dir);
				parent_dir = current.parent_dir();
				path = String.format("%s\\%s", parent_dir, path);
			}
			return path;
		}
	}
}
