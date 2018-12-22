package model;

public enum Challenges {
	manoContraria("MANO CONTRARIA", "Intercambia la mano del rat�n y del teclado"),
	mareo("QU� MAREO", "Invierte los controles de movimiento"),
	panicUlt("PANIC ULT", "Usa tu ulti nada m�s la consigas"),
	berseker("BERSEKER", "Cada vez que veas a un enemigo tienes que ir hacia �l para matarlo"),
	doomfist("TODOS SOMOS DOOMFIST", "Solo pod�is atacar con pu�itos"),
	apestao("APESTAO", "No se te puede curar"),
	floorLava("THE FLOOR IS LAVA", "Tienes que estar siempre en highgrounds"),
	iman("IMAN", "Tienes que estar tocando siempre el punto"),
	spamer("SPAMER", "Cada vez que mates a alguien tienes que usar una voiceline o emote"),
	permamute("PERMAMUTE", "No puedes hablar"),
	permacall("PERMACALL", "Debes callear o decir constantemente lo que haces"),
	fuckYou("FUCK YOU IN PARTICULAR", "Solo puedes hacer solo ults"),
	permaflanker("PERMAFLANKER", "Tienes que flankear siempre"),
	noNoobs("NO NOOBS", "Juega sin interfaz"),
	mirror("MIRROR", "C�mbiate al personaje del que te haya matado siempre");
	
	private String title;
	private String description;

	Challenges(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
}
