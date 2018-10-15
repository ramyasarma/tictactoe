package model;

import view.*;
public class Model {
	private View v;
	private int player_id;
	private int count_moves;
	private char[][] grid;
	private String message;
	public Model() {
		this.grid = new char[3][3];
		this.count_moves = 9;
		this.player_id = 1;
	}
	public void referenceView(View v) {
		this.v = v;
	}
	public int get_player_id() {
		return player_id;
	}

	public void set_player_id(int player_id) {
		this.player_id = player_id;
	}

	public int get_count_moves() {
		return count_moves;
	}

	public void set_moves_count(int count_moves) {
		this.count_moves = count_moves;
	}

	public char[][] get_grid() {
		return grid;
	}

	public void set_grid(char[][] board) {
		this.grid = board;
	}

	public String get_message() {
		return message;
	}

	public void set_message(String message) {
		this.message = message;
	}
	public void playMove(int x, int y) {
		
		if(get_count_moves() > 0){
			if(player_id%2 != 0) 
				grid[x][y] = 'X';
			else 
				grid[x][y] = 'O';
			set_moves_count(--count_moves);
			if(isWinner(x, y)) {
				set_message("Player " + player_id + " is Winner!");
				v.isWinner(x, y, grid[x][y], get_message());
			}
			else if(get_count_moves()==0) {
				set_message("No Winner! Game ended in a Tie");
				v.isWinner(x, y, grid[x][y], get_message());
			}
			else {
				if(player_id%2 != 0) {
					set_player_id(2);
					set_message("'O':  Player " +get_player_id());
				}
				else {
					set_player_id(1);
					set_message("'X':  Player " +get_player_id());

				}
				v.update(x, y, grid[x][y], get_message());
			}
			
		}
		
	}
	
	public boolean isWinner(int x, int y) {
		int countRow = 0;
		int countCol = 0;
		int countLDiag = 0;
		int countRDiag = 0;
		char symbol;
		if(get_player_id() %2 !=0)
			symbol = 'X';
		else
			symbol = 'O';
		
		for(int i=0; i<grid.length;i++) {
			if(grid[x][i] == symbol)
				countRow++;
			if(grid[i][y] == symbol)
				countCol++;
			if(grid[i][i] == symbol)
				countRDiag++;
			if(grid[grid.length-1-i][i] == symbol)
				countLDiag++;	
		}
		
		if(countCol==grid.length || countRow==grid.length 
		   || countLDiag == grid.length || countRDiag == grid.length)
			return true;
		
		return false;
	}
	public void reset_model() {
		count_moves = 9;
		set_player_id(1);
		set_message("");
		for(int i=0; i<grid.length;i++) {
			for(int j=0; j<grid.length;j++) {
				grid[i][j] = '\0';
			}
		}
		v.resetGame();
		
	}
		
}
