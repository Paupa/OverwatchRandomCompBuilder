package model;

public enum Heroes {
	
	// Tanks
	Dva(HeroClass.tank), Orisa(HeroClass.tank), Reinhardt(HeroClass.tank), 
	Roadhog(HeroClass.tank), Winston(HeroClass.tank), WreckingBall(HeroClass.tank), 
	Zarya(HeroClass.tank),
	
	//Damage
	Ashe(HeroClass.damage), Bastion(HeroClass.damage), Doomfist(HeroClass.damage),
	Genji(HeroClass.damage), Hanzo(HeroClass.damage), Junkrat(HeroClass.damage), 
	McCree(HeroClass.damage), Mei(HeroClass.damage), Pharah(HeroClass.damage), 
	Reaper(HeroClass.damage), Soldier76(HeroClass.damage), Sombra(HeroClass.damage), 
	Symmetra(HeroClass.damage), Torbjorn(HeroClass.damage), Tracer(HeroClass.damage), 
	Widowmaker(HeroClass.damage),
	
	//Support
	Ana(HeroClass.support), Brigitte(HeroClass.support), Lucio(HeroClass.support), 
	Mercy(HeroClass.support), Moira(HeroClass.support), Zenyatta(HeroClass.support);
	
	private HeroClass hClass;
	
	Heroes(HeroClass hClass) {
		
		this.hClass = hClass;
	}
	
	public HeroClass getHeroeClass() {
		return hClass;
	}

}
