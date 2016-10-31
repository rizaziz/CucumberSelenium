package repository;


import algorithm.ISudoku;
import algorithm.Sudoku;
import algorithm.SudokuCoordinates;
import algorithm.SudokuSolver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SudokuPage {

    private final String url="http://www.websudoku.com";

    WebDriver driver=null;

    public SudokuPage(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(name="submit")
    public WebElement btn_Submit;

    @FindBy(name="pause")
    public WebElement btn_Pause;

    @FindBy(name="printopts")
    public WebElement btn_Print;

    @FindBy(name="clear")
    public WebElement btn_Clear;

    @FindBy(name="showopts")
    public WebElement btn_Options;

    @FindBy(linkText="Easy")
    public WebElement link_Easy;

    @FindBy(linkText="Medium")
    public WebElement link_Medium;

    @FindBy(linkText="Hard")
    public WebElement link_Hard;

    @FindBy(linkText="Evil")
    public WebElement link_Evil;

    @FindBy(id="puzzle_grid")
    public WebElement sudokuGrid;

    @FindBy(name="newgame")
    public WebElement btn_newGame;

    public String getUrl(){
        return this.url;
    }

    public ISudoku getSudoku(){

        Sudoku sudoku=new Sudoku();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(driver.findElement(By.id("f"+i+""+j)).getAttribute("value").length()==0){
                    sudoku.getStorage()[j][i]=0;

                }else{
                    sudoku.getStorage()[j][i]=Integer.valueOf(
                            driver.findElement(By.id("f"+i+""+j)).getAttribute("value"));
                }
            }
        }
        return sudoku;
    }

    public void setSudoku(ISudoku sudoku){

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(driver.findElement(By.id("f"+i+""+j)).getAttribute("value").length()==0){
                    driver.findElement(By.id("f"+i+""+j)).sendKeys(
                            String.valueOf(((Sudoku)sudoku).getStorage()[j][i]));
                }
            }
        }
    }

    public static void main(String[] args){

        System.setProperty("webdriver.gecko.driver", "/Programs/selenium/drivers/geckodriver");
        WebDriver driver=new FirefoxDriver();

        SudokuPage page=new SudokuPage(driver);

        PageFactory.initElements(driver, page);

        driver.get(page.getUrl());

        driver.switchTo().frame(0);

        WebDriverWait wait=new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(page.btn_Submit));



        page.link_Evil.click();

        driver.switchTo().frame(0);


        for(int i=0; i<5; i++){

            ISudoku sud=page.getSudoku();

            SudokuSolver solver=new SudokuSolver(sud);

            ISudoku solved=solver.getSolvedSudoku();

            page.setSudoku(solved);

            page.btn_Submit.click();

            page.btn_newGame.click();

        }

        driver.quit();
    }
}
