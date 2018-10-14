package controller;


import java.util.ArrayList;

import model.*;
public class Controller {
	private Model m;
	public void set_model(Model m) {
		this.m = m;
	}
	public void set_request(ArrayList<Integer> position) {
		m.playMove(position.get(0), position.get(1));
	}
	
	public void set_request() {
		m.resetModel();
	}
	
}
