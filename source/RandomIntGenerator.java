import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class RandomIntGenerator extends JFrame {
  JLabel rangeLabel, resultLabel, myName;
  JButton exitButton, generateButton;
  JTextField rangeField, resultField;
  ExitButtonHandler ebHandler;
  GenerateButtonHandler gbHandler;
  private static final int WIDTH = 550;
  private static final int HEIGHT = 150;
  
  public RandomIntGenerator() {
    rangeLabel = new JLabel("Generate a random integer between 0 and", SwingConstants.RIGHT);
    resultLabel = new JLabel("The generated number was", SwingConstants.RIGHT);
    myName = new JLabel("Made by Luke Nelson", SwingConstants.CENTER);
    rangeField = new JTextField(10);
    resultField = new JTextField(10);;
    exitButton = new JButton("Exit");
    ebHandler = new ExitButtonHandler();
    exitButton.addActionListener(ebHandler);
    generateButton = new JButton("Generate");
    gbHandler = new GenerateButtonHandler();
    generateButton.addActionListener(gbHandler);
    setTitle("Random Integer Generator");
    Container pane = getContentPane();
    pane.setLayout(new GridLayout(4 , 2));
    pane.add(rangeLabel);
    pane.add(rangeField);
    pane.add(resultLabel);
    pane.add(resultField);
    pane.add(generateButton);
    pane.add(exitButton);
    pane.add(myName);
    setSize(WIDTH, HEIGHT);
    setVisible(false);
    
  }
  
  private class GenerateButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      int r;
      Random rand = new Random();
      r = rand.nextInt(Integer.parseInt(rangeField.getText()));
      resultField.setText("" + r);
    }
  }
  
  private class ExitButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      setVisible(false);
    }
  }
  
  
  public void makeVisible() {
    this.setVisible(true);
  }
  
}