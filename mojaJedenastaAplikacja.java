package pl.pp;



import java.util.*;

class Student {
    private String indeks;
    private String imie;
    private String nazwisko;
    private List<Integer> oceny;

    public Student(String indeks, String imie, String nazwisko, List<Integer> oceny) {
        this.indeks = indeks;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.oceny = oceny;
    }

    public String getIndeks() {
        return indeks;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public List<Integer> getOceny() {
        return oceny;
    }

    public double obliczSrednia() {
        if (oceny == null || oceny.isEmpty()) {
            return 0.0;
        }
        int suma = 0;
        for (int ocena : oceny) {
            suma += ocena;
        }
        return (double) suma / oceny.size();
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + " (" + indeks + ") Average: " + String.format("%.2f", obliczSrednia());
    }
}

public class mojaJedenastaAplikacja {
    public static void main(String[] args) {
        List<Student> studenci = Arrays.asList(
                new Student("12345", "Jan", "Kowalski", Arrays.asList(4, 5, 3, 5)),
                new Student("67890", "Anna", "Nowak", Arrays.asList(5, 5, 4, 4)),
                new Student("54321", "Paweł", "Wiśniewski", Arrays.asList(2, 3, 2, 4)),
                new Student("89876", "Katarzyna", "Kowalczyk", Arrays.asList(5, 4, 4, 5))
        );

        // 1. Znajdź studenta z najwyższą średnią
        Student najlepszy = studenci.get(0);
        for (Student s : studenci) {
            if (s.obliczSrednia() > najlepszy.obliczSrednia()) {
                najlepszy = s;
            }
        }

        System.out.println("Student z najwyższą średnią: " +
                najlepszy.getImie() + " " + najlepszy.getNazwisko() +
                " (" + najlepszy.getIndeks() + ") Average: " + String.format("%.2f", najlepszy.obliczSrednia()));

        // 2. Sortowanie według nazwiska
        List<Student> posortowani = new ArrayList<>(studenci);
        posortowani.sort(Comparator.comparing(Student::getNazwisko));

        System.out.println("\nStudenci posortowani według nazwisk:");
        for (Student s : posortowani) {
            System.out.println(s);
        }

        // 3. Średnia ocen wszystkich studentów
        double sumaSrednich = 0;
        for (Student s : studenci) {
            sumaSrednich += s.obliczSrednia();
        }
        double sredniaWszystkich = sumaSrednich / studenci.size();
        System.out.println("\nŚrednia ocen wszystkich studentów: " + String.format("%.2f", sredniaWszystkich));
    }
}
