import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.*;

public class MultimeterMiniProject {



    public static void main(String[] args) {



        // JFRAME
        JFrame frame = new JFrame("Multimeter Simulator");
        frame.setSize(1600, 980);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());





        // PANEL 1 with Gradient Background
        GradientPanel panel1 = new GradientPanel();
        frame.add(panel1, BorderLayout.CENTER);





        // PANEL 4 (USER INPUT VALUE FORM)
        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.white);
        panel4.setLayout(null); 
        panel4.setBounds(200, 200, 600, 750);
        frame.add(panel4);





        // PANEL 5 (Multimeter)
        CustomImagePanel panel5 = new CustomImagePanel();
        panel5.setBackground(new Color(255, 204, 65));
        panel5.setLayout(null); 
        panel5.setBounds(900, 200, 550, 750);
        frame.add(panel5);






        //layout for panel1 to GridBagLayout
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;





        // Title label
        JLabel titleLabel = new JLabel("MULTIMETER SIMULATOR");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setForeground(Color.white);
        titleLabel.setBounds(50, 50, 600, 40);





        // panel1 layout positioning
        panel1.setLayout(null);
        panel1.add(titleLabel); 

        class FloatDocumentFilter extends DocumentFilter {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("[0-9]*\\.?[0-9]*")) {  // Allow digits and one decimal point
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[0-9]*\\.?[0-9]*")) {  // Allow digits and one decimal point
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        }









        //Resistance label and text area 
        JLabel resistanceLabel = new JLabel("Resistance (Ω):");
        resistanceLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        resistanceLabel.setBounds(50, 100, 200, 30);
        panel4.add(resistanceLabel);

        JTextArea resistanceArea = new JTextArea();
        resistanceArea.setFont(new Font("Arial", Font.PLAIN, 30));
        resistanceArea.setBounds(50, 140, 350, 50);
        resistanceArea.setBorder(new LineBorder(Color.BLACK)); // Add border
        panel4.add(resistanceArea);
        ((AbstractDocument) resistanceArea.getDocument()).setDocumentFilter(new FloatDocumentFilter());






        // AC Voltage label and text area 
        JLabel acVoltageLabel = new JLabel("AC Voltage (V):");
        acVoltageLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        acVoltageLabel.setBounds(50, 230, 200, 30);
        panel4.add(acVoltageLabel);

        JTextArea acVoltageArea = new JTextArea();
        acVoltageArea.setFont(new Font("Arial", Font.PLAIN, 30));
        acVoltageArea.setBounds(50, 260, 350, 50);
        acVoltageArea.setBorder(new LineBorder(Color.BLACK)); // Add border
        panel4.add(acVoltageArea);
        ((AbstractDocument) acVoltageArea.getDocument()).setDocumentFilter(new FloatDocumentFilter());








        //DC Voltage label and text area 
        JLabel dcVoltageLabel = new JLabel("DC Voltage (V):");
        dcVoltageLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        dcVoltageLabel.setBounds(50, 350, 200, 30);
        panel4.add(dcVoltageLabel);

        JTextArea dcVoltageArea = new JTextArea();
        dcVoltageArea.setFont(new Font("Arial", Font.PLAIN, 30));
        dcVoltageArea.setBounds(50, 380, 350, 50);
        dcVoltageArea.setBorder(new LineBorder(Color.BLACK)); 
        panel4.add(dcVoltageArea);
        ((AbstractDocument) dcVoltageArea.getDocument()).setDocumentFilter(new FloatDocumentFilter());







        // Submit Button
        JButton submitButton = new JButton("Submit") {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isPressed()) {
                    g.setColor(new Color(200, 200, 255)); 
                    g.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
                } else {
                    Graphics2D g2d = (Graphics2D) g;
                    Color startColor = new Color(102, 102, 255); 
                    Color endColor = new Color(255, 0, 255); 
                    GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, getHeight(), endColor);
                    g2d.setPaint(gradient);
                    g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15); 
                }

                super.paintComponent(g); 
            }

            @Override
            public void updateUI() {
                super.updateUI();
                setContentAreaFilled(false); 
                setBorderPainted(false); 
            }
        };











        //font and size for the button text
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBounds(80, 530, 410, 50);
        panel4.add(submitButton);





        // Add Clear button
        JButton clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Arial", Font.BOLD, 20));
        clearButton.setBounds(80, 600, 410, 50);
        panel4.add(clearButton);
        frame.add(panel1);
        frame.setVisible(true);


        
        // Add ActionListener to the clear button
clearButton.addActionListener(e -> {
    resistanceArea.setText("");  
    acVoltageArea.setText("");  
    dcVoltageArea.setText("");
    
   
    });





        // Create the ButtonGroup
        ButtonGroup group = new ButtonGroup();




        // Create the output label
        JLabel outputLabel = new JLabel("Display Output");
        outputLabel.setFont(new Font("Arial", Font.BOLD, 30));
        outputLabel.setForeground(Color.BLACK);
        outputLabel.setBounds(220, 110, 250, 40); 
        panel5.add(outputLabel);
        outputLabel.setText("Display Output");




        // Create and add radio buttons to panel5 
        JRadioButton radioButton1 = new JRadioButton();
        radioButton1.setBounds(261, 280, 150, 30);
        panel5.add(radioButton1);
        group.add(radioButton1); 

        JRadioButton radioButton2 = new JRadioButton();
        radioButton2.setBounds(156, 310, 150, 30);
        panel5.add(radioButton2);
        group.add(radioButton2); 

        JRadioButton radioButton3 = new JRadioButton();
        radioButton3.setBounds(116, 350, 150, 30);
        panel5.add(radioButton3);
        group.add(radioButton3); 

        JRadioButton radioButton4 = new JRadioButton();
        radioButton4.setBounds(136, 598, 150, 30);
        panel5.add(radioButton4);
        group.add(radioButton4);

        JRadioButton radioButton5 = new JRadioButton();
        radioButton5.setBounds(373, 310, 150, 30);
        panel5.add(radioButton5);
        group.add(radioButton5);

        JRadioButton radioButton6 = new JRadioButton();
        radioButton6.setBounds(412, 355, 150, 30);
        panel5.add(radioButton6);
        group.add(radioButton6); 





        // Add ActionListener to submit button
        submitButton.addActionListener(e -> {
            if (radioButton1.isSelected()) {
                outputLabel.setText("OFF");  
            }
        });

       
        radioButton1.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
            }
        });




        // Add ActionListener to submit button
submitButton.addActionListener(e -> {
    if (radioButton2.isSelected()) {
        String dcVoltage = dcVoltageArea.getText(); 
        
        outputLabel.setText("" + dcVoltage + " V");
    } else if (radioButton1.isSelected()) {
        outputLabel.setText("No Output");
    }
});





// Add ActionListener to submit button
submitButton.addActionListener(e -> {
    
    if (radioButton3.isSelected()) {
        try {
           
            String dcVoltageText = dcVoltageArea.getText(); 
            String resistanceText = resistanceArea.getText(); 

            
            double dcVoltage = Double.parseDouble(dcVoltageText);
            double resistance = Double.parseDouble(resistanceText);

        
            double result = dcVoltage / resistance;

            
            outputLabel.setText("Result (V/Ω): " + result);

        } catch (NumberFormatException ex) {
            outputLabel.setText("Invalid input");
        }
    } else if (radioButton1.isSelected()) {
        
        
        outputLabel.setText("No Output");
    }
});





// Add ActionListener to submit button for radioButton4
submitButton.addActionListener(e -> {
   
    if (radioButton4.isSelected()) {
        
        String resistance = resistanceArea.getText(); 
        outputLabel.setText(resistance + " Ω");
    } else if (radioButton1.isSelected()) {
        outputLabel.setText("No Output");
    }
});


// Add ActionListener to submit button for radioButton5
submitButton.addActionListener(e -> {
   
    if (radioButton5.isSelected()) {
       
        String acVoltage = acVoltageArea.getText(); 

      
        outputLabel.setText(acVoltage + " V AC");
    } else if (radioButton1.isSelected()) {
        
        outputLabel.setText("No Output");
    }
});




// Add ActionListener to submit button for radioButton6
submitButton.addActionListener(e -> {
 
    if (radioButton6.isSelected()) {
        try {
            String acVoltageText = acVoltageArea.getText(); 
            String resistanceText = resistanceArea.getText(); 
            double acVoltage = Double.parseDouble(acVoltageText);
            double resistance = Double.parseDouble(resistanceText);  
            double result = acVoltage / resistance;
            outputLabel.setText("Result (V/Ω): " + result);
        } catch (NumberFormatException ex) {
            outputLabel.setText("Invalid input");
        }
    } else if (radioButton1.isSelected()) {
        outputLabel.setText("No Output");
    }
});










    }

    // New CustomImagePanel for panel5
    static class CustomImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Image image = Toolkit.getDefaultToolkit().getImage("2.png"); 
            
            g.drawImage(image, 0, 0, 550, 750, this); 

            Image image2 = Toolkit.getDefaultToolkit().getImage("1.png"); 
            g.drawImage(image2, 125, 325, 310, 295, this); 
        }
    }

    // GradientPanel class for a gradient background
    static class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

           
            Color startColor = new Color(102, 102, 255);
            Color endColor = new Color(255, 0, 255); 

            GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, getHeight(), endColor);
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
