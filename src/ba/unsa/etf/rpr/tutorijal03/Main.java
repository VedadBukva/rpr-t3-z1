package ba.unsa.etf.rpr.tutorijal03;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main {
	private  Imenik imenik = new Imenik() ;

	public static void main(String[] args) {
		Main aplikacija = new Main();

		String usluga="";
		usluga += "Sljedeće komande možete koristiti pri radu sa ETF imenikom:\n";
		usluga +="*dodajMobitel -> za dodavanje mobilnog broja u imenik\n";
		usluga +="*dodajFiksni -> za dodavanje fiksnog broja u imenik\n";
		usluga +="*dodajMedjunarodni -> za dodavanje međunarodnog broja u imenik\n";
		usluga +="*dajBroj -> za dohvaćanje broja nekog korisnika\n";
		usluga +="*izGrada -> za dohvaćanje korisnika jednog grada\n";
		usluga +="*izGradaBrojevi -> za dohvaćanje brojeva korisnika iz jednog grada\n";
		usluga +="*naSlovo -> za dohvaćanje korisnika čije ime počinje na slovo, i njihovih brojeva\n";
		usluga +="*dajIme -> za dohvaćanje imena korisnika na osnovu broja\n";
		usluga +="*kraj -> izlaz iz programa\n";
		String funkcija;
		Scanner citac = new Scanner(System.in);
		Ende:for(;;){
			System.out.println(usluga);
			System.out.print("komanda: ");
			funkcija = citac.next();
			switch (funkcija){
				case "dodajMobitel":
					aplikacija.dodajMob();
					break;
				case "dodajFiksni":
					aplikacija.dodajFiks();
					break;
				case "izGrada":
					aplikacija.izGrada();
					break;
				case "izGradaBrojevi":
					aplikacija.izGradaBrojevi();
					break;
				case "naSlovo":
					aplikacija.naSlovo();
					break;
				case "dajIme":
					aplikacija.dajIme();
					break;
				case "dajBroj":
					aplikacija.dajBroj();
					break;
				case "dodajMedjunarodni":
					aplikacija.dodajMed();
					break;
				case "kraj":
					break Ende;
				default:
					break ;
			}
		}
	}

	private void dajBroj() {
		Metoda metoda = new Metoda().invoke();
		String ime = metoda.getIme();
		String prezime = metoda.getPrezime();
		System.out.println(imenik.dajBroj(ime+" "+ prezime));
	}

	private void dajIme(){
		HashMap<String,TelefonskiBroj> kopija= imenik.getBrojKorisnik();
		System.out.print("Unesite broj korisnika: ");
		Scanner citac = new Scanner(System.in);
		String input = citac.next();
		for(HashMap.Entry<String,TelefonskiBroj> element : kopija.entrySet()){
			if(element.getValue().ispisi().equals(input))
			{
				System.out.println("Ime korisnika s brojem "+input+" je "+element.getKey());
				return;
			}
		}
		System.out.println("Broj ne postoji!");
	}
	private void naSlovo(){
		Scanner citac = new Scanner(System.in);
		char slovo = (citac.next()).charAt(0);
		System.out.println( imenik.naSlovo(slovo));
	}
	private void izGradaBrojevi(){
		ispisGradova("Unesite grad:\n"+
				"TRAVNIK\n"+ "ORASJE\n"+ "ZENICA\n"+ "SARAJEVO\n"+ "LIVNO\n"+
				"TUZLA\n"+ "MOSTAR\n"+ "BIHAC\n"+ "GORAZDE\n"+ "SIROKIBRIJEG\n"+
				"MRKONJICGRAD\n"+ "BANJALUKA\n"+ "PRIJEDOR\n"+ "DOBOJ\n"+
				"SAMAC\n"+ "BIJELJINA\n"+ "ZVORNIK\n"+ "PALE\n"+"FOCA\n"+"TREBINJE\n");
		Scanner citac = new Scanner(System.in);
		String grad = citac.next();
		FiksniBroj.Grad grad1 = FiksniBroj.Grad.valueOf(grad);
		Set<TelefonskiBroj> brojevi = imenik.izGradaBrojevi(grad1);
		for(TelefonskiBroj element : brojevi){
			System.out.println(element.ispisi());
		}
	}
	private void izGrada(){
		ispisGradova("Unesite grad:\n" +
				"TRAVNIK\n" + "ORASJE\n" + "ZENICA\n" + "SARAJEVO\n" + "LIVNO\n" +
				"TUZLA\n" + "MOSTAR\n" + "BIHAC\n" + "GORAZDE\n" + "SIROKIBRIJEG\n" +
				"MRKONJICGRAD\n" + "BANJALUKA\n" + "PRIJEDOR\n" + "DOBOJ\n" +
				"SAMAC\n" + "BIJELJINA\n" + "ZVORNIK\n" + "PALE\n" + "FOCA\n" + "TREBINJE\n");
		Scanner citac = new Scanner(System.in);
		String grad = citac.next();
		FiksniBroj.Grad grad1 = FiksniBroj.Grad.valueOf(grad);
		Set<String> names = imenik.izGrada(grad1);
		for(String element : names){
			System.out.println("--"+element);
		}
	}

	private void ispisGradova(String s) {
		System.out.println(s);
	}

	private void dodajFiks(){
		Scanner citac = new Scanner(System.in);
		System.out.println("Ime i prezime korisnika: ");

		String ime=citac.next();
		String prezime=citac.next();

		System.out.println("Unesite grad:\n"+
				"TRAVNIK\n"+ "ORASJE\n"+ "ZENICA\n"+ "SARAJEVO\n"+ "LIVNO\n"+
				"TUZLA\n"+ "MOSTAR\n"+ "BIHAC\n"+ "GORAZDE\n"+ "SIROKIBRIJEG\n"+
				"MRKONJICGRAD\n"+ "BANJALUKA\n"+ "PRIJEDOR\n"+ "DOBOJ\n"+
				"SAMAC\n"+ "BIJELJINA\n"+ "ZVORNIK\n"+ "PALE\n"+"FOCA\n"+"TREBINJE\n");

		String grad=citac.next();
		FiksniBroj.Grad grad1 = FiksniBroj.Grad.valueOf(grad);
		System.out.print("Unesite broj koji dolazi poslije pozivnog(123-456): ");
		String broj=citac.next();
		try {
			imenik.dodaj(ime + " " + prezime, new FiksniBroj(grad1, broj));
		}catch(IllegalArgumentException izuzetak) {
			System.out.println(izuzetak.getMessage());
		}
	}

	private void dodajMob(){
		Scanner citac = new Scanner(System.in);
		Metoda metoda = new Metoda().invoke();
		String ime = metoda.getIme();
		String prezime = metoda.getPrezime();

		System.out.println("Mreže:\n"+
				"BH Mobile : 060, 061, 062\n"+
				"ERONET : 063\n"+
				"Haloo : 064\n"+
				"mtel : 065, 066, 067(Izi mobil)\n");
		System.out.print("Unesite pozivni broj bez 0(primjer 61 za 061): ");
		int pozivni;
		pozivni = citac.nextInt();
		System.out.print("Unesite broj koji dolazi poslije pozivnog(123-456): ");
		String broj=citac.next();
		try {
			imenik.dodaj(ime + " " + prezime, new MobilniBroj(pozivni, broj));
		}catch(IllegalArgumentException izuzetak) {
			System.out.println(izuzetak.getMessage());
		}
	}

	private void dodajMed() {
		Scanner citac = new Scanner(System.in);
		Metoda metoda = new Metoda().invoke();
		String ime = metoda.getIme();
		String prezime = metoda.getPrezime();
		System.out.print("Unesite broj države (+387) : ");
		String pozivni = citac.next();
		System.out.print("Unesite vas broj(33/123-456): ");
		String broj = citac.next();
		imenik.dodaj(ime+" "+prezime, new MedunarodniBroj(pozivni,broj));
	}

	private class Metoda {
		private String ime;
		private String prezime;

		public String getIme() {
			return ime;
		}

		public String getPrezime() {
			return prezime;
		}

		public Metoda invoke() {
			Scanner citac = new Scanner(System.in);
			System.out.println("Ime i prezime korisnika: ");

			ime = citac.next();
			prezime = citac.next();
			return this;
		}
	}
}