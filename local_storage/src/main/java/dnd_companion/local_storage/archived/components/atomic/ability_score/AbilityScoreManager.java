package dnd_companion.local_storage.archived.components.atomic.ability_score;

import java.util.Collection;

import dnd_companion.local_storage.structure.elements.AbstractManager;

public class AbilityScoreManager extends AbstractManager<AbilityScoreElement, AbilityScoreGroup, AbilityScoreManager>
{
	public AbilityScoreManager() {
		super();
	}
	public AbilityScoreManager(Collection<AbilityScoreGroup> ability_score_groups) {
		super(ability_score_groups);
	}
	public AbilityScoreManager(AbilityScoreManager ability_score_manager) {
		super(ability_score_manager);
	}

	@Override
	protected void add_element(AbilityScoreGroup ability_score_group) {
		this.mapping.put(ability_score_group.element(), ability_score_group);
	}

	@Override
	protected void remove_element(AbilityScoreGroup ability_score_group) {
		this.mapping.remove(ability_score_group.element());
	}
}
