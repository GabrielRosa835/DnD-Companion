package main.life;

public class HitPoints
{
	private int current;
	public int maximum;
	public int temporary;
	
	public int current() {return current;}
	public void damage(int damage) 
	{
		temporary -= damage;
		if(temporary < 0) 
		{
			current -= temporary;
			temporary = 0;
		}
	}
	public void heal(int heal) 
	{
		current += heal;
		if(current > maximum) {current = maximum;}
	}
	
	public HitPoints(int current, int maximum, int temporary) {
		this.current = current;
		this.maximum = maximum;
		this.temporary = temporary;
	}
	public HitPoints(int maximum) {
		this.current = maximum;
		this.maximum = maximum;
		this.temporary = 0;
	}
}
