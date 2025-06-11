package pl.pp;



import java.util.*;

interface TypPaliwa {
    String getTypPaliwa();
}

// Implementacje TypPaliwa
class Diesel implements TypPaliwa {
    public String getTypPaliwa() {
        return "Diesel";
    }
}

class Benzyna implements TypPaliwa {
    public String getTypPaliwa() {
        return "Benzyna";
    }
}

class Elektryk implements TypPaliwa {
    public String getTypPaliwa() {
        return "Elektryk";
    }
}

// Klasa abstrakcyjna Pojazd
abstract class Pojazd {
    protected String nrRejestracyjny;
    protected String numerVin;
    protected String kolor;
    protected double cena;
    protected double spalanie; // litry na 100 km
    protected double poziomPaliwa; // litry
    protected double przebieg; // km
    protected TypPaliwa typPaliwa;

    public Pojazd(String nrRejestracyjny, String numerVin, String kolor, double cena,
                  double spalanie, double poziomPaliwa, double przebieg, TypPaliwa typPaliwa) {
        this.nrRejestracyjny = nrRejestracyjny;
        this.numerVin = numerVin;
        this.kolor = kolor;
        this.cena = cena;
        this.spalanie = spalanie;
        this.poziomPaliwa = poziomPaliwa;
        this.przebieg = przebieg;
        this.typPaliwa = typPaliwa;
    }

    public void prowadz(double km) {
        double zuzycie = (km * spalanie) / 100.0;
        if (poziomPaliwa >= zuzycie) {
            poziomPaliwa -= zuzycie;
            przebieg += km;
            System.out.println("Przejechano " + km + " km.");
        } else {
            System.out.println("Za mało paliwa! Przejechano 0 km.");
        }
    }

    public void zatankuj(double litry) {
        poziomPaliwa += litry;
        System.out.println("Zatankowano " + litry + " litrów paliwa.");
    }

    public void info() {
        System.out.println("=== " + this.getClass().getSimpleName() + " ===");
        System.out.println("Rejestracja: " + nrRejestracyjny);
        System.out.println("VIN: " + numerVin);
        System.out.println("Kolor: " + kolor);
        System.out.println("Cena: " + cena + " PLN");
        System.out.println("Spalanie: " + spalanie + " l/100km");
        System.out.println("Paliwo: " + typPaliwa.getTypPaliwa());
        System.out.println("Poziom paliwa: " + poziomPaliwa + " l");
        System.out.println("Przebieg: " + przebieg + " km");
        System.out.println();
    }
}

// Klasa Osobowe
class Osobowe extends Pojazd {
    private int liczbaDrzwi;

    public Osobowe(String nrRejestracyjny, String numerVin, String kolor, double cena,
                   double spalanie, double poziomPaliwa, double przebieg, TypPaliwa typPaliwa, int liczbaDrzwi) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg, typPaliwa);
        this.liczbaDrzwi = liczbaDrzwi;
    }
}

// Klasa Ciezarowka
class Ciezarowka extends Pojazd {
    private double ladownosc;

    public Ciezarowka(String nrRejestracyjny, String numerVin, String kolor, double cena,
                      double spalanie, double poziomPaliwa, double przebieg, TypPaliwa typPaliwa, double ladownosc) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg, typPaliwa);
        this.ladownosc = ladownosc;
    }
}

// Klasa Motocykl
class Motocykl extends Pojazd {
    private boolean posiadaDostawke;

    public Motocykl(String nrRejestracyjny, String numerVin, String kolor, double cena,
                    double spalanie, double poziomPaliwa, double przebieg, TypPaliwa typPaliwa, boolean posiadaDostawke) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg, typPaliwa);
        this.posiadaDostawke = posiadaDostawke;
    }
}

// Klasa SprzetBudowlany
class SprzetBudowlany extends Pojazd {
    private int przepracowaneGodziny;

    public SprzetBudowlany(String nrRejestracyjny, String numerVin, String kolor, double cena,
                           double spalanie, double poziomPaliwa, double przebieg, TypPaliwa typPaliwa, int przepracowaneGodziny) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg, typPaliwa);
        this.przepracowaneGodziny = przepracowaneGodziny;
    }
}

// Klasa Testowa
public class mojaCzternastaAplikacja {
    public static void main(String[] args) {
        Pojazd osobowy = new Osobowe("KR12345", "VINOSOB123", "Czerwony", 75000, 6.5, 40, 100000, new Benzyna(), 5);
        Pojazd ciezarowka = new Ciezarowka("KR23456", "VINCIEZ456", "Biały", 150000, 12.0, 120, 200000, new Diesel(), 10000);
        Pojazd motocykl = new Motocykl("KR34567", "VINMOTO789", "Czarny", 20000, 4.0, 15, 25000, new Benzyna(), false);
        Pojazd koparka = new SprzetBudowlany("KR45678", "VINSRPB999", "Żółty", 300000, 20.0, 60, 5000, new Diesel(), 1500);

        osobowy.info();
        osobowy.prowadz(100);
        osobowy.zatankuj(20);
        osobowy.info();

        ciezarowka.info();
        motocykl.info();
        koparka.info();
    }
}