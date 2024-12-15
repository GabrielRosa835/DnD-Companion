package dnd_companion.local_storage.archived.components.main.attributes;

// Proficiency doesn't have a specific group nor a manager because it's an element used only for the general Group Technique
public interface SkillProficiencyOptions extends Element
{
	public double multiplier();

	public enum Standard implements SkillProficiencyOptions
	{
		NONE(0), PROFICIENCY(1), EXPERTISE(2), JACK_OF_ALL_TRADES(0.5);

		private double multiplier;
		@Override
		public double multiplier() {return this.multiplier;}

		private Standard(double multiplier) {
			this.multiplier = multiplier;
		}
	}

	public class Custom implements SkillProficiencyOptions
	{
		private String name;
		public String name() {return name;}

		private double multiplier;
		@Override
		public double multiplier() {return this.multiplier;}

		public Custom(String name, double multiplier) {
			this.name = name.toUpperCase();
			this.multiplier = multiplier;
		}
	}
}
