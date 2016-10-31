package repository;

import algorithm.ISudoku;
import algorithm.Sudoku;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by admin on 10/24/16.
 */
public class IPageOperImpl implements IPageOperations {

    private SudokuPage page=null;
    WebDriver driver=null;

    public IPageOperImpl(SudokuPage page, WebDriver driver){
        this.page=page;
        this.driver=driver;
    }

    @Override
    public ISudoku createSudoku() {

        Sudoku sudoku=new Sudoku();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){

                if(driver.findElement(By.id("f"+i+""+j)).getAttribute("value").length()==0){
                    sudoku.getStorage()[j][i]=0;

                }else{
                    sudoku.getStorage()[j][i]=Integer.valueOf(driver.findElement(By.id("f"+i+""+j)).getAttribute("value"));
                }
            }
        }

        return sudoku;

    }

    @Override
    public void fillSudoku(ISudoku sudoku) {

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){

                if(driver.findElement(By.id("f"+i+""+j)).getAttribute("value").length()==0){
                    driver.findElement(By.id("f"+i+""+j)).sendKeys(String.valueOf(((Sudoku)sudoku).getStorage()[j][i]));
                }

            }
        }

    }
}
