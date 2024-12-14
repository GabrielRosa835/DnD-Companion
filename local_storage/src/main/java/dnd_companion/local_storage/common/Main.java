package dnd_companion.local_storage.common;

import java.util.Arrays;

import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.data.Data;
import dnd_companion.local_storage.structure.data.system.units.WeightUnitData;

public class Main
{
	public static void main (String args[])
	{
		DataHandler handler = new DataHandler();
		
		Data[] data1 = handler
				.retrieve_multiple(new WeightUnitData().collection(), WeightUnitData.class)
				.result();
		ToolBox.print("Simple retrieval: " + Arrays.toString(data1) + "\n");
		
		Data[] data2 = handler
				.retrieve_multiple(new WeightUnitData().collection(), WeightUnitData.class)
				.filter("^(Kilograms|Grams)$")
				.result();
		ToolBox.print("Filtered retrieval: " + Arrays.toString(data2) + "\n");
		
		Data[] data3 = handler
				.retrieve_multiple(new WeightUnitData().collection(), WeightUnitData.class)
				.limit(3)
				.result();
		ToolBox.print("Limited retrieval: " + Arrays.toString(data3) + "\n");
		
		Data[] data4 = handler
				.retrieve_multiple(new WeightUnitData().collection(), WeightUnitData.class)
				.filter("^(Kilograms|Grams)$")
				.limit(1)
				.result();
		ToolBox.print("Filtered and limited retrieval: " + Arrays.toString(data4) + "\n");
	}
}
