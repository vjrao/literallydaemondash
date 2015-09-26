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
        setSize(new Dimension(900,700));
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
        
        JPanel button1 = new JPanel();
        button1.setSize(100, 100);
        button1.setBorder(null);
        button1.setBackground(new Color(160,160,160));
        button1.setLocation(this.getWidth()/2-button1.getWidth()/2, 
        		this.getHeight()/2-button1.getHeight()/2-50);  
        button1.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                button1.setBackground(new Color(160,160,160));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Not working :(
                button1.setBackground(new Color(200,200,200));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button1.setBorder(null);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button1.setBorder(mouseOverBorder);
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
            	//button1.setBackground(new Color(120,120,120));
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
        audioPanel.setBackground(new Color(160, 160, 160));
        audioPanel.setSize(870, 150);
        audioPanel.setLocation(10, this.getHeight()-200);
        
        
        add(testPB);
        add(button1);
        add(audioPanel);
        
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