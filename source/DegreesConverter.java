import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DegreesConverter extends JFrame {
  private static final int WIDTH = 500;
  private static final int HEIGHT = 150;
  
  JLabel celLabel, fahLabel, myName;
  JButton celToFah, fahToCel, exitButton;
  JTextField celField, fahField;
  
  private celToFahHandler ctfHandler;
  private fahToCelHandler ftcHandler;
  private ExitHandler exHandler;
  
  public DegreesConverter() {
    celLabel = new JLabel("Degrees:", SwingConstants.RIGHT);
    fahLabel = new JLabel("Radians:", SwingConstants.RIGHT);
    celToFah = new JButton("Degrees To Radians");
    ctfHandler = new celToFahHandler();
    celToFah.addActionListener(ctfHandler);
    celToFah.setToolTipText("Click to calculate Radians from Degrees");
    fahToCel = new JButton("Radians To Degrees");
    fahToCel.setToolTipText("Click to calculate Degrees from Radians");
    ftcHandler = new fahToCelHandler();
    fahToCel.addActionListener(ftcHandler);
    exitButton = new JButton("Exit");
    exHandler = new ExitHandler();
    exitButton.addActionListener(exHandler);
    myName = new JLabel("Made By Luke Nelson", SwingConstants.CENTER);
    
    celField = new JTextField(10);
    fahField = new JTextField(10);
    
    setTitle("Degrees - Radians Converter");
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
      cel = Math.toRadians(cel);
      fahField.setText("Answer: " + cel);
    }
  }
  
  private class fahToCelHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      double fah;
      fah = Double.parseDouble(fahField.getText());
      fah = Math.toDegrees(fah);
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
