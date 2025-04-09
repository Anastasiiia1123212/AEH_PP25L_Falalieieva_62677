import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Zadanie {

    public static void main(String[] args) {
                // 2 tablice po 6 liczb całkowitych
        int[] losoweLiczby = new int[6];
             int[] liczbyUzytkownika = new int[6];

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        //  6 różnych liczb z przedziału 1 do 49
        for (int i = 0; i < 6; ) {
            int liczba = random.nextInt(49) + 1;
            boolean powtarzaSie = false;

            // Sprawdzamy czy już była taka liczba
            for (int j = 0; j < i; j++) {
                if (losoweLiczby[j] == liczba) {
                    powtarzaSie = true;
                    break;
                }
            }

            // liczba się nie powtarza, dodajemy ją do tablicy
                    if (!powtarzaSie) {
                losoweLiczby[i] = liczba;
                i++;
            }
             }

             System.out.println("Podaj 6 różnych liczb od 1 do 49:");

        for (int i = 0; i < 6; ) {
            System.out.print("Liczba " + (i + 1) + ": ");
            int liczba = scanner.nextInt();

            //  czy liczba jest w zakresie
            if (liczba < 1 || liczba > 49) {
                System.out.println("Liczba musi być z przedziału od 1 do 49.");
                continue;
            }

            //  czy już została podana
            boolean powtarzaSie = false;
            for (int j = 0; j < i; j++) {
                if (liczbyUzytkownika[j] == liczba) {
                    powtarzaSie = true;
                    break;
                }
            }

            if (powtarzaSie) {
                System.out.println("Już podałeś tę liczbę. Wpisz inną.");
                         } else {
                liczbyUzytkownika[i] = liczba;
                i++;
                 }
        }

        //  ile liczb się powtarza
        int trafienia = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (losoweLiczby[i] == liczbyUzytkownika[j]) {
                    trafienia++;
                }
            }
        }


        System.out.println("\nWylosowane liczby: " + Arrays.toString(losoweLiczby));
        System.out.println("Twoje liczby:      " + Arrays.toString(liczbyUzytkownika));
        System.out.println("Liczba trafień: " + trafienia);
    }
}
