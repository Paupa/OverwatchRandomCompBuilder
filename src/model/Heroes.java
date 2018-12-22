package model;

public enum Heroes {
	
	// Tanks
	Dva(HeroClass.tank, HeroSubclass.OffTank), Orisa(HeroClass.tank, HeroSubclass.MainTank), 
	Reinhardt(HeroClass.tank, HeroSubclass.MainTank), Roadhog(HeroClass.tank, HeroSubclass.OffTank), 
	Winston(HeroClass.tank, HeroSubclass.MainTank), WreckingBall(HeroClass.tank, HeroSubclass.OffTank), 
	Zarya(HeroClass.tank, HeroSubclass.OffTank),
	
	//Damage
	Ashe(HeroClass.damage, HeroSubclass.Hitscan), Bastion(HeroClass.damage, HeroSubclass.Hitscan), 
	Doomfist(HeroClass.damage, HeroSubclass.Projectiles),
	Genji(HeroClass.damage, HeroSubclass.Projectiles), Hanzo(HeroClass.damage, HeroSubclass.Projectiles), 
	Junkrat(HeroClass.damage, HeroSubclass.Projectiles), McCree(HeroClass.damage, HeroSubclass.Hitscan), 
	Mei(HeroClass.damage, HeroSubclass.Projectiles), Pharah(HeroClass.damage, HeroSubclass.Projectiles), 
	Reaper(HeroClass.damage, HeroSubclass.Projectiles), Soldier76(HeroClass.damage, HeroSubclass.Hitscan), 
	Sombra(HeroClass.damage, HeroSubclass.Hitscan), Symmetra(HeroClass.damage, HeroSubclass.Projectiles), 
	Torbjorn(HeroClass.damage, HeroSubclass.Projectiles), Tracer(HeroClass.damage, HeroSubclass.Hitscan), 
	Widowmaker(HeroClass.damage, HeroSubclass.Hitscan),
	
	//Support
	Ana(HeroClass.support, HeroSubclass.MainHeal), Brigitte(HeroClass.support, HeroSubclass.OffHeal), 
	Lucio(HeroClass.support, HeroSubclass.OffHeal), Mercy(HeroClass.support, HeroSubclass.MainHeal), 
	Moira(HeroClass.support, HeroSubclass.MainHeal), Zenyatta(HeroClass.support, HeroSubclass.OffHeal);
	
	private HeroClass hClass;
	private HeroSubclass hSubclass;
	
	Heroes(HeroClass hClass, HeroSubclass hSubclass) {
		
		this.hClass = hClass;
		this.hSubclass = hSubclass;
	}
	
	public HeroClass getHeroClass() {
		return hClass;
	}
	
	public HeroSubclass getHeroSubclass() {
		return hSubclass;
	}

}
