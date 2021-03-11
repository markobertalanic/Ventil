//Uvozimo paket za delo z GUI
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Vmesnik implements ActionListener{
	
	//deklariramo lastnost
	private VentilTableModel modelTabele;
	private JTextField vnosnoPolje;
	private JTextField vnosnoPolje2;
	private JTextField vnosId;
	private JTextField odpriV;
	private JButton gumb;
	private JButton odpri;
	
	
	// deklariramo javno staticno metodo main
	public static void main(String[] args){
		
		
		//napravimo referenco do samega sebe
		Vmesnik m = new Vmesnik();
		
	}
	
	//Konstruktor
	public Vmesnik(){
		
		//glavno okno programa
		JFrame okno = new JFrame("Ventili GUI");
		
		// dolocimo lastnosti
		okno.setSize(800,600);
		okno.setVisible(true);
		
		//zapri
		okno.setDefaultCloseOperation(3);
		
		//povrsina z gumbi
		JPanel povrsina = new JPanel(new BorderLayout());
		
		//povrsina na vrhu
		JPanel povrsinaVrh = new JPanel();
		JPanel povrsinaSpodaj = new JPanel();
	
		//dodamo povrsino na vrhu
		povrsina.add(povrsinaVrh, BorderLayout.NORTH);
		povrsina.add(povrsinaSpodaj, BorderLayout.SOUTH);
		
		
		//dodamo povrsino na okno
		okno.add(povrsina);
		
		// napis
		JLabel napis = new JLabel ("Ventil ");
		
		//dodamo napis na povrsino
		povrsinaVrh.add(napis);
		
		//dodamo gumb
		gumb = new JButton("Dodaj Ventil");
		odpri = new JButton("Odpri");
		
		//bumbu dodamo poslusalec
		gumb.addActionListener(this);
		odpri.addActionListener(this);
		
		//dodamo vnosno polje
		vnosnoPolje = new JTextField("Vnesite lokacijo ventila", 32);
		vnosnoPolje2 = new JTextField("Vnesite odprtost ventila (%)", 16);
		vnosId = new JTextField("Vnesite ID ventila", 16);
		odpriV = new JTextField("Spremeni odprtost ventila (%)", 16);
		povrsinaVrh.add(vnosnoPolje);
		povrsinaVrh.add(vnosnoPolje2);
		povrsinaSpodaj.add(vnosId);
		povrsinaSpodaj.add(odpriV);
		povrsinaSpodaj.add(odpri);
		
		
		
		
		//gumb dodamo na zgornjo povrsino
		povrsinaVrh.add(gumb);
		
		//dodamo model tabele
		modelTabele = new VentilTableModel();
		
		
		//dodamo tabelo z modelom
		JTable tabela = new JTable(modelTabele);
		povrsina.add(tabela, BorderLayout.CENTER);
		
		
	}
	
	
	//metoda predpisana v vmesniku ActionListener
	public void actionPerformed(ActionEvent ae){
		

		
		if(ae.getSource() == this.gumb){
		
			//izdelamo nov ventil z neznano lokacijo
			Ventil y = new Ventil("");
		
			// spremenimo lokacijo ventila
			y.spremeniLokacijoVentila(vnosnoPolje.getText());
			int stv = Integer.parseInt(vnosnoPolje2.getText());
			y.odpriVentil(stv);
		
			//dodamo vrstico v tabelo
			modelTabele.dodajVentil(y);
		}
		
		if(ae.getSource() == this.odpri){
			
			// zajezimo mozno odpiranje zapiranje
			int odp = Integer.parseInt(odpriV.getText());
			if(odp > 100){
				odp = 100;
			}else if (odp < 0){
				odp = 0;	
			}
			
			//spremenimo vnos
			modelTabele.setValueAt(odp + " %", Integer.parseInt(vnosId.getText()), 2);
			
			//spremenimo status
			String st;
			if(odp > 0){
				st = "Ventil je odprt";	
			}else{
				st = "Ventil je zaprt";
			}
			modelTabele.setValueAt(st, Integer.parseInt(vnosId.getText()), 3);

		}
		
	}
	
}