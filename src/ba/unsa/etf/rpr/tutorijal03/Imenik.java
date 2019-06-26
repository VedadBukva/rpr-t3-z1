package ba.unsa.etf.rpr.tutorijal03;

import java.util.*;

public class Imenik {

    public HashMap<String, TelefonskiBroj> getBrojKorisnik() {
        return brojKorisnik;
    }

    private HashMap<String,TelefonskiBroj> brojKorisnik=new HashMap<>();

    public Imenik(){}

    public String dajBroj(String imePrezime) {
        return brojKorisnik.get(imePrezime).ispisi();
    }

    public void dodaj(String imePrezime, TelefonskiBroj broj) {
        brojKorisnik.putIfAbsent(imePrezime,broj);
    }

    public Set<String> izGrada(FiksniBroj.Grad nazivGrada) {
        Set<String> townPeople = new TreeSet<>();
        for(Map.Entry<String, TelefonskiBroj> element : brojKorisnik.entrySet()) {
            TelefonskiBroj broj = element.getValue();
            if (broj instanceof FiksniBroj){
                if(((FiksniBroj)broj).getGrad().equals(nazivGrada))townPeople.add(element.getKey());
            }
        }
        return townPeople;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(FiksniBroj.Grad nazivGrada) {
        Set<TelefonskiBroj> brojeviIzGrada = new TreeSet<>();
        for(Map.Entry<String, TelefonskiBroj> element : brojKorisnik.entrySet()) {
            TelefonskiBroj broj = element.getValue();
            if (broj instanceof FiksniBroj){
                if(((FiksniBroj)broj).getGrad().equals(nazivGrada))brojeviIzGrada.add(element.getValue());
            }
        }
        return brojeviIzGrada;
    }

    public String naSlovo(char s) {
        int counter=1;
        StringBuilder people = new StringBuilder();
        for(Map.Entry<String, TelefonskiBroj> element : brojKorisnik.entrySet()) {
            if( element.getKey().charAt(0)==s){
                people.append(String.format("%d. %s - %s\n", counter, element.getKey(), element.getValue().ispisi()));
                counter++;
            }
        }
        return people.toString();
    }

    public String dajIme(TelefonskiBroj broj){
        for(Map.Entry<String, TelefonskiBroj> element : brojKorisnik.entrySet()) {
            if( element.getValue().compareTo(broj)==0)return element.getKey();
        }
        return "";
    }
}
