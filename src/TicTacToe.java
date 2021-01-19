//This represents out tictactoe game
public class TicTacToe {
    //This is the class of all possible tictactoe games, this is the blueprint for a game


    //Each tic tac toe game must have one of these fields:
    //They vary by game, but every game has them
    Boolean[][] board;          //This is completely empty
                                //An array of boolean[][] will be full of false by default
                                //An array of Boolean[][] is full of null by default
                                //null = nothing
                                //true is x, false is o
    Boolean pastPlayer;

    //Static means that EVERY tictactoe game has this exact value
    static String gameName = "Super TicTacBros Ultimate";

    public TicTacToe(int size){
        board = new Boolean[size][size];
        //this sets up our board with nothing in it, so that people can play
    }




    //When you have a 2d array, you have an array of arrays
    //[abc, 123, whatever ]
    //[[abc, 123, whatever ], [abc, 123]]

    public String play(int xCoord, int yCoord, Boolean player){
        if(xCoord > board.length || yCoord > board[0].length){
            throw new IllegalArgumentException("your coordinates are too big, and you are trying to play outside the grid");
        }

        if(board[xCoord][yCoord] != null){
            throw new IllegalArgumentException("Something is off, you tried to place an x or an o where there is one");
        }

        if(pastPlayer != null && pastPlayer.equals(player)){
            throw new IllegalArgumentException("You cannot play twice in a row");
        }

        board[xCoord][yCoord] = player;

        return testWinConditions();
    }




    private String testWinConditions(){
        Boolean winner = null;
        if(horizontalWinner(board) != null){
            winner = horizontalWinner(board);
        }

        if(verticalWinner(board) != null){
            winner = verticalWinner(board);
        }

        if(diagonalWinner(board) != null){
            winner = diagonalWinner(board);
        }

        if(winner != null){
            board = new Boolean[board.length][board.length];
            if(winner){
                return "X wins";
            }else{
                return "O wins";
            }

        }else{
            return "";
        }
    }

    public static Boolean horizontalWinner(Boolean[][] board){
        //Look for a horizontal where all the elements are the same
        //If there is one, return who won, else
        //Return null

        //for every list of Booleans in the board called row
        for(Boolean[] row : board){
            //We don't care which row wins, we just care whether it wins or not, so we use a loop without an index!

            //do something to the row!

            boolean rowAllEqual = true;

            if(row[0] != null){

                for(int i = 1; i<row.length; i++){

                    //This loop wants to challenge our assumption that someone won
                    if(!row[i-1].equals(row[i])){
                        rowAllEqual = false;
                        break;
                    }
                }

                if(rowAllEqual){
                    return row[0];
                }

            }else{
                rowAllEqual = false;
            }
        }

        return null;
    }

    public static Boolean diagonalWinner(Boolean[][] board) {
        Boolean firstCorner = board[0][0];

        boolean hasWonFirst = true;

        if(firstCorner != null){
            for(int i = 0; i < board.length; i++){
                if(!firstCorner.equals(board[i][i])){
                    hasWonFirst = false;
                    break;
                }
            }

            if(hasWonFirst){
                return firstCorner;
            }
        }

        Boolean secondCorner = board[board.length -1 ][board.length -1];

        boolean hasWonSecond = true;

        if(secondCorner != null){
            for(int i = 0; i < board.length; i++){
                if(!secondCorner.equals(board[i][i])){
                    hasWonSecond = false;
                    break;
                }
            }

            if(hasWonSecond){
                return secondCorner;
            }
        }

        return  null;
    }

    public static Boolean verticalWinner(Boolean[][] board) {
        for(int i = 0; i < board.length ; i++){

            boolean columnAllEqual = true;
            Boolean firstInCol = board[0][i];
            if(firstInCol == null) continue;

            for(int j = 1; j < board.length; j++){
                if (!firstInCol.equals(board[j][i])) {
                    columnAllEqual = false;
                    break;
                }
            }


            if(columnAllEqual){
                return firstInCol;
            }
        }

        return null;

    }
}
