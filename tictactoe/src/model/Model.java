package model;
 public class Model {
	private int player_id;
	private int count_moves;
	private char[][] grid;
	private String message;
	
	// default constructor
	public Model() {
		this.grid = new char[3][3];
		this.count_moves = 9;
	}
    
	//setters and getters
	public int get_player_id() {
		return player_id;
	}
 	public void set_player_id(int player_id) {
		this.player_id = player_id;
	}
 	public int get_count_moves() {
		return count_moves;
	}
 	public void set_count_moves(int count_moves) {
		this.count_moves = count_moves;
	}
 	public char[][] get_grid() {
		return grid;
	}
 	public void set_grid(char[][] grid) {
		this.grid = grid;
	}
 	public String get_message() {
		return message;
	}
 	public void set_message(String message) {
		this.message = message;
	}
 	// function to update the board
	public void playMove(int x, int y, int player_id) {
		if(get_count_moves() > 0){
			
			if(player_id%2 != 0)
				grid[x][y] = 'X';
			else
				grid[x][y] = 'O';
			
			set_count_moves(--count_moves);
			
			if(isWinner(x, y, player_id))
				set_message("Player" + player_id + "is Winner!");
			if(get_count_moves()==0)
				set_message("No Winner! Game ended in a Tie");
		}
		
	}
	
	// function to check if there is a winner
	public boolean isWinner(int x, int y, int player_id) {
		int countRow = 0;
		int countCol = 0;
		int countLDiag = 0;
		int countRDiag = 0;
		char symbol;
		if(player_id %2 !=0)
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
		
}