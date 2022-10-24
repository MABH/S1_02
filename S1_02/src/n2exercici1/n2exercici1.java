package n2exercici1;

import java.util.InputMismatchException;

public class n2exercici1 {
	public static void main(String[] args) throws InputMismatchException, Exception {
		
		System.out.println("\nLes dades demanades no es comproven solament es tracten per fer saltar les escepcions");
		
		Entrada.llegirByte("Introdueix la teva edat: ");
		Entrada.llegirInt("Introdueix el teu any de naixement: ");
		Entrada.llegirFloat("Introdueix la teva alçada: ");
		Entrada.llegirDouble("Introdueix el nombre PI amb 9 decimals: ");
		Entrada.llegirChar("Introdueix un caracter del codi ASCII desde el '33' fins al '171': ");
		Entrada.llegirString("Introdueix el teu nom: ");
		Entrada.llegirSiNo("Introdueix (s/n)");
	}
}
