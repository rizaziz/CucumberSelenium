package algorithm;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;


public class Sudoku implements ISudoku {

    private int[][] storage;

    public Sudoku(){
        storage=new int[9][9];
    }

    public Sudoku(String path){
        storage=new int[9][9];
        populateSudoku(path);
    }

    public Sudoku(int[][] data){

        int[][] newData=new int[9][9];

        System.arraycopy(data, 0, newData, 0, 9);

        this.storage=newData;
    }

    public Sudoku(Map<SudokuCoordinates, Integer> map){

        this();




    }

    public Sudoku copySudoku(){

        Sudoku sud=new Sudoku();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){

                sud.storage[i][j]=this.storage[i][j];
            }
        }

        return sud;
    }


    public int[][] getStorage(){
        return storage;
    }

    @Override
    public String toString(){

        String output="";

        for(int i=0; i<9; i++){

            for(int j=0; j<9; j++){
                output+=storage[i][j];
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

    @Override
    public int[] getVerticalArray(SudokuCoordinates coor) {

        int[] temp=new int[9];

        for(int i=0; i<9; i++){
            temp[i]=storage[i][coor.getX()-1];
        }

        return temp;
    }


    @Override
    public int[] getHorizontalArray(SudokuCoordinates coor) {
        return storage[coor.getY()-1];
    }

    @Override
    public int[] getSquareArray(SudokuCoordinates coor) {

        int[] temp=new int[9];
        int k=0;

        int verCoeff=(coor.getX()-1)/3*3;
        int horCoeff=(coor.getY()-1)/3*3;

        for(int i=verCoeff; i<verCoeff+3; i++){
            for(int j=horCoeff; j<horCoeff+3; j++){

                temp[k]=storage[j][i];
                k++;
            }
        }

        return temp;
    }


    @Override
    public SudokuCoordinates getNextEmptyCell() {

        SudokuCoordinates coor=null;

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(this.getStorage()[i][j]==0){
                    coor=new SudokuCoordinates(j+1,i+1);
                    return coor;
                }
            }
        }

        return coor;

    }

    public int getEmptyCells(){

        int counter=0;

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(this.getStorage()[i][j]==0){
                    counter++;
                }
            }
        }
        return counter;
    }

    @Override
    public void populateSudoku(String path) {

        BufferedReader br=null;
        FileReader fr=null;

        try{
            fr=new FileReader(path);
            br=new BufferedReader(fr);

            String str=null;

            int index=0;

            while((str=br.readLine())!=null){

                for(int i=0; i<str.toCharArray().length; i++){
                    storage[index][i]=(int)(str.toCharArray()[i]-48);
                }
                index++;
            }

        }catch(IOException e){
            e.printStackTrace();
        }


    }

    @Override
    public List<Integer> acceptableValues(SudokuCoordinates coor) {

        List<Integer> list=new ArrayList<>();

        int[] arr={1,2,3,4,5,6,7,8,9};

        for(int b:arr){
            if(isNumberAllowed(coor, b)){
                list.add(b);
            }
        }

        return list;
    }

    @Override
    public void putNumberAt(SudokuCoordinates sc, int number) {

        this.getStorage()[sc.getY()-1][sc.getX()-1]=number;

    }

    @Override
    public boolean isNumberAllowed(SudokuCoordinates sc, int number) {


        int[] hor=getHorizontalArray(sc);
        int[] ver=getVerticalArray(sc);
        int[] sq=getSquareArray(sc);

        for(int c : hor){
            if(c==number){
                return false;
            }
        }

        for(int c : ver){
            if(c==number){
                return false;
            }
        }

        for(int c : sq){
            if(c==number){
                return false;
            }
        }

        return true;
    }
}
