
			// Avtor: Marko Bertalanic
			// Namen: Implementacija razreda Ventil z lastnostmi in metodami
			// Vhodi: Lokacija na novo ustvarjenega ventila, vrednost za odpiranje ventila, vrednost za zapiranje ventila
			// Izhodi: trenutni status ventila, trenutna odprtost ventila, lokacija ventila
			// Test: test delovanja metod sem preizkusil v loceni java datoteki. - UporabaVentila.java

//deklariramo javni razred
public class Ventil{

	//deklariramo lastnosti
	public int odprtost;
	public boolean status;
	public String lokacija;


	//deklariramo konstruktor
	public Ventil(String y){
	
		//inicializiramo lastnosti
		odprtost = 0;
		status = false;
		lokacija = y;
		
	}

	//getter metoda ki vrne status ventila
	public boolean getStatusVentila(){
		if(status == true){
			return true;
		} else {
			return false;
		}
	}

	//getter metoda ki vrne trenutno odprtost ventila
	public int getOdprtostVentila(){
		return odprtost;
	}

	//getter metoda ki vrne trenutno lokacijo ventila
	public String getLokacijaVentila(){
		return lokacija;
	}

	//metoda za odpiranje ventila
	public int odpriVentil(int x){
	
		
			// preverimo, ce je ventil ze odprt do konca
			if(odprtost < 100){
				// preverimo, ce je ventil mozno odpreti za izbrano vrednost, ce ni mozno, ga odpremo do konca
				if((odprtost + x) >= 100){			
					odprtost = 100;
				} else {
					odprtost = odprtost + x;
				}
			} else {
				odprtost = 100;
			}
	
			//spreminjanje statusa ventila na odprto ali zaprto
			if(odprtost > 0){
				status = true;
			} else {
				status = false;
			}
			return odprtost;
		
	}
	
	//metoda za zapiranje ventila
	public int zapriVentil(int x) throws Exception{
		
		if(x == (int)x){
			// preverimo, ce je ventil ze zaprt do konca
			if(odprtost > 0){
				// preverimo, ce je ventil mozno zapreti za izbrano vrednost, ce ni mozno, ga zapremo do konca
				if((odprtost - x) <= 0){			
					odprtost = 0;
				} else {
					odprtost = odprtost - x;
				}
			} else {
				odprtost = 0;
			}
		
			//spreminjanje statusa ventila na odprto ali zaprto
			if(odprtost > 0){
				status = true;
			} else {
				status = false;
			}
			return 0;
		} else {
			throw new Exception("Prosimo vnesite stevilo.");	
		}
	}

	//metoda za spreminjanje lokacije ventila
	public void spremeniLokacijoVentila(String lv){
		
		if (lv == (String)lv){
			lokacija = lv;
		}
	}	
}