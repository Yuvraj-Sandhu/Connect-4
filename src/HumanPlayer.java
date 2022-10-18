import java.util.Scanner;

public class HumanPlayer extends Player { 

    public HumanPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    public void makeMove(Board board) {
        int input = 0;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.print(name + ", please input your move: ");
            String nextIntString = sc.nextLine();
            input = Integer.parseInt(nextIntString);
        }while(!board.checkValid(input));
        
        board.insert(symbol, input);
    }

}