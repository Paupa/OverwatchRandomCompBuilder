package model;

public class Assignation {
	
	private String player;
	private Heroes hero;
	
	public Assignation(String player, Heroes hero) {
		this.player = player;
		this.hero = hero;
	}
	
	public String getPlayer() {
		return player;
	}
	public Heroes getHero() {
		return hero;
	}

}
