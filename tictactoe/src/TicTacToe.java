/* This is the Driver class for the TicTacToe game.
It creates objects of Model, View and Controller 
classes and aggregates them.
 */
import model.*;
import view.*;
import controller.*;

public class TicTacToe {                                                              
                                                                                 
    public static void main(String[] args) { 
    	// Creating the components
    	Controller c = new Controller();  
    	View v = new View();   
        Model m = new Model();
        
        // Aggregating the components
        m.referenceView(v);
        c.set_model(m);
        v.setActionListener(c);
    }                                                                            
} 