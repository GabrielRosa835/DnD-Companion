package dnd_companion.game_helper.local_storage.data_builder;

import dnd_companion.game_helper.local_storage.data.structure.CampaignData;
import dnd_companion.game_helper.local_storage.storage_builder.StorageBuilder;
import dnd_companion.game_helper.utils.Command;
import dnd_companion.game_helper.utils.ToolBox;

public class BuildCampaignCommand extends Command
{
	private CampaignData data;
	
	public BuildCampaignCommand(CampaignData data) {
		this.data = data;
	}

	public BuildCampaignCommand execute() {
		try {
			StorageBuilder.create_directory(String.format("data/campaign/%s", ToolBox.to_snake_case(data.name())));
			StorageBuilder.create_directory(String.format("data/campaign/%s/characters", ToolBox.to_snake_case(data.name())));
			status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			status = false;
		}
		return this;
	}
}
