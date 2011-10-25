import java.awt.*;
import javax.swing.*;
 
public class PlotTest extends JPanel
{
    int PAD = 20;
    boolean drawLine = true;
    boolean drawDots = true;
    int dotRadius = 3;

    // the y coordinates of the points to be drawn; the x coordinates are evenly spaced
    int[] data = { 25, 60, 42, 75 };
 
    protected void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        g2.drawLine(PAD, PAD, PAD, h-PAD);
        g2.drawLine(PAD, h-PAD, w-PAD, h-PAD);
        double xScale = (w - 2*PAD) / (data.length + 1);
        double maxValue = 100.0;
        double yScale = (h - 2*PAD) / maxValue;
        // The origin location
        int x0 = PAD;
        int y0 = h-PAD;

        // draw connecting line
        if (drawLine)
        {
            for (int j = 0; j < data.length-1; j++)
            {
                int x1 = x0 + (int)(xScale * (j+1));
                int y1 = y0 - (int)(yScale * data[j]);
                int x2 = x0 + (int)(xScale * (j+2));
                int y2 = y0 - (int)(yScale * data[j+1]);
                g2.drawLine(x1, y1, x2, y2);
            }
        }

        // draw the points as little circles in red
        if (drawDots)
        {
            g2.setPaint(Color.red);
            for (int j = 0; j < data.length; j++)
            {
                int x = x0 + (int)(xScale * (j+1));
                int y = y0 - (int)(yScale * data[j]);
                g2.fillOval(x-dotRadius, y-dotRadius, 2*dotRadius, 2*dotRadius);
            }
        }
    }

    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new PlotTest());
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}