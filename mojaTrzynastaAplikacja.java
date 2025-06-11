package pl.pp;



import java.util.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class mojaTrzynastaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path sciezkaWejsciowa;
        while (true) {
            System.out.print("Podaj ścieżkę do pliku wejściowego: ");
            String inputPath = scanner.nextLine();
            sciezkaWejsciowa = Paths.get(inputPath);

            if (Files.exists(sciezkaWejsciowa)) {
                break;
            } else {
                System.out.println("Problem z odczytem pliku.");
            }
        }


        String zawartosc = "";
        try {
            zawartosc = Files.readString(sciezkaWejsciowa);
        } catch (IOException e) {
            System.out.println("Problem z odczytem pliku: " + e.getMessage());
            return;
        }


        String[] slowa = zawartosc.split("\\s+");
        int liczbaSlow = slowa.length;
        System.out.println("Liczba słów w pliku: " + liczbaSlow);


        Map<String, Integer> wystapienia = new TreeMap<>();

        for (String slowo : slowa) {
            String czysteSlowo = slowo
                    .replaceAll("[^a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ0-9]", "")
                    .toLowerCase();

            if (czysteSlowo.isEmpty()) continue;

            wystapienia.put(czysteSlowo, wystapienia.getOrDefault(czysteSlowo, 0) + 1);
        }


        StringBuilder wynik = new StringBuilder();
        wynik.append("Plik: ").append(sciezkaWejsciowa.getFileName()).append("\n");
        wynik.append("Liczba słów: ").append(liczbaSlow).append("\n\n");
        wynik.append("Wystąpienia słów:\n");

        for (Map.Entry<String, Integer> entry : wystapienia.entrySet()) {
            wynik.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }


        System.out.println(wynik.toString());


        System.out.print("Podaj ścieżkę do pliku wyjściowego: ");
        String outputPath = scanner.nextLine();
        Path sciezkaWyjsciowa = Paths.get(outputPath);
        try {
            Files.writeString(sciezkaWyjsciowa, wynik.toString());
            System.out.println("Zapisano wynik do pliku: " + sciezkaWyjsciowa);
        } catch (IOException e) {
            System.out.println("Problem z odczytem pliku: " + e.getMessage());
        }
    }
}
