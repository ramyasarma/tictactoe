package adapter;

/* 
The adapter class acts as an interface between view and controller
to allow code separation. 
 */
import controller.*;
import view.*;
import java.awt.event.*;
import java.util.*;

public class Adapter implements ActionListener {
	private Controller c;
	private View v;
	// Initializing reference to controller and view 
    public Adapter(Controller c, View v) {
        this.c = c;
        this.v = v;
    }
 // adapter calls controller to perform desired action depending on which button is clicked
    public void actionPerformed(ActionEvent e) {
    		if(v.isReset(e))
    			c.set_request();
    		else {
    			ArrayList<Integer> position = v.getPosition(e);
    			c.set_request(position);
    		}
    }

}
