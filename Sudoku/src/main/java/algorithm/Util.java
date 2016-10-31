package algorithm;

import java.util.List;

public class Util {


    public static String printArray(int[][] arr){

        String output="";

        for(int i=0; i<9; i++){

            for(int j=0; j<9; j++){
                output+=arr[i][j];
                if((j+1)%3==0){
                    output+="  ";
                }
            }

            if((i+1)%3==0){
                output+="\n\n";
            }else{
                output+="\n";
            }

        }

        return output;
    }

    public static String printList(List<ISudoku> list){

        String output="";

        for(int i=0; i<9; i++){

            output+=" |  ";

            for(ISudoku sudoku:list){

                for(int j=0; j<9; j++){
                    output+=((Sudoku)sudoku).getStorage()[i][j];
                    if((j+1)%3==0){
                        output+=" ";
                    }
                }

                output+=" |  ";
            }

            if((i+1)%3==0){
                output+="\n";
            }

            output+="\n";
        }

        return output;
    }


    public static void putNumberAt(ISudoku sudoku, SudokuCoordinates coor, int number){
        ((Sudoku)sudoku).getStorage()[coor.getY()-1][coor.getX()-1]=number;
    }

}
