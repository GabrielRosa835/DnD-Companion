package GabrielRosa835.compositions;

import GabrielRosa835.*;
import GabrielRosa835.components.*;
import GabrielRosa835.models.*;
import lombok.*;
import lombok.experimental.*;

import java.util.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@ToString
@Getter
@Accessors(fluent = true)
public class AbilityScoreComposition implements Component, Effectable
{
	private Map<AbilityScore.Type, AbilityScore> statusMapping = new HashMap<>();

	public AbilityScore get(AbilityScore.Type type) {
		return statusMapping.get(type);
	}
	public AbilityScoreComposition add(AbilityScore abilityScore) {
		statusMapping.putIfAbsent(abilityScore.type(), abilityScore);
		return this;
	}

	public AbilityScore strength() 		{return get(AbilityScore.Type.STRENGTH);}
	public AbilityScore dexterity() 		{return get(AbilityScore.Type.DEXTERITY);}
	public AbilityScore constitution() 	{return get(AbilityScore.Type.CONSTITUTION);}
	public AbilityScore intelligence() 	{return get(AbilityScore.Type.INTELLIGENCE);}
	public AbilityScore wisdom() 			{return get(AbilityScore.Type.WISDOM);}
	public AbilityScore charisma() 		{return get(AbilityScore.Type.CHARISMA);}

	public AbilityScoreComposition applyEffect(GabrielRosa835.Effect effect) {
		Effect e = (Effect) effect;
		e.loadObject(this);
		this.statusMapping = e.changeStatusMapping();
		return this;
	}
	public interface Effect extends GabrielRosa835.Effect {
		Map<AbilityScore.Type, AbilityScore> changeStatusMapping();
	}
}
