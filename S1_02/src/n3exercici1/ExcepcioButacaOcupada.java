package n3exercici1;

public class ExcepcioButacaOcupada extends Exception{
private String missatge;
    
    public ExcepcioButacaOcupada(){
        
        this.missatge="Aquesta butaca ja està ocupada.";
    }
    
	@Override
	    public String getMessage(){	         
	       	         
	        return missatge;	         
	    }
}
