import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrimeChecker extends JFrame {
  
  JButton checkButton, exitButton;
  public static final int WIDTH = 400;
  public static final int HEIGHT = 200;
  JLabel numberLabel, resultLabel, resultAnswer, myName;
  JTextField inputField;
  ExitButtonHandler ebHandler;
  CheckButtonHandler cbHandler;
  
  public PrimeChecker() {
    numberLabel = new JLabel("Number:", SwingConstants.RIGHT);
    resultLabel = new JLabel("Result:", SwingConstants.RIGHT);
    resultAnswer = new JLabel("", SwingConstants.LEFT);
    myName = new JLabel("Made By Luke Nelson", SwingConstants.CENTER);
    ebHandler = new ExitButtonHandler();
    cbHandler = new CheckButtonHandler();
    checkButton = new JButton("Check");
    exitButton = new JButton("Exit");
    exitButton.addActionListener(ebHandler);
    checkButton.addActionListener(cbHandler);
    inputField = new JTextField(10);
    setTitle("Prime Number Checker");
    Container pane = getContentPane();
    pane.setLayout(new GridLayout(4, 2));
    setSize(WIDTH, HEIGHT);
    pane.add(numberLabel);
    pane.add(inputField);
    pane.add(resultLabel);
    pane.add(resultAnswer);
    pane.add(checkButton);
    pane.add(exitButton);
    pane.add(myName);
  }
  
  
  
  public class ExitButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      setVisible(false);
    }
  }
  
  public class CheckButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        int x;
        int y;
        x = Integer.parseInt(inputField.getText());
        if( x != 1) {
        for(y = x - 1; true; y--) {
          if(x == 2) {
            resultAnswer.setText("  Prime");
            break;
          }
          
          
          if(x % y == 0) {
            resultAnswer.setText("  Composite  (" + y + ")");
            break;
          }
          
          if(y == 2) {
            resultAnswer.setText("  Prime");
            break;
          }
        }
        }
        else if (x == 1) {
          resultAnswer.setText("  Neither");
        }
    }
  }
  
}