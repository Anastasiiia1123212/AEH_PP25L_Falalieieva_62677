package pl.pp;



import java.util.Scanner;

public class mojaDziewietaAplikacja {


    static class Magazyn {
        private int numerMagazynu;
        private int dostepnaPrzestrzen;
        private int zajetaPrzestrzen;
        private String nazwaWlasciciela;
        private String email;
        private String numerTelefonu;

        public Magazyn(int numerMagazynu, int dostepnaPrzestrzen, String nazwaWlasciciela, String email, String numerTelefonu) {
            this.numerMagazynu = numerMagazynu;
            this.dostepnaPrzestrzen = dostepnaPrzestrzen;
            this.zajetaPrzestrzen = 0;
            this.nazwaWlasciciela = nazwaWlasciciela;
            this.email = email;
            this.numerTelefonu = numerTelefonu;
        }

        public void dodajTowar(int ilosc) {
            if (zajetaPrzestrzen + ilosc <= dostepnaPrzestrzen) {
                zajetaPrzestrzen += ilosc;
                System.out.println("Dodano " + ilosc + " jednostek towaru.");
            } else {
                System.out.println("Za malo miejsca w magazynie.");
            }
            pokazStan();
        }

        public void usunTowar(int ilosc) {
            if (zajetaPrzestrzen >= ilosc) {
                zajetaPrzestrzen -= ilosc;
                System.out.println("Usunięto " + ilosc + " jednostek towaru.");
            } else {
                System.out.println("Nie ma tyle towaru do usunięcia.");
            }
            pokazStan();
        }

        public void sprawdzZajetosc() {
            System.out.println("Zajęta przestrzeń: " + zajetaPrzestrzen + " jednostek.");
            System.out.println("Dostępna przestrzeń: " + (dostepnaPrzestrzen - zajetaPrzestrzen) + " jednostek.");
        }

        public void aktualizujKontakt(String email, String numerTelefonu) {

            System.out.println("Zaktualizowano dane kontaktowe:");
            System.out.println("Nowy email: " + email);
            System.out.println("Nowy numer telefonu: " + numerTelefonu);
        }

        private void pokazStan() {
            System.out.println("Pozostała przestrzeń magazynowa: " + (dostepnaPrzestrzen - zajetaPrzestrzen) + " jednostek.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Magazyn magazyn = new Magazyn(3, 5000, "Anastasiia Falalieieva", "falaleeva@magazyn.pl", "+48 111 000 000");

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Dodaj towar");
            System.out.println("2. Usuń towar");
            System.out.println("3. Sprawdź zajętość");
            System.out.println("4. Zaktualizuj kontakt");
            System.out.println("5. Wyjście");
            System.out.print("Wybierz opcję: ");
            int opcja = scanner.nextInt();

            switch (opcja) {
                case 1:
                    System.out.print("Podaj ilość towaru do dodania: ");
                    int dodaj = scanner.nextInt();
                    magazyn.dodajTowar(dodaj);
                    break;
                case 2:
                    System.out.print("Podaj ilość towaru do usunięcia: ");
                    int usun = scanner.nextInt();
                    magazyn.usunTowar(usun);
                    break;
                case 3:
                    magazyn.sprawdzZajetosc();
                    break;
                case 4:
                    System.out.print("Podaj nowy email: ");
                    scanner.nextLine(); // czyści bufor
                    String email = scanner.nextLine();
                    System.out.print("Podaj nowy numer telefonu: ");
                    String telefon = scanner.nextLine();
                    magazyn.aktualizujKontakt(email, telefon);
                    break;
                case 5:
                    System.out.println("Zakończono program.");
                    return;
                default:
                    System.out.println("Nieprawidłowa opcja.");
            }
        }
    }
}
