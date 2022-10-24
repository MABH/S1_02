package n2exercici1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
	static Scanner sc=new Scanner(System.in);
	
	public static byte llegirByte(String missatge) throws InputMismatchException, Exception{
		byte dada=-1;
		
		do {	
			System.out.println(missatge);	
			try {
				dada=sc.nextByte();
			} catch (InputMismatchException e) {
				System.err.println("Heu d'ingressar un nombre enter des de 0 a 127.\n");
			}
			sc.nextLine();
		}while (dada < 0 || dada >127);
		
		return dada;
	}
	
	public static int llegirInt(String missatge) throws InputMismatchException{
		int dada=-1;
		
		do {
			System.out.println(missatge);		
			try {
				dada=sc.nextInt();
			} catch (InputMismatchException e) {
				
				//System.err.println("Heu d'ingressar un nombre enter des de -2.147.483.648 fins a 2.147.483.647\n");
				System.err.println("Heu d'ingressar un nombre enter des de 0 fins a 2.147.483.647\n");
			}
			sc.nextLine();
		}while (dada < 0);
		
		return dada;
	}
	
	public static float llegirFloat(String missatge) throws InputMismatchException{
		float dada=0;
		
		do {
			System.out.println(missatge);		
			try {
				dada=sc.nextFloat();
			} catch (InputMismatchException e) {
				System.err.println("Error de format.\n");
				
			}
			sc.nextLine();
		}while (dada <= 0);
		
		return dada;
	}
	
	public static double llegirDouble(String missatge) throws InputMismatchException{
			double dada=0;
			
			do {
				System.out.println(missatge);		
				try {
					dada=sc.nextDouble();
				} catch (InputMismatchException e) {
					System.err.println("Error de format.\n");
				}
				sc.nextLine();
			}while (dada <= 0);
			
			return dada;
	}
	
	public static char llegirChar(String missatge) throws Exception{
		char dada=' ';
		
		do {
			System.out.println(missatge);		
			try {
				dada=sc.nextLine().charAt(0);
				if((int)dada < 33 || (int)dada > 171) throw new InputMismatchException();
			} catch (InputMismatchException e) {
				System.err.println("Heu d'ingressar un caracter valit.\n");
			}
		}while ((int)dada < 33 || (int)dada > 171);
		
		return dada;
	}
	
	public static String llegirString(String missatge) throws Exception{
		String dada=null;
		
		do {
			System.out.println(missatge+": ");		
			try {
				dada=sc.nextLine();
				if (dada.matches("[a-zA-Z]+")==false) throw new InputMismatchException();
			} catch (InputMismatchException e) {
				System.err.println("Heu d'ingressar nomes lletres.\n");
			}
		}while (dada.matches("[a-zA-Z]+")==false);
		
		return dada;
	}
	
	public static boolean llegirSiNo(String missatge) throws InputMismatchException, Exception{
		boolean dada = false;		
		char auxDada=' ';
		
		do {			
			System.out.println(missatge+": ");		
			try {
				auxDada=sc.nextLine().toUpperCase().charAt(0);
								
				if(auxDada=='S') dada = true;
				else if(auxDada=='N') dada = false;
				else throw new InputMismatchException();
			} catch (InputMismatchException e) {
				//e.printStackTrace();
				System.err.println("Heu d'ingressar (s/n).\n");
			}
		}while (auxDada != 'S' && auxDada != 'N');
		
		return dada;
	}
}