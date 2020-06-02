/**
 * 
 */
package com.dkatalis.DkatalisAssignment;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.google.common.io.Files;

/**
 * @author gslab
 *
 */

	public class CommonUtilities extends Setup {

		static Logger logger = Logger.getLogger(CommonUtilities.class);
		TimeUtil timeobj = new TimeUtil();
		
		
		
		/**
		 * @Description:- Used to enter value in text field by placeholder
		 * @Used_In:- Login Page UserName and Password
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void enterNameInTextFieldByPlaceHolder(String placeholder, String text) throws Exception {
			String myxpath = "//*[@placeholder='" + placeholder + "']";
			
			
			
			if ((driver.findElements(By.xpath(myxpath))).size() != 0) {
				
			//	implicitWaitUtilityBySeconds(SLEEP_TIME_SMALL);
				logger.info("Entering text into field with placeholder "+ placeholder);
				driver.findElement(By.xpath(myxpath)).click();
				driver.findElement(By.xpath(myxpath)).sendKeys(text);
				
			} else {

				throw new Exception("Unable to locate text field with placeholder " + placeholder);
			}
			
		}

		/**
		 * @Description:- Used to clear value in text field by placeholder
		 * @Used_In:- Login Page UserName and Password
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void clearTextFromTextFieldByPlaceHolder(String placeholder) throws Exception {
			
			String myxpath = "//*[@placeholder='" + placeholder + "']";
			
			
			if ((driver.findElements(By.xpath(myxpath))).size() != 0) {
				
				logger.info("Clearing text from field with placeholder "+ placeholder);
				driver.findElement(By.xpath("//*[@placeholder='" + placeholder + "']")).clear();
				
			} else {

				throw new Exception("Unable to locate text field with placeholder " + placeholder);
			}
			
		}
		
		
		/**
		 * @Description:- Used to Click on button by it's Id value
		 * @Used_In:- Login Page login button
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void clickOnButtonById(String id) throws Exception {
			// driver.findElement(By.name("btnG")).click();

			
			if ((driver.findElements(By.id(id))).size() != 0) {
				
			//	implicitWaitUtilityBySeconds(SLEEP_TIME_LARGE);
				logger.info("Clicking on button with id "+ id);
				driver.findElement(By.id(id)).click();
				
			} else {

				throw new Exception("Unable to locate button with id " + id);
			}
		}

		/**
		 * @Description:- Used to Click on Navigation bar links such as Dashboard, Add
		 *                Person, Hierarchy etc...
		 * @Used_In:- All test cases
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void clickOnNavBarLinkByText(String text) throws Exception {
			
			String xpath = "//*[@id='appNavbar']//li[contains(@ui-sref,'" + text + "')]/span";
			
			if (driver.findElements(By.xpath(xpath)).size() != 0) {
				
				logger.info("Clicking on link with label "+ text);
				driver.findElement(By.xpath(xpath)).click();
			}else {

				throw new Exception("Unable to locate button with label " + text);
			}
			
		}
		
		
		/**
		 * @Description:- Used to Click on Text Field by it's placeholder value
		 * @Used_In:- Global Filter, Search page dropdown
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void clickOnFieldByPlaceholder(String placeholder) throws Exception {

			String xpath = "//*[@placeholder='" + placeholder + "']";
			
			if (driver.findElements(By.xpath(xpath)).size() != 0) {
				
			//	implicitWaitUtilityBySeconds(SLEEP_TIME_XLARGE);
				logger.info("Clicking on Field with placeholder "+ placeholder);
				driver.findElement(By.xpath(xpath)).click();
			}else {

				throw new Exception("Unable to locate Field with placeholder " + placeholder);
			}
		}

		/**
		 * @Description:- Used to Click on Drop down search field of Global Filter by
		 *                the name of filter like Brands, BMUs etc...
		 * @Used_In:- Global Filter
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void clickOnSearchFieldForGlobalFilterByName(String name) throws Exception {
			
			String xpath = "//*[@id='all" + name + "']/..//*[@placeholder='Search']";
			
			if (driver.findElements(By.xpath(xpath)).size() != 0) 
			{
			//	implicitWaitUtilityBySeconds(SLEEP_TIME_SMALL);
				logger.info("Clicking on search field of global filter name as "+ name);
				driver.findElement(By.xpath(xpath)).click();
			}else {
				
				throw new Exception("Unable to locate Field with name " + name);
			}
		}

		/**
		 * @Description:- Used to enter text into Drop down search field of Global
		 *                Filter by the name of filter like Brands, BMUs etc. With it we
		 *                can search the option of drop down by entering its value into
		 *                search filed
		 * @Used_In:- Global Filter
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void enterTextInSearchFieldForGlobalFilterByName(String name, String value) throws Exception {
			
			String xpath = "//*[@id='all" + name + "']/..//*[@placeholder='Search']";
			
			if(driver.findElements(By.xpath(xpath)).size() != 0) {
				
			//	implicitWaitUtilityBySeconds(SLEEP_TIME_SMALL);
				logger.info("Writing text to field of global filter name as "+ name);
				driver.findElement(By.xpath(xpath)).sendKeys(value);
			}else {
				
				throw new Exception("Unable to locate Text Field with name " + name);
			}
		}

		/**
		 * @Description:- Used to Click on All option of Global Filter drop down by the
		 *                name of Filter like Brands, BMUs etc.
		 * @Used_In:- Global Filter
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void clickOnAllOfGlobalFilterByFilterName(String name) throws Exception {
			
			String xpath = "//*[@id='all" + name + "']//*[contains(text(),'All')]";
			
			if(driver.findElements(By.xpath(xpath)).size() != 0) {
				
				logger.info("Writing text to field of global filter name as "+ name);
				driver.findElement(By.xpath(xpath)).click();
			}else {
				
				throw new Exception("Unable to locate the ALL option for " + name + " dropdown");
			}
			
		}

		/**
		 * @Description:- Used to Select the option from drop down by the option value.
		 *                It can be used for Drop down values within "md-option" tag
		 * @Used_In:- Global Filter, Search page dropdown value selection
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void selectoptionFromDropdownByOptionValue(String value) throws Exception {
			
			String xpath = "//div[@aria-hidden='false']//md-option[@value='"+value+"']//*[contains(text(),'"+value+"')]";
			
			if(driver.findElements(By.xpath(xpath)).size() != 0) {
				
			//	implicitWaitUtilityBySeconds(SLEEP_TIME_SMALL);
				driver.findElement(By.xpath(xpath)).click();
			}else {
				
				throw new Exception("Unable to locate the option " + value + " in dropdown");
			}
			
		}
		
		
		/**
		 * @Description:- Used to Select the option from drop down by the option value.
		 *                It can be used for Drop down values within "md-checkbox" tag
		 * @Used_In:- Global Filter
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void selectoptionFromDropdownByOptionText(String text) throws Exception {

			String xpath = "//md-checkbox[@aria-label='" + text + "']//*[contains(text(),'" + text + "')]";
			
			if(driver.findElements(By.xpath(xpath)).size() != 0) {
				
				driver.findElement(By.xpath(xpath)).click();
			}else {
				
				throw new Exception("Unable to locate the option " + text + " in dropdown");
			}	
		}

		/**
		 * @Description:- Used to Select the option from drop down by the option value.
		 *                It can be used for Drop down values within "md-checkbox" tag
		 *                and drop-downs whose value attribute has value as [object
		 *                object]
		 * @Used_In:- Global Filter
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void chooseOptionFromDropdownByOptionValue(String value) throws Exception {

			String xpath = "//md-option[@aria-hidden='false']//*[contains(text(),'" + value + "')]";
			
			if(driver.findElements(By.xpath(xpath)).size() != 0) {
				
				driver.findElement(By.xpath(xpath)).click();
			}else {
				
				throw new Exception("Unable to locate the option " + value + " in dropdown");
			}	
		}

		/**
		 * @Description:- To Press ESC button as to close the drop down in which we can
		 *                select multiple values.
		 * @Used_In:- Global Filter, Tree Search Filter
		 * @author Mayur Sapre
		 */

		public void pressEscapeButton() {

			Actions action = new Actions(driver);

		//	implicitWaitUtilityBySeconds(SLEEP_TIME_SMALL);
			logger.info("******* Pressing Escape button *******");
			action.sendKeys(Keys.ESCAPE).build().perform();
		}

		/**
		 * @Description:- To Press Enter button as to close the drop down in which we
		 *                can select multiple values.
		 * @Used_In:- Tree Search Filter
		 * @author Mayur Sapre
		 */

		public void pressEnterButton() {

			Actions action = new Actions(driver);

			//implicitWaitUtilityBySeconds(SLEEP_TIME_SMALL);
			logger.info("******* Pressing Escape button *******");
			action.sendKeys(Keys.ENTER).build().perform();
		}

		/**
		 * @Description:- To Click on button by it's title attribute value
		 * @Used_In:- Global Filter
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void clickOnButtonByTitle(String title) throws Exception {

			
			String xpath = "//*[@title='" + title + "']";
			
			if (driver.findElements(By.xpath(xpath)).size() != 0){
				
				driver.findElement(By.xpath(xpath)).click();
			}else {
				throw new Exception("Unable to locate the button " + title);
			}
		}
		
		
		/**
		 * @Description:- To drag and drop element from source to destination. Here the
		 *                index of source is required and node type and node name of the
		 *                destination
		 * @Used_In:- Assign People, Assign Store, Assign Operational Roles
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void dragAndDropElement(String nodetype, String label, String srcindex) throws Exception {
			
			String tag = "//span[text()='" + nodetype + "']/../..//*[@aria-label='" + label + "']";
			String source = "//*[@id='tree-root']//li[" + srcindex + "]//div[1]/a/i";
			
			WebElement target = driver.findElement(By.xpath(tag));
			WebElement src = driver.findElement(By.xpath(source));
			
			if (driver.findElements(By.xpath(tag)).size() == 0){
				
				throw new Exception("Unable to locate the target node "+ nodetype +" with name " + label);
			} 
			
			if (driver.findElements(By.xpath(source)).size() == 0){
				
				throw new Exception("No Element present at index " + srcindex);
			}
			
			Actions action = new Actions(driver);
			action.dragAndDrop(src, target).build().perform();
		}
		
		
		/**
		 * @Description:- To extract the name of Unassigned store or people by its index
		 * @Used_In:- Assign People, Assign Store, Assign Operational Roles
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public String getNameOfUnassignedObjectByIndex(String index) throws Exception {
			
			WebElement ele;
			String name = "";
			String myxpath = "//*[@id='tree-root']//li[" + index + "]//div[2]/div/p//span/span";
			
			if (driver.findElements(By.xpath(myxpath)).size() != 0){
				
				ele = driver.findElement(By.xpath(myxpath));
				name = ele.getText();

			}else {
				
				throw new Exception("Can not return text as no element is present at index " + index);
			}
			
			return name;
		}



		/**
		 * @throws Exception 
		 * @function: This method is used to select the value from dropdown
		 * @Used-in: Logout test case
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void selectValueFromDropdown(String value) throws Exception {

			String myxpath = "//*[contains(text(),'" + value + "')]";
			
			if ((driver.findElements(By.xpath(myxpath))).size() != 0) {
				
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("Selected value from dropdown " + value);
			} else {

				throw new Exception("Unable to find the option " + value +" in dropdown");
			}
		}

		/**
		 * @throws Exception 
		 * @function: This method is used to click on filter dropdown by class name
		 * @Used-in: Corporate hierarchy test case
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void clickOnFilterDropdownToggleByClass(String classname) throws Exception {

			String myxpath = ".//*[@class='" + classname + "']//img";
			
			if ((driver.findElements(By.xpath(myxpath))).size() != 0) {
				
				logger.info("Click on " + classname);
				driver.findElement(By.xpath(myxpath)).click();	
			} else {

				throw new Exception("Unable to locate the filter image with class name" + classname);
			}
		}

		/**
		 * @throws Exception 
		 * @function: This method is used to click on franchisee by name and id
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void clickOnFranchiseeByTypeAndName(String type, String name) throws Exception {

			String myxpath = "//*[text()='" + type + "']/../..//*[@aria-label='" + name + "']";
			
			
			if ((driver.findElements(By.xpath(myxpath))).size() != 0) {
				
			//	implicitWaitUtilityBySeconds(SLEEP_TIME_MEDIUM);
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("Click on " + type + " with name " + name);
			} else {

				throw new Exception("Unable to locate the node " + type +" labeled as "+ name);
			}
		}

		/**
		 * @throws Exception 
		 * @function: This method is used to click on button by button-text
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void clickOnButtonByText(String text) throws Exception {

			String myxpath = "//*[text()='" + text + "']";
			
			if ((driver.findElements(By.xpath(myxpath))).size() != 0) {
				
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("Clicked on " + text + " button");
			} 
			else {
				throw new Exception("Unable to locate the "+ text +" button");
			}

		}
		
		/**
		 * @throws Exception 
		 * @function: This method is used to clear text in textbox by value
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public String clearTextInTextBoxByValue(String value) throws Exception {

			String myxpath = "//*[@value='"+value+"']";
			if ((driver.findElements(By.xpath(myxpath))).size() != 0) {
				driver.findElement(By.xpath(myxpath)).clear();
			} else {
				throw new Exception("Unable to enter text "+value +"");
			}
			return myxpath;

		}
		
		/**
		 * @throws Exception 
		 * @function: This method is used to clear text in textbox by value
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void enterTextInTextBoxByLabel(String value,String new_value) throws Exception {
			
			String myxpath = "//*[@value='"+value+"']";
			if ((driver.findElements(By.xpath(myxpath))).size() != 0) {
				driver.findElement(By.xpath(myxpath)).clear();
				driver.findElement(By.xpath(myxpath)).sendKeys(new_value);
				
			} else {
				throw new Exception("Unable to enter text "+value +"");
			}

		}


		/**
		 * @throws Exception 
		 * @function: This method is used to click on context menu option of specific
		 *            level with levelname
		 * @Used-in: Add level test case
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void clickOnContextMenuOptionOfLevelByLevelAndLevelname(String level, String levelname) throws Exception {

			String myxpath = "//*[@aria-label='" + levelname + "']/../../../..//span[text()='" +level+ "']/../..//*[@class='context-menu-tree']//img";
			
			
			if ((driver.findElements(By.xpath(myxpath))).size() != 0) {
				
			//	implicitWaitUtilityBySeconds(SLEEP_TIME_SMALL);
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("Click on context menu option of " + level + " name " + levelname);
				
			} else {

				throw new Exception("Unable to locate the context menu for node "+level+ " with name "+ levelname);
			}
		}

		/**
		 * @throws Exception 
		 * @function: This method is used to choose any operation from context menu
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void chooseOperationOnLevelFromContextMenuBytext(String text) throws Exception {

			String myxpath = ".//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable'][@aria-hidden='false']//*[contains(text(),'" + text + "')]";
			
			
			if ((driver.findElements(By.xpath(myxpath))).size() != 0) {
				
			//	implicitWaitUtilityBySeconds(SLEEP_TIME_MEDIUM);
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("Choose " + text + " option from context menu");
				
			} else {

				throw new Exception("Unable to locate option "+ text + " in context menu");
			}
		}
		
		
		/**
		 * @Description:- To validate level is within the same parent node or not
		 * @Used_In:- Add level operations
		 * @author Mayur Sapre
		 */

		public void validateLevelByParent(String parentname, String nodename) throws Exception {

			String myxpath = "//*[@name='levelForm']//md-select-value[@class='md-select-value']//*[contains(text(),'" + parentname + "')]";

			if ((driver.findElements(By.xpath(myxpath))).size() != 0) {
				logger.info("************** Level Within Parent Validation Passed **************");
			} else {

				throw new Exception(nodename + " node is not present under parent " + parentname);
			}
		}

		/**
		 * @function: This method is used to check one org present per country
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void checkOneCorporateOrgPerCountry(String orgtype, String countryname) throws Exception {

			String myxpath = "//span[text()='" + orgtype + "']/../span[@aria-label='" + countryname + "']";

			if ((driver.findElements(By.xpath(myxpath))).size() == 1) {
				logger.info("Only one " + orgtype + "Organization present for " + countryname + "country");
			} else {

				throw new Exception(orgtype + " with " + countryname + " is not present");
			}

		}
		
		
			
		/**
		 * @Description:- Used to clear and enter value in text field by name attribute
		 *                of field
		 * @Used_In:- Search Field of tree
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void enterValueInTextFieldByName(String name, String text) throws Exception {

			
			
			if(driver.findElements(By.name(name)).size() != 0){
				
				driver.findElement(By.name(name)).clear();
				driver.findElement(By.name(name)).sendKeys(text);
			}else {
				
				throw new Exception("Unable to locate text field with name "+name);
			}
		}

		

		/**
		 * @throws Exception 
		 * @function: This method is used to click on search images beside the search
		 *            fields
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void clickOnSearchImageByFieldName(String name) throws Exception {

			String myxpath = "//*[@name='" + name + "']/../i[@role='button']";
			
			if (driver.findElements(By.xpath(myxpath)).size() != 0) {
				
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("Clicking on Search button");
			}else {
				throw new Exception("Unable to the locate search button for field "+ name);
			}
		}

		/**
		 * @Description:- Used to Click on text within md-tab-item tag, in the settings
		 *                menu navigation bar (can't be used for BU Grouping )
		 * @Used_In:- To Click on tabs of settings like GES Language, Operational roles
		 *            etc...
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void clickOnNavBarOfSettingPageByText(String text) throws Exception {

			
			String myxpath = "//md-tab-item[text()='" + text + "']";
			
			if (driver.findElements(By.xpath(myxpath)).size() != 0) {
				
				logger.info("******* Clicking on Link " + text + " *******");
				driver.findElement(By.xpath(myxpath)).click();
				
			}else {
				throw new Exception("Unable to the locate the "+ text +" link in settings");
			}
		}

		/**
		 * @Description:- To mouse hover over settings and select option inside it
		 * @Used_In:- All setting test cases
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void selectSettingOptions(String navbar, String option) throws Exception {

			String myxpath = "//*[@id='appNavbar']//span[contains(text(),'" + navbar + "')]";
			String myxpath2 = "//*[@id='appNavbar']//span[contains(text(),'" + navbar + "')]/..//*[contains(text(),'" + option + "')]";

			WebElement element = driver.findElement(By.xpath(myxpath));
			WebElement ele1 = driver.findElement(By.xpath(myxpath2));
			
			logger.info("Clicking on " +option+" in settings");
			
			if(driver.findElements(By.xpath(myxpath)).size() != 0) {
				
				Actions action = new Actions(driver);
				action.moveToElement(element).build().perform();
			}else {
				
				throw new Exception("Unable to locate the Settings in navigation bar");
			}
			
			if(driver.findElements(By.xpath(myxpath2)).size() != 0) {

				ele1.click();	
			}else {
				
				throw new Exception("Unable to the locate the "+ option +" option in Settings dropdown");
			}

		}
		
		
			
		/** @throws Exception 
		 * @function: This method is used to click on button image by classname 
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void clickOnButtonByClassname(String classname) throws Exception {
		
			String myxpath = "//*[@class='"+ classname +"']";
			
			
			if(driver.findElements(By.xpath(myxpath)).size() != 0) {
				
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("Clicking on " + classname + " button");
			}else {
				throw new Exception("Unable to the locate the image with classname" + classname);
			}
		}

		
		/** @throws Exception 
		 * @function: This method is used to click on dropdown by label
		 * @UsedIn: click on dropdwon present under Settings tab
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void clickOnDropdownByLabel(String label) throws Exception {
		
			String myxpath = "//*[text()='"+ label +"']/../../..//md-select";
			
			
			if(driver.findElements(By.xpath(myxpath)).size() != 0) {
				
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("Clicking on " + label + " dropdown");
			}else {
				throw new Exception("Unable to the locate the " + label + " dropdown");
			}
		}
		
		/**
		 * @function This method is used to click on radio button by ng-model and label name
		 * @UsedIn:- used in GES complaint -> add operational role.
		 * @author: Mayur Sapre
		 * @throws Exception 
		 */
		public void clickOnRadioButtonByModelnameAndLabelname(String modelname, String radiobuttonname) throws Exception{
			
			String myxpath =".//tr[@aria-hidden='false']//*[@ng-model='"+ modelname +"']//md-radio-button[@value='"+ radiobuttonname +"']";
			
			if(driver.findElements(By.xpath(myxpath)).size() != 0) {
				
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("Click on radio button of "+ modelname +" by label " + radiobuttonname);
			}else {
				throw new Exception("Unable to the locate the " + radiobuttonname + " radio button");
			}
			
		}
		
		/**
		 * @Description:- Used to Select the option from drop down by the option name. 
		 *				  It can be used for Drop down values within "md-option" tag
		 * @Used_In:- GES Language
		 * @author Mayur Sapre
		 * @throws Exception 
		 */
		
		public void selectOptionFromDropdownByOptionName(String name) throws Exception {
			
			String myxpath = "//*[@class='md-select-menu-container md-active md-clickable']//*[contains(text(),'"+name+"')]";
			
			if(driver.findElements(By.xpath(myxpath)).size() != 0) {
				
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("Clicked on " + name + " in dropdown");
			}else {
				throw new Exception("Unable to the locate the " + name + " option in dropdown");
			}
		}
		
		/**
		 * @function This method is used to click on dropdown by operation & contacttype(like firstcontact, secondcontact)
		 * @UsedIn:- used in GES complaint -> add operational role.
		 * @author: Mayur Sapre
		 * @throws Exception 
		 */
		public void clickOnDropdownByOperationnameAndContacttypelabel(String operationname, String contact_type, String placeholder) throws Exception{
			
			String myxpath ="//tr[@ng-show='"+ operationname +"']//*[@ng-show=\""+ contact_type +"\"]//*[@aria-label='"+ placeholder +"']";
			
			if(driver.findElements(By.xpath(myxpath)).size() != 0) {
				
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("Click on dropdwon by "+ operationname +" and contact-type " + contact_type);
				
			}else {
				throw new Exception("Unable to the locate the dropdown for " + operationname + " operation name and contact type as " +contact_type);
			}
		}
		
		/**
		 * @function This method is used to right click on element by label
		 * @UsedIn:- used in GES complaint -> operational role.
		 * @author: Mayur Sapre
		 * @throws Exception 
		 */
		public void rightClickOnElementByLabel(String label) throws Exception {
			
			String myxpath =".//*[@ng-show='showGESComplaint()']//*[text()='"+ label +"']";
			
			if (driver.findElements(By.xpath(myxpath)).size() != 0) {
				
				Actions action = new Actions(driver);
				WebElement rightClickElement= driver.findElement(By.xpath(myxpath));
		        action.contextClick(rightClickElement).build().perform();
		        logger.info("Right click on Element by "+ label);
			}else {
				
				throw new Exception("Unable to locate element with label "+ label);
			}
			
		}
		
		/**
		 * @function This method is used to choose the option from menu after right clicking on any element
		 * @UsedIn:- used in GES complaint -> Edit/delete operational role.
		 * @author: Mayur Sapre 
		 * @throws Exception 
		 */
		public void chooseOptionFromMenuAfterRightClickbyOptionName(String optionName) throws Exception {
			
			String myxpath = "//*[@class='dropdown-menu']//div[contains(text(),'"+ optionName +"')]";
			
			if (driver.findElements(By.xpath(myxpath)).size() != 0) {
				
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("Choosen the "+ optionName + " option from menu after right click");
			}else {
				
				throw new Exception("Unable to locate option" + optionName);
			}
				
		}
		
		/**
		 * @function This method is used to select person from list 
		 * @UsedIn:- In add operational role-> search people when person dropdown is selected.
		 * @author: Mayur Sapre 
		 * @throws Exception 
		 */
		public void selectPersonFromDropdownList(String index) throws Exception {
			
			String myxpath = ".//*[@class='md-autocomplete-suggestions']//li["+ index +"]";
			
			if(driver.findElements(By.xpath(myxpath)).size() != 0) {
				
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("Selected the person present at location "+ index);
			}else {
				
				throw new Exception("No element present at index "+ index);
			}
		}
		
		/**
		 * @function This method is used to enter the text in textbox by name
		 ** @UsedIn:- In add operational role-> for entering description, email & mobile no
		 * @author: Mayur Sapre 
		 * @throws Exception 
		 */
		public void enterTextInTextboxByName(String name,String new_name) throws Exception {
			
			String myxpath = "//textarea[text()='"+name+"']";
			
			if(driver.findElements(By.xpath(myxpath)).size() != 0) {
				driver.findElement(By.xpath(myxpath)).clear();
				driver.findElement(By.xpath(myxpath)).sendKeys(new_name);
				logger.info("Entered the "+ name +"");
			}else {
				throw new Exception("Unable to locate "+ name +"");
			}
		}
		
		/**
		 * @function This method is used to verify operational role for organization
		 * @UsedIn:- verifing the created operational roles.
		 * @author: Mayur Sapre
		 * @throws Exception 
		 */
		public void verifyOperationalRoleForOrganization(String organizationName) throws Exception{
			
			String myxpath =".//*[@ng-show='showGESComplaint()']//*[text()='"+ organizationName +"']";
			
			if(driver.findElements(By.xpath(myxpath)).size() != 0) {
				
				logger.info("Operation role for " + organizationName + " is present");

			}else {
				
				throw new Exception("Operational Role is for " + organizationName + " is not present");
			}	
		}
		
		
		
		/** @throws Exception 
		 * @function: This method is used to click on organization by ng-repeat
		 * @UsedIn:- To click on organization/operational role by ng-repeat in vendor tool & reports of settings tab
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void clickOnOrganizationByLabelnameAndNgrepeat(String labelName, String ngRepeat) throws Exception {
		
			String myxpath = "//*[text()='"+ labelName +"']//ancestor::li[@ng-repeat='"+ ngRepeat +"']";
			
			if(driver.findElements(By.xpath(myxpath)).size() != 0) {
			
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("clicked on "+ labelName+ " by ng-repeat " + ngRepeat);
			}else {
				
				throw new Exception("Unable to locate " +labelName+ " organization");
			}
		}
		
		/** @throws Exception 
		 * @function: This method is used to select the operational role by ng-click
		 * @UsedIn:- To select the operational role by ng-click in vendor tool & reports of settings tab
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void selectOperationalRoleByNameAndNgclick(String name, String ngclick) throws Exception {
		
			String myxpath = "//*[contains(text(),'"+ name +"')]//ancestor::md-checkbox[@ng-click='"+ ngclick +"']";
			
			if(driver.findElements(By.xpath(myxpath)).size() != 0) {
				
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("clicked on "+ name+ " by ng-click " + ngclick);
			}else{
				
				throw new Exception("Unable to locate Operational role "+ name);
			}
		}
		
		/**
		 * @Description:- To get the name of people by its index
		 * @Used_In:- For cherrypicking the people in vendor tool & vendor report
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public String getUsernameFromPeopleList(String index) throws Exception {
			
			String myxpath = ".//*[@id='tree-root']/ol/li["+ index +"]";
			
			if(driver.findElements(By.xpath(myxpath)).size() == 0) {
				
				throw new Exception("No Element present at index " + index);
			}
			
			WebElement getPeople = driver.findElement(By.xpath(myxpath));
			 
			String peoplename = getPeople.getText();
			String[] arr = peoplename.split("\n");
			String userID = arr[0];
			return userID;
		}
		
		
		/** @throws Exception 
		 * @function: This method is used to select persons
		 * @UsedIn:- To cherry picked peoples in vendor tool & reports of settings tab
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void checkedCheckboxOfPeopleByUserID(String userid) throws Exception {
		
			String myxpath = ".//*[text()='"+ userid +"']/..//md-checkbox";
			
			if(driver.findElements(By.xpath(myxpath)).size() != 0) {
				
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("selected the "+ userid);
			}else {
				
				throw new Exception("Unable to locate chechbox for UserID "+ userid);
			}
			
		}
		
		/**
		 * @Description:- Used to Click on button by it's ng-click value
		 * @Used_In:- Search button on search page (with magnifying glass image)
		 * @author Mayur Sapre
		 * @throws Exception 
		 */
		
		public void clickOnButtonByNgClick(String ngclick) throws Exception {
			// driver.findElement(By.name("btnG")).click();
			String myxpath = "//*[@ng-click='"+ngclick+"']";
			
			if(driver.findElements(By.xpath(myxpath)).size() != 0) {
				
			//	implicitWaitUtilityBySeconds(SLEEP_TIME_SMALL);
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("Clicked on button by "+ ngclick);
			}else {
				
				throw new Exception("Unable to locate button with ng-click value "+ ngclick);
			}
				
		}
		
		/** @throws Exception 
		 * @function: This method is used to check the status of operational role
		 * @UsedIn:- To check whether operational role is check in vendor tool & reports of settings tab
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void checkStatusOfOperationalRoleByName(String name, String ngclick) throws Exception {
		
			//[@aria-checked='"+ status +"']
			String myxpath = "//*[contains(text(),'"+ name +"')]//ancestor::md-checkbox[@ng-click='"+ ngclick +"'][@aria-checked='true']";
			//WebElement element = driver.findElement(By.xpath(myxpath));
			List<WebElement> myList=driver.findElements(By.xpath(myxpath));
			
			if (myList.size() != 0){
				
				logger.info(name +" operational role is selected");
			}else {
				
				throw new Exception(name+" operational role is not selected");
			}

		}
		
		/** @throws Exception 
		 * @function: This method is used to select persons
		 * @UsedIn:- To cherry picked peoples in vendor tool & reports of settings tab
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void checkedstatusOfPeopleByUserID(String userid) throws Exception {
		
			String myxpath = ".//*[text()='"+ userid +"']/..//md-checkbox[@aria-checked='true']";
			//WebElement element = driver.findElement(By.xpath(myxpath));
			List<WebElement> myList=driver.findElements(By.xpath(myxpath));
			
			if (myList.size() != 0){
				
				logger.info(userid +" people is selected");
			}else {
				
				throw new Exception(userid+" people is not selected");
			}
		}
		
		/**
		 * @Description:- To drag and drop element from source to destination. Here, src is identified by name 
		 * @Used_In:- Assign Operational Roles
		 * @author Mayur Sapre
		 * @throws Exception 
		 */
		
		public void dragAndDropElementByName(String name, String nodetype, String nodename) throws Exception {
			
			String srcxpath = "//*[@aria-label='"+ name +"']/../../..//i";
			String destxpath = "//span[text()='"+ nodetype +"']/../..//*[@aria-label='"+ nodename +"']";
			
			
			if(driver.findElements(By.xpath(srcxpath)).size() == 0) {
				
				throw new Exception("Unable to find the element " + name + ", which is to be draged");
			}
			
			if(driver.findElements(By.xpath(destxpath)).size() == 0) {
				
				throw new Exception("Unable to locate " + nodetype + " with name " + nodename +" where elements need to be dragged and dropped");
			}
			
			WebElement source = driver.findElement(By.xpath(srcxpath));
			WebElement destination = driver.findElement(By.xpath(destxpath));
		
			Actions action = new Actions(driver);
			
			action.dragAndDrop(source,destination).build().perform();
		}
		
		/**
		 * @Description:- To get the list of assigned operational roles, assigned primary coaches, assign people
		 * @Used_In:- assigned operational roles, coaches, peoples
		 * @author Mayur Sapre
		 * @throws Exception 
		 */
		
		public ArrayList<String> getListOfAssignedvaluesByName(String name) throws Exception {
			
			String myxpath = "//*[@name='"+ name +"']/..//a";
			List<WebElement> ele = driver.findElements(By.xpath(myxpath));
			
			
			ArrayList<String> mylist = new ArrayList<String>();
			
			if(ele.size() != 0) {
				for(int j=0; j<ele.size();j++) {
					
					mylist.add(ele.get(j).getText());
					
				}
			}else {
				
				throw new Exception("No values present in the assigned list of operational roles/coaches/people");
			}
			
			return(mylist);
		}
		
		/**
		 * @Description:- To check assigned operational roles, assigned primary coaches, assign people
		 * @Used_In:- Verifying assigned operational roles, coaches, peoples
		 * @author Mayur Sapre
		 * @throws Exception 
		 * @throws AWTException 
		 */
		
		public void checkValuesPresentAfterAssignment(ArrayList<String> arrayList1, String value) throws Exception {
			
			for(int i=0; i<arrayList1.size();i++) {
				
				if(arrayList1.get(i).equals(value)) {
					
					logger.info(value + " is assigned successfully");
				}else {
					
					throw new Exception(value + " is not assigned");
				}
			}
			
		}
		
		/**
		 * @Description:- Used to scroll page up or down by using keys
		 * @Used_In:- verification of assigned people/ operational role
		 * @author Mayur Sapre
		 * @throws Exception
		 */

		public void scrollpageByPageButton(String direction) throws Exception {

			Actions action = new Actions(driver);
			
			if(direction.equalsIgnoreCase("UP"))
			{	
				action.sendKeys(Keys.PAGE_UP).build().perform();
				
			}else if(direction.equalsIgnoreCase("DOWN")) {
					
				action.sendKeys(Keys.PAGE_DOWN).build().perform();
				logger.info("Scroll Down");
			}
		}

		/**
		 * @Description:- To click on toggle button by its label
		 * @Used_In:- GES Languages, Double Byte
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void clickOnToggleButtonByLabel(String label) throws Exception {

			String myxpath = "//*[contains(text(),'" + label + "')]/ancestor::tr//div[@class='md-bar']";

			WebElement element = driver.findElement(By.xpath(myxpath));
			
			if(driver.findElements(By.xpath(myxpath)).size() != 0) {
				element.click();
			}else {
				
				throw new Exception("Unable to locate the toggle button for "+ label);
			}
		}

		
		/**
		 * @Description:- Used to click on button with ng-show value and button label
		 * @Used_In:- GES Language save button, Edit button BU Grouping
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void clickOnButtonByNgShowAndLabel(String ngshow, String label) throws Exception {
			
			String xpath = "//*[contains(@ng-show,'" + ngshow + "')]//*[contains(text(),'" + label + "')]";
			WebElement ele = driver.findElement(By.xpath(xpath));
			
			if(driver.findElements(By.xpath(xpath)).size() != 0) {
				
				ele.click();
			}else {
				throw new Exception("Unable to locate"+ label +" button");
			}
		}

		/**
		 * @Description:- Used to click on assign values,so as to unassign them
		 * @Used_In:- GES Secondary Language
		 * @author Mayur Sapre
		 */

		public void unassignValuesFromMultiSelectionDropdownSettings(String country, String placeholder) {

			String xpath = "//*[text()='" + country + "']/..//*[@placeholder='" + placeholder + "']/..//a";

			List<WebElement> list = driver.findElements(By.xpath(xpath));

			if (list.size() != 0) {

				for (int index = list.size(); index > 0; index--) {

					driver.findElement(By.xpath("//*[text()='" + country + "']/..//*[@placeholder='" + placeholder + "']/..//a[" + index + "]")).click();

				}
			} else {

				logger.info("No value to un-assign");
			}

		}

		/**
		 * @Description:- Used to select value from dropdown which are whithin "
		 *                <li>" tag by option name (Usually multiple select dropdown)
		 * @Used_In:- GES secondary Language dropdown, edit store dropdown, BU Grouping Organization dropdown
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void selectOptionFromLiTagDropdownByOption(String option) throws Exception {
			
			String xpath = "//md-virtual-repeat-container[@aria-hidden='false']//*[text()='" + option + "']";
			
			if(driver.findElements(By.xpath(xpath)).size() != 0) {
				
			//	implicitWaitUtilityBySeconds(SLEEP_TIME_SMALL);
				driver.findElement(By.xpath(xpath)).click();
				logger.info("---- Clicked on " + option);
			}else {
				
				throw new Exception("Unable to locate "+option+" value in dropdown");
			}
				
		}

		/**
		 * @Description:- Used to enter value in text field which are in input tag by
		 *                placeholder
		 * @Used_In:- GES Secondary Language dropdown
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void enterTextInFieldByFieldPlaceholder(String placeholder, String text) throws Exception {
			
			String xpath = "//input[@placeholder='" + placeholder + "']";
			
			if(driver.findElements(By.xpath(xpath)).size() != 0) {
				
			//	implicitWaitUtilityBySeconds(SLEEP_TIME_MEDIUM);
				driver.findElement(By.xpath(xpath)).click();
				driver.findElement(By.xpath(xpath)).clear();
			//	implicitWaitUtilityBySeconds(SLEEP_TIME_MEDIUM);
				driver.findElement(By.xpath(xpath)).sendKeys(text);
			}else {
				
				throw new Exception("Unable to locate Field with placeholder "+ placeholder);
			}
		}
		

		/**
		 * @Description:- Used to click on cell of a table by row and column index.
		 * @Used_In:- Used to click on any value in table
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void clickOnTableCellByRowAndColumnIndex(int rowindex, int colindex) throws Exception {
			
			String xpath = "//*[@class='ui-grid-canvas']/div[" + rowindex + "]//div[" + colindex + "]/div";
			
			if(driver.findElements(By.xpath(xpath)).size() != 0){
				
				driver.findElement(By.xpath(xpath)).click();
			}else {
				
				throw new Exception("Table is not present or there is no cell present at row index "+rowindex+" and column index "+colindex);
			}
		}

		/**
		 * @Description:- Used to check that selected value is reflected in dropdown
		 *                field
		 * @Used_In:- GES language(Validation)
		 * @author Mayur Sapre
		 * @throws Exception
		 */

		public void checkForSelectedValueInDropdownByLabelAndValue(String label, String value) throws Exception {
			// driver.findElement(By.name("btnG")).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String xpath = "//*[text()='" + label + "']/../..//*[contains(@aria-label,'" + value + "')]";

			js.executeScript("scroll(0,230);");

			if (driver.findElements(By.xpath(xpath)).size() == 0) {

				throw new Exception("The selected value " + value + " is not reflected in field for dropdown" + label);

			} else {

				logger.info(value + " is selected from dropdown" + label);
			}
		}

		/**
		 * @Description:- Used to check that selected value is reflected beneath the
		 *                field of multiple value selection dropdown
		 * @Used_In:- GES language(Validation)
		 * @author Mayur Sapre
		 * @throws Exception
		 */

		public void checkForSelectedValueInMultiSelectionDropdown(String label, String value) throws Exception {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String xpath = "//*[text()='" + label + "']/../..//a[contains(text(),'" + value + "')]";

			js.executeScript("scroll(0,230);");

			if (driver.findElements(By.xpath(xpath)).size() == 0) {

				throw new Exception("The selected value " + value + " is not reflected beneath dropdown " + label);

			} else {

				logger.info(value + " is selected from dropdown" + label);
			}
		}

		/**
		 * @Description:- Used to click on sections of edit store so as to expand it
		 * @Used_In:- GES language(Validation)
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void expandEditStoreSectionsByLabel(String processName, String label) throws Exception {
			// driver.findElement(By.name("btnG")).click();
			String index = "";
			JavascriptExecutor js = (JavascriptExecutor) driver;

			if (label.equalsIgnoreCase("Store Details")) {
				index = "collapse1";
			} else if (label.equalsIgnoreCase("Status")) {
				index = "collapse2";
			} else if (label.equalsIgnoreCase("Address")) {
				index = "collapse3";
			} else if (label.equalsIgnoreCase("Hours of Operation")) {
				index = "collapse4";
			} else if (label.equalsIgnoreCase("Additional Details")) {
				index = "collapse5";
			} else if (label.equalsIgnoreCase("Operational Role Details")) {
				index = "Leadership2";
			} else if (label.equalsIgnoreCase("Organization Owner Details")) {
				index = "Leadership1";
			}
			
			String xpath = "//*[@id='"+ index + "']/..//i";
			
			if(driver.findElements(By.xpath(xpath)).size() != 0) {
				
				String expanded = "//*[@id='" + index + "']/../div[2]";

				driver.findElement(By.xpath("//*[@id='"+ index +"']/..//i")).click();
				timeobj.waitForSmalltime();;

				String value = driver.findElement(By.xpath(expanded)).getAttribute("aria-expanded");
				
				WebElement ele = driver.findElement(By.xpath(xpath));
				js.executeScript("arguments[0].scrollIntoView();", ele);
		
				if (processName.equalsIgnoreCase("Expand")) {
					if (value.equalsIgnoreCase("false")) {
							ele.click();
		
				} else {
					logger.info(label + " Section is already expanded");
					}
				} else {
					
					if (value.equalsIgnoreCase("true")) {
						ele.click();

					} else {
						logger.info(label + " Section is already collapsed");
					}
				}
			}else {
				
				throw new Exception("Unable to locate section "+ label);
			}

		}
		
		
		/** @throws Exception 
		 * @function: This method is used to enter the text in search box by ng model
		 * @UsedIn:- To enter text in search box present in settings tab
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void enterTextInTextBoxByNgmodel(String ngmodel, String text) throws Exception {
		
			String myxpath = ".//*[@ng-model='"+ ngmodel +"']";
			
			
			if(driver.findElements(By.xpath(myxpath)).size() != 0) {
				
				driver.findElement(By.xpath(myxpath)).clear();
				driver.findElement(By.xpath(myxpath)).sendKeys(text);
			
			logger.info("Enter the "+ text +" in textbox of "+ ngmodel);
			}else {
				
				throw new Exception("Unable to locate text box with ng-model value as"+ ngmodel);
			}
		}

		/**
		 * @Description:- Used to click on Group present at specified index
		 * @Used_In:- BU Grouping
		 * @author Mayur Sapre
		 * @throws Exception
		 */

		public void clickOnBUGroupByIndex(String id, String index) throws Exception {

//			JavascriptExecutor js = (JavascriptExecutor) driver;
			String xpath = "//*[@id='" + id + "']//li[" + index + "]";
			WebElement ele = driver.findElement(By.xpath(xpath));

			if (driver.findElements(By.xpath(xpath)).size() == 0) {

				throw new Exception("There is no Group present at index " + index);

			} else {

//				js.executeScript("arguments[0].scrollIntoView();", ele);
				logger.info("Clicking on group at index " + index);
				ele.click();
			}
		}
		
		
		/**
		 * @Description:- Used to click on Group present at specified index
		 * @Used_In:- Global Grouping
		 * @author Mayur Sapre
		 * @throws Exception
		 */

		public void clickOnGlobalGroupByIndex(String id, String index) throws Exception {

//			JavascriptExecutor js = (JavascriptExecutor) driver;
			String xpath = "//*[@id='" + id + "']//ul[" + index + "]/li";
			WebElement ele = driver.findElement(By.xpath(xpath));

			if (driver.findElements(By.xpath(xpath)).size() == 0) {

				throw new Exception("There is no Group present at index " + index);

			} else {

//				js.executeScript("arguments[0].scrollIntoView();", ele);
				logger.info("Clicking on group at index " + index);
				ele.click();
			}
		}
		
		
		/**
		 * @Description:- Used to click on Group present with given name
		 * @Used_In:- BU Grouping
		 * @author Mayur Sapre
		 * @throws Exception
		 */

		public void clickOnBUGroupByName(String id, String name) throws Exception {

//			JavascriptExecutor js = (JavascriptExecutor) driver;
			String xpath = "//*[@id='" + id + "']//*[contains(text(),'"+name+"')]";
			WebElement ele = driver.findElement(By.xpath(xpath));

			if (driver.findElements(By.xpath(xpath)).size() == 0) {

				throw new Exception("There is no Group present with name " + name);

			} else {

//				js.executeScript("arguments[0].scrollIntoView();", ele);
				logger.info("Clicking on group " + name);
				ele.click();
			}
		}

		/**
		 * @Description:- Used to unassign the values of multiple selection dropdown
		 * @Used_In:- BU Grouping
		 * @author Mayur Sapre
		 * @throws Exception
		 */

		public void unassignValuesOfMultipleSelcetionDropdown(String text, String placeholder) throws Exception {

			String xpath = "//*[contains(text(),'" + text + "')]/..//*[@placeholder='" + placeholder + "']/..//a";

			List<WebElement> list = driver.findElements(By.xpath(xpath));

			if (list.size() != 0) {

				for (int index = list.size(); index > 0; index--) {

					driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]/..//*[@placeholder='"+ placeholder +"']/..//a["+ index +"]")).click();

				}
			} else {

				logger.info("No value to un-assign");
			}
		}
		
		/**
		 * @Description:- Used to enter text in multiple selection dropdown
		 * @Used_In:- BU Grouping
		 * @author Mayur Sapre
		 * @throws Exception
		 */

		public void enterTextInFieldByLabelAndPlaceholder(String label, String placeholder, String text) throws Exception {

			String xpath = "//*[contains(text(),'" + label + "')]/..//input[@placeholder='" + placeholder + "']";

			if(driver.findElements(By.xpath(xpath)).size() != 0) {
				
				WebElement ele = driver.findElement(By.xpath(xpath));
			
				ele.click();
				ele.clear();
				ele.sendKeys(text);
			}else {
				
				throw new Exception("Unable to locate text field with label "+ label+" and placeholder "+ placeholder);
			}
		}
		
		/**
		 * @Description:- Used to check whether the org is assigned to group or not
		 * @Used_In:- BU Grouping
		 * @author Mayur Sapre
		 * @throws Exception
		 */

		public void checkForElementByLabel(String id, String elename) throws Exception {

			String xpath = "//*[@id='" + id + "']//*[text()='" + elename + "']";

			List<WebElement> ele = driver.findElements(By.xpath(xpath));
			
			if(ele.size() == 0) {
				
				throw new Exception("Organization/Group " +elename+ " is not assigned/present");
			}else {
				
				logger.info("Organization/Group "+elename+" Successfully assigned/present");
			}
			
		}
		
		
		/**
		 * @Description:- Used to click on image by it's label and parent id
		 * @Used_In:- BU Grouping
		 * @author Mayur Sapre
		 * @throws Exception
		 */

		public void clickOnImagesByIdAndText(String id,String text) throws Exception {

			String xpath = "//*[@id='"+id+"']//*[contains(text(),'"+text+"')]/..//img";
			
			if(driver.findElements(By.xpath(xpath)).size() != 0) {
				WebElement ele = driver.findElement(By.xpath(xpath));
				
				logger.info("Clicking on image with label "+ text);
				ele.click();
			}else {
				
				throw new Exception("Unable to click on image with text "+ text);
			}
		}
		
		/**
		 * @Description:- Used to scroll page up or down
		 * @Used_In:- 
		 * @author Mayur Sapre
		 * @throws Exception
		 */

		public void scrollpage(String direction) throws Exception {

			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			if(direction.equalsIgnoreCase("UP"))
			{	
				js.executeScript("window.scrollBy(0,-250);", "");
				
			}else if(direction.equalsIgnoreCase("DOWN")) {
				
				js.executeScript("window.scrollBy(0,250);", "");
			}
		}
		
		
			/**
		 * @function This method is used to click on channel type from Dashboard
		 * @author Mayur Sapre
		 * @throws Exception 
		 * @UsedIn:
		 */
		
		public void ClickOnChanneltypeByCardheaderAndChannelnameFromDashboard(String cardheader, String channelname) throws Exception{
			
			String myxpath = ".//div[text()='"+ cardheader +"']/../..//*[contains(@ng-click,'"+ channelname +"')]/..//*[@class='KFC']";
			WebElement ele = driver.findElement(By.xpath(myxpath));
			
			if (driver.findElements(By.xpath(myxpath)).size() != 0) {
				
				ele.click();
				logger.info("clicked on"+ channelname );
			}else {
				
				throw new Exception("Unable to find the element by "+ channelname);
			}
			
		}
		
		/**
		 * @Description:- Used to deselect the channel types from store details
		 * @Used_In:- Dashboard- Channel types 
		 * @author Mayur Sapre
		 * @throws Exception
		 */

		public void DeselectValuesFromLabel(String label, String value) throws Exception {
			
			String myxpath = "//*[text()='" + label + "']/../..//a[contains(text(),'" + value + "')]";
			WebElement ele = driver.findElement(By.xpath(myxpath));
			if (driver.findElements(By.xpath(myxpath)).size() == 0) {

				throw new Exception(value + " is not present in " + label + " for deselection");

			} else {
				
				ele.click();
				logger.info("Deselected the "+ value +" from "+ label );
			}
		}
		
		/**
		 * @Description:- This method is used to click on donut of ordering method 
		 *                present on dashboard
		 * @Used_In:- Dashboard- Ordering method 
		 * @author Mayur Sapre
		 * @throws Exception
		 */

		public void ClickOnOrderingMethodByLabelNameAndOrderingType(String labelName, String orderingType) throws Exception {
			
			String myxpath = ".//*[text()='"+ labelName +"']/../..//*[contains(@aria-label,'"+ orderingType +"')]";
			WebElement ele = driver.findElement(By.xpath(myxpath));
			if (driver.findElements(By.xpath(myxpath)).size() != 0) {

				ele.click();
				logger.info("Clicked on "+ labelName +" of type "+ orderingType );

			} else {
				
				throw new Exception("Unable to find the " + labelName + " with type "+ orderingType);
				
			}
		}
		
		
		/**
		 * @throws Exception 
		 * @function: This method is used to check error message is present or not
		 * @Used-in: Checking error when mandatory fields kept as blank.
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void checkErrorMessageIsPresent(String message) throws Exception {

			String myxpath = "//*[contains(text(),'" + message + "')]";
			
			if ((driver.findElements(By.xpath(myxpath))).size() != 0) {
				
				logger.info(message + " error message is present ");
			} else {

				throw new Exception("Unable to find the " + message);
			}
		}
		
		
		
		/**
		 * @Description:- This method is used to select option from context menu 
		 *                after clicking on operational role
		 * @Used_In:- transfer store test case
		 * @author Mayur Sapre
		 * @throws Exception
		 */

		public void ChooseOptionFromContextMenuByNgClick(String ngclick) throws Exception {
			
			String myxpath = "//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']//button[contains(@ng-click,'"+ ngclick +"')]";
			WebElement ele = driver.findElement(By.xpath(myxpath));
			if (driver.findElements(By.xpath(myxpath)).size() != 0) {

				ele.click();
				logger.info("Selected "+ ngclick + " option from context menu");

			} else {
				
				throw new Exception("Unable to find the " + ngclick + " option in context menu");
				
			}
		}
		
		/**
		 * @Description:- This method is used to enable/disable the toggle  
		 *                present on operational role
		 * @Used_In:- transfer store test case
		 * @author Mayur Sapre
		 * @throws Exception
		 */

		public void EnableDisableToggleByLabel(String label) throws Exception {
			
			String myxpath = "//*[contains(text(),'"+ label +"')]/..//td[@aria-hidden='false']//md-switch";
			WebElement ele = driver.findElement(By.xpath(myxpath));
			if (driver.findElements(By.xpath(myxpath)).size() != 0) {

				ele.click();
				logger.info("Clicked on the toggle of "+ label + " present in operational role");

			} else {
				
				throw new Exception("Unable to find the toggle of " + label + " in operational role");
				
			}
		}

		/**
		 * @Description:- Used to Select the checkbox by nodename present in hierarchy.
		 * @Used_In:- Transfer store
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void selectCheckboxByNodename(String nodename) throws Exception {

			String xpath = "//md-checkbox[@aria-label='" + nodename + "']";
			
			if(driver.findElements(By.xpath(xpath)).size() != 0) {
				
				driver.findElement(By.xpath(xpath)).click();
				logger.info("Selected the checkbox infront of "+ nodename);
			}else {
				
				throw new Exception("Unable to find the node with name " + nodename);
			}	
		}

		
		/**
		 * @Description:- This method is used to verify the toggle is enable/disabled  
		 *                present on operational role
		 * @Used_In:- Add levels when settings are enabled test case
		 * @author Mayur Sapre
		 * @throws Exception
		 */

		public void VerifyEnabledDisableToggleByLabelAndStatus(String label, String status) throws Exception {
			
			String myxpath = "//*[contains(text(),'"+ label +"')]/..//td[@aria-hidden='false']//md-switch[@aria-checked='"+ status +"']";
		
			if (driver.findElements(By.xpath(myxpath)).size() != 0) {

				logger.info(label + " toggle status is "+ status);

			} else {
				
				throw new Exception("Unable to find the toggle " + label + " with status "+ status);
				
			}
		}
		
		/**
		 * @Description:- This utility is used to set the wait time in seconds  
		 * @Used_In:- All test cases
		 * @author Mayur Sapre
		 * @throws Exception
		 */
		public void implicitWaitUtilityBySeconds(long second) {
			
			driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
		}
		
		
		/**
		 * @Description:- Used to get all values from dropdown which are within "
		 *                <li>" tag by option name and store them in array (Usually multiple select dropdown)
		 * @Used_In:- Assign Leader from Edit form
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public String[] getOptionsFromDropdown() throws Exception {
			
			String xpath = "//md-virtual-repeat-container[@aria-hidden='false']//li//span";
		
			int numberOfOptions = driver.findElements(By.xpath(xpath)).size();
			String options[]= new String[numberOfOptions];
			
			
			if(numberOfOptions != 0) {
				
				logger.info("There are "+numberOfOptions+" values in dropdown");
				
				for(int i = 0; i < numberOfOptions; i++) {
					
					String index = Integer.toString(i+1);
					logger.info("At index: "+ index);
					
					options[i] = driver.findElement(By.xpath("//md-virtual-repeat-container[@aria-hidden='false']//li["+index+"]//span")).getText();
					
					logger.info(options[i]);
				}
				
			}else {
				
				throw new Exception("No value present in dropdown");
			}
			
			return options;
				
		}
		
		
		
		/**
		 * @Description:- Used to select value from dropdown which are whithin "
		 *                <li>" tag by index (Usually multiple select dropdown)
		 * @Used_In:- Assign Leader from Edit form
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void selectOptionFromDropdownByIndex(String index) throws Exception {
			
			String xpath = "//md-virtual-repeat-container[@aria-hidden='false']//li["+index+"]//span";
			
			if(driver.findElements(By.xpath(xpath)).size() != 0) {
				
				driver.findElement(By.xpath(xpath)).click();
				logger.info("---- Clicked on " + index);
			}else {
				
				throw new Exception("Unable to locate value at index "+index+" in dropdown");
			}
				
		}
		
		
		/**
		 * @Description:- Returns number of selected options present below the drop down after selection
		 * @Used_In:- Assign Leader from Edit form
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public int getNumberOfSelectedOptionsByPlaceholder(String placeholder) throws Exception {
			
			String xpath = "//*[@placeholder='"+placeholder+"']/..//a";
			
			int num = driver.findElements(By.xpath(xpath)).size();
			
			return num;
		}
		
		
		/**
		 * @Description:- Used to click on text field by placeholder
		 * @Used_In:- Assign Leader from Edit form
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void clickOnTextFieldByPlaceHolder(String placeholder) throws Exception {
			String myxpath = "//input[@placeholder='" + placeholder + "']";
			
			if ((driver.findElements(By.xpath(myxpath))).size() != 0) {
				
				logger.info("Clicking on field with placeholder "+ placeholder);
				driver.findElement(By.xpath(myxpath)).click();
				
			} else {

				throw new Exception("Unable to locate text field with placeholder " + placeholder);
			}
			
		}
		
		
		/**
		 * @Description:- Used to select option from context menu of franchise in hierarchy settings, to enable and disable
		 * 				  Coaches in settings or to reset it to default value
		 * @Used_In:- Master and Suborg (Area transfer across)
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void selectOptionFromHierarchyContextMenuByFranchiseName(String frnname, String option) throws Exception {
			String myxpath = "//*[contains(text(),'"+ frnname+"')]//parent::tr[@class='ng-scope']//span/i";
			String myxpath2 = "//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']//button[contains(@ng-click,'"+option+"')]";
			
			if ((driver.findElements(By.xpath(myxpath))).size() != 0) {
				
				logger.info("Clicking on context menu of franchise "+ frnname);
				driver.findElement(By.xpath(myxpath)).click();
				
				timeobj.waitForSmalltime();
				
				if ((driver.findElements(By.xpath(myxpath2))).size() != 0) {
					
					logger.info("Clicking on option "+option+" in context menu of franchise "+ frnname);
					driver.findElement(By.xpath(myxpath2)).click();
					
				} else {

					throw new Exception("Unable to locate option "+ option +" in context menu for franchise " + frnname);
				}
				
				
			} else {

				throw new Exception("Unable to locate context menu for franchise " + frnname);
			}
			
			timeobj.waitForSmalltime();
			
		}
		
		
		/**
		 * @Description:- Used to click on toggle of level coaches by label
		 * @Used_In:- Master and Suborg (Area transfer across)
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void clickOnOperationalRolesToggleButtonByLabel(String label) throws Exception {
			String myxpath = "//*[contains(text(),'"+label+"')]/ancestor::tr//md-switch[@tabindex='0']//*[@class='md-thumb md-ink-ripple']";
			
			if ((driver.findElements(By.xpath(myxpath))).size() != 0) {
				
				logger.info("Clicking on toggle button of "+ label);
				driver.findElement(By.xpath(myxpath)).click();
				
			} else {

				throw new Exception("Unable to locate toggle button of " + label);
			}
			
		}
		
		
		/**
		 * @Description:- To drag and drop element from source to destination. Here the
		 *                name of source is required and node type and node name of the
		 *                destination
		 * @Used_In:- Assign People, Assign Store, Assign Operational Roles, Level Transfer
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void dragAndDropElementUsingName(String srcname, String srctype, String tartype, String tarname) throws Exception {
			
			String tag = "//span[text()='" + tartype + "']/../..//*[@aria-label='" + tarname + "']";
			
			String source = "//span[text()='" + srctype + "']/../..//*[@aria-label='" + srcname + "']/../../../../..//i";
			
			WebElement target = driver.findElement(By.xpath(tag));
			WebElement src = driver.findElement(By.xpath(source));
			
			if (driver.findElements(By.xpath(tag)).size() == 0){
				
				throw new Exception("Unable to locate the target node "+ tartype +" with name " + tarname);
			} 
			
			if (driver.findElements(By.xpath(source)).size() == 0){
				
				throw new Exception("Unable to locate the source node "+ srctype +" with name " + srcname);
			}
			
			Actions action = new Actions(driver);
			action.dragAndDrop(src, target).build().perform();
		}
		
		
		/**
		 * @Description:- To check and return the status of check box whether it's checked
		 *                
		 * @Used_In:- Function to select single value in global filter
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public String checkStatusOfCheckBoxByIdAndLabel(String id, String label) throws Exception {

			String myxpath = "//*[@id='"+id+"'][@aria-label='"+label+"']";
			String status = "";
			
			if(driver.findElements(By.xpath(myxpath)).size() != 0) {
				
				WebElement element = driver.findElement(By.xpath(myxpath));
				status = element.getAttribute("aria-checked");
			}else {
				
				throw new Exception("Unable to locate the check box with "+ label);
			}
			
			return status;
		}
		
		
		/**
		 * @Description:- To validate field is displayed or not by there placeholder value
		 * @Used_In:- Edit Region(Territory not configured)
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void checkFieldIsDisplayedByPlaceHolder(String placeholder, String status) throws Exception {
			
			String myxpath = "//*[@placeholder='" + placeholder + "']";
			
			int size = driver.findElements(By.xpath(myxpath)).size();
			
			if ( size != 0 && status.equalsIgnoreCase("Displayed")) {
				
				logger.info("Text field with placeholder "+ placeholder +" is displayed");
				
			}else if (size == 0 && status.equalsIgnoreCase("Displayed")) {
				
				throw new Exception("Text field with placeholder " + placeholder + " is not displayed");
				
			}else if (size == 0 && status.equalsIgnoreCase("Not Displayed")) {
				
				logger.info("Text field with placeholder "+ placeholder +" is not displayed");
			}
			else {

				throw new Exception("Text field with placeholder " + placeholder + " is displayed");
			}
			
		}
		
		
		/**
		 * @Description:- Click's on checkbox of multiple store, people etc.
		 * @Used_In:- transfer store test case
		 * @author Mayur Sapre
		 * @throws Exception
		 */

		public void selectMultipleValuesByIndex(String num) throws Exception {
			
			int numOfValues = Integer.parseInt(num);
			
			for(int i = 1; i <= numOfValues; i++) {
				
				String index = String.valueOf(i);
				
				String myxpath = "//*[@id='tree-root']//li["+index+"]//md-checkbox";
				WebElement ele = driver.findElement(By.xpath(myxpath));
				if (driver.findElements(By.xpath(myxpath)).size() != 0) {
		
					ele.click();
					logger.info("Selected value at index"+ index);
					timeobj.waitForSmalltime();;
		
				} else {
					
					throw new Exception("Unable to find the value at index" + index);
					
				}
			}
		}
		
		
		/**
		 * @Description:- To extract the names of Unassigned store or people by its index and returns array
		 * @Used_In:- Assign People, Assign Store, Assign Operational Roles
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public String[] getNamesOfUnassignedObjectByIndex(String num) throws Exception {
			
			int numOfValues = Integer.parseInt(num);
			String names[]= new String[numOfValues];
			WebElement ele;
			
			for(int i = 1; i <= numOfValues; i++) {
				
				String index = String.valueOf(i);
				String myxpath = "//*[@id='tree-root']//li[" + index + "]//div[2]/div/p//span/span";
				
				if (driver.findElements(By.xpath(myxpath)).size() != 0){
					
					ele = driver.findElement(By.xpath(myxpath));
					names[i-1] = ele.getText();
		
				}else {
					
					throw new Exception("Can not return text as no element is present at index " + index);
				}
			}
			
			return names;
		}
		
		
		/**
		 * @Description:- It select multiple levels on clicking there checkbox by there names
		 * @Used_In:- Transfer Store
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void selectMultiplelevelsByName(int num, String nodetype,String name) throws Exception {
			
			for(int i = 0; i < num; i++) {
				
				
				String myxpath = "//span[text()='"+nodetype+"']/../..//md-checkbox[@aria-label='"+name+"']";
				WebElement ele = driver.findElement(By.xpath(myxpath));
				if (driver.findElements(By.xpath(myxpath)).size() != 0) {
		
					ele.click();
					logger.info("Selected "+nodetype+" by name "+ name);
					timeobj.waitForSmalltime();;
		
				} else {
					
					throw new Exception("Unable to find "+nodetype+" by name " + name);
					
				}
			}
		}
		
		
		/**
		 * @Description:- Used to Click on links under particular section
		 * @Used_In:- Edit Person (Operational Roles)
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void clickOnLinkBySectionAndText(String section, String linkname) throws Exception {
			
			String xpath = "//*[text() = '"+section+"']/..//a[contains(text(),'"+linkname+"')]";
			
			if (driver.findElements(By.xpath(xpath)).size() != 0) {
				
				logger.info("Clicking on link with label "+ linkname);
				driver.findElement(By.xpath(xpath)).click();
			}else {

				throw new Exception("Unable to locate link with label " + linkname);
			}
			
		}
		
		
		/**
		 * @Description:- To Click on link by its text
		 * @Used_In:- Edit Person (Unassign Operational Role)
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void clickOnLinkByLinkName(String name) throws Exception {

			if (driver.findElements(By.linkText(name)).size() != 0){
				
				logger.info("Clicking on Link " + name);
				driver.findElement(By.linkText(name)).click();
			}else {
				throw new Exception("Unable to locate the "+ name +" link");
			}
		}
		
		
		/**
		 * @Description:- Used to Click on images such as Unassign 
		 * @Used_In:- Edit Person (Operational Roles)
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void clickOnUnassignImage(String section, String optRole) throws Exception {
			
			String xpath = "//*[text()='"+section+"']/..//*[text()='"+optRole+"']/..//img";
			
			if (driver.findElements(By.xpath(xpath)).size() != 0){
				
				logger.info("Clicking on image of "+ optRole);
				driver.findElement(By.xpath(xpath)).click();
			}else {
				throw new Exception("Unable to locate the operational role "+ optRole +" in section "+ section);
			}
		}
		
		
		/**
		 * @Description:- Performs Unassign Operational Role Operation 
		 * @Used_In:- Edit Person (Operational Roles)
		 * @author Mayur Sapre
		 * @throws Exception 
		 */
		
		
		public void unassignOperationalRoleInEditPerson(String section,String optRole ,String linkname, String ngclick) throws Exception {
			
			
			String xpath = "//*[text()='"+section+"']/..//*[text()='"+optRole+"']/..//img";
			
			List<WebElement> ele = driver.findElements(By.xpath(xpath));
			
			
			
			if(ele.size() == 0) {
				
				logger.info("Operational Role is not Assigned");
			}
			else {
				clickOnUnassignImage(section, optRole);
				timeobj.waitForSmalltime();;
				clickOnLinkByLinkName(linkname);
				timeobj.waitForSmalltime();;
				clickOnButtonByNgClick(ngclick);
				timeobj.waitForSmalltime();;
			}
			
			
		}
		
		
		/**
		 * @Description:- Used to click on assign values,so as to unassign them 
		 * 				  by using id value of "md-autocomplete" tag
		 * @Used_In:- Edit Person Profile(Unassign BMU Countries)
		 * @author Mayur Sapre
		 */

		public void unassignValuesFromMultiSelectionDropdownById(String id) {

			String xpath = "//*[@id='" + id + "']/..//a";

			List<WebElement> list = driver.findElements(By.xpath(xpath));

			if (list.size() != 0) {

				for (int index = list.size(); index > 0; index--) {

					driver.findElement(By.xpath("//*[@id='" + id + "']/..//a[" + index + "]")).click();

				}
			} else {

				logger.info("No value to un-assign");
			}

		}
		
		
		/**
		 * @Description:- Used to enter value in text field which are in input tag by
		 *                id of its parent md-autocomplete tag
		 * @Used_In:- Edit Person Profile(assign BMU Countries)
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void enterTextInFieldById(String id, String text) throws Exception {
			
			String xpath = "//md-autocomplete[@id='"+id +"']//input";
			
			if(driver.findElements(By.xpath(xpath)).size() != 0) {
				
			//	implicitWaitUtilityBySeconds(SLEEP_TIME_MEDIUM);
				driver.findElement(By.xpath(xpath)).click();
				driver.findElement(By.xpath(xpath)).clear();
			//	implicitWaitUtilityBySeconds(SLEEP_TIME_MEDIUM);
				driver.findElement(By.xpath(xpath)).sendKeys(text);
			}else {
				
				throw new Exception("Unable to locate Field with id as "+ id);
			}
		}
		
		
		/**
		 * @Description:- It select a level on clicking there checkbox by there names
		 * @Used_In:- Transfer Store
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void selectSinglelevelByName(String nodetype,String name) throws Exception {
				
				String myxpath = "//span[text()='"+nodetype+"']/../..//md-checkbox[@aria-label='"+name+"']";
				
				
				WebElement ele = driver.findElement(By.xpath(myxpath));
				if (driver.findElements(By.xpath(myxpath)).size() != 0) {
					
//					JavascriptExecutor e = (JavascriptExecutor)driver;
//					e.executeScript("arguments[0].click();", myxpath);
					
					ele.click();
					logger.info("Selected "+nodetype+" by name "+ name);
					timeobj.waitForSmalltime();;
		
				} else {
					
					throw new Exception("Unable to find "+nodetype+" by name " + name);
					
				}
		}
		
		
		
		/**
		 * @Description:- Extracts the names of assigned vendor tools or reports and store them in array and returns the array
		 * @Used_In:- Edit Person Profile
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public String[] getAssignedVendorToolsAndReports(String section) throws Exception {
			
			String xpath = "//*[text() = '"+section+"']/..//div/p";
		
			int numberOfOptions = driver.findElements(By.xpath(xpath)).size();
			String options[]= new String[numberOfOptions];
			
			
			if(numberOfOptions != 0) {
				
				logger.info("There are "+numberOfOptions+" values in dropdown");
				
				for(int i = 0; i < numberOfOptions; i++) {
					
					String index = Integer.toString(i+1);
					logger.info("At index: "+ index);
					
					options[i] = driver.findElement(By.xpath("//*[text() = '"+section+"']/..//div["+index+"]/p")).getText();
					
					logger.info(options[i]);
				}
				
			}else {
				
				logger.info("No value present in dropdown");
			}
			
			return options;
				
		}
		
		
		/**
		 * @Description:- Used to click on button by it's label and the header of pop-up
		 * @Used_In:- Edit Person
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void clickOnButtonByHeaderAndLabel(String header, String label) throws Exception {
			
			String xpath = "//*[text()='"+header+"']/../..//button[text()='"+label+"']";
			
			if(driver.findElements(By.xpath(xpath)).size() != 0) {
				
				driver.findElement(By.xpath(xpath)).click();
			}else {
				
				throw new Exception("Unable to locate the button with label " + label);
			}
			
		}
		
		
		
		/**
		 * @throws Exception 
		 * @function: This method is used to check the value is present or not
		 * @Used-in: Edit Person Profile
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public boolean checkValueIsPresent(String section, String value) throws Exception {
			
			boolean flag = false;
			String myxpath = "//*[text()='"+section+"']/..//*[contains(text(),'"+value+"')]";
			
			if ((driver.findElements(By.xpath(myxpath))).size() != 0) {
				
				logger.info(value + " is present in section" + section);
				flag = true;
			} else {

				logger.info(value + " is not present in section" + section);
			}
			
			
			return flag;
		}
		
		/**
		 * @Description:- Used to Select the option from drop down by the option name. It chooses the option from exact option name.
		 *				  It can be used for Drop down values within "md-option" tag
		 * @Used_In:- Operational Role
		 * @author Mayur Sapre
		 * @throws Exception 
		 */
		
		public void selectOptionFromDropdownByName(String name) throws Exception {
			
			String myxpath = "//*[@class='md-select-menu-container md-active md-clickable']//*[text()='"+name+"']";
			
			if(driver.findElements(By.xpath(myxpath)).size() != 0) {
				
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("Clicked on " + name + " in dropdown");
			}else {
				throw new Exception("Unable to the locate the " + name + " option in dropdown");
			}
		}
		
		/**
		 * @throws Exception 
		 * @function: This method is used to select the checkbox by using data-id & text
		 * @Used-in: For assign people filter selection
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void selectCheckboxBydataidAndtext(String dataid, String text) throws Exception {

			String myxpath = ".//*[@data-id='" + dataid + "']//div[text()='" + text + "']";
			
			if ((driver.findElements(By.xpath(myxpath))).size() != 0) {
				
				logger.info("Select checkbox of " + text);
				driver.findElement(By.xpath(myxpath)).click();
			} else {

				throw new Exception("Unable to locate checkbox with label" + text);
			}
		}

		/**
		 * @Description:- Used to select value from dropdown within the <li> tag by option name
		 * @Used_In:- Assign people/coaches in Edit level
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void selectOptionFromDropdownByOptionname(String option) throws Exception {
			
			String xpath = "//md-virtual-repeat-container[@aria-hidden='false']//*[contains(text(),'" + option + "')]";
			
			if(driver.findElements(By.xpath(xpath)).size() != 0) {
				
			//	implicitWaitUtilityBySeconds(SLEEP_TIME_SMALL);
				driver.findElement(By.xpath(xpath)).click();
				logger.info("---- Clicked on " + option);
			}else {
				
				throw new Exception("Unable to locate "+option+" value in dropdown");
			}
				
		}
		
		/**
		 * @Description:- Used to Click on text within md-tab-item tag, in the store edit
		 * @Used_In:- To Click on tabs present after editing the store like leadership, Organization, Assignments etc
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public void clickOnTabAfterStoreEditByText(String text) throws Exception {

			
			String myxpath = "//md-tab-item[contains(text(),'" + text + "')]";
			
			if (driver.findElements(By.xpath(myxpath)).size() != 0) {
				
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("Clicking on Tab " + text);
				
				
			}else {
				throw new Exception("Unable to the click on "+ text +" tab in settings");
			}
		}

		/**
		 * @Description:- Used to verify coach value from leadership tab in Edit store
		 * @Used_In:- To verify coach names by styles
		 * @author Mayur Sapre
		 * @throws Exception 
		 */
		
		public void VerifyCoachValueFromEditStore(String coachName) throws Exception {
			
			String myxpath = ".//*[@id='Leadership2']//td[text()='"+ coachName +"']/..//input[@style='']";
			
			if (driver.findElements(By.xpath(myxpath)).size() > 0) {
				
				logger.info("Verifying the value of coach name " + coachName);
				
			}else {
				throw new Exception("Unable to the verify coach name "+ coachName);
			}
			
		}
		
		/**
		 * @throws Exception 
		 * @function: This method is used to click on context menu option of specific
		 *            level with levelname 
		 * @Used-in: People verification
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void clickOnContextMenuOptionOfLevelByLevelAndLevelnameInPeople(String level, String levelname) throws Exception {

			String myxpath = "//*[contains(@aria-label,'" + levelname + "')]/../../../..//span[text()='" +level+ "']/../..//*[@class='context-menu-tree']//img";
			
			
			if ((driver.findElements(By.xpath(myxpath))).size() != 0) {
				
			//	implicitWaitUtilityBySeconds(SLEEP_TIME_SMALL);
				driver.findElement(By.xpath(myxpath)).click();
				logger.info("Click on context menu option of " + level + " name " + levelname);
				
			} else {

				throw new Exception("Unable to locate the context menu for node "+level+ " with name "+ levelname);
			}
		}
		

		/**
		 * @Description:- Used to Write data in text file
		 * @Used_In:- For writing the assigned people names in file
		 * @author Mayur Sapre
		 * @throws Exception 
		 */	
		
		public void WriteToFile(String text, String filepath) throws IOException {
			
			FileWriter writer = new FileWriter(filepath, true);
			writer.write(text+",");
			logger.info(text + " written to text file");
			writer.close();
		}
		
		/**
		 * @Description:- Used to Read data from text file
		 * @Used_In:- For Reading the already assigned people names
		 * @author Mayur Sapre
		 * @throws Exception 
		 */	
		public String[] ReadFromFile(String filepath) throws IOException {
			
			FileReader reader = new FileReader(filepath);
			BufferedReader br = new BufferedReader(reader);
		    String line;
		    String[] peopleList = null;
		    logger.info("Reading text file using FileReader");
		    
		    while((line = br.readLine()) != null){
		            //process the line
		    	logger.info("lines are "+line);
		      peopleList = line.split(",");
		     }
		     reader.close();
		     br.close();
		     return(peopleList);
		     
		}
		
		/**
		 * @Description:- Used to Clear data from text file
		 * @Used_In:- For clearing the data from file
		 * @author Mayur Sapre
		 * @throws Exception 
		 */	
		public void clearFileContents(String filepath) throws IOException {
			
			FileWriter fwOb = new FileWriter(filepath, true); 
	        PrintWriter pwOb = new PrintWriter(fwOb, false);
	        pwOb.flush();
	        logger.info("clear the file contents successfully"); 
	        pwOb.close();
	        fwOb.close();
		}
		
		/**
		 * @Description:- Used to delete the text file
		 * @Used_In:- For deleting the file after execution of people validation
		 * @author Mayur Sapre
		 * @throws Exception 
		 */	
		public void deleteFile(String filepath) {
			
			File file = new File(filepath); 
	        
	        if(file.delete()) 
	        { 
	        	logger.info("File deleted successfully"); 
	        } 
	        else
	        { 
	        	logger.info("Failed to delete the file"); 
	        } 
		}
	
		
		
		/**
		 * @throws Exception 
		 * @function: This method is used to create text file to write assigned peoples name
		 * @Used-in: Assign People
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void createFile(String path) throws Exception {
			
			try {
			     File file = new File(path);
			     /*If file gets created then the createNewFile() 
			      * method would return true or if the file is 
			      * already present it would return false
			      */
		             boolean fvar = file.createNewFile();
			     if (fvar){
			          System.out.println("File has been created successfully");
			     }
			     else{
			          System.out.println("File already present at the specified location");
			          FileWriter fw = new FileWriter(file, false);
			          fw.flush();
			          fw.close();
			     }
		    	} catch (IOException e) {
		    		System.out.println("Exception Occurred:");
			        e.printStackTrace();
			  }
		}
		
		
		
		/**
		 * @throws Exception 
		 * @function: This method is used to write assigned peoples name to the created file
		 * @Used-in: Assign People
		 * @Author: Mayur Sapre
		 * @Version: 1.0
		 */
		public void writeToFile(String path,String arr[]) throws Exception {
			
			 BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			 
			 for (int i = 0; i < arr.length; i++) {
				 
				if(i == arr.length-1) {
					
					writer.write(arr[i]);
				}else {
					
					 writer.write(arr[i] + ",");
				}
			 }
			    writer.close();
		}
		
		
		/**
		 * @Description:- Used to get all values which are selected from dropdown i.e from chips list which are within "
		 *                <a>" tag by option name and store them in array (Usually multiple select dropdown)
		 * @Used_In:- Assign Channel type from store edit page
		 * @author Mayur Sapre
		 * @throws Exception 
		 */

		public String[] getSelectedValuesFromDropdown(String labelname) throws Exception {
			
			String xpath = ".//*[text()='"+ labelname +"']/../..//div[@class='chips-list clearfix']/a";
		
			int numberOfValues = driver.findElements(By.xpath(xpath)).size();
			String values[]= new String[numberOfValues];
			
			
			if(numberOfValues != 0) {
				
				logger.info("There are "+numberOfValues+" values in dropdown");
				
				for(int i = 0; i < numberOfValues; i++) {
					
					String index = Integer.toString(i+1);
					logger.info("At index: "+ index);
					
					values[i] = driver.findElement(By.xpath(".//*[text()='"+ labelname +"']/../..//div[@class='chips-list clearfix']/a["+ index +"]")).getText();
					
					logger.info(values[i]);
				}
				
			}else {
				
				throw new Exception("No value selected in dropdown");
			}
			
			return values;		
		}
		
		/**
	     * This method utilises TestNG Asserts to compare Texts
	     *
	     * @param actual   Actual Value
	     * @param expected Expected Value
	     */
	    public void compareText(String actual, String expected) {
	        try {
	            Assert.assertEquals(actual, expected);
	            logger.info("Text compared successfully");
	        } catch (Exception e) {
	            logger.error("Texts compare failed" + e);
	        }
	    }
	    
	    public void fluentWait(WebElement element, int timeout) {
	        try {
	            Wait wait = new FluentWait<>(driver)
	                    .withTimeout(Duration.ofSeconds(timeout))
	                    .pollingEvery(Duration.ofMillis(5))
	                    .ignoring(NoSuchElementException.class);
	            wait.until(ExpectedConditions.visibilityOf(element));

	        } catch (ElementNotVisibleException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public String getText(WebElement element) {
	        fluentWait(element, 10);
	        return element.getText();
	    }
	    
	    public void switchToFrame(String framename) {
	    	try {
	    		driver.switchTo().frame(framename);
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    }
	    
	    public void clickOnValueInsideCLass(String classname,String value) throws Exception {
			
			String xpath = "//*[@class='"+classname+"']//*[text()='"+value+"']";
			
			if(driver.findElements(By.xpath(xpath)).size() != 0) {
				driver.findElement(By.xpath(xpath)).click();
				logger.info("---- Clicked on " + value);
			}else {
				throw new Exception("Unable to locate "+value+" value in dropdown");
			}
				
		}
	    
	    
		
		

	}

