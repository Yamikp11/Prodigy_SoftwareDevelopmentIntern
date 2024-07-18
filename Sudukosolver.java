package sudukosolver;
import java.util.*;
public class Sudukosolver {
    int[][] board=new int[9][9];
    Scanner u;
      Set set=new HashSet<>();
    public static void main(String[] args) {
        Sudukosolver sud=new Sudukosolver();
        sud.game(0);
    }
    public void game(int count){
        if(count == board.length *board.length){
            System.out.println("Congrations you won");
            Iterator i=set.iterator();
            while(i.hasNext())
            System.out.println(i.next());
        }
        u=new Scanner(System.in);
        printboard();
        System.out.println("Enter the poistion(row 0 to 8)");
        int row=u.nextInt();
        System.out.println("Enter the poistion(column 0 to 8)");
        int col=u.nextInt();
        System.out.println("Enter the number(1 to 9)");
        int val=u.nextInt();
        if((row>=0 && row <board.length) &&(col>=0 && col <board.length)&&(val>=1 && row <=board.length))
        count+=insertcheck(row,col,val);
        else
            System.out.println("please enter the valid row or column or value");
        /*System.out.println("Enter E to exit");
        char n='0';
        if(n=='E')
            exit(0);*/
        game(count);
    }
    public int insertcheck(int row, int col, int val){
        if(board[row][col]!=0){
             System.out.println("Please enter at another position that does not contains value");
             return 0;
        }
        else{
           if((set.contains(val + "in r" + row)) ||
                         (set.contains(val + "in c" + col)) ||
                            (set.contains(val + "in b" + row/3 + " "+ col/3))){
               System.out.println(val +" can't be entered" );
               return 0;
           }
           else {
               set.add(val + "in r" + row);
               set.add(val + "in c" + col);
               set.add(val + "in b" + row/3 + " "+ col/3);
         board[row][col]=val;  
        return 1; 
        }
        }
    }
    public  void printboard(){
        int i,j;
        for(i=0;i<board.length;i++){
            for(j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }  
}
