package n3exercici1;

public class ExcepcioFilaIncorrecta extends Exception{
private String missatge;
    
    public ExcepcioFilaIncorrecta(){
        
        this.missatge="Nombre de fila incorrecte.";
    }
    
	@Override
	    public String getMessage(){	         
	       	         
	        return missatge;	         
	    }
}
