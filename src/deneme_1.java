import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deneme_1 extends JFrame {
    //paneldeki ekledegimiz degerler
    private JPanel panel;
    private JButton tp1;
    private JTextField sayi1;
    private JTextField sayi2;
    private JButton çk2;
    private JButton çrp3;
    private JButton bol4;
    private JLabel lbl1;
    private JLabel s1;
    private JLabel s2;

    deneme_1() {
        add(panel);// Paneli pencereye ekler
        setTitle("Dört işlem yapan program - Saffettin mert genç - 23410082008"); // Pencere başlığı
        setSize(600, 400); // Pencere boyutu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Pencere kapatıldığında uygulama sonlanır

        // Butonlara tıklandıgında yapılacak işlevsellik ekleme
        tp1.addActionListener(e -> hesapla('+'));
        çk2.addActionListener(e -> hesapla('-'));
        çrp3.addActionListener(e -> hesapla('*'));
        bol4.addActionListener(e -> hesapla('/'));
    }

    private void hesapla(char operator) {
        try {
            double num1 = Double.parseDouble(sayi1.getText()); // 1. sayıyı alır
            double num2 = Double.parseDouble(sayi2.getText()); // 2. sayıyı alır
            double sonuc = 0;


            switch (operator) { // Operatöre göre işlem yapar
                case '+':
                    sonuc = num1 + num2;
                    break;
                case '-':
                    sonuc = num1 - num2;
                    break;
                case '*':
                    sonuc = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) throw new ArithmeticException();  // Sıfıra bölme kontrolü
                    sonuc = num1 / num2;
                    break;
            }

            lbl1.setText(String.format("Sonuç: %.2f", sonuc)); //sonucu gösterir

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Geçersiz sayı formatı!", "Hata", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, "Sıfıra bölme hatası!", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) { //formu açabilmek için main metodu
        SwingUtilities.invokeLater(new Runnable() { //formla eş zamanla çalışsın diye theared
            @Override
            public void run() {
                deneme_1 d1 =new deneme_1(); //nesne oluşturduk
                d1.setVisible(true); //formu ekranda göstermek için

            }
        });

    }
}