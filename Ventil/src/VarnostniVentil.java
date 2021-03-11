public class VarnostniVentil extends Ventil{
	
	//deklariramo lastnosti
	private int pritisk;
	private int varnostniIzpust;
	
	// Deklariramo nov konstruktor
	public VarnostniVentil(String y){
		
		
		// Klicemo konstruktor nadrazreda
		super(y);
		
		//iniciliziramo lastnosti
		pritisk = 0;
		varnostniIzpust = 0;
	}
	
	//metoda ki nastavi pretok v ventilu
	public void setPritisk(int x) throws Exception{
		if(x == (int)x){
			pritisk = x;
		}
		else{
			throw new Exception("Prosimo vnesite stevilo.");
		}
	}
	
	public int getPritisk(){
		return pritisk;
	}
	
	//metoda ki nastavi tocko varnostnega izpusta
	public void setVarnostniIzpust(int x) throws Exception{
		if(x == (int)x){
			varnostniIzpust = x;
		}
		else{
			throw new Exception("Prosimo vnesite stevilo.");
		}
	}
	
	//metoda ki vrne tocko varnostnega izpusta
	public int getVarnostniIzpust(){
		return varnostniIzpust;
	}
	
	// metoda, ki vrne status varnostnega ventila
	public boolean varnostniIzpust(){
		
		// preverimo, ce je pogoj za varnostni izpust
		if(pritisk < varnostniIzpust){
			odprtost = 0;
			return true;
		} else {
			odprtost = 100;
			return false;
		}
		
	}
}