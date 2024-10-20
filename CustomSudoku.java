package DSARecursion.com;

import java.util.Scanner;
import java.util.Stack;

public class CustomSudoku {
   static int [][] board;
     static Stack<int[]> moveHistory = new Stack<>();
   public CustomSudoku() {
      board = new int[][]{
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

    }
    public Boolean isValid(int row,int col,int num){
        for(int i=0;i<9;i++){
            if(board[row][i]==num){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(board[i][col]==num){
                return false;
            }
        }
        int startrow=row/3*3;
        int startcol=col/3*3;
        for(int i=startrow;i<startrow+3;i++){
            for(int j=startcol;j<startcol+3;j++){
                if(board[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isComplete(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]==0){
                    return false;
                }
            }
        }
return true;
    }
    public void DisplayBoard(){
        for(int i=0;i<9;i++){
            if(i%3==0 && i!=0){
                System.out.println("---------------------");
            }

            for(int j=0;j<9;j++){
                if(j%3==0 && j!=0){
                    System.out.print("| ");
                }
                if(board[i][j]==0){
                    System.out.print(". ");
                }else{
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
   static public  void undoMove() {
        if (!moveHistory.isEmpty()) {
            int[] lastMove = moveHistory.pop();
            int row = lastMove[0];
            int col = lastMove[1];
            int previousValue = lastMove[2];
            board[row][col] = previousValue; // Restore the previous value
            System.out.println("Last move undone.");
        } else {
            System.out.println("No moves to undo.");
        }
    }
    private boolean solve() {
        int n= board.length;
        int r=-1;
        int c=-1;
        boolean empty=true;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]==0){
                    r=i;
                    c=j;
                    empty=false;
                    break;
                }
            }
            if(!empty){
                break;
            }
        }
        if(empty){
            return true;
        }
        for(int i=0;i<=9;i++){
            if(isValid(r,c,i)){
                board[r][c]=i;
                if(solve()){
                    return true;
                }else{
                    board[r][c]=0;
                }
            }
        }
        return false;
    }

    private void setValue(int row, int col, int num) {
        if(isValid(row,col,num)){
            board[row][col]=num;
        }else{
            System.out.println("Invalid move! try Again.");
        }
    }




    public static void main(String[] args) {
    CustomSudoku game=new CustomSudoku();
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Sudoku!");
        System.out.println("To make a move, enter the row (1-9), column (1-9), and number (1-9).");
        System.out.println("Type 'solve' to get the solution or 'undo' to revert the last move.");
        while(!game.isComplete()){
            game.DisplayBoard();
            System.out.print("Enter row (1-9) or 'solve' to get the solution: ");
            String input = sc.next();
            if (input.equalsIgnoreCase("solve")){
                if(game.solve()){
                    System.out.println("Here's the solved Sudoku:");
                    game.DisplayBoard();
                } else {
                    System.out.println("Unable to solve the Sudoku.");
                    System.out.println(" OR please Undo your wrong Steps to Get sudoku Solved");
                }
                break;
            }
            if (input.equalsIgnoreCase("undo")) {
                undoMove();
                continue;
            }
            int row=Integer.parseInt(input)-1;
            System.out.print("Enter column (1-9): ");
            int col = sc.nextInt() - 1;  // Convert to 0-based index
            System.out.print("Enter number (1-9): ");
            int num = sc.nextInt();
            moveHistory.push(new int[]{row, col, board[row][col]});
            game.setValue(row, col, num);
            }
        if (game.isComplete()) {
            System.out.println("Congratulations! You've completed the Sudoku puzzle!");
            game.DisplayBoard();
        }


        }


}

