package n3exercici1;

import java.util.ArrayList;
import java.util.Scanner;

public class Cine {	
	int nFilas;
	int nSeients;
	GestioButaques gestio;
	
	public Cine() {
		gestio = new GestioButaques();
		demanarDadesInicials();
	}
	private void demanarDadesInicials() {
		Scanner sc=new Scanner(System.in);
		String auxFiles, auxSeients;
		boolean correcte = false;
		
		nFilas=0;
		nSeients=0;
		System.out.println("\nIntrodueixi les dades del cinema.\n");
		
		do {			
			System.out.println("Introdueixi el nombre de files: ");
			auxFiles = sc.nextLine();
			if (auxFiles.matches("[0-9]*")==true) {
				nFilas = Integer.parseInt(auxFiles);
				correcte=true;		 
				if(nFilas<=0) correcte=false;
			}
			if(correcte==false) 
	        	System.out.println("Si us plau nomes valors numerics majors de 0!!!\n");    
	    }while (!correcte);	
		
		correcte = false;
		do {			
			System.out.println("Introdueixi el nombre de seients: ");
			auxSeients = sc.nextLine();
			if (auxSeients.matches("[0-9]*")==true) {
				nSeients = Integer.parseInt(auxSeients);
				correcte=true;
		        if(nSeients<=0) correcte=false;		    
			}
			if(correcte==false) 
	        	System.out.println("Si us plau nomes valors numerics majors de 0!!!\n");    
		}while (!correcte);	
	}
	
	public void iniciar() {
		int opcio=0;
		do {
			opcio = menu();
			switch(opcio) {
			case '1':
				mostrarButaques(gestio);		
				break;
			case '2':	
				mostrarButaquesPersona(gestio);
				break;
			case '3':
				reservarButaca(gestio);
				break;		
			case '4':
				anularReserva(gestio);
				break;
			case '5':
				anularReservaPersona(gestio);
				break;				
			case '0':				
				System.out.println("\nHas sortit de l'aplicació\n");
				break;
			default:
				System.out.println("\nOpció incorrecta\n");
				break;
			}	
		}while (opcio!=0);
	}
	
	public int menu() {
		Scanner sc=new Scanner(System.in);
		char opcio=' ';		
		System.out.println("\nMenu Principal");
		System.out.println("1.- Mostrar totes les butaques reservades.");
		System.out.println("2.- Mostrar les butaques reservades per una persona.");
		System.out.println("3.- Reservar butaca.");
		System.out.println("4.- Anul·lar la reserva d’una butaca.");
		System.out.println("5.- Anul·lar totes les reserves d’una persona.");		
		System.out.println("0.- Sortir.");
		opcio=sc.nextLine().charAt(0);
		
		return (int)opcio;				
	}
	
	public void mostrarButaques(GestioButaques gestio){
		if (gestio.getButaques().size()!=0) {
			System.out.println("\nLlista de butaques ocupades:");
			
			for(Butaca butaca : gestio.getButaques()) {
				System.out.println("Seient: "+butaca.getSeient()+" - Fila: "+butaca.getFila());
			}
		}
		else System.out.println("\nNo hi han butaques ocupades");
	}
	
	public void mostrarButaquesPersona(GestioButaques gestio){
		String nom=null;
		int i=0;
		ArrayList<Butaca> butaques=null;
		boolean ocupada = false;		
		boolean error = false;
		
		if (gestio.getButaques().size()!=0) {
			butaques = gestio.getButaques();
			/*do {
				try {
					nom = introduirPersona();
				} catch (ExcepcioNomPersonaIncorrecte e) {
					System.err.println(e.getMessage());
				}
			}while(nom!=null);*/
			
			do {
				try {
					nom = introduirPersona();
					error = false;
				} catch (ExcepcioNomPersonaIncorrecte e) {
					System.err.println(e.getMessage());
					error=true;
				}
			}while(error);
			
			while (i<butaques.size()) {
				if (butaques.get(i).getNom().equalsIgnoreCase(nom)) {
					System.out.println("Seient: "+butaques.get(i).getSeient()+" - Fila: "+butaques.get(i).getFila());				
					ocupada = true;
				}
				i++;
			}
			
			if(ocupada==false) System.out.println("No hi han butaques reservades a nom de :"+nom);				
							
		}else System.out.println("\nNo hi han butaques ocupades");
	}

	public void reservarButaca(GestioButaques gestio){
		Butaca butaca;
		int fila=0, seient=0;
		String persona=null;
		boolean error = false;
		
		do {
			try {
				fila = introduirFila();
				error = false;
			} catch (ExcepcioFilaIncorrecta e) {
				System.err.println(e.getMessage());
				error=true;
			}
		}while(error);
		error=false;
		do {
			try {
				seient = introduirSeient();
				error = false;
			} catch (ExcepcioSeientIncorrecte e) {
				System.err.println(e.getMessage());
				error=true;
			}
		}while(error);
		error=false;
		do {
			try {
				persona = introduirPersona();
				error = false;
			} catch (ExcepcioNomPersonaIncorrecte e) {
				System.err.println(e.getMessage());
				error=true;
			}
		}while(error);
		
		butaca = new Butaca(fila, seient, persona);
		try {
			gestio.afegirButaca(butaca);
		} catch (ExcepcioButacaOcupada e) {
			System.err.println(e.getMessage());
		}
	}

	public void anularReserva(GestioButaques gestio){
		int fila=0, seient=0;
		boolean error = false;
		
		do {
			try {
				fila = introduirFila();
				error = false;
			} catch (ExcepcioFilaIncorrecta e) {
				System.err.println(e.getMessage());
				error = true;
			}
		}while(error);
		error=false;
		do {
			try {
				seient = introduirSeient();
				error = false;
			} catch (ExcepcioSeientIncorrecte e) {
				System.err.println(e.getMessage());
				error = true;
			}
		}while(error);
		error=false;
		
		try {
			gestio.eliminarButaca(fila, seient);		
		} catch (ExcepcioButacaLliure e) {
			System.err.println(e.getMessage());			
		}		
	}

	public void anularReservaPersona(GestioButaques gestio){
		String persona=null;
		int i=0;
		ArrayList<Butaca> butaques;
		boolean error = false;
		
		do {
			try {
				persona = introduirPersona();
				error = false;
			} catch (ExcepcioNomPersonaIncorrecte e) {
				System.err.println(e.getMessage());
				error = true;
			}
		}while(error);
		butaques = gestio.getButaques();
		
		while (i<butaques.size()) {
			if (butaques.get(i).getNom().equalsIgnoreCase(persona)) {
				butaques.remove(i);
			}
			i++;
		}		
	}
	
	public String introduirPersona() throws ExcepcioNomPersonaIncorrecte{
		Scanner sc=new Scanner(System.in);
		String nom=null;		
		
		System.out.println("Introdueixi el nom: ");
		nom=sc.nextLine();
		if (nom.matches("[a-zA-Z]*")==false)
		{	
			nom = null;
			throw new ExcepcioNomPersonaIncorrecte();			
		}
		return nom;
	}
	
	public int introduirFila() throws ExcepcioFilaIncorrecta{
		Scanner sc=new Scanner(System.in);
		String fila=null;		
		boolean correcte = false;
		
		System.out.println("\nIntrodueixi la fila: ");
		fila=sc.nextLine();
		
		if (fila.matches("[0-9]*")==true)
		{	
			correcte=true;
			if (Integer.parseInt(fila)==0 || Integer.parseInt(fila)>nFilas) correcte=false;
		}
		
		if(!correcte) {
			fila = null;
			throw new ExcepcioFilaIncorrecta();			
		}
		
		return Integer.parseInt(fila) ;
	}
	
	public int introduirSeient() throws ExcepcioSeientIncorrecte {
		Scanner sc=new Scanner(System.in);
		String seient=null;		
		boolean correcte = false;
		
		System.out.println("\nIntrodueixi el seient: ");
		seient=sc.nextLine();
		
		if (seient.matches("[0-9]*")==true)
		{	
			correcte=true;
			if (Integer.parseInt(seient)==0 || Integer.parseInt(seient)>nSeients) correcte=false;
		}
		
		if(!correcte) {
			seient = null;
			throw new ExcepcioSeientIncorrecte();
		}
		
		return Integer.parseInt(seient) ;
	}

}
