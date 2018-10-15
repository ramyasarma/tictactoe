/* 
 The Controller class is responsible for requesting the model
to update its state whenever there is an event on a button on 
the game board. 

*/

package controller;
import java.util.ArrayList;

import model.*;
public class Controller {
	// initializing the reference of model class
	private Model m;
	public void set_model(Model m) {
		this.m = m;
	}
	// overloaded function to request model to reset
	public void set_request(ArrayList<Integer> position) {
		m.playMove(position.get(0), position.get(1));
	}
	// function to request the model to update the board
	public void set_request() {
		m.reset_model();
	}
	
}
