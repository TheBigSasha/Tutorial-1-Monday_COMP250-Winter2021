import java.util.Scanner;

public class TicTacToeApp {

    public static void main(String[] args){
        System.out.println("Welcome to " + TicTacToe.gameName);     //This is static, common to all games, so before you start your game you can still see it
        Scanner s = new Scanner(System.in);
        System.out.println("How big of a board do you want?");
        int size = s.nextInt();
        TicTacToe game = new TicTacToe(size);

        boolean player = false;
        while(true){
            String name = "O";
            if(player){
                name = "X";
            }

            System.out.println("It's " + name +"'s turn!");
            display(game);
            System.out.println("X coordinate:");
            int xCord = s.nextInt();
            System.out.println("Y coordinate:");
            int yCord = s.nextInt();
            System.out.println(game.play(xCord,yCord,player));
            display(game);
            player = !player;
        }
    }

    public static void display(TicTacToe game){
        for(Boolean[] row : game.board){
            for(Boolean item : row){
                if(item == null){
                    System.out.print("-");
                }else{
                    if(item){
                        System.out.print("X");
                    }else{
                        System.out.print("O");
                    }
                }
            }
            System.out.println();

        }
    }
}
