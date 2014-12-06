package hack;

public class Score {
	
	private String name;
	private int score;
	
	public Score(String name, int score) {
		
		this.name = name;
		this.score = score;
		
	}
	
	public Score(String serial) {
		
		String[] parts = serial.split(",");
		this.name = parts[0];
		this.score = Integer.parseInt(parts[1]);
		
	}
	
	public String getName() {
		
		return this.name;
		
	}
	
	public int getScore() {
		
		return this.score;
		
	}
	
	public String serialise() {
		
		return this.name + "," + this.score;
		
	}

}
