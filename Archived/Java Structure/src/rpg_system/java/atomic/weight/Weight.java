package atomic.weight;

import atomic.Element.NormalizeableElement;

public interface Weight extends NormalizeableElement<Double>
{
	public enum Standard implements Weight 
	{
		KG(1), G(0.001), LBS(0.453), OZ(0.028);
		
		private Double normalizing_factor;
		public Double normalizing_factor() {return normalizing_factor;}
		
		private Standard(double normalizing_factor) {
			this.normalizing_factor = normalizing_factor;
		}
	}
	
	public class Custom implements Weight 
	{
		private String name;
		public String name() {return name;}
		
		private Double normalizing_factor;
		public Double normalizing_factor() {return normalizing_factor;}
		
		public Custom(String name, double normalizing_factor) {
			this.name = name.toUpperCase();
			this.normalizing_factor = normalizing_factor;
		}
	}
}
