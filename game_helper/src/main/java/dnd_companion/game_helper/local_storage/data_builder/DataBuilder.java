package dnd_companion.game_helper.local_storage.data_builder;

import dnd_companion.game_helper.local_storage.data.structure.CampaignData;

public class DataBuilder 
{
	public static boolean create_campaign(CampaignData data) {
		return new BuildCampaignCommand(data).execute().status();
	}
}
