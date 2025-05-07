package pl.pp;



    public class  mojaOsmaAplikacja {


            public static void main(String[] args) {
                Konto mojeKonto = new Konto("PL1234567890", 1000.0, "Jan Kowalski", "jan@example.com", "123456789");

                mojeKonto.wyplata(900.0);
                mojeKonto.wplata(250.0);
                mojeKonto.wyplata(50.0);
                mojeKonto.wyplata(500.0);
            }
        }

        class Konto {
            private String numerKonta;
            private double saldo;
            private String wlasciciel;
            private String email;
            private String numerTelefonu;

            public Konto(String numerKonta, double saldo, String wlasciciel, String email, String numerTelefonu) {
                this.numerKonta = numerKonta;
                this.saldo = saldo;
                this.wlasciciel = wlasciciel;
                this.email = email;
                this.numerTelefonu = numerTelefonu;
            }

            public String getNumerKonta() {
                return numerKonta;
            }

            public double getSaldo() {
                return saldo;
            }

            public String getWlasciciel() {
                return wlasciciel;
            }

            public String getEmail() {
                return email;
            }

            public String getNumerTelefonu() {
                return numerTelefonu;
            }

            public void setNumerKonta(String numerKonta) {
                this.numerKonta = numerKonta;
            }

            public void setSaldo(double saldo) {
                this.saldo = saldo;
            }

            public void setWlasciciel(String wlasciciel) {
                this.wlasciciel = wlasciciel;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public void setNumerTelefonu(String numerTelefonu) {
                this.numerTelefonu = numerTelefonu;
            }

            public void wplata(double kwota) {
                if (kwota > 0) {
                    saldo += kwota;
                    System.out.println("Wpłata PLN " + kwota + " została wykonana. Nowe saldo PLN " + saldo);
                } else {
                    System.out.println("Nieprawidłowa kwota do wpłaty.");
                }
            }

            public void wyplata(double kwota) {
                if (kwota > saldo) {
                    System.out.println("Brak środków. Masz PLN " + saldo + " na koncie.");
                } else if (kwota > 0) {
                    saldo -= kwota;
                    System.out.println("Pobrano PLN " + kwota + " z konta. Pozostałe saldo PLN " + saldo);
                } else {
                              System.out.println("Nieprawidłowa kwota do wypłaty.");
                }
            }
        }