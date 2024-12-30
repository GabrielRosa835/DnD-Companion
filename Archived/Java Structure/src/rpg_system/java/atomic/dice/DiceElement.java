package atomic.dice;

import atomic.Element;

public interface DiceElement extends Element 
{
	public int max_possible();
	public double average();

	public enum Standard implements DiceElement {
		D4(4), D6(6), D8(8), D10(10), D12(12), D20(20), D100(100);
		
		private int max_possible;
		public int max_possible() {return max_possible;}
		
		public double average() {return (max_possible+1)/2;}
				
		private Standard(int max_possible) {
			this.max_possible = max_possible;
		}
	}
	public class Custom implements DiceElement {
		private String name;
		public String name() {return name;}
		
		private int max_possible;
		public int max_possible() {return max_possible;}
		
		public double average() {return (max_possible+1)/2;}
		
		public Custom(String name, int max_possible) {
			this.name = name.toUpperCase();
			this.max_possible = max_possible;
		}
	}
}
