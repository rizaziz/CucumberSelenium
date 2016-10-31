package algorithm;

/**
 * Created by admin on 10/19/16.
 */
public class Example {

    public static void main(String[] args){

        Sudoku sud=new Sudoku("/Users/admin/Desktop/CucumberSelenium/Sudoku/src/main/resources/sudoku");

        SudokuSolver solver=new SudokuSolver(sud);

        System.out.println(solver.getSolvedSudoku());

    }
}
