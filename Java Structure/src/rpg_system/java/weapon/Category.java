package weapon;

public class Category {
	public Options option;
	
	public interface Options {
		public String name();
		
		public enum Fixed {SIMPLE, MARTIAL}
		
		public class Custom {
			private String name;
			public String name() {return name;}
			
			public Custom(String name) {
				this.name = name.toUpperCase();
			}
		}
	}
}
