import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Control.Elevator;



public class Driver {
	
	
	
	public static void main(String[] args) {
		
        new Elevator("1", 1, 3000, 30, false, false);
        new Elevator("2", 1, 3000, 30, false, false);


    
    }
    
    public static void showMessage(String message, String title) {
        final JOptionPane pane = new JOptionPane(message);
        final JDialog d = pane.createDialog(null, title);
        d.setLocation(200, 40);
        d.setVisible(true);
    }
	
	
	
	
	

}
