package repository;

import algorithm.ISudoku;

/**
 * Created by admin on 10/24/16.
 */
public interface IPageOperations {

    ISudoku createSudoku();
    void fillSudoku(ISudoku sudoku);

}
