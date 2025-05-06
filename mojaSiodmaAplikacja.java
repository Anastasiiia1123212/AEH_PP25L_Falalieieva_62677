public class  mojaSiodmaAplikacja {


        public static void main(String[] args) {
            Person person1 = new Person("Anastasia", "Falalieeva", 19);
            person1.address = "Warszawa, ul. Warszawska 0";
            person1.birthYear = 2006;

            person1.hiToAll();
            System.out.println("Adres: " + person1.address);
            System.out.println("Rok urodzenia: " + person1.birthYear);

            person1.growOld(10);
            person1.hiToAll();

            person1.beYounger(); // - 1 rok
            person1.hiToAll();
        }
    }

    class Person {
        public String forename;
        public String surname;
        public int age;
        public String address;     // nowe pole
        public int birthYear;      // nowe pole

        public Person() {
        }

        public Person(String initForename, String initSurname, int initAge) {
            forename = initForename;
            surname = initSurname;
            age = initAge;
        }

        public void hiToAll() {
            System.out.println("Nazywam się " + forename + " " + surname + ". Mam " + age + " lat.");
        }


        public int growOld(int howManyYears) {
            age = age + howManyYears;
            return age;
        }


        public int beYounger() {
            age = age - 1;
            return age;
        }

        public String getName() {
            return forename;
        }

        public void setName(String nameToSet) {
            forename = nameToSet;
        }
    }

