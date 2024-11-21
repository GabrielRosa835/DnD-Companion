package dnd_companion.game_helper.local_storage.data.structure;

import dnd_companion.game_helper.local_storage.Data;

public record CampaignData(
	String collection,
	String name,
	Object[] characters
) implements Data {}
