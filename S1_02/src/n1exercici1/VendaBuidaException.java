package n1exercici1;

public class VendaBuidaException extends Exception{
	 
	private String missatge;
    
    public VendaBuidaException(String missatge){
        super();
        this.missatge=missatge;
    }
    
	@Override
	    public String getMessage(){	         
	       	         
	        return missatge;	         
	    }
}
