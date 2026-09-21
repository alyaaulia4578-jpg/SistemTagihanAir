package sistemtagihanair;

public class Golongan {
    protected String nama;
    protected int tarif;

    public Golongan(String nama, int tarif) {
        this.nama = nama;
        this.tarif = tarif;
    }

    public int hitungTagihan(int pemakaian) {
        return pemakaian * tarif;
    }

    public String getNama() {
        return nama;
    }

    public int getTarif() {
        return tarif;
    }
}