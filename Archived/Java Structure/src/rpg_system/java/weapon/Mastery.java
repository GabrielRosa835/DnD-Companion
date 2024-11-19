package weapon;

public class Mastery {
	public Options option;
	
	public interface Options {
		public String name();
		public String description();
		
		public enum Fixed implements Options {
			CLEAVE, GRAZE, NICK, PUSH, SAP, SLOW, TOPPLE, VEX;
			
			private String description;
			public String description() {return description;}
		}
		
		public class Custom implements Options {
			private String name;
			public String name() {return name;}
			
			private String description;
			public String description() {return description;}
			public Custom(String name, String description) {
				this.name = name.toUpperCase();
				this.description = description;
			}
		}
	}
}
