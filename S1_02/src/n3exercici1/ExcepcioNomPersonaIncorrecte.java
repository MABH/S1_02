package n3exercici1;

public class ExcepcioNomPersonaIncorrecte extends Exception{
private String missatge;
    
    public ExcepcioNomPersonaIncorrecte(){
        
        this.missatge="Introduïu només lletres.";
    }
    
	@Override
	    public String getMessage(){	         
	       	         
	        return missatge;	         
	    }
}
