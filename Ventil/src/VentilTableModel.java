//vkljucimo paket za delo s tabelami
import javax.swing.table.*;
import java.util.*;

//razred, ki razsirja TableModel
public class VentilTableModel extends DefaultTableModel{
	
	//Seznam kozarcev
	private ArrayList<Ventil> ventili;
	
	//deklariramo in inicializiramo sprem. c
	int c = 1;
	
	
	//Konstruktor
	public VentilTableModel(){
		
		//klicemo konstruktor nadrazreda
		super();
		
		//inicializiramo seznam kozarcev
		ventili = new ArrayList<Ventil>();
		
		
		// dodamo stolpce v tabelo
		addColumn("ID Ventila");
		addColumn("Lokacija");
		addColumn("Odprtost");
		addColumn("Status ventila");
		
		
		//dodamo prvo vrstico tabele
		Object[] prvaVrstica = new Object[]{"ID","Lokacija","Odprtost Ventila", "Status Ventila"};
		addRow(prvaVrstica);
		
	}
	
	//metoda za dodajanje vrstic
	
	public void dodajVentil(Ventil y){
		
		
		
		//doda kozarec v seznam
		ventili.add(y);
		
		//preverimo ali je ventil odprt ali zaprt
		String status;
		
		if(y.getStatusVentila() == true){
			status = "Ventil je odprt";
		}else{
			status = "Ventil je zaprt";
		}
		
		//pripravi vrstico za vnos v tabelo
		Object[] vrstica = new Object[]{c, y.getLokacijaVentila(), y.getOdprtostVentila()+ " %", status};
		
		//doda vrednost v tabelo
		addRow(vrstica);
		
		//dodamo sprem c +1
		c++;
	}

	//public int velikostSeznama(){
		
		//int velikost = ventili.size();
		//return velikost;
		//}
	

	

}