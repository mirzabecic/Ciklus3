package View;


import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;
/**
 * Main gui class. 
 * Creates initial frame.
 * @author mirza
 *
 */
public class Main {
	
	private static JFrame window = null;
	protected static int windowWidth = 400;
	protected static int windowHeight = 500;
	
	public static void init(){
		window = new JFrame("BitBook");
		window.setSize(windowWidth, windowHeight);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
	}
	
	protected static void setVisible(){
		window.validate();
		window.repaint();
		window.setVisible(true);
	}
	/**
	 * Replacing our frames content.
	 * This way we're just replacing panel in our frame
	 * isntead opening new frame on each button press.
	 * @param panel
	 */
	protected static void replaceContent(Container panel){
		window.setContentPane(panel);
		setVisible();
	}
}

