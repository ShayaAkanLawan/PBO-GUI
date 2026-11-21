import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KasirSederhana extends JFrame {

    // Atomic Components
    JTextField nama, harga, jumlah;
    JLabel hasil;
    JButton hitung, reset;

    public KasirSederhana() {

        // FRAME
        setTitle("Aplikasi Kasir Sederhana");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // INTERMEDIATE COMPONENT
        JPanel panelUtama = new JPanel();
        panelUtama.setLayout(new BorderLayout(10, 10));

        JPanel panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(4, 2, 10, 10));

        JPanel panelTombol = new JPanel();
        panelTombol.setLayout(new FlowLayout());

        // ATOMIC COMPONENT
        nama = new JTextField();
        harga = new JTextField();
        jumlah = new JTextField();

        hasil = new JLabel("Total: Rp0");

        hitung = new JButton("Hitung");
        reset = new JButton("Reset");

        // Insert componen into panel form
        panelForm.add(new JLabel("Nama Barang:"));
        panelForm.add(nama);

        panelForm.add(new JLabel("Harga:"));
        panelForm.add(harga);

        panelForm.add(new JLabel("Jumlah:"));
        panelForm.add(jumlah);

        panelForm.add(new JLabel("Hasil:"));
        panelForm.add(hasil);

        // Inser Button to panel
        panelTombol.add(hitung);
        panelTombol.add(reset);

        // Assembling panels
        panelUtama.add(panelForm, BorderLayout.CENTER);
        panelUtama.add(panelTombol, BorderLayout.SOUTH);

        add(panelUtama);

        // EVENT LISTENER COUNT BUTTON
        hitung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int h = Integer.parseInt(harga.getText());
                    int j = Integer.parseInt(jumlah.getText());

                    int total = h * j;

                    hasil.setText("Rp" + total);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                        null, "Masukkan angka yang benar!"
                    );
                }
            }
        });

        // EVENT LISTENER RESET BUTTON
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nama.setText("");
                harga.setText("");
                jumlah.setText("");
                hasil.setText("Total: Rp0");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new KasirSederhana();
    }
}
