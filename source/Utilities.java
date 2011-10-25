
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Utilities extends JFrame {
  static JLabel titleLabel, myName;
  static JButton startBMICalculator, startCelsiusConverter, startRandomIntGenerator, exitButton, startDegreesConverter;
  static private BMIButtonHandler bmiHandler;
  static JButton startPrimeChecker;
  static private CelsiusButtonHandler celsiusHandler;
  static private RandomButtonHandler randomHandler;
  static private ExitButtonHandler ebHandler;
  static private DegreesButtonHandler dbHandler;
  public static final int WIDTH = 380;
  public static final int HEIGHT = 350;
  static int choice = 0;
  static CelsiusConverter c = new CelsiusConverter();
  static BMICalculator b = new BMICalculator();
  static RandomIntGenerator r = new RandomIntGenerator();
  static DegreesConverter d = new DegreesConverter();
  static PrimeChecker p = new PrimeChecker();
  static PrimeButtonHandler pbHandler;
  
  public Utilities() {
      titleLabel = new JLabel("A Simple Utilities Application", SwingConstants.CENTER);
    myName = new JLabel("Made by Luke Nelson", SwingConstants.CENTER);
    startBMICalculator = new JButton("Start BMI Calculator");
    startCelsiusConverter = new JButton("Start Celsius/Fahrenheit Converter");
    startRandomIntGenerator = new JButton("Start Random Integer Generator");
    exitButton = new JButton("Exit");
    startPrimeChecker = new JButton("Start Prime Checker");
    pbHandler = new PrimeButtonHandler();
    startPrimeChecker.addActionListener(pbHandler);
    ebHandler = new ExitButtonHandler();
    exitButton.addActionListener(ebHandler);
    bmiHandler = new BMIButtonHandler();
    celsiusHandler = new CelsiusButtonHandler();
    randomHandler = new RandomButtonHandler();
    startBMICalculator.addActionListener(bmiHandler);
    startCelsiusConverter.addActionListener(celsiusHandler);
    startRandomIntGenerator.addActionListener(randomHandler);
    startDegreesConverter = new JButton("Start Degrees/Radians Converter");
    dbHandler = new DegreesButtonHandler();
    startDegreesConverter.addActionListener(dbHandler);
    setTitle("Utilities App");
    Container pane = getContentPane();
    pane.setLayout(new GridLayout(8, 1));
    setSize(WIDTH, HEIGHT);
    pane.add(titleLabel);
    pane.add(startBMICalculator);
    pane.add(startRandomIntGenerator);
    pane.add(startCelsiusConverter);
    pane.add(startDegreesConverter);
    pane.add(startPrimeChecker);
    pane.add(exitButton);
    pane.add(myName);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }
  
  private static class ExitButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      System.exit(0);
    }
  }
  
  private static class CelsiusButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      c.setVisible(true);
    }
  }
  
  private static class BMIButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      b.setVisible(true);
    }
  }
  
  private static class RandomButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      r.setVisible(true);
    }
  }
  
  public static class DegreesButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      d.setVisible(true);
    }
  }
  
  public static class PrimeButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      p.setVisible(true);
    }
  }
  
  public static void main(String[] args) {
  
    Utilities util = new Utilities();
    
    
  }
  
  
}