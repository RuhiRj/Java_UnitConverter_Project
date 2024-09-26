package Project;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitConverter extends JFrame {

    private JPanel panel;

    private JLabel l1;

    private JLabel l2;

    private JButton b1;

    private JComboBox<String> Box1; // Specify String for combo box type

    private JComboBox<String> Box2; // Specify String for combo box type

    private JLabel l3;

    private JTextField t1;

    private JLabel l4;
    // To take input value

    // Array of units
    private String[] units = {"Kilometer","Hectometer" ,"Decameter","Meter", "Decimeter","Centimeter" ,"Millimeter"};

    public void initComponents() {
        // Initialize components
        panel = new JPanel();

        l1 = new JLabel("From Unit:");

        l2 = new JLabel("To Unit:");

       // b1 = new JButton("Convert");
      //  l3 = new JLabel("Result is :");
        t1 = new JTextField(); // Input field to get the number

        // Initialize JComboBox with the unit array
        Box1 = new JComboBox<>(units);

        Box2 = new JComboBox<>(units);

        // Set layout and bounds
        panel.setLayout(null);
        l1.setBounds(50, 50, 100, 20);
        l2.setBounds(350, 50, 120, 30);
        b1.setBounds(100, 300, 100, 40);
        Box1.setBounds(170, 50, 150, 40);
        Box2.setBounds(450, 50, 150, 40);
        t1.setBounds(250, 150, 100, 30);
        l3.setBounds(100, 400, 100, 20);
        l4.setBounds(70,150,100,30);

        // Add components to the panel
        panel.add(l1);
        panel.add(l2);
        panel.add(b1);
        panel.add(Box1);
        panel.add(Box2);
        panel.add(t1);
        panel.add(l3);
        panel.add(l4);

        // Add ActionListener to the button to trigger conversion
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performConversion();
            }
        });
    }

    // Method to perform the unit conversion
    private void performConversion() {
        try {
            // Get input value
            double inputValue = Double.parseDouble(t1.getText());

            // Get selected units from combo boxes
            String fromUnit = (String) Box1.getSelectedItem();
            String toUnit = (String) Box2.getSelectedItem();

            // Convert input value to meters
            double valueInMeters = convertToMeters(inputValue, fromUnit);

            // Convert from meters to the target unit
            double convertedValue = convertFromMeters(valueInMeters, toUnit);

            // Display result
            l3.setText("Result: " + convertedValue + " " + toUnit);
        } catch (NumberFormatException ex) {
            l3.setText("Please enter a valid number.");
        }
    }

    // Convert from any unit to meters (base unit)
    private double convertToMeters(double value, String fromUnit) {
        switch (fromUnit) {
            case "km": return value * 1000;

            case "hm": return value * 100;

            case "dam": return value * 10;

            case "m": return value;

            case "dcm": return value * 0.1;

            case "cm": return value * 0.01;

            case "mm": return value * 0.001;

            default: return value;
        }
    }

    // Convert from meters to the target unit
    private double convertFromMeters(double valueInMeters, String toUnit) {
        switch (toUnit) {
            case "km": return valueInMeters / 1000;

            case "hm": return valueInMeters / 100;

            case "dam": return valueInMeters / 10;

            case "m": return valueInMeters;

            case "dcm": return valueInMeters / 0.1;

            case "cm": return valueInMeters / 0.01;

            case "mm": return valueInMeters / 0.001;

            default: return valueInMeters;
        }
    }

    public UnitConverter() {
        initComponents();
        setContentPane(panel);
        setSize(700, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new UnitConverter(); // Run the program
    }
}