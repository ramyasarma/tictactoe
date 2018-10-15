
import model.*;
import view.*;
import controller.*;

public class TicTacToe {                                                              
                                                                                 
    public static void main(String[] args) {                                   
    	Controller c = new Controller();  
    	View v = new View();   
        Model m = new Model();   
        m.referenceView(v);
        c.set_model(m);
        v.setActionListener(c);
    }                                                                            
} 