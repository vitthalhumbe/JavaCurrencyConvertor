
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;


public class CurrencyConvertor {
    private Font titleFont = new Font("Arial", Font.BOLD, 32);
    private Font fromToFont = new Font("Arial", Font.ITALIC, 15);
    private Font authorFont = new Font("Arial", Font.PLAIN, 15);
    private Border blackline = BorderFactory.createLineBorder(Color.black);
    private JFrame frame = new JFrame("Currency Convertor"); 

    public CurrencyConvertor() {
        frame.setBounds(300, 200, 962, 569);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.decode("#ffffff"));
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
        fromCurrency.setBackground(Color.white);
        fromCurrency.setBounds(105, 242, 317, 35);
        frame.add(fromCurrency);

        // To list
        JComboBox<String> toCurrency = new JComboBox<String>(CurrencyStrings);
        toCurrency.setSelectedItem("American Dollar");
        toCurrency.setBackground(Color.white);
        toCurrency.setBounds(552, 242, 317, 35);
        frame.add(toCurrency);

        // from Text input field
        JTextField inputTextField = new JTextField();
        inputTextField.setBounds(105, 305, 317, 39);
        inputTextField.setMargin(new Insets(0, 10, 0, 0));
        frame.add(inputTextField);

        // to text output label 
        JLabel outputTextLabel = new JLabel();
        outputTextLabel.setBorder(blackline);
        outputTextLabel.setBounds(552, 305, 317, 39);
        outputTextLabel.setBackground(Color.white);
        frame.add(outputTextLabel);

        // Convert button
        JButton convertButton = new JButton("Convert");
        convertButton.setBackground(Color.decode("#5DA1E0"));
        convertButton.setBounds(155, 407, 300, 50);
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputType = String.valueOf(fromCurrency.getSelectedItem());
                String outputType = String.valueOf(toCurrency.getSelectedItem());

                try {
                    double inputAmount = Double.parseDouble(inputTextField.getText());

                    if (inputType.equals("Indian Rupees")) {
                        if (outputType.equals("American Dollar")) {
                            double outputValue = rupeeToDollars(inputAmount);
                            outputTextLabel.setText(" $ " + String.valueOf(outputValue));
                        }
                        else if (outputType.equals("Japanese Yen")) {
                            double outputValue = rupeeToYen(inputAmount);
                            outputTextLabel.setText(" ¥ " + String.valueOf(outputValue));
                        }
                        else if (outputType.equals("European Euro")) {
                            double outputValue = rupeeToEuro(inputAmount);
                            outputTextLabel.setText(" € " + String.valueOf(outputValue));
                        }
                        else {
                            outputTextLabel.setText(" ₹ " + inputAmount);
                        }
                    }
                    else if (inputType.equals("American Dollar")) {
                        if (outputType.equals("Indian Rupees")) {
                            double outputValue = dollarToRupee(inputAmount);
                            outputTextLabel.setText(" ₹ " + String.valueOf(outputValue));
                        }
                        else if (outputType.equals("Japanese Yen")) {
                            double outputValue = dollarToYen(inputAmount);
                            outputTextLabel.setText(" ¥ " + String.valueOf(outputValue));
                        }
                        else if (outputType.equals("European Euro")) {
                            double outputValue = dollarToEuro(inputAmount);
                            outputTextLabel.setText(" € " + String.valueOf(outputValue));
                        }
                        else {
                            outputTextLabel.setText(" $ " + inputAmount);
                        }
                    }
                    else if (inputType.equals("Japanese Yen")) {
                        if (outputType.equals("Indian Rupees")) {
                            double outputValue = yenToRupee(inputAmount);
                            outputTextLabel.setText(" ₹ " + String.valueOf(outputValue));
                        }
                        else if (outputType.equals("American Dollar")) {
                            double outputValue = yenToDollar(inputAmount);
                            outputTextLabel.setText(" $ " + String.valueOf(outputValue));
                        }
                        else if (outputType.equals("European Euro")) {
                            double outputValue = yenToEuro(inputAmount);
                            outputTextLabel.setText(" € " + String.valueOf(outputValue));
                        }
                        else {
                            outputTextLabel.setText(" ¥ " + inputAmount);
                        }
                    }
                    else {
                        if (outputType.equals("Indian Rupees")) {
                            double outputValue = euroToRupee(inputAmount);
                            outputTextLabel.setText(" ₹ " + String.valueOf(outputValue));
                        }
                        else if (outputType.equals("American Dollar")) {
                            double outputValue = euroToDollar(inputAmount);
                            outputTextLabel.setText(" $ " + String.valueOf(outputValue));
                        }
                        else if (outputType.equals("Japanese Yen")) {
                            double outputValue = euroToYen(inputAmount);
                            outputTextLabel.setText(" € " + String.valueOf(outputValue));
                        }
                        else {
                            outputTextLabel.setText(" € " + inputAmount);
                        }
                    }

                }
                catch(NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(frame, "Enter only numbers");
                }
                catch(Exception a) {
                    System.out.println(a);
                }
            }
        });
        frame.add(convertButton);

        // Clear Button
        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(Color.white);
        clearButton.setBounds(504, 407, 300, 50);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputTextField.setText("");
                outputTextLabel.setText("");
            }
        });
        frame.add(clearButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CurrencyConvertor();
    }

    private double rupeeToDollars(double rupee) {
        return rupee * 0.012;
    }
    private double rupeeToYen(double rupee) {
        return rupee * 1.74457;
    }
    private double rupeeToEuro(double rupee) {
        return rupee * 0.011;
    }
    private double dollarToRupee(double dollar) {
        return dollar * 83.09;
    }
    private double dollarToYen(double dollar) {
        return dollar * 141.66;
    }
    private double dollarToEuro(double dollar) {
        return dollar * 0.918624;
    }
    private double yenToRupee(double yen) {
        return yen * 0.59;
    }
    private double yenToDollar(double yen) {
        return yen * 0.0071;
    }
    private double yenToEuro(double yen) {
        return yen * 0.0064;
    }
    private double euroToRupee(double euro) {
        return euro * 91.01;
    }
    private double euroToDollar(double euro) {
        return euro * 1.10;
    }
    private double euroToYen(double euro) {
        return euro * 155.25;
    }
}