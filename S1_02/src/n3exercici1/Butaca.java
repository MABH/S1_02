package n3exercici1;

public class Butaca {
	
	private int fila;
	private int seient;
	private String nom;
	
	public Butaca(int fila, int seient, String nom) {
		super();
		this.fila = fila;
		this.seient = seient;
		this.nom = nom;
	}

	public boolean Equals(int fila, int seient) {
		boolean iguals=false;
		
		if(fila==seient) iguals=true;
		return iguals;		
	}
	
	public int getFila() {
		return fila;
	}

	public int getSeient() {
		return seient;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Butaca [Fila=" + fila + ", Seient=" + seient + ", Persona=" + nom + "]";
	}
}
