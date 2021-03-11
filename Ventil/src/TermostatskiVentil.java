public class TermostatskiVentil extends Ventil{
	
	//deklariramo lastnosti
	private int temperatura;
	private int tempStikalo;
	
	// Deklariramo nov konstruktor
	public TermostatskiVentil(String y){
		
		
		// Klicemo konstruktor nadrazreda
		super(y);
		
		//iniciliziramo lastnosti
		temperatura = 0;
		tempStikalo = 0;
	}
	
	//metoda ki nastavi termperaturp
	public void setTemperatura(int x) throws Exception{
		if(x == (int)x){
			temperatura = x;
		}
		else{
			throw new Exception("Prosimo vnesite stevilo.");
		}
	}
	//metoda ki vrne termepraturo
	public int getTemperatura(){
		return temperatura;
	}
	
	//metoda ki nastavi tocko odpiranja ventila
	public void setTempStikalo(int x) throws Exception{
		if(x == (int)x){
			tempStikalo = x;
		}
		else{
			throw new Exception("Prosimo vnesite stevilo.");
		}
	}
	//metoda ki vrne tocko odpiranja ventila
	public int getTempStikalo(){
		return tempStikalo;
	}
	
	//metoda, ki vrne status termostatskega ventila
	public boolean tempStikalo(){
		
		// preverimo, ce je pogoj za odprtje ventila
		if(temperatura > tempStikalo){
			odprtost = 100;
			return true;
		} else {
			odprtost = 0;
			return false;
		}
		
	}
	
	
	
}