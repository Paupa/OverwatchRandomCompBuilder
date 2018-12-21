package model;

public enum Heroes {
	
	// Tanks
	Dva(HeroeClass.tank), Orisa(HeroeClass.tank), Reinhardt(HeroeClass.tank), 
	Roadhog(HeroeClass.tank), Winston(HeroeClass.tank), WreckingBall(HeroeClass.tank), 
	Zarya(HeroeClass.tank),
	
	//Damage
	Ashe(HeroeClass.damage), Bastion(HeroeClass.damage), Doomfist(HeroeClass.damage),
	Genji(HeroeClass.damage), Hanzo(HeroeClass.damage), Junkrat(HeroeClass.damage), 
	McCree(HeroeClass.damage), Mei(HeroeClass.damage), Pharah(HeroeClass.damage), 
	Reaper(HeroeClass.damage), Soldier76(HeroeClass.damage), Sombra(HeroeClass.damage), 
	Symmetra(HeroeClass.damage), Torbjorn(HeroeClass.damage), Tracer(HeroeClass.damage), 
	Widowmaker(HeroeClass.damage),
	
	//Support
	Ana(HeroeClass.support), Brigitte(HeroeClass.support), Lucio(HeroeClass.support), 
	Mercy(HeroeClass.support), Moira(HeroeClass.support), Zenyatta(HeroeClass.support);
	
	private HeroeClass hClass;
	
	Heroes(HeroeClass hClass) {
		
		this.hClass = hClass;
	}
	
	public HeroeClass getHeroeClass() {
		return hClass;
	}

}
