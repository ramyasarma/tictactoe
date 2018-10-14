package adapter;
import controller.*;
import view.*;
import java.awt.event.*;
import java.util.*;

public class Adapter implements ActionListener {
   public Adapter(Controller c, View v) {
        this.c = c;
        this.v = v;
    }
    public void action_performed(ActionEvent e) {
    		if(v.isReset(e))
    			c.set_request();
    		else {
    			ArrayList<Integer> position = v.getPosition(e);
    			c.set_request(position);
    		}
    }

}
