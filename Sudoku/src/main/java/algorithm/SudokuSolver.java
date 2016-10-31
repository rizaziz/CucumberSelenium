package algorithm;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {

    ISudoku sudoku;
    int emptyCells;
    int counter;
    ISudoku solved;

    public SudokuSolver(ISudoku sudoku){
        this.sudoku=sudoku;
        emptyCells=((Sudoku)sudoku).getEmptyCells();
        counter=0;
    }

    @Override
    public String toString(){
        return sudoku.toString();
    }

    private void solveSudoku(List<ISudoku> list){

        List<ISudoku> newSudokuList=new ArrayList<>();

        SudokuCoordinates nextEmptyCell=null;

        List<Integer> acceptableNumbers=null;

        ISudoku newSudoku=null;

        for(ISudoku sudoku:list){

            nextEmptyCell=sudoku.getNextEmptyCell();

            acceptableNumbers=sudoku.acceptableValues(nextEmptyCell);

            //System.out.println("next empty cell is: "+nextEmptyCell+"\t"+"acceptable numbers: "+acceptableNumbers);

            for(int value:acceptableNumbers){

                newSudoku=((Sudoku)sudoku).copySudoku();

                newSudoku.putNumberAt(nextEmptyCell, value);

                newSudokuList.add(newSudoku);

            }

        }

        counter++;

        if(counter==emptyCells){
            solved=newSudokuList.get(0);
            return;
        }

        solveSudoku(newSudokuList);

    }

    public ISudoku getSolvedSudoku(){

        List<ISudoku> list=new ArrayList<>();

        list.add(sudoku);

        solveSudoku(list);

        return solved;

    }

}
