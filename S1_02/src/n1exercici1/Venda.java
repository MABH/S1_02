package n1exercici1;

import java.util.ArrayList;

public class Venda {
	private ArrayList<Producte> productes;
	private float preuTotal;
	

	public void calcularTotal() throws VendaBuidaException{
		try {
			if (productes==null) throw new VendaBuidaException("Per fer una venda primer has d’afegir productes");
			else
				for (int i = 0; i < productes.size(); i++) {
					preuTotal += productes.get(i).preu;
				}	
		   
		} catch (ArrayIndexOutOfBoundsException e) {
			
			System.out.println(e.getMessage());
		}
	}


	public ArrayList<Producte> getProductes() {
		return productes;
	}


	public void setProductes(ArrayList<Producte> productes) {
		this.productes = productes;
	}
}
