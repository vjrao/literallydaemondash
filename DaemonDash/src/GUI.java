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
        button1.setSize(120, 120);
        button1.setBorder(null);
        button1.setBackground(new Color(160,160,160));
        button1.setLocation(580,20);  
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
        
        JPanel button2 = new JPanel();
        button2.setSize(120, 120);
        button2.setBorder(null);
        button2.setBackground(new Color(160,160,160));
        button2.setLocation(720,20);  
        button2.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                button2.setBackground(new Color(160,160,160));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Not working :(
                button2.setBackground(new Color(200,200,200));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button2.setBorder(null);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button2.setBorder(mouseOverBorder);
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
            	//button2.setBackground(new Color(120,120,120));
            }
        });
        
        JPanel button3 = new JPanel();
        button3.setSize(120, 120);
        button3.setBorder(null);
        button3.setBackground(new Color(160,160,160));
        button3.setLocation(580,160);  
        button3.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                button3.setBackground(new Color(160,160,160));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Not working :(
                button3.setBackground(new Color(200,200,200));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button3.setBorder(null);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button3.setBorder(mouseOverBorder);
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
            	//button3.setBackground(new Color(120,120,120));
            }
        });
        
        JPanel button4 = new JPanel();
        button4.setSize(120, 120);
        button4.setBorder(null);
        button4.setBackground(new Color(160,160,160));
        button4.setLocation(720,160);  
        button4.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                button4.setBackground(new Color(160,160,160));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Not working :(
                button4.setBackground(new Color(200,200,200));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button4.setBorder(null);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button4.setBorder(mouseOverBorder);
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
            	//button4.setBackground(new Color(120,120,120));
            }
        });
        
        JPanel button5 = new JPanel();
        button5.setSize(120, 120);
        button5.setBorder(null);
        button5.setBackground(new Color(160,160,160));
        button5.setLocation(580,300);  
        button5.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                button5.setBackground(new Color(160,160,160));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Not working :(
                button5.setBackground(new Color(200,200,200));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button5.setBorder(null);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button5.setBorder(mouseOverBorder);
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
            	//button5.setBackground(new Color(120,120,120));
            }
        });
        
        JPanel button6 = new JPanel();
        button6.setSize(120, 120);
        button6.setBorder(null);
        button6.setBackground(new Color(160,160,160));
        button6.setLocation(720,300);  
        button6.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                button6.setBackground(new Color(160,160,160));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Not working :(
                button6.setBackground(new Color(200,200,200));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button6.setBorder(null);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button6.setBorder(mouseOverBorder);
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
            	//button6.setBackground(new Color(120,120,120));
            }
        });
        
        JProgressBar testPB = new JProgressBar();
        testPB.setBackground(Color.black);
        testPB.setForeground(new Color(160,160,160));
        testPB.setBorder(null);
        testPB.setBorderPainted(false);
        testPB.setSize(260, 40);
        testPB.setLocation(580, 440);
        testPB.setValue(50);
        
        JPanel audioPanel = new JPanel();
        audioPanel.setBorder(null);
        audioPanel.setBackground(new Color(160, 160, 160));
        audioPanel.setSize(870, 150);
        audioPanel.setLocation(10, this.getHeight()-200);
        
        
        add(testPB);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
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