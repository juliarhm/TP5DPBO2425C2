Saya Julia Rahmawati dengan NIM 2400742 mengerjakan TP 4 dalam mata kuliah Desain Pemrograman Berorientasi Berorientasi Objek untuk keberkahan-Nya, maka saya tidak akan melakukan kecurangan seperti yang telah di spesifikasikan Aamiin.

#### Desain Program
1. kelas mahasiswa ( kelas yang digunakan untuk menyimpan data setiap mahasiswa. atribut atribut nya ada nim, nama, prodi, fakultas, alamat, dan jeniskelamin.method yang di tambhakan ada Getter dan setter untuk semua atribut agar bisa diakses dan diubah kelas lain).
2. kelas MahasiswaMenu ( kelas ini merupakan tampilan utama dengan menggunakan JFrame yang berfungsi menampilkan data mahasiswa. komponen yang di gunakan JTextField nimField, namaField, prodiField, alamatField, JComboBox fakultasComboBox, JRadioButton lakiLakiRadioButton, perempuanRadioButton, JButton addUpdateButton, deleteButton, cancelButton, JTable productTable. Fitur yang di tambahkan ada ButtonGroup jenisKelaminGroup, ArrayList listMahasiswa, selectedIndex, populateList(),insertData(), updateData(), deleteData(), dan clearform()).
3. kelas database untuk mengatur koneksi dan komunikaasi, atributny ada connection, statement, method yang ada selectquery, insertupdatedeletequery, dan getstatment.

#### Penjelasan Alur
1. class mahasiswa memilik 6 atribut yaiut, nim, nama, prodi, fakultas, alamat, dan jenisi kelamin. setiap atribut memiliki getter dan setter
2. class database, kelas untuk mengkoneksikan dan mengorerasikan ke database MySQL. Alur dari Databsenya itu:
    1. membuat koneksi ke databse mahasiswa di localhost
    2. menjalankan printah select
    3. menjalankan perintah insert, update, dan delete.
3. class mahasiswaMenu, kelas utama untuk tampilan. Alurnya :
   1. membuat objek mahasiswamenu, menentukan ukuran, posisi, warna backgroun, dan menampilkan jendela GUI.
   2. membuat objek database untuk koneksi ke MySQl

#### Dokumentasi
###### 1. Insert Data 
![gambar]Dokumentasi/Data_yang_diAdd.png
###### 2. Hasil Data 
![gambar]Dokumentasi/Data_berhasil_ditambahkan.png
###### 3. Update Data 
![gambar]Dokumentasi/Data_yang_akan_diUpdate.png
###### 4. Hasil Data 
![gambar]Dokumentasi/Data_Terupdate.png
###### 5. Delete Data 
![gambar]Delete_data.png
delete data nya masih gagal
###### 6. Jika Kolom Data Ada Yang Kosong 
![gambar]Kolom_Ada_yg_Kosong.png
###### 7. Jika NIM Ada Yang Sama 
![gambar]Nim_Sama.png
