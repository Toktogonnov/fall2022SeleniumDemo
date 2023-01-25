package org.example.intro;

import org.bouncycastle.est.LimitedSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {

    private WebElement tableElements;
    private WebDriver driver;

    public Table(WebElement tableElements, WebDriver driver) {
        this.tableElements = tableElements;
        this.driver = driver;
    }
    public List<WebElement> getrows(){
        List<WebElement> rows = tableElements.findElements(By.xpath("//div[@class='rt-table']"));
        rows.remove(0);
        return rows;
    }
    public List<WebElement> getHeadings(){
        WebElement headingsRow = tableElements.findElement(By.xpath("//div[@class='rt-tr']"));
        List<WebElement> headingsCols = headingsRow.findElements(By.xpath("//div[@class='rt-tr-group']"));
        return headingsCols;
    }

    public List<List<WebElement>> getRowsWithCols(){
        List<WebElement> rows = getrows();
        List<List<WebElement>> rowsWithCols =  new ArrayList<List<WebElement>>();
        for (WebElement row : rows){
            List<WebElement> rowWithCols = row.findElements(By.xpath("//div[@class='rt-tbody']"));
            rowsWithCols.add(rowWithCols);
        }
        return rowsWithCols;
    }

    public List<Map<String , WebElement>> getRowsWithColsByHeading(){
        List<List<WebElement>> rowsWithCols = getRowsWithCols();
        List<Map<String , WebElement>> rowWithColsByHeading = new ArrayList<Map<String, WebElement>>();
        Map<String, WebElement> rowByHeading;
        List<WebElement> headingCols = getHeadings();

        for (List<WebElement> row : rowsWithCols){
            rowByHeading = new HashMap<String, WebElement>();
            for (int i = 0; i< headingCols.size(); i++){
                String heading = headingCols.get(i).getText();
                WebElement cell = row.get(i);
                rowByHeading.put(heading,cell);
            }
            rowWithColsByHeading.add(rowByHeading);
        }
        return rowWithColsByHeading;
    }
    public String getValue(int rowNumber, int colsNumber){
        List<List<WebElement>> rowsWithCols = getRowsWithCols();
        WebElement cell = rowsWithCols.get(rowNumber - 1).get(colsNumber -1);
        return cell.getText();
    }
    public String getValue(int rowNumber, String colsNumber){
        List<Map<String,WebElement>> rowsWithColsByHeadings = getRowsWithColsByHeading();
        return rowsWithColsByHeadings.get(rowNumber -1).get(colsNumber).getText();
    }
}
