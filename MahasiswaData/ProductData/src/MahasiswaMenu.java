import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MahasiswaMenu extends JFrame {
    public static void main(String[] args) {
        // buat object window
        MahasiswaMenu menu = new MahasiswaMenu();

        // atur ukuran window
        menu.setSize(700, 600);

        // letakkan window di tengah layar
        menu.setLocationRelativeTo(null);

        // isi window
        menu.setContentPane(menu.mainPanel);

        // ubah warna background
        menu.getContentPane().setBackground(Color.PINK);

        // tampilkan window
        menu.setVisible(true);

        // agar program ikut berhenti saat window diclose
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // index baris yang diklik
    private int selectedIndex = -1;
    // menambahkan atribut database
    private Database database;
    private String selectedNim = "";

    private JPanel mainPanel;
    private JTextField nimField;
    private JTextField namaField;
    private JTextField prodiField;
    private JTextField alamatField;

    private JTable productTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JComboBox<String> fakultasComboBox;
    private JButton deleteButton;
    private JLabel dataMahasiswaLabel;
    private JLabel nimLabel;
    private JLabel namaLabel;
    private JLabel prodiLabel;
    private JLabel fakultasLabel;
    private JLabel alamatLabel;
    private JLabel jenisKelaminLabel;
    private ButtonGroup jenisKelaminGroup;
    private JRadioButton lakiLakiRadioButton;
    private JRadioButton perampuanRadioButton;

    // constructor
    public MahasiswaMenu() {

        // buat objek database
        database = new Database();

        // isi tabel produk
        productTable.setModel(setTable());

        // ubah styling title
        dataMahasiswaLabel.setFont(dataMahasiswaLabel.getFont().deriveFont(Font.BOLD, 20f));

        jenisKelaminGroup = new ButtonGroup();
        jenisKelaminGroup.add(lakiLakiRadioButton);
        jenisKelaminGroup.add(perampuanRadioButton);

        // isi combo box fakultas
        String[] fakultasData = {"???", "FPTI", "FPEB", "FIP", "FH", "FK", "FPMIPA", "FPSD", "FPOK"};
        fakultasComboBox.setModel(new DefaultComboBoxModel<>(fakultasData));

        // sembunyikan button delete
        deleteButton.setVisible(false);

        // saat tombol add.update ditekan
        addUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex == -1) {
                    insertData();
                } else {
                    updateData();
                }
            }
        });
        // saat tombol delete ditekan
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pilihan = JOptionPane.showConfirmDialog(
                        null, "Apakah Kamu Yakin Ingin Menghapus Data Ini ??", "Konfirmasi!", JOptionPane.YES_NO_OPTION
                );
                  deleteData();
            }
        });

        // saat tombol cancel ditekan
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        // saat salah satu baris tabel ditekan
        productTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // ubah selectedIndex menjadi baris tabel yang diklik
                selectedIndex = productTable.getSelectedRow();

                // simpan value textfield dan combo box
                String curNim = productTable.getModel().getValueAt(selectedIndex, 0).toString();
                String curNama = productTable.getModel().getValueAt(selectedIndex, 1).toString();
                String curProdi = productTable.getModel().getValueAt(selectedIndex, 2).toString();
                String curFakultas = productTable.getModel().getValueAt(selectedIndex, 3).toString();
                String curAlamat = productTable.getModel().getValueAt(selectedIndex, 4).toString();
                String curJenisKelamin = productTable.getModel().getValueAt(selectedIndex, 5).toString();

                // ubah isi textfield dan combo box
                nimField.setText(curNim);
                namaField.setText(curNama);
                prodiField.setText(curProdi);
                fakultasComboBox.setSelectedItem(curFakultas);
                alamatField.setText(curAlamat);

                if (curJenisKelamin.equalsIgnoreCase("L")) {
                    lakiLakiRadioButton.setSelected(true);
                } else if (curJenisKelamin.equalsIgnoreCase("P")) {
                    perampuanRadioButton.setSelected(true);
                } else {
                    jenisKelaminGroup.clearSelection();
                }

                // ubah button "Add" menjadi "Update"
                addUpdateButton.setText("Update");

                // tampilkan button delete
                deleteButton.setVisible(true);
            }
        });
    }

    private String getSelectedJenisKelamin() {
        if (lakiLakiRadioButton.isSelected()) {
            return "L";
        } else if (perampuanRadioButton.isSelected()) {
            return "P";
        }
        return ""; // Kembalikan string kosong jika tidak ada yang dipilih
    }

    public final DefaultTableModel setTable() {
        // tentukan kolom tabel
        Object[] cols = {"NIM", "Nama", "Prodi", "Fakultas", "Alamat", "Jenis Kelamin"};

        // buat objek tabel dengan kolom yang sudah dibuat
        DefaultTableModel tmp = new DefaultTableModel(null, cols);

        // isi tabel dengan listProduct
        try {
            ResultSet resultSet = database.selectQuery("SELECT * FROM biodata");

            // isi tabel denga hasil query
            int i = 0;
            while (resultSet.next()){
                Object[] row = new Object[6];
                row[0] = resultSet.getString("NIM");
                row[1] = resultSet.getString("Nama");
                row[2] = resultSet.getString("Prodi");
                row[3] = resultSet.getString("Fakultas");
                row[4] = resultSet.getString("Alamat");
                row[5] = resultSet.getString("Jenis_Kelamin");
                tmp.addRow(row);
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tmp;
    }

    public void insertData() {
        String nim = nimField.getText();
        String nama = namaField.getText();
        String prodi = prodiField.getText();
        String fakultas = fakultasComboBox.getSelectedItem().toString();
        String alamat = alamatField.getText();
        String jenisKelamin = getSelectedJenisKelamin();

        if (nim.isEmpty() || namaField.getText().isEmpty() || prodiField.getText().isEmpty() || alamatField.getText().isEmpty() || jenisKelaminGroup.getSelection() == null) {

            JOptionPane.showMessageDialog(null, "Kolomnya ada yang kosong itu WOYY!!!!", "Error Input", JOptionPane.ERROR_MESSAGE);
            return; // Menghentikan eksekusi fungsi
        }
        try {
            // tambahkan data ke dalam database
            String sqlQuery = "INSERT INTO biodata VALUES ('" + nim + "','" + nama + "','" + prodi + "', '" + fakultas + "', '" + alamat + "', '" + jenisKelamin + "')";
            database.insertUpdateDeleteQuery(sqlQuery);

            // update tabel
            productTable.setModel(setTable());

            // bersihkan form
            clearForm();

            // feedback
            System.out.println("Insert berhasil");
            JOptionPane.showMessageDialog(null, "Data mahasiswa berhasil ditambahkan");
        } catch (RuntimeException e){
            if (e.getCause() instanceof SQLException) {
                SQLException sqlEx = (SQLException) e.getCause();

                if (sqlEx.getErrorCode() == 1062) {
                    JOptionPane.showMessageDialog(null, "NIM " + nim + " sudah ada kak, cari nomor lainn!", "Duplikasi Data", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan !", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateData() {
        try {
            // ambil data dari form
            String nim = nimField.getText();
            String nama = namaField.getText();
            String prodi = prodiField.getText();
            String fakultas = fakultasComboBox.getSelectedItem().toString();
            String alamat = alamatField.getText();
            String jenisKelamin = getSelectedJenisKelamin();

            String sqlQuery = "UPDATE biodata SET " + "Nama = '" + nama + "', " + "Prodi = '" + prodi + "', " + "Fakultas = '" + fakultas + "', " + "Alamat = '" + alamat + "', " + "Jenis_Kelamin = '" + jenisKelamin + "' " + "WHERE NIM = '" + nim + "'";
            database.insertUpdateDeleteQuery(sqlQuery);

            // update tabel
            productTable.setModel(setTable());

            // bersihkan form
            clearForm();

            // feedback
            System.out.println("Insert berhasil");
            JOptionPane.showMessageDialog(null, "Data mahasiswa berhasil diperbarui");
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Terjadi kesahalan!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteData() {
        // Ini akan mengambil data nim dari baris yang diklik pada tabel.
        String nim = selectedNim;

        try {
            String sqlQuery = "DELETE FROM biodata WHERE NIM = '" + nim + "'";
            int rowsAffected = database.insertUpdateDeleteQuery(sqlQuery);

            if (rowsAffected > 0) {
                //update tabel
                productTable.setModel(setTable());
                //bersihkan form
                clearForm();
                System.out.println("Delete berhasil");
                JOptionPane.showMessageDialog(null, "Data mahasiswa berhasil dihapus.");
            } else {
                JOptionPane.showMessageDialog(null, "Data dengan NIM " + nim + " tidak ditemukan di database.", "Gagal Hapus", JOptionPane.WARNING_MESSAGE);
                clearForm();
            }

        } catch (RuntimeException ex) {
            Throwable cause = ex.getCause();

            if (cause instanceof SQLException) {
                SQLException sqlEx = (SQLException) cause;

                if (sqlEx.getErrorCode() == 1451) {
                    JOptionPane.showMessageDialog(null, "Gagal menghapus! Data ini masih terhubung dengan data lain di database.", "Error Database", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Terjadi error database: " + sqlEx.getMessage(), "Error Database", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Error lainnya
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan  " + ex.getMessage(), "Error Runtime", JOptionPane.ERROR_MESSAGE);
            }
            System.err.println("Error saat Delete Data: " + ex.getMessage());
        }
    }

    public void clearForm() {
        // kosongkan semua texfield dan combo box
        nimField.setText("");
        namaField.setText("");
        prodiField.setText("");
        fakultasComboBox.setSelectedIndex(0);
        alamatField.setText("");
        jenisKelaminGroup.clearSelection();

        // ubah button "Update" menjadi "Add"
        addUpdateButton.setText("Add");

        // sembunyikan button delete
        deleteButton.setVisible(false);

        // ubah selectedIndex menjadi -1 (tidak ada baris yang dipilih)
        selectedIndex = -1;
    }
}
