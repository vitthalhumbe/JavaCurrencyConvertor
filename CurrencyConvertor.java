
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;


public class CurrencyConvertor {
    private Font titleFont = new Font("Arial", Font.BOLD, 32);
    private Font fromToFont = new Font("Arial", Font.ITALIC, 15);
    private Font authorFont = new Font("Arial", Font.PLAIN, 15);
    private JFrame frame = new JFrame("Currency Convertor"); 

    public CurrencyConvertor() {
        frame.setBounds(300, 200, 962, 569);
        frame.setLayout(null);
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Title label 
        JLabel titleLabel = new JLabel("Currency Convertor", JLabel.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setBounds(0, 40, 962, 40);
        frame.add(titleLabel);

        // Author label (it's me - Vitthal Humbe)
        JLabel authorLabel = new JLabel("Vitthal Humbe", JLabel.CENTER);
        authorLabel.setFont(authorFont);
        authorLabel.setBounds(0, 90, 962, 40);
        frame.add(authorLabel);

        // From label
        JLabel fromLabel = new JLabel("From");
        fromLabel.setBounds(105, 214, 100, 30);
        fromLabel.setFont(fromToFont);
        frame.add(fromLabel);

        // To Label 
        JLabel toLabel = new JLabel("To");
        toLabel.setBounds(552, 214, 100, 30);
        toLabel.setFont(fromToFont);
        frame.add(toLabel);   
        
        // from list
        String[] CurrencyStrings = {"Indian Rupees", "American Dollar", "Japanese Yen", "European Euro"};
        JComboBox<String> fromCurrency = new JComboBox<String>(CurrencyStrings);
        fromCurrency.setBounds(105, 242, 317, 35);
        frame.add(fromCurrency);

        // To list
        JComboBox<String> toCurrency = new JComboBox<String>(CurrencyStrings);
        toCurrency.setSelectedItem("American Dollar");
        toCurrency.setBounds(552, 242, 317, 35);
        frame.add(toCurrency);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CurrencyConvertor();
    }
}