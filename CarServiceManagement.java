import javax.swing.*;
import java.awt.*;

public class CarServicingCenter extends JFrame {

    JTextField txtServiceNo, txtDate;
    JTextField txtCarNo, txtCustomer, txtTotal;

    JCheckBox chkGeneral, chkEngine, chkOil;
    JCheckBox chkWheel, chkWash;

    JButton btnGenerate, btnReset, btnExit;

    public CarServicingCenter() {

        setTitle("Car Servicing Center");
        setSize(850, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(245, 245, 245));

        // Heading
        JLabel heading = new JLabel("Car Servicing Center");
        heading.setFont(new Font("Serif", Font.BOLD, 34));
        heading.setForeground(new Color(15, 55, 105));
        heading.setBounds(245, 25, 420, 50);
        panel.add(heading);

        // Service Number
        JLabel lblService = new JLabel("Service No. :");
        lblService.setBounds(50, 120, 140, 30);
        lblService.setFont(new Font("Serif", Font.BOLD, 18));
        panel.add(lblService);

        txtServiceNo = new JTextField();
        txtServiceNo.setBounds(210, 120, 200, 35);
        panel.add(txtServiceNo);

        // Date
        JLabel lblDate = new JLabel("Date :");
        lblDate.setBounds(460, 120, 100, 30);
        lblDate.setFont(new Font("Serif", Font.BOLD, 18));
        panel.add(lblDate);

        txtDate = new JTextField();
        txtDate.setBounds(560, 120, 220, 35);
        panel.add(txtDate);

        // Car Number
        JLabel lblCar = new JLabel("Car No. :");
        lblCar.setBounds(50, 180, 140, 30);
        lblCar.setFont(new Font("Serif", Font.BOLD, 18));
        panel.add(lblCar);

        txtCarNo = new JTextField();
        txtCarNo.setBounds(210, 180, 200, 35);
        panel.add(txtCarNo);

        // Customer Name
        JLabel lblCustomer = new JLabel("Customer Name :");
        lblCustomer.setBounds(460, 180, 150, 30);
        lblCustomer.setFont(new Font("Serif", Font.BOLD, 18));
        panel.add(lblCustomer);

        txtCustomer = new JTextField();
        txtCustomer.setBounds(610, 180, 170, 35);
        panel.add(txtCustomer);

        // Select Services
        JLabel lblSelect = new JLabel("Select Services :");
        lblSelect.setBounds(50, 250, 180, 30);
        lblSelect.setFont(new Font("Serif", Font.BOLD, 18));
        panel.add(lblSelect);

        // General Service
        chkGeneral = new JCheckBox("General Service (Rs. 1500)");
        chkGeneral.setBounds(210, 250, 300, 30);
        chkGeneral.setBackground(new Color(245, 245, 245));
        panel.add(chkGeneral);

        // Engine Tuning
        chkEngine = new JCheckBox("Engine Tuning (Rs. 1200)");
        chkEngine.setBounds(210, 290, 300, 30);
        chkEngine.setBackground(new Color(245, 245, 245));
        panel.add(chkEngine);

        // Oil Change
        chkOil = new JCheckBox("Oil Change (Rs. 800)");
        chkOil.setBounds(210, 330, 300, 30);
        chkOil.setBackground(new Color(245, 245, 245));
        panel.add(chkOil);

        // Wheel Alignment
        chkWheel = new JCheckBox("Wheel Alignment (Rs. 600)");
        chkWheel.setBounds(210, 370, 300, 30);
        chkWheel.setBackground(new Color(245, 245, 245));
        panel.add(chkWheel);

        // Car Wash
        chkWash = new JCheckBox("Car Wash (Rs. 300)");
        chkWash.setBounds(210, 410, 300, 30);
        chkWash.setBackground(new Color(245, 245, 245));
        panel.add(chkWash);

        // Total Amount
        JLabel lblTotal = new JLabel("Total Amount :");
        lblTotal.setBounds(50, 470, 150, 30);
        lblTotal.setFont(new Font("Serif", Font.BOLD, 18));
        panel.add(lblTotal);

        txtTotal = new JTextField();
        txtTotal.setBounds(210, 470, 200, 35);
        txtTotal.setEditable(false);
        panel.add(txtTotal);

        // Generate Bill Button
        btnGenerate = new JButton("Generate Bill");
        btnGenerate.setBounds(70, 540, 190, 40);
        panel.add(btnGenerate);

        // Reset Button
        btnReset = new JButton("Reset");
        btnReset.setBounds(330, 540, 150, 40);
        panel.add(btnReset);

        // Exit Button
        btnExit = new JButton("Exit");
        btnExit.setBounds(550, 540, 150, 40);
        panel.add(btnExit);

        // Button Actions
        btnGenerate.addActionListener(e -> generateBill());

        btnReset.addActionListener(e -> resetForm());

        btnExit.addActionListener(e -> {
            System.exit(0);
        });

        add(panel);
        setVisible(true);
    }

    // Generate Bill Method
    private void generateBill() {

        double total = 0;
        String result = "";

        // Check selected services

        if (chkGeneral.isSelected()) {
            total = total + 1500;
            result = result + "General Service, ";
        }

        if (chkEngine.isSelected()) {
            total = total + 1200;
            result = result + "Engine Tuning, ";
        }

        if (chkOil.isSelected()) {
            total = total + 800;
            result = result + "Oil Change, ";
        }

        if (chkWheel.isSelected()) {
            total = total + 600;
            result = result + "Wheel Alignment, ";
        }

        if (chkWash.isSelected()) {
            total = total + 300;
            result = result + "Car Wash, ";
        }

        // Check service selection

        if (result.equals("")) {
            JOptionPane.showMessageDialog(
                this, "Please select a service"
            );
            return;
        }

        // Check customer details

        if (txtServiceNo.getText().trim().isEmpty()
                || txtDate.getText().trim().isEmpty()
                || txtCarNo.getText().trim().isEmpty()
                || txtCustomer.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                this, "Please enter all details"
            );
            return;
        }

        // Remove last comma

        result = result.substring(0, result.length() - 2);

        // Display total

        txtTotal.setText(String.valueOf(total));

        // Display Bill

        JOptionPane.showMessageDialog(
            this,
            "CAR SERVICING BILL\n\n"
            + "Service No.: " + txtServiceNo.getText()
            + "\nDate: " + txtDate.getText()
            + "\nCar No.: " + txtCarNo.getText()
            + "\nCustomer Name: " + txtCustomer.getText()
            + "\nSelected Services: " + result
            + "\nTotal Amount: Rs. " + total
        );
    }

    // Reset Method
    private void resetForm() {

        txtServiceNo.setText("");
        txtDate.setText("");
        txtCarNo.setText("");
        txtCustomer.setText("");
        txtTotal.setText("");

        chkGeneral.setSelected(false);
        chkEngine.setSelected(false);
        chkOil.setSelected(false);
        chkWheel.setSelected(false);
        chkWash.setSelected(false);
    }

    // Main Method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new CarServicingCenter();
        });
    }
}