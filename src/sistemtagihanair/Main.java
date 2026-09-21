package sistemtagihanair;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int menu;

        do {
            System.out.println("\n==============================");
            System.out.println(" SISTEM PERHITUNGAN TAGIHAN AIR");
            System.out.println("==============================");
            System.out.println("1. Hitung Tagihan");
            System.out.println("2. Keluar");
            System.out.print("Pilih menu: ");
            menu = input.nextInt();
            input.nextLine();

            if (menu == 1) {

                System.out.print("\nNomor Meter : ");
                String nomor = input.nextLine();

                System.out.print("Meter Awal  : ");
                int awal = input.nextInt();

                System.out.print("Meter Akhir : ");
                int akhir = input.nextInt();

                if (akhir < awal) {
                    System.out.println("Meter akhir tidak boleh lebih kecil dari meter awal.");
                    continue;
                }

                Meter meter = new Meter(nomor, awal, akhir);

                System.out.println("\nPilih Golongan:");
                System.out.println("1. Hunian");
                System.out.println("2. Usaha");
                System.out.print("Pilihan: ");
                int pilihan = input.nextInt();

                Golongan golongan;

                if (pilihan == 1) {
                    golongan = new Hunian();
                } else if (pilihan == 2) {
                    golongan = new Usaha();
                } else {
                    System.out.println("Golongan tidak tersedia.");
                    continue;
                }

                int pemakaian = meter.hitungPemakaian();
                int total = golongan.hitungTagihan(pemakaian);

                System.out.println("\n==============================");
                System.out.println("      HASIL TAGIHAN AIR");
                System.out.println("==============================");
                System.out.println("Nomor Meter : " + meter.getNomor());
                System.out.println("Golongan    : " + golongan.getNama());
                System.out.println("Meter Awal  : " + meter.getAwal());
                System.out.println("Meter Akhir : " + meter.getAkhir());
                System.out.println("Pemakaian   : " + pemakaian + " m3");
                System.out.println("Tarif       : Rp" + golongan.getTarif() + "/m3");
                System.out.println("Total       : Rp" + total);
                System.out.println("==============================");

            } else if (menu == 2) {

                System.out.println("\nProgram selesai.");

            } else {

                System.out.println("\nMenu tidak tersedia.");
            }

        } while (menu != 2);

        input.close();
    }
}