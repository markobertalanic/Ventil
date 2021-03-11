// vkljucimo paket za delo z vhodno izhodnimi napravami
import java.io.*;
import java.util.*;

			// Avtor: Marko Bertalanic
			// Namen: Razred, ki preizkusi delovanje metod razreda Ventil
			// Vhodi: /
			// Izhodi: trenutni status ventila, trenutna odprtost ventila, lokacija ventila
			// Test: ob zagonu programa se izpisejo statusi, odprtost in lokacije narejenih ventilov


//deklariramo javni razred
public class UporabaVentila{
	
	// deklariramo staticno lastnost, ki kaze na vnos iz konzole
	private static BufferedReader in;
	
	// deklariramo sezname
	private static ArrayList<Ventil> sVentilov;
	private static ArrayList<VarnostniVentil> sVVentilov;
	private static ArrayList<TermostatskiVentil> sTVentilov;


	// deklariramo javno staticno metodo main
	public static void main(String[] args){
		
		// inicializiramo lastnosti
		in = new BufferedReader(new InputStreamReader(System.in));
		Scanner scan = new Scanner(System.in);
		int stevilo;
		String vsebina = "";
		
		//inicializiramo sezname Ventilov - prazne sezname ventilov     <---- Abstraktni razredi array list implementirani v poslovno logiko Vaja 34 *
		sVentilov = new ArrayList<Ventil>();
		sVVentilov = new ArrayList<VarnostniVentil>();
		sTVentilov = new ArrayList<TermostatskiVentil>();
		

		//deklariramo in inicializiramo counter in izvajamo zanko do praznega vnosa
		int c1=0;
		do{
			
			// Vprasamo uporabnika kje se nahaja ventil
			try{
				System.out.print("Vnesi lokacijo ventila " + (c1+1) + ": ");
				vsebina = in.readLine();
			}
			catch(Exception e){
				System.err.println("Napaka pri vnosu" + e.toString());
			}
	
			// deklariramo in inicializiramo nove objekte tipa Ventil
			//Ventil ventil1 = new Ventil(vsebina);
			sVentilov.add(new Ventil(vsebina));
			
	
			System.out.println(" ");
			
			// ce ni prazen vnos izpišemo status (odprt/zaprt) in lokacijo ventila
			if(vsebina != ""){
				if(sVentilov.get(c1).getStatusVentila() == true){
					System.out.println("Ventil na lokaciji " + sVentilov.get(c1).getLokacijaVentila() + " je odprt.");			
				}
				else{
					System.out.println("Ventil na lokaciji " + sVentilov.get(c1).getLokacijaVentila() + " je zaprt.");			
				}
			}
			c1++;
		
		} while (vsebina != "");
		//preberemo stevilo objektov v seznamu
		int stVentilov = (sVentilov.size()-1);
		System.out.println(" ");
	
		for(int c=0; c<stVentilov; c++){
		
				try{
					// Vprasamo uporabnika za koliko hoce odpreti ventil
					System.out.print("Vnesite za koliko hocete odpreti ventil na lokaciji " + sVentilov.get(c).getLokacijaVentila() +" (%): ");
					stevilo = scan.nextInt();
				}
				catch (InputMismatchException ex){
					System.out.print("Napaka pri vnosu. Prosimo poskusite se enkrat.");
					System.out.print("Vnesite za koliko hocete odpreti ventil(%): ");
					stevilo = scan.nextInt();
					}	
		
		
			try{
				// odpremo ventil
				sVentilov.get(c).odpriVentil(stevilo);
			}
			catch(Exception e){
				System.out.print("Napaka pri vnosu.");
			}
		
		
			// ventil1 izpišemo odprtost ventila ; program vrne: Ventil na lokaciji Kuhinja je odprt na: 35%
			System.out.println("Ventil na lokaciji " + sVentilov.get(c).getLokacijaVentila() + " je odprt na: " + sVentilov.get(c).getOdprtostVentila() +"%");
			
			System.out.println(" ");

				try{
					// Vprasamo uporabnika za koliko hoce zapresi ventil
					System.out.print("Vnesite za koliko hocete zapreti ventil na lokaciji " + sVentilov.get(c).getLokacijaVentila() +" (%): ");
					stevilo = scan.nextInt();
				}
				catch (InputMismatchException ex){
					System.out.print("Napaka pri vnosu. Prosimo poskusite se enkrat.");
					System.out.print("Vnesite za koliko hocete zapreti ventil(%): ");
					stevilo = scan.nextInt();
					}

		
			try{
				// ventil1 zapiramo
				sVentilov.get(c).zapriVentil(stevilo);
			}
			catch(Exception e){
				System.out.print("Napaka pri vnosu.");
			}
			// izpišemo odprtost ventila1 ; program vrne: Ventil na lokaciji Kuhinja je odprt na: 23%
			System.out.println("Ventil na lokaciji " + sVentilov.get(c).getLokacijaVentila() + " je odprt na: " + sVentilov.get(c).getOdprtostVentila() +"%");
			System.out.println(" ");
		}
		
		
		
		//////////////////////////////////////////Varnostni ventil///////////////////////////////////
		
		
		System.out.println(" ");
		System.out.println("/////////Varnostni Ventil/////////////");
		System.out.println(" ");
		
		
		c1=0;
		do{
		
			// Vprasamo uporabnika kje se nahaja ventil
			try{
				System.out.print("Vnesi lokacijo varnostnega ventila " + (c1+1) +": ");
				vsebina = in.readLine();
			}
			catch(Exception e){
				System.err.println("Napaka pri vnosu" + e.toString());
			}
		
			//Ustavarimo nov varnosti ventil
			sVVentilov.add(new VarnostniVentil(vsebina));
			System.out.println(" ");
			c1++;
			
		}while(vsebina != "");
		
		int stVVentilov = (sVVentilov.size()-1);
		
		
		
		// dekleriramo in inicializiramo, ker z spremenljivko -stevilo- z nekega razloga od tukaj naprej vec noce delati -- razloga ne razumem
		int vnos = 0;
		
		for(int c=0; c<stVVentilov; c++){
			
			
			try{
				// Vprasamo uporabnika po trenutnem pritisku v ventilu
				System.out.print("Vnesite trenutni pritisk(Bar) v varnostnem ventilu na lokaciji " + sVVentilov.get(c).getLokacijaVentila() + ": ");
				vnos = scan.nextInt();
			}
			catch (InputMismatchException ex){
				System.out.print("Napaka pri vnosu. Prosimo poskusite se enkrat.");
				}
		
		
			try{
				//nastavimo trenutni pritisk
				sVVentilov.get(c).setPritisk(vnos);
				System.out.println("Pritisk varnostnega ventila na lokaciji " + sVVentilov.get(c).getLokacijaVentila() + " nastavljen na " + sVVentilov.get(c).getPritisk() + " bar");
			}
			catch(Exception e){
				System.out.println("Napaka pri vnosu.");
			}
			System.out.println(" ");


			try{
				// Vprasamo uporabnika pod kaksnim pritiskom naj se ventil odpre
				System.out.print("Vnesite pod katerim pritiskom(Bar) naj se varnostni ventil na lokaciji " +sVVentilov.get(c).getLokacijaVentila()+ " odpre: ");
				vnos = scan.nextInt();
			}
			catch (InputMismatchException ex){
				System.out.print("Napaka pri vnosu. Prosimo poskusite se enkrat.");
				}

		
			try{
				//nastavimo tocko varnostnega izpusta
				sVVentilov.get(c).setVarnostniIzpust(vnos);
				System.out.println("Varnostni izpust varnostnega ventila na lokaciji " + sVVentilov.get(c).getLokacijaVentila() + " nastavljen na " + sVVentilov.get(c).getVarnostniIzpust() + " barov");
			}
			catch(Exception e){
				System.out.println("Napaka pri vnosu.");
			}
			System.out.println(" ");
			//preverimo status ventila
			sVVentilov.get(c).varnostniIzpust();
		
			//izpis statusa varnostnega izpisa
			System.out.println("Varnostni Ventil na lokaciji " + sVVentilov.get(c).getLokacijaVentila() + " je odprt na: " + sVVentilov.get(c).getOdprtostVentila() +"%");
			System.out.println(" ");
		}
		
		
		
		
		//////////////////////////////////////////Termostatski ventil///////////////////////////////////
		
		System.out.println(" ");
		System.out.println("/////////Termostatski Ventil/////////////");
		System.out.println(" ");
		
		c1=0;
		do{
		
			// Vprasamo uporabnika kje se nahaja ventil
			try{
				System.out.print("Vnesi lokacijo termostatskega ventila "+(c1+1)+": ");
				vsebina = in.readLine();
			}
			catch(Exception e){
				System.err.println("Napaka pri vnosu" + e.toString());
			}
		
		
			//Ustavarimo nov termostatski ventil
			sTVentilov.add(new TermostatskiVentil(vsebina));
			System.out.println(" ");
			c1++;
		}while(vsebina != "");

		int stTVentilov = (sTVentilov.size()-1);

		for(int c=0; c<stTVentilov; c++){

			try{
				// Vprasamo uporabnika po trenutni temperaturi v termostatskem ventilu
				System.out.print("Vnesite trenutno temperaturo(*C) v termostatskem ventilu na lokaciji " + sTVentilov.get(c).getLokacijaVentila() + ": ");
				vnos = scan.nextInt();
				}
			catch (InputMismatchException ex){
				System.out.print("Napaka pri vnosu. Prosimo poskusite se enkrat.");
				}
		
			try{
				//nastavimo trenutno temperaturo
				sTVentilov.get(c).setTemperatura(vnos);
				System.out.println("Temperatura termostatskega ventila na lokaciji " + sTVentilov.get(c).getLokacijaVentila() + " je nastavljena na " + sTVentilov.get(c).getTemperatura() + " *C");
			}
			catch(Exception e){
				System.out.println("Napaka pri vnosu.");
			}
		
			System.out.println(" ");


			try{
				// Vprasamo uporabnika pod kaksno temperaturo naj se termostatski ventil odpre
				System.out.print("Vnesite temperaturo(*C), ko se naj termostatski ventil na lokaciji "+sTVentilov.get(c).getLokacijaVentila()+" odpre: ");
				vnos = scan.nextInt();

			}
			catch (InputMismatchException ex){
				System.out.print("Napaka pri vnosu. Prosimo poskusite se enkrat.");

				}

		
			try{
				//nastavimo tocko odprtja ventila
				sTVentilov.get(c).setTempStikalo(vnos);
				System.out.println("Termostatski ventil na lokaciji "+sTVentilov.get(c).getLokacijaVentila()+" se odpre pri " + sTVentilov.get(c).getTempStikalo() + " *C");
			}
			catch(Exception e){
				System.out.println("Napaka pri vnosu.");
			}
			
		
			//preverimo status ventila
			sTVentilov.get(c).tempStikalo();
		
			System.out.println(" ");
			//izpis statusa varnostnega izpisa
			System.out.println("Termostatski Ventil na lokaciji " + sTVentilov.get(c).getLokacijaVentila() + " je odprt na: " + sTVentilov.get(c).getOdprtostVentila() +"%");
			System.out.println(" ");
		}
		scan.close();	
	}
	
}