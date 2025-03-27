package pl.pp;

import java.util.Scanner;

public class mojaDrugaaplikacja {
     public static void main(String[] args) {
    // liniowy
         Scanner scanner = new Scanner (System.in);
         /*
         blokowy
          */
       /*System.out.println("Proszę podaj swoje Imię:");
   String forename = scanner.nextLine();
     System.out.println("Prosze podac swoje nazwisko:");
    String surname = scanner.nextLine ();
     scanner.close();
     System.out.println("Witaj"+ forename +" " + surname);

        */
         /*
    double x = 10;
     double y = 2;
     var result = x + y;
     System.out.println ("x + y =" + result );
     result = x - y;
     System.out.println ("x - y =" + result );
     result = x * y;
     System.out.println ("x * y =" + result );
     result = x / y;
     System.out.println ("x / y =" + result );
         result = x % y;
         System.out.println ("x % y =" + result );

         System.out.println ("Wpisz dwie liczby rozdzielony klawiesze Enter"  );
         double first = scanner.nextDouble();
         double second = scanner.nextDouble();
         System.out.println("x + y =" + (first + second) );

          */
        /*
         double x = 10;
     double y = 2;

        var result = x * y;
         System.out.println ("x * y =" + result );
         result = x * x;
         System.out.println ("x * x =" + result );
         System.out.println ("x = 10"  );
         */
         System.out.println ("Proszę podaj swoj wiek"  );
         double first  = scanner.nextDouble();
         double s = 31536000 ;
         System.out.println ("Twoj wiek w sek.:" + ( first * s )  );

    }

}
