/**
 * Exercise 8.5
 * Author: Dylan Mah
 * Since: 1.0
 * Version: 1.0
 */

/*
 * EightQueens is a program that allows the user to place queens or remove existing queens from an 8x8 chessboard.
 * The program also has an algorithm to see if up to a specified number of queens can be placed on the board so that
 * no queens can attack each other.
 */

class EightQueens implements Cloneable{
    private char[][] board=new char[8][8];

    /**
     * Default constructor that creates fills all elements of board with 'o'
     */
    public EightQueens(){
        for(int i=0; i < 8; i++){
            for(int j=0; j < 8; j++){
                this.board[i][j]='o';
            }
        }
    }

    /**
     * Method to return the current values in board
     * @return: all elements in board
     */
    public char[][] getBoard(){
        return this.board;
    }

    /**
     * Method to clone the object EightQueens
     * @return: deep copy of board
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException{
        EightQueens copy=(EightQueens)super.clone();    //creating a reference to class
        copy.board=new char[8][8];

        for(int i=0; i < 8; i++){
            for(int j=0; j < 8; j++) {
                copy.board[i][j]=this.board[i][j];       //deep copying each element of board into copy
            }
        }

        return copy;
    }

    /**
     * Method to place a queen at the desired location
     * @param row: row (first index in board) to place the queen
     * @param column: column (second index in board) to place the queen
     */
    public void setQueen(int row, int column){
        this.board[row][column]='Q';
    }

    /**
     * Method to create an empty square at the desired location
     * @param row: row (first index in board) where an empty square is created
     * @param column: column (second index in board) where an empty square is created
     */
    public void emptySquare(int row, int column){
        this.board[row][column]='o';
    }

    /**
     * Method to place an integer amount of queens and returns true if successful or returns false if the method fails
     * @param queensRemaining: integer that represents the number of queens to be placed
     * @return: true if the desired number of queens can be placed, false otherwise
     */
    public boolean setQueens(int queensRemaining) throws IllegalArgumentException{
        if(queensRemaining > 8){
            throw new IllegalArgumentException("Cannot place more than 8 queens on the board.");
        }

        if(queensRemaining < 0){
            throw new IllegalArgumentException("Cannot place a negative amount of queens.");
        }

        if (queensRemaining==0) {
            return true;
        }

        for (int i=0; i < 8; i++){
            for (int j=0; j < 8; j++){
                if (checkThreat(i, j)==false){       //if a queen cannot be attacked...
                    this.board[i][j] = 'Q';

                    if (setQueens(queensRemaining - 1)==true){       //if a queen can be placed and NOT be under threat...
                        return true;
                    }

                    this.board[i][j]='o';    //for backtracking in case recursion fails
                }
            }
        }

        return false;
    }

    /**
     * Method to check if a queen can be attacked at its current location
     * @return: true if queen can be attacked, false if queen cannot be attacked
     */
    public boolean checkThreat(int row, int col){
        for(int i=0; i < 8; i++) {
            if (board[row][i]=='Q' || board[i][col]=='Q') {
                //if there are queens in the same row or column, return true
                return true;
            }

            for (int j=0; j < 8; j++){
                if ( (i+j==row+col || i-j==row-col) && board[i][j] == 'Q'){
                    //if a queen is diagonally adjacent to another queen, return true
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Method to show the state of the board in the console
     */
    public void printBoard(){
        for(int i=0; i < 8; i++){
            for(int j=0; j < 8; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main (String[] args) throws CloneNotSupportedException{
        EightQueens eq1=new EightQueens();
        eq1.setQueen(1,1);
        eq1.setQueen(2,5);
        eq1.setQueen(7,7);
        eq1.printBoard();
        eq1.emptySquare(7,7);

        System.out.println(eq1.setQueens(2));       //prints true
        eq1.printBoard();

        EightQueens eq2=new EightQueens();
        System.out.println(eq2.setQueens(8));       //prints true
        //eq2.printBoard();

        EightQueens eq3=new EightQueens();
        eq3.setQueen(0,7);
        eq3.setQueen(1,4);
        eq3.setQueen(5,5);
        System.out.println(eq3.setQueens(6));       //prints false
        eq3.printBoard();

        //eq3.setQueens(-1);        //out of bounds
        //eq3.setQueens(10);        //out of bounds

        EightQueens eq4=(EightQueens)eq2.clone();
        eq4.printBoard();

        eq2.setQueen(1,1);
        System.out.println("eq4:");
        eq4.printBoard();
        System.out.println("eq2:");
        eq2.printBoard();
    }
}   //end of class declaration
