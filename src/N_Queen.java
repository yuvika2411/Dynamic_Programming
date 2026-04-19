import java.util.*;
public class N_Queen {
    static int[][] board;

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        board= new int[n][n];

        if(!placeQueen(n,0)){
            printBoard();
        }
        else{
            printBoard();
        }
    }

    static boolean placeQueen(int n, int row){
        if(row==n) return true;
        for(int col=0;col<n;col++){
            if(safe(row,col,n)){
                board[row][col]=1;
                if(placeQueen(n,row+1)) return true;
                board[row][col]=0;
            }
        }

        return false;
    }


    static boolean safe(int row, int col,int n){
        for(int i=0;i<row;i++){
            if(board[i][col]==1) return false;
        }

        for(int i=row-1,j=col-1;i>=0 && j>=0; i--,j--){
            if(board[i][j]==1) return false;
        }

        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(board[i][j]==1) return false;
        }

        return true;
    }

    static void printBoard(){
        for(int[] row: board){
            System.out.print("[");
            for(int i=0;i<row.length;i++){
                System.out.print(row[i]);
                if(i!=row.length-1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}
