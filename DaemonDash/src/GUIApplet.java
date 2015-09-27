import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import static java.awt.GraphicsDevice.WindowTranslucency.*;

public class GUIApplet extends JApplet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static BufferedImage play = null;
	private static BufferedImage stop = null;
	private static BufferedImage pause = null;
	private static double midiEnd = 0;
	private static double midiCur = 0;
	private static JProgressBar testPB = new JProgressBar();
	private static Sequencer sq = null;
    private static boolean disPlay = true;
	
	public GUIApplet() {
		System.getProperty("user.dir");
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
		
		try {
			sq = MidiSystem.getSequencer();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			sq.open();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        InputStream is = null;
        try {
			is = new BufferedInputStream(
					new FileInputStream(new File("ChromaticScale.mid")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			sq.setSequence(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		init();
		start();
	}
	
	public void init() {

	        JFrame.setDefaultLookAndFeelDecorated(true);

	        // Create the GUI on the event-dispatching thread
	        /*
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                gtw = new
	                    GUI();

	                // Display the window.
	                gtw.setVisible(true);
	            }
	        });
	        */
			
	        
        setBackground(new Color(0,0,0,0));
        setSize(new Dimension(900,700));

        JPanel panel = new JPanel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

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
        
		try {
			play = ImageIO.read(new File("playImg.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} try {
			pause = ImageIO.read(new File("pauseImg.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} try {
			stop = ImageIO.read(new File("stopImg.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
        
        JPanel button1 = new JPanel(){
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		if (disPlay)
        			g.drawImage(play, 0, 0, null);
        		else
        			g.drawImage(pause, 0, 0, null);
        	}
        };
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
            	if (disPlay) {
            		sq.start();
            		disPlay = false;
            	} else {
            		sq.stop();
            		disPlay = true;
            	}
            	
            	if (midiCur >= midiEnd)
            		testPB.setValue((int) (midiCur/(midiEnd)*100));
            	repaint();
            }
        });
        
        JPanel button2 = new JPanel(){
        	public void paintComponent(Graphics g) {
        		super.paintComponent(g);
        		g.drawImage(stop, 0, 0, null);
        	}
        };
        
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
            	sq.stop();
            	disPlay = true;
            	sq.setMicrosecondPosition(0);
            	testPB.setValue((int) (midiCur/(midiEnd)*100));
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
        
        testPB.setBackground(Color.black);
        testPB.setForeground(new Color(39,117,236));
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
	
	public void start() {
        while(true)
        {
            midiCur = sq.getMicrosecondPosition();
            midiEnd = sq.getMicrosecondLength();
        	while (midiCur < midiEnd)
        	{
        		midiCur = sq.getMicrosecondPosition();
        		//System.out.println(midiCur/midiEnd);  ==> debug purposes
        		testPB.setValue((int) (midiCur/(midiEnd)*100));
        	}
        	disPlay = true;
        	sq.setMicrosecondPosition(0);
        	testPB.setValue(0);
        }
	}

    public static void main(String[] args) {
        // Determine what the GraphicsDevice can support.
        
        
    }
}