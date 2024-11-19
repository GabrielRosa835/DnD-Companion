package main.attributes;

import java.util.*;

import atomic.Proficiency;
import atomic.ProficiencyManager;

public class SkillManager 
{
	private ProficiencyManager proficiency_manager;
	public ProficiencyManager proficiency_manager() {return this.proficiency_manager;}
	
	public SkillManager(Skill... skills) {
		this.proficiency_manager = new SkillManager().gather(skills).proficiency_manager();
	}
	public SkillManager(Collection<Skill> skills) {
		this.proficiency_manager = new SkillManager().gather(skills).proficiency_manager();
	}
	public SkillManager(ProficiencyManager proficiency_manager) {
		this.proficiency_manager = proficiency_manager;
	}
	
	public SkillManager remove(Skill... skills) {
		return this.remove(Arrays.asList(skills));
	}
	public SkillManager remove(Collection<Skill> skills) {
		for (Skill skill : skills)
			this.proficiency_manager.remove(skill.to_proficiency());
		return this;
	}
	
	public SkillManager gather(Skill... skills) {
		return this.gather(Arrays.asList(skills));
	}
	public SkillManager gather(Collection<Skill> skills) {
		List<Proficiency> proficiency_list = new ArrayList<Proficiency>();
		for (Skill skill : skills)
			proficiency_list.add(skill.to_proficiency());
		this.proficiency_manager.merge(new ProficiencyManager(proficiency_list));
		return this;
	}
	
	public SkillManager merge(SkillManager... skill_managers) {
		return this.merge(Arrays.asList(skill_managers));
	}
	public SkillManager merge(Collection<SkillManager> skill_managers) {
		for (SkillManager skill_manager : skill_managers)
			this.proficiency_manager.merge(skill_manager.proficiency_manager());
		return this;
	}
}
