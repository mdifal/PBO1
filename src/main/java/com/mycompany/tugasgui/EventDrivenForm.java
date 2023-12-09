package com.mycompany.tugasgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EventDrivenForm {
    private JPanel panel1;
    private final JTextField nameTextField;
    private final JTextField addressTextField;
    private final JTextField phoneTextField;
    private final JLabel nameLabel;
    private final JLabel addressLabel;
    private final JLabel phoneLabel;
    private final JCheckBox steakCheckBox;
    private final JCheckBox spaghettiCheckBox;
    private final JCheckBox pizzaCheckBox;
    private final JSpinner steakSpinner;
    private final JSpinner spaghettiSpinner;
    private final JSpinner pizzaSpinner;
    private final JTextField totalPriceTextField;
    private final JTextArea detailsTextArea;
    private final JButton processButton;
    private JTextField totalLabel;  // New JTextField for total price
    private static final double STEAK_PRICE = 60000;
    private static final double SPAGHETTI_PRICE = 40000;
    private static final double PIZZA_PRICE = 80000;
    private static final String NAME_LABEL_TEXT = "Nama:";
    private static final String ADDRESS_LABEL_TEXT = "Alamat:";
    private static final String PHONE_LABEL_TEXT = "Telp:";
    private static final String BUTTON_TEXT = "Tambah";

    public EventDrivenForm() {
        panel1 = new JPanel();
        nameTextField = new JTextField(20);
        addressTextField = new JTextField(20);
        phoneTextField = new JTextField(20);
        nameLabel = new JLabel(NAME_LABEL_TEXT);
        addressLabel = new JLabel(ADDRESS_LABEL_TEXT);
        phoneLabel = new JLabel(PHONE_LABEL_TEXT);

        phoneTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char inputChar = e.getKeyChar();
                if (!Character.isDigit(inputChar)) {
                    e.consume();
                }
            }
        });

        steakCheckBox = new JCheckBox("Steak");
        spaghettiCheckBox = new JCheckBox("Spaghetti");
        pizzaCheckBox = new JCheckBox("Pizza");
        steakSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        spaghettiSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        pizzaSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));

        totalPriceTextField = new JTextField(10);
        totalPriceTextField.setEditable(false);

        processButton = new JButton(BUTTON_TEXT);
        processButton.addActionListener(e -> processTransaction());

        detailsTextArea = new JTextArea();
        detailsTextArea.setEditable(false);

        totalLabel = new JTextField(10);
        totalLabel.setEditable(false);

        attachSpinnerListeners(steakCheckBox, steakSpinner);
        attachSpinnerListeners(spaghettiCheckBox, spaghettiSpinner);
        attachSpinnerListeners(pizzaCheckBox, pizzaSpinner);

        setInitialSpinnerState(steakCheckBox, steakSpinner);
        setInitialSpinnerState(spaghettiCheckBox, spaghettiSpinner);
        setInitialSpinnerState(pizzaCheckBox, pizzaSpinner);

        panel1.setLayout(new BorderLayout());
        panel1.add(personalInfoPanel(), BorderLayout.NORTH);
        panel1.add(menuPanel(), BorderLayout.WEST);
        panel1.add(createDetailsPanel(), BorderLayout.CENTER);
        panel1.add(processButtonPanel(processButton), BorderLayout.SOUTH);
    }

    private JPanel personalInfoPanel() {
        JPanel personalInfoPanel = new JPanel(new GridLayout(3, 2));
        personalInfoPanel.setBorder(BorderFactory.createTitledBorder("Identitas Pelanggan"));
        personalInfoPanel.add(nameLabel);
        personalInfoPanel.add(nameTextField);
        personalInfoPanel.add(addressLabel);
        personalInfoPanel.add(addressTextField);
        personalInfoPanel.add(phoneLabel);
        personalInfoPanel.add(phoneTextField);
        return personalInfoPanel;
    }

    private JPanel menuPanel() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        menuPanel.setBorder(BorderFactory.createTitledBorder("Menu"));
        menuPanel.add(steakCheckBox);
        menuPanel.add(steakSpinner);
        menuPanel.add(spaghettiCheckBox);
        menuPanel.add(spaghettiSpinner);
        menuPanel.add(pizzaCheckBox);
        menuPanel.add(pizzaSpinner);

        return menuPanel;
    }

    private JPanel processButtonPanel(JButton processButton) {
        JPanel processButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        processButtonPanel.add(processButton);
        return processButtonPanel;
    }

    private JPanel createDetailsPanel() {
        JPanel detailsPanel = new JPanel(new BorderLayout());
        detailsPanel.setBorder(BorderFactory.createTitledBorder("Detail Pemesanan"));

        detailsPanel.setPreferredSize(new Dimension(400, 300));
        String details = "Daftar Harga" + "\nSteak: " + STEAK_PRICE +
                "\nSpaghetti: " + SPAGHETTI_PRICE +
                "\nPizza: " + PIZZA_PRICE +
                "\n\nTotal Price: Rp. 0";
        detailsTextArea.setText(details);

        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        totalPanel.add(new JLabel("Total:"));
        totalPanel.add(totalLabel);

        detailsPanel.add(new JScrollPane(detailsTextArea), BorderLayout.CENTER);
        detailsPanel.add(totalPanel, BorderLayout.SOUTH);

        return detailsPanel;
    }

    private void attachSpinnerListeners(JCheckBox checkBox, JSpinner spinner) {
        checkBox.addActionListener(e -> {
            boolean isSelected = checkBox.isSelected();
            spinner.setEnabled(isSelected);
            if (!isSelected) {
                spinner.setValue(0);
            } else if ((int) spinner.getValue() == 0) {
                spinner.setValue(1);
            }
            updateTotalLabel();
        });

        spinner.addChangeListener(e -> {
            updateTotalLabel();
            if ((int) spinner.getValue() == 0 && checkBox.isSelected()) {
                spinner.setValue(1);
            }
        });
    }

    private void updateTotalLabel() {
        double total = calculateTotalPrice();
        totalLabel.setText(String.format("Rp. %.2f", total));
    }

    private void setInitialSpinnerState(JCheckBox checkBox, JSpinner spinner) {
        boolean isSelected = checkBox.isSelected();
        spinner.setEnabled(isSelected);
        if (!isSelected) {
            spinner.setValue(0);
        } else if ((int) spinner.getValue() == 0) {
            spinner.setValue(1);
        }
        updateTotalLabel();
    }
    private void processTransaction() {
         if (isValidInput()) {
 double totalPrice = calculateTotalPrice();
 totalPriceTextField.setText(String.format("%.2f", totalPrice));
 showPurchaseDetails(totalPrice);
 } else {
 JOptionPane.showMessageDialog(null, "Mohon lengkapi data identitas dan pilih setidaknya satu item.");
 processButton.setText(BUTTON_TEXT);
 processButton.setForeground(Color.BLACK);
 nameLabel.setText(NAME_LABEL_TEXT);
 nameLabel.setForeground(Color.BLACK);
 addressLabel.setText(ADDRESS_LABEL_TEXT);
 addressLabel.setForeground(Color.BLACK);
 phoneLabel.setText(PHONE_LABEL_TEXT);
 phoneLabel.setForeground(Color.BLACK);
 }
    }

    private boolean isValidInput() {
        boolean isNameValid = !nameTextField.getText().isEmpty();
 boolean isAddressValid = !addressTextField.getText().isEmpty();
 boolean isPhoneValid = !phoneTextField.getText().isEmpty();
 boolean isMenuSelected = steakCheckBox.isSelected() ||
spaghettiCheckBox.isSelected() || pizzaCheckBox.isSelected();
 processButton.setText(isMenuSelected ? BUTTON_TEXT : "Mohon pilih menu!");
 processButton.setForeground(isMenuSelected ? Color.BLACK :
Color.RED);
 nameLabel.setText(isNameValid ? NAME_LABEL_TEXT : "Nama: (Mohondiisi!)");
 nameLabel.setForeground(isNameValid ? Color.BLACK : Color.RED);
 addressLabel.setText(isAddressValid ? ADDRESS_LABEL_TEXT : "Alamat:(Mohon diisi!)");
 addressLabel.setForeground(isAddressValid ? Color.BLACK :
Color.RED);
 phoneLabel.setText(isPhoneValid ? PHONE_LABEL_TEXT : "Telp: (Mohon diisi!)");
 phoneLabel.setForeground(isPhoneValid ? Color.BLACK : Color.RED);
 return isNameValid && isAddressValid && isPhoneValid && isMenuSelected;
    }

    private double calculateTotalPrice() {
        int steakQty = (int) steakSpinner.getValue();
 int spaghettiQty = (int) spaghettiSpinner.getValue();
 int pizzaQty = (int) pizzaSpinner.getValue();
 return (STEAK_PRICE * steakQty) + (SPAGHETTI_PRICE * spaghettiQty)+ (PIZZA_PRICE * pizzaQty);
    }

    private void showPurchaseDetails(double totalPrice) {
        String name = nameTextField.getText();
 String address = addressTextField.getText();
 String phone = phoneTextField.getText();
 StringBuilder details = new StringBuilder("Detail Pemesanan:\nNama:" + name + "\nAlamat: " + address + "\nTelp: " + phone + "\n\nPesanan:");
 showItemDetails(details, "Steak", steakCheckBox.isSelected(), (int)
steakSpinner.getValue(), STEAK_PRICE);
 showItemDetails(details, "Spaghetti",
spaghettiCheckBox.isSelected(), (int) spaghettiSpinner.getValue(),
SPAGHETTI_PRICE);
 showItemDetails(details, "Pizza", pizzaCheckBox.isSelected(), (int)
pizzaSpinner.getValue(), PIZZA_PRICE);
 details.append("\n\nTotal Price: Rp. ").append(totalPrice);
 detailsTextArea.setText(details.toString());
    }

    private void showItemDetails(StringBuilder details, String itemName, boolean isSelected, int quantity, double price) {
         if (isSelected && quantity > 0) {
 double itemTotal = quantity * price;
 details.append("\n").append(itemName).append(":").append(quantity).append(" pc(s) * Rp. ").append(price).append(" = Rp.").append(itemTotal);
 }
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
