package project.motus;

public class Joueur {
	private String name;
	private int points;
	
	public Joueur(String name) {
		this.name = name;
		this.points = 0;
	}
	
	public Joueur(String name, int points) {
		this.name = name;
		this.points = points;
	}
}
