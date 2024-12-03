package src.system_components;

import src.storage_build.StorageBuilder;

public class Main {
    public static void main(String args[]) {
        StorageBuilder.setup_directory_hierarquy();
        StorageBuilder.setup_options();
        StorageBuilder.setup_armors();
    }
}
