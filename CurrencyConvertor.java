
import java.awt.Font;

import javax.swing.*;


public class CurrencyConvertor {
    private Font titleFont = new Font("Arial", Font.BOLD, 30);
    private Font authorFont = new Font("Arial", Font.PLAIN, 15);
    private JFrame frame = new JFrame("Currency Convertor"); 

    public CurrencyConvertor() {
        frame.setBounds(300, 200, 1000, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Title label 
        JLabel titleLabel = new JLabel("Currency Convertor", JLabel.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setBounds(0, 40, 1000, 40);
        frame.add(titleLabel);

        // Author label (it's me - Vitthal Humbe)
        JLabel authorLabel = new JLabel("Vitthal Humbe", JLabel.CENTER);
        authorLabel.setFont(authorFont);
        authorLabel.setBounds(0, 90, 1000, 40);
        frame.add(authorLabel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CurrencyConvertor();
    }
}