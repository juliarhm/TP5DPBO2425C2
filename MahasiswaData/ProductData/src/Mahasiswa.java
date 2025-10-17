public class Mahasiswa {
    private String nim;
    private String nama;
    private String prodi;
    private String fakultas;
    private String alamat;
    private String jenisKelamin;

    public Mahasiswa(String nim, String nama, String prodi, String fakultas, String alamat, String jenisKelamin) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.fakultas = fakultas;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNim() {
        return this.nim;
    }

    public String getNama() {
        return this.nama;
    }

    public String getProdi() {
        return this.prodi;
    }

    public String getFakultas() {
        return this.fakultas;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public String getJenisKelamin() {
        return this.jenisKelamin;
    }
}