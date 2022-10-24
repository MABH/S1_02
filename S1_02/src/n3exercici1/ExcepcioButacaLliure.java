package n3exercici1;

public class ExcepcioButacaLliure extends Exception{
private String missatge;
    
    public ExcepcioButacaLliure(){
        
        this.missatge="Aquesta butaca no està ocupada.";
    }
    
	@Override
	    public String getMessage(){	         
	       	         
	        return missatge;	         
	    }
}
