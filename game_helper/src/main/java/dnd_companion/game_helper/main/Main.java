package dnd_companion.game_helper.main;

import dnd_companion.game_helper.local_storage.manager.LocalStorageManager;

public class Main 
{
	public static void main (String args[]) {
		LocalStorageManager.create_directory_hierarquy();		
	}
}
