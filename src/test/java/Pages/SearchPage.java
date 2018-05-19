package Pages;

import com.opencsv.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class SearchPage extends BasePage {

	@FindBy(css =".scope")
	protected WebElement SearchButton;

	@FindBy(css ="#search_form_type_term")
	protected WebElement InputSearch;

	public enum Part {
		PRODUCT, VACANCY
	}

	private String actualResult = "src\\test\\resources\\Properties\\results.csv";
	private String expectedResult = "src\\test\\resources\\Properties\\test.csv";

	private String[][] getBlockValue(Part part) {
		WebElement headersName = driver.findElement(By.cssSelector(".pure-u-xs-1:nth-of-type("+(part.ordinal()+1)+") h2"));
		List<WebElement> listOfContent = driver.findElements(By.cssSelector(".pure-u-xs-1:nth-of-type("+(part.ordinal()+1)+") .solutions-list .pure-menu-item"));

		int count = 0;
		for (int i = 0; i <listOfContent.size() ; i++) {
			String list = listOfContent.get(i).getAttribute("innerText").trim();
			if(list.length()>0) {
				count++;
			}
		}

		String[][] data = new String[count][2];

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
		String[][] writeProduct = getBlockValue(Part.PRODUCT);
		String[][] writeVacancy = getBlockValue(Part.VACANCY);
		PrintWriter pw = new PrintWriter(new File("src\\test\\resources\\Properties\\results.csv"));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < writeProduct.length; i++) {
			sb.append(writeProduct[i][0]);
			sb.append(';');
			sb.append(writeProduct[i][1]);
			sb.append('\n');
		}

		for (int i = 0; i < writeVacancy.length; i++) {
			sb.append(writeVacancy[i][0]);
			sb.append(';');
			sb.append(writeVacancy[i][1]);
			sb.append('\n');
		}
		pw.write(sb.toString());
		pw.close();
	}

	private ArrayList<String> readCSV(String file) throws IOException {
		CSVReader reader = new CSVReader(new FileReader(file));
		String [] nextLine;
		ArrayList<String> list = new ArrayList<>();
		while ((nextLine = reader.readNext()) != null) {
			list.add(nextLine[0]);
		}
		return list;
	}

	public boolean compareTwoCSV() throws IOException {
		ArrayList<String> list1 = readCSV(actualResult);
		ArrayList<String> list2 = readCSV(expectedResult);
		int i;
		for (i = 0; i < list1.size() && i < list2.size(); i++) {
			if (!list1.get(i).equals(list2.get(i))){
				return false;
			}
		}
		return i == list1.size() && i == list2.size();
	}
}
