package n1exercici1;

import java.util.ArrayList;

public class n1exercici1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producte producte;
		Venda venda = new Venda();		
		ArrayList<Producte> productes;
		
		productes = venda.getProductes();
		
		System.out.println ("Error provocado por la excepción VendaBuidaException");
		try {
			venda.calcularTotal();
		} catch (VendaBuidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println ("\nError provocado por la excepción ArrayIndexOutOfBoundsException");
		calcularTotal(productes);	
		
	}
	
	public static void calcularTotal(ArrayList<Producte> productes) throws ArrayIndexOutOfBoundsException{
		float preuTotal=0;
		try {
			for (int i = 0; i < productes.size(); i++) {
	            preuTotal += productes.get(i).preu;
	        }	
		   
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
		}
	}

}
