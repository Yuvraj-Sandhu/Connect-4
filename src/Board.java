public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6; 
	
	private char[][] board = new char[NUM_OF_ROW][NUM_OF_COLUMNS*2 + 1];

	public Board() {
		
		char[][] board = new char[NUM_OF_ROW][NUM_OF_COLUMNS*2 + 1];

		for(int i = 0; i < NUM_OF_ROW; i++){
			for(int j = 0; j < NUM_OF_COLUMNS*2 + 1;j++){
				if(j % 2 == 0){
					board[i][j] = '|';
				}
				else{
					if(i == 5){
						board[i][j] = '_';
					}
					else board[i][j] = ' ';
				}
			}
		}
		this.board = board;
	}
	
	public void printBoard() {
		System.out.println(" 1 2 3 4 5 6 7");
		for(int i = 0; i < NUM_OF_ROW; i++){
			for(int j = 0; j < NUM_OF_COLUMNS*2 + 1;j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public boolean containsWin() {
		// Horizontal Check
		// First line of if statement checks if the row is empty or not.
		// Second line of if statement checks if the entries in the row are equal or not.
		
		for(int i = 0; i < NUM_OF_ROW; i++){
			for(int j = 0; j < 4; j++){
				if( ((board[i][2*j+1] != ' ') && (board[i][2*j+1] != '_')) && ((board[i][2*j+3] != ' ') && (board[i][2*j+3] != '_')) && 
				((board[i][2*j+5] != ' ') && (board[i][2*j+5] != '_')) && ((board[i][2*j+7] != ' ') && (board[i][2*j+7] != '_')) &&
				( (board[i][2*j+1] == board[i][2*j+3]) && (board[i][2*j+3] == board[i][2*j+5]) && (board[i][2*j+5] == board[i][2*j+7]) ) ){
					return true;
				}
			}
		}

		// Vertical Check

		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 6; j++){
				if( ((board[i][2*j+1] != ' ') && (board[i][2*j+1] != '_')) && ((board[i+1][2*j+1] != ' ') && (board[i+1][2*j+1] != '_')) &&
				((board[i+2][2*j+1] != ' ') && (board[i+2][2*j+1] != '_')) && ((board[i+3][2*j+1] != ' ') && (board[i+3][2*j+1] != '_')) &&
				( (board[i][2*j+1] == board[i+1][2*j+1]) && (board[i+1][2*j+1] == board[i+2][2*j+1]) && (board[i+2][2*j+1] == board[i+3][2*j+1]) ) ){
					return true;
				} 
			}
		}

		// Left to Right Diagonal Check (\)

		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 4; j++){
				if( ((board[i][2*j+1] != ' ') && (board[i][2*j+1] != '_')) && ((board[i+1][2*j+3] != ' ') && (board[i+1][2*j+3] != '_')) &&
				((board[i+2][2*j+5] != ' ') && (board[i+2][2*j+5] != '_')) && ((board[i+3][2*j+7] != ' ') && (board[i+3][2*j+7] != '_')) &&
				( (board[i][2*j+1] == board[i+1][2*j+3]) && (board[i+1][2*j+3] == board[i+2][2*j+5]) && (board[i+2][2*j+5] == board[i+3][2*j+7]) ) ){
					return true;
				}
			}
		}

		// Right to Left Diagonal Check (/)

		for(int i = 0; i < 3; i++){
			for(int j = 3; j < 7; j++){
				if( ((board[i][2*j+1] != ' ') && (board[i][2*j+1] != '_')) && ((board[i+1][2*j-1] != ' ') && (board[i+1][2*j-1] != '_')) &&
				((board[i+2][2*j-3] != ' ') && (board[i+2][2*j-3] != '_')) && ((board[i+3][2*j-5] != ' ') && (board[i+3][2*j-5] != '_')) &&
				( (board[i][2*j+1] == board[i+1][2*j-1]) && (board[i+1][2*j-1] == board[i+2][2*j-3]) && (board[i+2][2*j-3] == board[i+3][2*j-5]) ) ){
					return true;
				}
			} 
		}
		return false;
	}
	
	public boolean isTie() {
		
		for(int i = 0; i < NUM_OF_ROW; i++){
			for(int j = 0; j < NUM_OF_COLUMNS;j++){
				if((board[i][2*j+1] == ' ') || (board[i][2*j+1] == '_')){
					return false;
				}
			}
		}
		return true;
	}
	
	public void reset() {
		for(int i = 0; i < NUM_OF_ROW; i++){
			for(int j = 0; j < NUM_OF_COLUMNS*2 + 1;j++){
				if(j % 2 == 0){
					board[i][j] = '|';
				}
				else{
					if(i == 5){
						board[i][j] = '_';
					}
					else board[i][j] = ' ';
				}
			}
		}
	}

	public void insert(char symbol,int x){
		for(int i = 5; i > -1; i--){

			if((i == 5) && (board[i][2*x-1] == '_')){
				(board[i][2*x-1]) = symbol;
			}
			else
			if((board[i][2*x-1] != ' ') && (board[i-1][2*x-1] == ' ')){
				board[i-1][2*x-1] = symbol;
				return;
			}
		}
	}

	// function to reset the topmost value of a column.

	public void revert(int x){
		for(int i = 0; i < NUM_OF_ROW; i++){

			if((i == 5)){
				(board[i][2*x-1]) = '_';
			}
			else
			if((board[i][2*x-1] != ' ')){
				board[i][2*x-1] = ' ';
				return;
			}
		}
	}

	public boolean isEmpty(int x,int i){
		int j = 2*x - 1;
		if(board[i][j] != ' ' && board[i][j] != '_'){
			return false;
		}

		return true;
	}

	// checks if the value is valid to enter in the board

	public boolean checkValid(int x){
		
		if(x > 7 || x < 1){
			return false;
		}

		for(int i = 5; i > -1; i--){
			if((board[i][2*x-1] == '_') || (board[i][2*x-1] == ' ')){
				return true;
			}
		}

		return false;
	}

	// adds an element at the end of an int array

	public int[] add(int x, int[] list,int size){
		int newlist[] = new int[size + 1];
		for(int i = 0; i < size; i++){
			newlist[i] = list[i];
		}
		newlist[size] = x;
		return newlist;
	}

	// returns an array of possible moves that AI should block.

	public int[] winningMove(){
		
		int arr[] = {};
		int size = 0;

		// Horizontal Check

		for(int i = 0; i < NUM_OF_ROW; i++){
			for(int j = 0; j < 4; j++){
				// last
				if((board[i][2*j+1] == board[i][2*j+3]) && (board[i][2*j+3] == board[i][2*j+5]) && ((board[i][2*j+1] != ' ') && (board[i][2*j+1] != '_'))){
					if(i != 5){
						if((board[i+1][2*j+7] != ' ' && board[i+1][2*j+7] != '_')){
							
							arr = add(2*j+7,arr,size);
							size += 1;
							arr = add(i,arr,size);
							size += 1;
						}
					}
					else{
						
						arr = add(2*j+7,arr,size);
						size += 1;
						arr = add(i,arr,size);
						size += 1;
					}
				}
				//first
				if((board[i][2*j+3] == board[i][2*j+5]) && (board[i][2*j+5] == board[i][2*j+7]) && ((board[i][2*j+3] != ' ') && (board[i][2*j+3] != '_'))){
					if(i != 5){
						if((board[i+1][2*j+1] != ' ' && board[i+1][2*j+1] != '_')){
							
							arr = add(2*j+1,arr,size);
							size += 1;
							arr = add(i,arr,size);
							size += 1;
						}
					}
					else{
						
						arr = add(2*j+1,arr,size);
						size += 1;
						arr = add(i,arr,size);
						size += 1;
					}
				}
				//second
				if((board[i][2*j+1] == board[i][2*j+5]) && (board[i][2*j+5] == board[i][2*j+7]) && ((board[i][2*j+1] != ' ') && (board[i][2*j+1] != '_'))){
					if(i != 5){
						if((board[i+1][2*j+3] != ' ' && board[i+1][2*j+3] != '_')){
							
							arr = add(2*j+3,arr,size);
							size += 1;
							arr = add(i,arr,size);
							size += 1;
						}
					}
					else{
						
						arr = add(2*j+3,arr,size);
						size += 1;
						arr = add(i,arr,size);
						size += 1;
					}
				}
				//third
				if((board[i][2*j+1] == board[i][2*j+3]) && (board[i][2*j+3] == board[i][2*j+7]) && ((board[i][2*j+3] != ' ') && (board[i][2*j+3] != '_'))){
					if(i != 5){
						if((board[i+1][2*j+5] != ' ' && board[i+1][2*j+5] != '_')){
							
							arr = add(2*j+5,arr,size);
							size += 1;
							arr = add(i,arr,size);
							size += 1;
						}
					}
					else{
						
						arr = add(2*j+5,arr,size);
						size += 1;
						arr = add(i,arr,size);
						size += 1;
					}
				}
			}
		}

		// Vertical Check

		for(int i = 1; i < 4; i++){
			for(int j = 0; j < 7; j++){
					if((board[i][2*j+1] == board[i+1][2*j+1]) && (board[i+1][2*j+1] == board[i+2][2*j+1]) && ((board[i][2*j+1] != ' ') && (board[i][2*j+1] != '_'))){
						
						arr = add(2*j+1,arr,size);
						size += 1;
						arr = add(i-1,arr,size);
						size += 1;
					}
			}
		}

		// Left to Right Diagonal Check (\)

		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 4; j++){

					//last
					if((board[i][2*j+1] == board[i+1][2*j+3]) && (board[i+1][2*j+3] == board[i+2][2*j+5]) && ((board[i][2*j+1] != ' ') && (board[i][2*j+1] != '_'))){
						if(i != 2){
							if((board[i+4][2*j+7] != ' ' && board[i+4][2*j+7] != '_')){
								
								arr = add(2*j+7,arr,size);
								size += 1;
								arr = add(i+3,arr,size);
								size += 1;
							}
						}
						else{
							
							arr = add(2*j+7,arr,size);
							size += 1;
							arr = add(i+3,arr,size);
							size += 1;
						}
					}
					//first
					if((board[i+1][2*j+3] == board[i+2][2*j+5]) && (board[i+2][2*j+5] == board[i+3][2*j+7]) && ((board[i+1][2*j+3] != ' ') && (board[i+1][2*j+3] != '_'))){
						if((board[i+1][2*j+1] != ' ' && board[i+1][2*j+1] != '_')){
							
							arr = add(2*j+1,arr,size);
							size += 1;
							arr = add(i,arr,size);
							size += 1;
						}
					}
					//second
					if((board[i][2*j+1] == board[i+2][2*j+5]) && (board[i+2][2*j+5] == board[i+3][2*j+7]) && ((board[i][2*j+1] != ' ') && (board[i][2*j+1] != '_'))){
						if((board[i+2][2*j+3] != ' ' && board[i+2][2*j+3] != '_')){
							
							arr = add(2*j+3,arr,size);
							size += 1;
							arr = add(i+1,arr,size);
							size += 1;
						}
					}
					//third
					if((board[i][2*j+1] == board[i+1][2*j+3]) && (board[i+1][2*j+3] == board[i+3][2*j+7]) && ((board[i][2*j+1] != ' ') && (board[i][2*j+1] != '_'))){
						if((board[i+3][2*j+5] != ' ' && board[i+3][2*j+5] != '_')){
							
							arr = add(2*j+5,arr,size);
							size += 1;
							arr = add(i+2,arr,size);
							size += 1;
						}
					}
			}
		}

		// Right to Left Diagonal Check (/)

		for(int i = 0; i < 3; i++){
			for(int j = 3; j < 7; j++){
					//last
					if((board[i][2*j+1] == board[i+1][2*j-1]) && (board[i+1][2*j-1] == board[i+2][2*j-3]) && ((board[i][2*j+1] != ' ') && (board[i][2*j+1] != '_'))){
						if(i != 2){
							if((board[i+4][2*j-5] != ' ' && board[i+4][2*j-5] != '_')){
								
								arr = add(2*j-5,arr,size);
								size += 1;
								arr = add(i+3,arr,size);
								size += 1;
							}
						}
						else{
							
							arr = add(2*j-5,arr,size);
							size += 1;
							arr = add(i+3,arr,size);
							size += 1;
						}
					}
					//first
					if((board[i+1][2*j-1] == board[i+2][2*j-3]) && (board[i+2][2*j-3] == board[i+3][2*j-5]) && ((board[i+1][2*j-1] != ' ') && (board[i+1][2*j-1] != '_'))){
						if((board[i+1][2*j+1] != ' ' && board[i+1][2*j+1] != '_')){
							
							arr = add(2*j+1,arr,size);
							size += 1;
							arr = add(i,arr,size);
							size += 1;
						}
					}
					//second
					if((board[i][2*+1] == board[i+2][2*j-3]) && (board[i+2][2*j-3] == board[i+3][2*j-5]) && ((board[i][2*j+1] != ' ') && (board[i][2*j+1] != '_'))){
						if((board[i+2][2*j-1] != ' ' && board[i+2][2*j-1] != '_')){
							
							arr = add(2*j-1,arr,size);
							size += 1;
							arr = add(i+1,arr,size);
							size += 1;
						}
					}
					//third
					if((board[i][2*j+1] == board[i+1][2*j-1]) && (board[i+1][2*j-1] == board[i+3][2*j-5]) && ((board[i][2*j+1] != ' ') && (board[i][2*j+1] != '_'))){
						if((board[i+3][2*j-3] != ' ' && board[i+3][2*j-3] != '_')){
							
							arr = add(2*j-3,arr,size);
							size += 1;
							arr = add(i+2,arr,size);
							size += 1;
						}
					}
			} 
		}

		return arr;
	}
	
}