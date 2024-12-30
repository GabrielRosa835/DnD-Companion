package main.life;

import main.life.DeathSaves;

public class Life 
{
	public HitPoints hit_points;
	public HitDice hit_dice;
	public DeathSaves death_saves;
	
	public Life(
		HitPoints hit_points, 
		HitDice hit_dice, 
		DeathSaves death_saves
	) {
		this.hit_points = hit_points;
		this.hit_dice = hit_dice;
		this.death_saves = death_saves;
	}	
}
