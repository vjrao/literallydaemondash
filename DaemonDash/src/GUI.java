import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import static java.awt.GraphicsDevice.WindowTranslucency.*;

public class GUI extends JFrame {
    public GUI() {
        super("DaemonDash Demo");

        setBackground(new Color(0,0,0,0));
        setSize(new Dimension(800,500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                if (g instanceof Graphics2D) {
                    final int R = 50;
                    final int G = 50;
                    final int B = 50;

                    Paint p =
                        new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 200),
                            0.0f, getHeight(), new Color(R, G, B, 240), true);
                    Graphics2D g2d = (Graphics2D)g;
                    g2d.setPaint(p);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };
        setContentPane(panel);
        setLayout(null);
        Border mouseOverBorder = new LineBorder(new Color(200,200,200),4);
        
        JPanel testPanel = new JPanel();
        testPanel.setSize(100, 100);
        testPanel.setBorder(null);
        testPanel.setBackground(new Color(160,160,160));
        testPanel.setLocation(this.getWidth()/2-testPanel.getWidth()/2, 
        		this.getHeight()/2-testPanel.getHeight()/2);  
        testPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                testPanel.setBackground(new Color(160,160,160));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Not working :(
                testPanel.setBackground(new Color(200,200,200));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                testPanel.setBorder(null);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                testPanel.setBorder(mouseOverBorder);
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
            	//testPanel.setBackground(new Color(120,120,120));
            }
        });
        
        JProgressBar testPB = new JProgressBar();
        testPB.setBackground(Color.black);
        testPB.setForeground(new Color(160,160,160));
        testPB.setBorder(null);
        testPB.setBorderPainted(false);
        testPB.setSize(100, 30);
        testPB.setLocation(100, 100);
        testPB.setValue(50);
        
        JPanel audioPanel = new JPanel();
        audioPanel.setBorder(null);
        
        add(testPB);
        add(testPanel);
        
    }

    public static void main(String[] args) {
        // Determine what the GraphicsDevice can support.
        GraphicsEnvironment ge = 
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        boolean isPerPixelTranslucencySupported = 
            gd.isWindowTranslucencySupported(PERPIXEL_TRANSLUCENT);

        //If translucent windows aren't supported, exit.
        if (!isPerPixelTranslucencySupported) {
            System.out.println(
                "Per-pixel translucency is not supported");
                System.exit(0);
        }

        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create the GUI on the event-dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gtw = new
                    GUI();

                // Display the window.
                gtw.setVisible(true);
            }
        });
    }
}