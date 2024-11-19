package atomic.currency;

import atomic.Element.NormalizeableElement;

public interface Currency extends NormalizeableElement<Integer>
{
	// Normalized based on Copper's value
	
	public enum Standard implements Currency 
	{
		PLATINUM(1000), GOLD(100), ELECTRUM(50), SILVER(10), COPPER(1);
		
		private Integer normalizing_factor;
		public Integer normalizing_factor() {return normalizing_factor;}
		
		private Standard(int normalizing_factor) {
			this.normalizing_factor = normalizing_factor;
		}
	}
	
	public class Custom implements Currency 
	{ 
		private String name;
		public String name() {return name;}
		
		private Integer normalizing_factor;
		public Integer normalizing_factor() {return normalizing_factor;}
		
		public Custom(String name, int normalizing_factor) {
			this.name = name.toUpperCase();
			this.normalizing_factor = normalizing_factor;
		}
	}
}
