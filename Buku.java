package Semester_2.Praktikum.Buku;

import java.io.BufferedWriter;
import java.io.IOException;

public class Buku {
    private String judul;
    private String penulis;
    private int tahunTerbit;

    public Buku(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    public void tampilInfo() {
        System.out.println("Judul: " + judul + ", Penulis: " + penulis + ", Tahun Terbit: " + tahunTerbit);
    }

    public void tampilInfo(boolean ringkas) {
        if (ringkas) {
            System.out.println("Judul: " + judul);
        } else {
            tampilInfo();
        }
    }

    public void simpanFile(BufferedWriter writer) throws IOException {
        writer.write(judul);
        writer.newLine();
        writer.write(penulis);
        writer.newLine();
        writer.write(String.valueOf(tahunTerbit));
        writer.newLine();
    }
}