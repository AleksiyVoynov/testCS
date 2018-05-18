package Pages;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;


public class SearchPage extends BasePage {

	@FindBy(css =".scope")
	private WebElement SearchButton;

	@FindBy(css ="#search_form_type_term")
	private WebElement InputSearch;

	@FindBy(css ="#locale-link")
	private WebElement InputSearch1;

	public enum Part {
		PRODUCT, VACANCY
	}
	
	public void inputSearch(String value) throws FileNotFoundException {
		driver.WaitElementToBeVisibilityOf(SearchButton,3);
		driver.WaitElementToBeClickable(SearchButton,3);
		SearchButton.click();
		InputSearch.sendKeys(value);
		InputSearch.sendKeys(Keys.ENTER);
		writeCSVData();
	}

	private String[][] getBlockValue(Part part) {
		WebElement headersName = driver.findElement(By.cssSelector(".pure-u-xs-1:nth-of-type("+(part.ordinal()+1)+") h2"));
		List<WebElement> listOfContent = driver.findElements(By.cssSelector(".pure-u-xs-1:nth-of-type("+(part.ordinal()+1)+") .solutions-list .pure-menu-item"));

		int cout = 0;
		for (int i = 0; i <listOfContent.size() ; i++) {
			String list = listOfContent.get(i).getAttribute("innerText").trim();
			if(list.length()>0) {
				cout++;
			}
		}

		String[][] data = new String[cout][2];

		for (int i = 0; i <listOfContent.size() ; i++) {
			String list = listOfContent.get(i).getAttribute("innerText").trim();
			if(list.length()>0) {
				data[i][0]=headersName.getAttribute("innerText").trim();
				data[i][1] = list;
			}
		}
		return data;
	}

	public void writeCSVData() throws FileNotFoundException {
		String[][] writeValue = getBlockValue(Part.PRODUCT);
		String[][] writeValue2 = getBlockValue(Part.VACANCY);

		//PrintWriter pw = new PrintWriter(System.getProperty("Properties/results.csv"));
		PrintWriter pw = new PrintWriter(new File("C:\\Develops\\testCS\\src\\test\\resources\\Properties\\results.csv"));//TODO path
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < writeValue.length; i++) {
			sb.append(writeValue[i][0]);
			sb.append(';');
			sb.append(writeValue[i][1]);
			sb.append('\n');
		}

		for (int i = 0; i < writeValue2.length; i++) {
			sb.append(writeValue2[i][0]);
			sb.append(';');
			sb.append(writeValue2[i][1]);
			sb.append('\n');
		}
		pw.write(sb.toString());
		pw.close();
	}
}
