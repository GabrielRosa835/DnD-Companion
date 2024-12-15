package dnd_companion.local_storage.archived.components.atomic.saving_throw;

import java.util.Collection;

import dnd_companion.local_storage.structure.components.AbstractManager;

public class SavingThrowManager extends AbstractManager<SavingThrow, SavingThrowTechnique, SavingThrowManager>
{
	public SavingThrowManager() {
		super();
	}
	public SavingThrowManager(Collection<SavingThrowTechnique> saving_throw_techniques) {
		super(saving_throw_techniques);
	}
	public SavingThrowManager(SavingThrowManager saving_throw_manager) {
		super(saving_throw_manager);
	}

	@Override
	protected void add_element(SavingThrowTechnique technique) {
		this.mapping.put(technique.element(), technique);
	}

	@Override
	protected void remove_element(SavingThrowTechnique technique) {
		this.mapping.remove(technique.element());
	}
}
