public class AIPlayer extends Player{

    public AIPlayer(char symbol, Board board, String name) {
        super(symbol, board, name); 
    }

    // function to add an element at the end of an int array;

    public int[] add(int x, int[] list,int size){
		int newlist[] = new int[size + 1];
		for(int i = 0; i < size; i++){
			newlist[i] = list[i];
		}
		newlist[size] = x;
		return newlist;
	}

    public void makeMove(Board board){

        // AI plays winning move if available

        for(int inp = 1; inp < 8; inp++){
            if(board.checkValid(inp)){
                board.insert(symbol, inp);
                if(board.containsWin()){
                    board.revert(inp);
                    System.out.println(name + ", please input your move: " + inp);
                    board.insert(symbol, inp);
                    return;
                }
                else board.revert(inp);
            }
        }

        // AI blocks other player's winning move

        int[] arr = {};
        int[] ans = {};
        int[] arr1 = {};


        arr = board.winningMove();
        
        for(int i = 0; i < arr.length; i += 2){
            arr1 = add(((arr[i] + 1)/2),arr1,i);
            arr1 = add(arr[i+1],arr1,i+1);
        }

        for(int i = 0; i < arr1.length; i += 2){
            if(board.checkValid(arr1[i]) == true){
                ans = add(arr1[i],ans,ans.length);
                ans = add(arr1[i+1],ans,ans.length);
            }
        }

        for(int i = 0; i < ans.length; i +=2){
            if(board.isEmpty(ans[i], ans[i+1])){
                System.out.println(name + ", please input your move: " + ans[i]);
                board.insert(symbol, ans[i]);
                return;
            }
        }

        // AI plays a random move

        int input = 0;
        do{
            input = (int)(Math.random()*(7)+1);
        }while(!board.checkValid(input));
        System.out.println(name + ", please input your move: " + input);
        board.insert(symbol, input);

        return;
    }
}
