package atomic.distance;

import atomic.Element.NormalizeableElement;

public interface Distance extends NormalizeableElement<Double> 
{
	public enum Standard implements Distance 
	{
		METERS(1.5), FEET(5), SQUARES(1);
		
		private Double normalizing_factor;
		public Double normalizing_factor() {return this.normalizing_factor;}
		
		private Standard(double normalizing_factor) {
			this.normalizing_factor = normalizing_factor;
		}
	}
	
	public class Custom implements Distance 
	{
		private String name;
		public String name() {return this.name;}
		
		private Double normalizing_factor;
		public Double normalizing_factor() {return this.normalizing_factor;}
		
		public Custom(String name, Double normalizing_factor) {
			this.name = name.toUpperCase();
			this.normalizing_factor = normalizing_factor;
		}
	}
}
