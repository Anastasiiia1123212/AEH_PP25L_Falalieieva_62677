package pl.pp;



import java.io.*;
import java.util.Scanner;

  public class mojaDwunastaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File inputFile;

        // Wczytaj poprawny plik wejściowy
        while (true) {
            System.out.print("Podaj ścieżkę do pliku wejściowego: ");
            String inputPath = scanner.nextLine();
            inputFile = new File(inputPath);

            if (inputFile.exists() && inputFile.isFile()) {
                break;
            } else {
                System.out.println("Plik nie istnieje. Spróbuj ponownie.");
            }
        }

        // Wczytaj ścieżkę do pliku wyjściowego
        System.out.print("Podaj ścieżkę do pliku wyjściowego: ");
        String outputPath = scanner.nextLine();
        File outputFile = new File(outputPath);

        int lineCount = 0;

        // Liczenie linii w pliku wejściowym
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
            System.out.println("Liczba linii w pliku: " + lineCount);
        } catch (IOException e) {
            System.out.println("Błąd podczas odczytu pliku: " + e.getMessage());
            return;
        }

        // Zapis do pliku wyjściowego
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("Plik: " + inputFile.getName() + "\n");
            writer.write("Liczba linii: " + lineCount + "\n");
            System.out.println("Dane zostały zapisane do pliku wyjściowego.");
        } catch (IOException e) {
            System.out.println("Błąd podczas zapisu do pliku: " + e.getMessage());
        }
    }
}
