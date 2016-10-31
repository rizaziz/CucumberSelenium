package algorithm;

import java.util.List;

public interface ISudoku {

    int[] getVerticalArray(SudokuCoordinates coor);

    int[] getHorizontalArray(SudokuCoordinates coor);

    int[] getSquareArray(SudokuCoordinates coor);

    SudokuCoordinates getNextEmptyCell();

    void putNumberAt(SudokuCoordinates sc, int number);

    boolean isNumberAllowed(SudokuCoordinates sc, int number);

    void populateSudoku(String path);

    List<Integer> acceptableValues(SudokuCoordinates coor);

}

