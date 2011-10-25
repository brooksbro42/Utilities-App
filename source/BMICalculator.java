import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BMICalculator extends JFrame {
  
  JLabel heightLabel, weightLabel, myName, bmiLabel, statusLabel, statusField, bmiField;
  JButton calculateButton, exitButton;
  JTextField heightField, weightField;
  private static final int HEIGHT = 200;
  private static final int WIDTH = 500;
  
  private CalculateButtonHandler cbHandler;
  private ExitButtonHandler ebHandler;
  
  public BMICalculator() {
    heightLabel = new JLabel("Height In Feet:", SwingConstants.RIGHT);
    weightLabel = new JLabel("Weight In Pounds:", SwingConstants.RIGHT);
    myName = new JLabel("Made By Luke Nelson", SwingConstants.CENTER);
    bmiLabel = new JLabel("BMI:", SwingConstants.RIGHT);
    statusLabel = new JLabel("Description:", SwingConstants.RIGHT);
    calculateButton = new JButton("Calculate");
    cbHandler = new CalculateButtonHandler();
    calculateButton.addActionListener(cbHandler);
    calculateButton.setToolTipText("Click to calculate"+" your BMI");
    exitButton = new JButton("Exit");
    ebHandler = new ExitButtonHandler();
    exitButton.addActionListener(ebHandler);
    heightField = new JTextField(10);
    weightField = new JTextField(10);
    bmiField = new JLabel("", SwingConstants.LEFT);
    statusField = new JLabel("", SwingConstants.LEFT);
    
    setTitle("BMI Calculator");
    Container pane = getContentPane();
    pane.setLayout(new GridLayout(6, 2));
    
    pane.add(heightLabel);
    pane.add(heightField);
    pane.add(weightLabel);
    pane.add(weightField);
    pane.add(bmiLabel);
    pane.add(bmiField);
    pane.add(statusLabel);
    pane.add(statusField);
    pane.add(calculateButton);
    pane.add(exitButton);
    pane.add(myName);
    
    setSize(WIDTH, HEIGHT);
    setVisible(false);
    
    
   }
  
  private class CalculateButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      double w, h, b;
      w = Double.parseDouble(weightField.getText());
      h = Double.parseDouble(heightField.getText());
      h = h*12;
      h = h * h;
      w = w * 703;
      b = w / h;
      bmiField.setText("  " + b);
      if (b<18.5 && b > 0) {
        statusField.setText("  Underweight");
      }
      else if (b >= 18.5 && b < 25) {
        statusField.setText("  Normal");
      }
      else if (b >= 25 && b < 30) {
        statusField.setText("  Overweight");
      }
      else if (b>30) {
        statusField.setText("  Obese");
      }
    }
  }
  
  private class ExitButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      setVisible(false);
    }
  }
  
  
  
}