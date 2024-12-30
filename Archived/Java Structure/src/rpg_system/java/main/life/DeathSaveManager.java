package main.life;

import java.util.*;

import main.life.DeathSave.Type;

public class DeathSaveManager {
	private Stack<DeathSave> successes;
	private Stack<DeathSave> failures;
	
	public Outcomes add_success() {
		this.successes.push(new DeathSave(Type.SUCCESS));
		return check_deathsaves();
	}
	public void remove_success() {
		this.successes.pop();
	}
	public Outcomes add_failure() {
		this.failures.push(new DeathSave(Type.FAILURE));
		return check_deathsaves();
	}
	public void remove_failure() {
		this.failures.pop();
	}
	public DeathSaveManager reset() {
		this.successes.clear();
		this.failures.clear();
		return this;
	}
	public Outcomes check_deathsaves()	{
		return successes.size() == 3 ? Outcomes.ESTABILIZED :
			   failures.size() == 3 ? Outcomes.DEAD :
		       Outcomes.UNCONCIOUS;
	}
	
	public DeathSaveManager() {
		this.successes = new Stack<DeathSave>();
		this.failures = new Stack<DeathSave>();
	}

	public enum Outcomes {
		UNCONCIOUS, ESTABILIZED, DEAD;
	}
}