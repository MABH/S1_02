package n3exercici1;

import java.util.ArrayList;

public class GestioButaques {
	
	private ArrayList<Butaca> butaques;
	
	public GestioButaques() {
		super();
		this.butaques = new ArrayList<Butaca>();
	}

	public ArrayList<Butaca> getButaques() {
		return butaques;
	}

	public void afegirButaca(Butaca butaca) throws ExcepcioButacaOcupada{
		int posicio=-1;
					
		posicio=cercarButaca(butaca.getFila(), butaca.getSeient());
		if(posicio==-1) butaques.add(butaca);
		else throw new ExcepcioButacaOcupada();	
	}
	
	public int cercarButaca(int fila, int seient) {
		int i=0, posicio=-1;
		Butaca butaca=null;
		
		while(butaca==null && i<butaques.size()) {
			if(butaques.get(i).getFila()==fila && butaques.get(i).getSeient()==seient) {
				posicio=i;
			}
			i++;
		}
		return posicio;		
	}
	
	public void eliminarButaca(int fila, int seient) throws ExcepcioButacaLliure{
		int posicio=-1;
				
		posicio=cercarButaca(fila, seient);
		if(posicio!=-1) butaques.remove(posicio);
		else throw new ExcepcioButacaLliure();		
	}
}
