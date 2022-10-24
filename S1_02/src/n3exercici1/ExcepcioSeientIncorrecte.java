package n3exercici1;

public class ExcepcioSeientIncorrecte extends Exception{
private String missatge;
    
    public ExcepcioSeientIncorrecte(){
        
        this.missatge="Nombre de seient incorrecte.";
    }
    
	@Override
	    public String getMessage(){	         
	       	         
	        return missatge;	         
	    }
}
