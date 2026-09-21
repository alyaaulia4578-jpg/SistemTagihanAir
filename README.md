# Sistem Perhitungan Tagihan Air


**Nama:** Alya Aulia  
**NIM:** 2509116060  
**Kelas:** B  
**Mata Kuliah:** Pemrograman Berorientasi Objek  

---

## Deskripsi Sistem

**Sistem Perhitungan Tagihan Air** merupakan aplikasi berbasis **Command Line Interface (CLI)** yang dibuat menggunakan bahasa pemrograman Java.

Sistem ini digunakan untuk menghitung jumlah pemakaian air berdasarkan selisih antara meter awal dan meter akhir. Setelah jumlah pemakaian diperoleh, sistem akan menghitung total tagihan berdasarkan golongan yang dipilih oleh pengguna.

Pada sistem ini terdapat dua golongan, yaitu:

- **Hunian**, yaitu golongan penggunaan air untuk tempat tinggal.
- **Usaha**, yaitu golongan penggunaan air untuk kegiatan usaha.

Tarif yang digunakan pada program merupakan **tarif simulasi untuk kebutuhan tugas**, yaitu:

- Hunian = Rp3.000/m³
- Usaha = Rp5.000/m³

Perhitungan yang digunakan adalah:

```text
Pemakaian Air = Meter Akhir - Meter Awal

Total Tagihan = Pemakaian Air × Tarif Golongan
```

---

## Fitur Sistem

Sistem memiliki beberapa fungsi utama, yaitu:

1. Menampilkan menu utama.
2. Memasukkan nomor meter.
3. Memasukkan nilai meter awal.
4. Memasukkan nilai meter akhir.
5. Menghitung jumlah pemakaian air.
6. Memilih golongan Hunian atau Usaha.
7. Menentukan tarif berdasarkan golongan.
8. Menghitung total tagihan air.
9. Menampilkan hasil perhitungan.
10. Melakukan validasi agar meter akhir tidak lebih kecil dari meter awal.
11. Menjalankan program secara berulang sampai pengguna memilih menu keluar.

---

## Struktur Class

Program terdiri dari lima class, yaitu:

```text
Golongan
├── Hunian
└── Usaha

Meter
Main
```

Keterangan:

- `Golongan` merupakan **superclass**.
- `Hunian` merupakan **subclass** dari Golongan.
- `Usaha` merupakan **subclass** dari Golongan.
- `Meter` digunakan untuk menyimpan dan mengolah data meter air.
- `Main` merupakan class utama untuk menjalankan program.

### Screenshot Struktur Project

<img width="199" height="111" alt="Screenshot 2026-09-21 211922" src="https://github.com/user-attachments/assets/493ef672-edfa-45a6-b974-8bc6b9a23dca" /> 


---

# Penjelasan Class

## 1. Class Golongan

Class `Golongan` merupakan superclass yang digunakan untuk menyimpan data umum mengenai golongan penggunaan air.

Atribut yang digunakan adalah:

```java
protected String nama;
protected int tarif;
```

Keterangan:

- `nama` digunakan untuk menyimpan nama golongan.
- `tarif` digunakan untuk menyimpan tarif air per meter kubik.

Constructor pada class Golongan:

```java
public Golongan(String nama, int tarif) {
    this.nama = nama;
    this.tarif = tarif;
}
```

Constructor tersebut digunakan untuk memberikan nilai awal pada atribut `nama` dan `tarif`.

Class Golongan juga mempunyai method:

```java
public int hitungTagihan(int pemakaian) {
    return pemakaian * tarif;
}
```

Method `hitungTagihan()` digunakan untuk menghitung total tagihan air dengan cara mengalikan jumlah pemakaian dengan tarif golongan.

Getter yang digunakan adalah:

```java
public String getNama() {
    return nama;
}

public int getTarif() {
    return tarif;
}
```

Getter digunakan agar nilai nama golongan dan tarif dapat diakses dari class lain.

---

## 2. Class Hunian

Class `Hunian` merupakan subclass dari class `Golongan`.

Kode utama pada class Hunian:

```java
public class Hunian extends Golongan {

    public Hunian() {
        super("Hunian", 3000);
    }
}
```

Bagian:

```java
extends Golongan
```

menunjukkan bahwa class `Hunian` mewarisi atribut dan method yang terdapat pada class `Golongan`.

Sedangkan kode:

```java
super("Hunian", 3000);
```

digunakan untuk memanggil constructor dari superclass `Golongan`.

Nilai tersebut berarti:

```text
Nama Golongan : Hunian
Tarif         : Rp3.000/m³
```


<img width="519" height="164" alt="Screenshot 2026-09-21 211943" src="https://github.com/user-attachments/assets/f34125bb-6bb8-4341-b823-b4fdb86c1300" />

---

## 3. Class Usaha

Class `Usaha` juga merupakan subclass dari class `Golongan`.

Kode utama:

```java
public class Usaha extends Golongan {

    public Usaha() {
        super("Usaha", 5000);
    }
}
```

Bagian:

```java
extends Golongan
```

menunjukkan bahwa class `Usaha` mewarisi atribut dan method yang terdapat pada class `Golongan`.

Kode:

```java
super("Usaha", 5000);
```

digunakan untuk memberikan nilai nama golongan dan tarif kepada constructor superclass.

Nilainya adalah:

```text
Nama Golongan : Usaha
Tarif         : Rp5.000/m³
```

Dengan demikian, class Hunian dan Usaha memiliki struktur dasar yang sama, tetapi menggunakan tarif yang berbeda.

---

## 4. Class Meter

Class `Meter` digunakan untuk menyimpan data meter air dan menghitung jumlah pemakaian air.

Atribut yang digunakan adalah:

```java
private String nomor;
private int awal;
private int akhir;
```

Keterangan:

- `nomor` digunakan untuk menyimpan nomor meter.
- `awal` digunakan untuk menyimpan angka meter awal.
- `akhir` digunakan untuk menyimpan angka meter akhir.

Constructor pada class Meter:

```java
public Meter(String nomor, int awal, int akhir) {
    this.nomor = nomor;
    this.awal = awal;
    this.akhir = akhir;
}
```

Method untuk menghitung jumlah pemakaian air:

```java
public int hitungPemakaian() {
    return akhir - awal;
}
```

Contoh:

```text
Meter Awal  = 100
Meter Akhir = 115

Pemakaian = 115 - 100
Pemakaian = 15 m³
```

Class Meter juga mempunyai getter untuk mengambil nilai nomor meter, meter awal, dan meter akhir.

```java
public String getNomor() {
    return nomor;
}

public int getAwal() {
    return awal;
}

public int getAkhir() {
    return akhir;
}
```

---

## 5. Class Main

Class `Main` merupakan class utama yang digunakan untuk menjalankan seluruh proses pada Sistem Perhitungan Tagihan Air.

Program menggunakan:

```java
Scanner input = new Scanner(System.in);
```

`Scanner` digunakan untuk menerima input dari pengguna melalui console.

Menu utama yang ditampilkan adalah:

```text
==============================
 SISTEM PERHITUNGAN TAGIHAN AIR
==============================
1. Hitung Tagihan
2. Keluar
```

Menu dijalankan menggunakan perulangan:

```java
do {
    // proses program
} while (menu != 2);
```

Dengan perulangan tersebut, program akan terus kembali ke menu utama sampai pengguna memilih menu `2. Keluar`.

---

# Penerapan Inheritance

Konsep **inheritance** diterapkan pada hubungan antara class berikut:

```text
Golongan
├── Hunian
└── Usaha
```

Class `Golongan` merupakan **superclass**, sedangkan `Hunian` dan `Usaha` merupakan **subclass**.

Penerapan inheritance pada class Hunian:

```java
public class Hunian extends Golongan
```

Penerapan inheritance pada class Usaha:

```java
public class Usaha extends Golongan
```

Dengan inheritance tersebut, class `Hunian` dan `Usaha` dapat mewarisi atribut dan method dari class `Golongan`, yaitu:

```text
nama
tarif
hitungTagihan()
getNama()
getTarif()
```

Hal ini membuat kode program lebih terstruktur dan mengurangi penulisan kode yang sama secara berulang.

---

## Penggunaan Superclass dan Subclass

Pada class `Main`, digunakan deklarasi:

```java
Golongan golongan;
```

Object yang digunakan kemudian ditentukan berdasarkan pilihan pengguna.

```java
if (pilihan == 1) {
    golongan = new Hunian();
} else if (pilihan == 2) {
    golongan = new Usaha();
}
```

Jika pengguna memilih:

```text
1. Hunian
```

maka program menjalankan:

```java
golongan = new Hunian();
```

dan tarif yang digunakan adalah Rp3.000/m³.

Jika pengguna memilih:

```text
2. Usaha
```

maka program menjalankan:

```java
golongan = new Usaha();
```

dan tarif yang digunakan adalah Rp5.000/m³.

Setelah golongan ditentukan, program menghitung pemakaian dan total tagihan dengan:

```java
int pemakaian = meter.hitungPemakaian();
int total = golongan.hitungTagihan(pemakaian);
```

Dengan demikian, class `Meter`, `Golongan`, `Hunian`, dan `Usaha` saling digunakan dalam proses perhitungan tagihan air.

---

# Alur Program

Alur kerja Sistem Perhitungan Tagihan Air adalah sebagai berikut:

```text
Mulai
  ↓
Tampilkan Menu Utama
  ↓
Pilih Hitung Tagihan
  ↓
Input Nomor Meter
  ↓
Input Meter Awal
  ↓
Input Meter Akhir
  ↓
Validasi Nilai Meter
  ↓
Hitung Pemakaian Air
  ↓
Pilih Golongan
  ↓
Hunian / Usaha
  ↓
Tentukan Tarif
  ↓
Hitung Total Tagihan
  ↓
Tampilkan Hasil
  ↓
Kembali ke Menu Utama
  ↓
Pilih Keluar
  ↓
Selesai
```

---

# Validasi Data

Program mempunyai validasi untuk memastikan nilai meter akhir tidak lebih kecil dari nilai meter awal.

Kode yang digunakan adalah:

```java
if (akhir < awal) {
    System.out.println("Meter akhir tidak boleh lebih kecil dari meter awal.");
    continue;
}
```

Contoh input yang salah:

```text
Meter Awal  : 150
Meter Akhir : 120
```

Karena meter akhir lebih kecil daripada meter awal, program tidak akan melanjutkan proses perhitungan dan akan menampilkan pesan:

```text
Meter akhir tidak boleh lebih kecil dari meter awal.
```


# Contoh Perhitungan

Contoh data yang dimasukkan:

```text
Nomor Meter : M1
Meter Awal  : 100
Meter Akhir : 115
Golongan    : Hunian
```

Jumlah pemakaian air:

```text
Pemakaian = Meter Akhir - Meter Awal

Pemakaian = 115 - 100

Pemakaian = 15 m³
```

Tarif golongan Hunian:

```text
Rp3.000/m³
```

Maka total tagihan:

```text
Total Tagihan = Pemakaian × Tarif

Total Tagihan = 15 × Rp3.000

Total Tagihan = Rp45.000
```

Hasil yang ditampilkan oleh program:

```text
==============================
      HASIL TAGIHAN AIR
==============================
Nomor Meter : M1
Golongan    : Hunian
Meter Awal  : 100
Meter Akhir : 115
Pemakaian   : 15 m3
Tarif       : Rp3000/m3
Total       : Rp45000
==============================
```

---

# Hasil Program

<img width="745" height="399" alt="Screenshot 2026-09-21 211837" src="https://github.com/user-attachments/assets/9020602a-706c-4680-91bd-db7f827443b4" />



---

# Cara Menjalankan Program

Program dapat dijalankan menggunakan NetBeans dengan langkah berikut:

1. Buka NetBeans.
2. Buka project `SistemPerhitunganTagihanAir`.
3. Pastikan seluruh class berada pada package `sistemtagihanair`.
4. Jalankan project dengan **Run Project**.
5. Program akan menampilkan menu utama.
6. Pilih `1. Hitung Tagihan`.
7. Masukkan nomor meter.
8. Masukkan nilai meter awal.
9. Masukkan nilai meter akhir.
10. Pilih golongan:
    - `1` untuk Hunian.
    - `2` untuk Usaha.
11. Sistem menghitung jumlah pemakaian air.
12. Sistem menghitung total tagihan berdasarkan tarif golongan.
13. Hasil perhitungan ditampilkan pada console.
14. Pilih `2. Keluar` untuk menghentikan program.

---

# Contoh Penggunaan Program

```text
==============================
 SISTEM PERHITUNGAN TAGIHAN AIR
==============================
1. Hitung Tagihan
2. Keluar

Pilih menu: 1

Nomor Meter : M1
Meter Awal  : 100
Meter Akhir : 115

Pilih Golongan:
1. Hunian
2. Usaha

Pilihan: 1

==============================
      HASIL TAGIHAN AIR
==============================
Nomor Meter : M1
Golongan    : Hunian
Meter Awal  : 100
Meter Akhir : 115
Pemakaian   : 15 m3
Tarif       : Rp3000/m3
Total       : Rp45000
==============================
```

---

# Konsep Pemrograman Berorientasi Objek yang Digunakan

Program ini menerapkan beberapa konsep dasar Pemrograman Berorientasi Objek, yaitu:

## Class dan Object

Program menggunakan beberapa class, yaitu:

```text
Golongan
Hunian
Usaha
Meter
Main
```

Object dibuat dari class tersebut saat program dijalankan.

Contohnya:

```java
Meter meter = new Meter(nomor, awal, akhir);
```

Object `meter` digunakan untuk menyimpan dan mengolah data meter air.

---

## Constructor

Constructor digunakan untuk memberikan nilai awal ketika sebuah object dibuat.

Contoh pada class Golongan:

```java
public Golongan(String nama, int tarif) {
    this.nama = nama;
    this.tarif = tarif;
}
```

Contoh pada class Meter:

```java
public Meter(String nomor, int awal, int akhir) {
    this.nomor = nomor;
    this.awal = awal;
    this.akhir = akhir;
}
```

---

## Encapsulation

Class `Meter` menggunakan atribut dengan access modifier `private`.

```java
private String nomor;
private int awal;
private int akhir;
```

Data tersebut diakses menggunakan getter seperti:

```java
public String getNomor() {
    return nomor;
}
```

Penggunaan atribut private membantu membatasi akses langsung terhadap data dari luar class.

---

## Inheritance

Inheritance diterapkan dengan menjadikan class `Golongan` sebagai superclass serta class `Hunian` dan `Usaha` sebagai subclass.

```java
public class Hunian extends Golongan
```

dan:

```java
public class Usaha extends Golongan
```

Dengan inheritance, class Hunian dan Usaha dapat menggunakan atribut dan method yang telah dibuat pada class Golongan.

---

# Kesimpulan

Sistem Perhitungan Tagihan Air merupakan aplikasi Java berbasis Command Line Interface yang digunakan untuk menghitung jumlah pemakaian dan total tagihan air.

Pemakaian air dihitung berdasarkan selisih antara meter akhir dan meter awal. Total tagihan kemudian dihitung berdasarkan tarif dari golongan yang dipilih, yaitu Hunian atau Usaha.

Program dibuat menggunakan konsep Pemrograman Berorientasi Objek dengan beberapa class yang memiliki fungsi masing-masing. Penerapan inheritance terdapat pada class `Golongan` sebagai superclass serta class `Hunian` dan `Usaha` sebagai subclass.

Penerapan class, object, constructor, encapsulation, dan inheritance membuat program lebih terstruktur serta memudahkan pengelolaan kode.

---
