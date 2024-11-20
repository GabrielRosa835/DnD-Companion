package dnd_companion.game_helper.tests;

public class TestManager 
{
	public static void main(String args[]) {
		retrieve_test();
	}
	
	public static void save_test() {
		new LSMSaveTest().execute().print();
	}
	public static void retrieve_test() {
		new LSMRetrieveTest().execute().print();
	}
	public static void update_test() {
		new LSMUpdateTest().execute().print();
	}	
}