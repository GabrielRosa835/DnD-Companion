package dnd_companion.common;

import dnd_companion.actors.components.rules.Health;
import dnd_companion.effects.health.DoubleDamageDealEffect;
import dnd_companion.effects.health.SimpleDamageDealEffect;
import dnd_companion.effects.health.SimpleHealEffect;

public class Main
{
	public static void main(String[] args) {
		Health health = new Health(59, 69, 25);
		ToolBox.print(health.toString());
		health.applyEffect(new SimpleDamageDealEffect(20));
		ToolBox.print(health.toString());
		health.applyEffect(new DoubleDamageDealEffect(20));
		ToolBox.print(health.toString());
		health.applyEffect(new SimpleHealEffect(20));
		ToolBox.print(health.toString());
	}
}
