package pl.pp;



    public class  mojaDziesiataAplikacja {



            public static void main(String[] args) {
                int[] input = {1, 2, 3, -4, 5, -3, -11};
                int[] result = countAndSumElements(input);
                if (result.length > 0) {
                    System.out.println("Liczba ujemnych: " + result[0]);
                    System.out.println("Suma dodatnich: " + result[1]);
                } else {
                    System.out.println("Pusta tablica lub null.");
                }
            }

            public static int[] countAndSumElements(int[] input) {
                if (input == null || input.length == 0) {
                    return new int[0];
                }

                int countNegatives = 0;
                int sumPositives = 0;

                for (int number : input) {
                    if (number < 0) {
                        countNegatives++;
                    } else if (number > 0) {
                        sumPositives += number;
                    }
                }

                return new int[]{countNegatives, sumPositives};
            }
        }
