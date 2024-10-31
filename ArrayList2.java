import java.util.ArrayList;
import java.util.Scanner;

class Buah {
    String nama;
    int harga;
    int jumlah;

    Buah(String nama, int harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    int getSubtotal() {
        return harga * jumlah;
    }
}

public class ArrayList2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] buahData = {
                { "apel", "35000" },
                { "jeruk", "50000" },
                { "mangga", "25000" },
                { "duku", "15000" },
                { "semangka", "20000" }
        };

        ArrayList<Buah> daftarBelanja = new ArrayList<>();
        int pilihan;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Beli Buah");
            System.out.println("2. Struk Belanja");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();

            if (pilihan == 1) {
                System.out.println("Daftar Buah:");
                for (int i = 0; i < buahData.length; i++) {
                    System.out.printf("%d. %s - Rp %s\n", i, buahData[i][0], buahData[i][1]);
                }

                System.out.print("Pilih Buah (0-4): ");
                int buahIndex = scanner.nextInt();
                if (buahIndex < 0 || buahIndex >= buahData.length) {
                    System.out.println("Pilihan tidak valid.");
                    continue;
                }

                System.out.print("Masukkan jumlah: ");
                int jumlah = scanner.nextInt();

                String namaBuah = buahData[buahIndex][0];
                int hargaBuah = Integer.parseInt(buahData[buahIndex][1]);
                daftarBelanja.add(new Buah(namaBuah, hargaBuah, jumlah));

                System.out.print("Input lagi? (y/n): ");
                String inputLagi = scanner.next();
                if (inputLagi.equalsIgnoreCase("n")) {
                    continue;
                }

            } else if (pilihan == 2) {
                System.out.println("Daftar Belanja:");
                System.out.println("===========================================");
                System.out.printf("%-3s %-10s %-5s %-7s %-10s\n", "No", "Nama Buah", "Jumlah", "Harga", "Subtotal");

                int total = 0;
                for (int i = 0; i < daftarBelanja.size(); i++) {
                    Buah buah = daftarBelanja.get(i);
                    int subtotal = buah.getSubtotal();
                    total += subtotal;
                    System.out.printf("%-3d %-10s %-5d %-7d %-10d\n", (i + 1), buah.nama, buah.jumlah, buah.harga,
                            subtotal);
                }

                System.out.println("===========================================");
                System.out.println("Total: " + total);

                int diskon = (int) (total * 0.15);
                int totalBayar = total - diskon;
                System.out.println("Discount (15%): " + diskon);
                System.out.println("Total bayar: " + totalBayar);
                System.out.println("-------------------------------------------");

            } else if (pilihan == 3) {
                System.out.println("Terima kasih, keluar dari program.");
                break;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}
