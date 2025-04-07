package pl.pp;

import java.util.Scanner;

public class MojaCzwartaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        try {
            System.out.print("Podaj dolną i górną granicę liczby całkowitej: ");
            int dolna = scanner.nextInt();
            int gorna = scanner.nextInt();

            if (gorna <= dolna) {
                System.out.println("Gotowe");
                return;
            }

            int suma = 0;
            for (int x = dolna; x <= gorna; x++) {
                suma += x * x;
            }

            System.out.println("Suma kwadratów od " + dolna + " do " + gorna + " wynosi " + suma);
        } catch (NumberFormatException e) {
            System.out.println("Błąd, spróbuj ponownie");
        } finally {
            scanner.close();

 */
        int choice;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Dodawanie");
            System.out.println("2. Odejmowanie");
            System.out.println("3. Mnożenie");
            System.out.println("4. Dzielenie");
            System.out.println("5. Wyjście");
            System.out.print("Wybierz opcję (1-5): ");

            while (!scanner.hasNextInt()) {
                System.out.println("Błąd! Wprowadź liczbę od 1 do 5.");
                scanner.next(); // usuwa niepoprawne dane
                System.out.print("Wybierz opcję (1-5): ");
            }

            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4) {
                System.out.print("Podaj pierwszą liczbę: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("To nie jest liczba. Spróbuj ponownie:");
                    scanner.next();
                }
                double a = scanner.nextDouble();

                System.out.print("Podaj drugą liczbę: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("To nie jest liczba. Spróbuj ponownie:");
                    scanner.next();
                }
                double b = scanner.nextDouble();

                switch (choice) {
                    case 1:
                        System.out.println("Wynik dodawania: " + (a + b));
                        break;
                    case 2:
                        System.out.println("Wynik odejmowania: " + (a - b));
                        break;
                    case 3:
                        System.out.println("Wynik mnożenia: " + (a * b));
                        break;
                    case 4:
                        if (b != 0) {
                            System.out.println("Wynik dzielenia: " + (a / b));
                        } else {
                            System.out.println("Nie można dzielić przez 0!");
                        }
                        break;
                }
            } else if (choice != 5) {
                System.out.println("Niepoprawna opcja. Wybierz 1-5.");
            }

        } while (choice != 5);

        System.out.println("Dziękuję za skorzystanie z programu!");
        scanner.close();
    }
}
