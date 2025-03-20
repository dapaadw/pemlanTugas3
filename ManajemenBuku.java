package Semester_2.Praktikum.Buku;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ManajemenBuku {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pil;

        do {
            System.out.println("=== Manajemen Buku ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan: ");
            pil = sc.nextInt();
            sc.nextLine();

            switch (pil) {
                case 1:
                    tambahBuku(sc);
                    break;
                case 2:
                    tampilDaftarBuku(sc);
                    break;
                case 3:
                    System.out.println("Anda telah keluar dari program");
                    break;
                default:
                    System.out.println("Pilihan tidak valid (1-3)");
            }
        } while (pil != 3);
    }

    private static void tambahBuku(Scanner sc) {
        System.out.print("Judul: ");
        String judul = sc.nextLine();
        System.out.print("Penulis: ");
        String penulis = sc.nextLine();
        System.out.print("Tahun Terbit: ");
        int tahunTerbit = sc.nextInt();
        sc.nextLine();

        Buku buku = new Buku(judul, penulis, tahunTerbit);
        simpanBukuFile(buku);
        System.out.println("Buku berhasil ditambahkan!");
    }

    private static void tampilDaftarBuku(Scanner sc) {
        try (BufferedReader reader = new BufferedReader(new FileReader("daftar_buku.txt"))) {
            String line;
            System.out.print("Daftar buku ringkas? (y/n): ");
            boolean ringkas = sc.nextLine().equalsIgnoreCase("y");

            while ((line = reader.readLine()) != null) {
                String penulis = reader.readLine();
                int tahunTerbit = Integer.parseInt(reader.readLine());
                Buku buku = new Buku(line, penulis, tahunTerbit);
                buku.tampilInfo(ringkas);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file!");
        }
    }

    private static void simpanBukuFile(Buku buku) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("daftar_buku.txt", true))) {
            buku.simpanFile(writer);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan file!");
        }
    }
}
