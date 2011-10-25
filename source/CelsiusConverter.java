import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CelsiusConverter extends JFrame {
  private static final int WIDTH = 500;
  private static final int HEIGHT = 150;
  
  JLabel celLabel, fahLabel, myName;
  JButton celToFah, fahToCel, exitButton;
  JTextField celField, fahField;
  
  private celToFahHandler ctfHandler;
  private fahToCelHandler ftcHandler;
  private ExitHandler exHandler;
  
  public CelsiusConverter() {
    celLabel = new JLabel("Celsius:", SwingConstants.RIGHT);
    fahLabel = new JLabel("Fahrenheit:", SwingConstants.RIGHT);
    celToFah = new JButton("Celsius To Fahrenheit");
    ctfHandler = new celToFahHandler();
    celToFah.addActionListener(ctfHandler);
    celToFah.setToolTipText("Click to calculate Fahrenheit from Celsius");
    fahToCel = new JButton("Fahrenheit To Celsius");
    fahToCel.setToolTipText("Click to calculate Celsius from Fahrenheit");
    ftcHandler = new fahToCelHandler();
    fahToCel.addActionListener(ftcHandler);
    exitButton = new JButton("Exit");
    exHandler = new ExitHandler();
    exitButton.addActionListener(exHandler);
    myName = new JLabel("Made By Luke Nelson", SwingConstants.CENTER);
    
    celField = new JTextField(10);
    fahField = new JTextField(10);
    
    setTitle("Celsius - Fahrenheit Converter");
    Container pane = getContentPane();
    pane.setLayout(new GridLayout(4, 2));
    
    pane.add(celLabel);
    pane.add(celField);
    pane.add(fahLabel);
    pane.add(fahField);
    pane.add(celToFah);
    pane.add(fahToCel);
    pane.add(exitButton);
    pane.add(myName);
    
    setSize(WIDTH, HEIGHT);
    setVisible(false);
    
  }
  
  public class celToFahHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      double cel;
      cel = Double.parseDouble(celField.getText());
      cel = cel * 9;
      cel = cel / 5;
      cel = cel + 32;
      fahField.setText("Answer: " + cel);
    }
  }
  
  private class fahToCelHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      double fah;
      fah = Double.parseDouble(fahField.getText());
      fah = fah - 32;
      fah = fah * 5;
      fah = fah / 9;
      celField.setText("Answer: " + fah);
    }
  }
    
    private class ExitHandler implements ActionListener {
      public void actionPerformed(ActionEvent event) {
        setVisible(false);
      }
    }
    
    public static void main(String[] args) {
      CelsiusConverter convObj = new CelsiusConverter();
    }
    
    public void makeVisible() {
      this.setVisible(true);
    }
  }
