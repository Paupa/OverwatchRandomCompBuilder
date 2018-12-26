package model;

public enum Challenges {
	panicUlt("PANIC ULT", "Usa tu ulti nada más la consigas"),
	berseker("BERSEKER", "Cada vez que veas a un enemigo tienes que ir hacia él para matarlo"),
	doomfist("TODOS SOMOS DOOMFIST", "Solo podéis atacar con puñitos"),
	apestao("APESTAO", "No se te puede curar"),
	floorLava("THE FLOOR IS LAVA", "Tienes que estar siempre en highgrounds"),
	iman("IMAN", "Tienes que estar tocando siempre el punto"),
	spamer("SPAMER", "Cada vez que mates a alguien tienes que usar una voiceline o emote"),
	permamute("PERMAMUTE", "No puedes hablar"),
	permacall("PERMACALL", "Debes callear o decir constantemente lo que haces"),
	fuckYou("FUCK YOU IN PARTICULAR", "Solo puedes hacer solo ults"),
	permaflanker("PERMAFLANKER", "Tienes que flankear siempre"),
	noNoobs("NO NOOBS", "Juega sin interfaz"),
	mirror("MIRROR", "Cámbiate al personaje del que te haya matado siempre"),
	cambiarSensibilidad("QUÉ LÍO", "Sube tu sensibilidad 2.0 puntos"),
	sinShift("SIN SHIFT", "No puedes usar las habilidades asignadas a la tecla shift"),
	sinE("SIN E", "No puedes usar las habilidades asignadas a la tecla e"),
	sinClickDerecho("SIN CLICK DERECHO", "No puedes usar las habilidades asignadas al click derecho"),
	sneaky("SNEAKY", "Debes pasarte la partida jugando agachado");
	
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
