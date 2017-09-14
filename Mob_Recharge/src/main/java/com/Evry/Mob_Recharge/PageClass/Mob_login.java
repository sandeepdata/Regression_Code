package com.Evry.Mob_Recharge.PageClass;



import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Evry.Mob_Recharge.GenericClass.WebPage;



public class Mob_login implements WebPage{

	static Logger logger;
	public WebDriver _driver;
	public WebDriverWait _WebDriverWait;
	public String mURL;
	public String logo;
	public String login;
	public String mob;
	public Properties prop;


	public  Mob_login(WebDriver driver,int timeout)
	{
		_driver=driver;
		logger=Logger.getLogger(this.getClass().getName());

		try {
			Properties prop =new Properties();
			prop.load(Mob_login.class.getClassLoader().getResourceAsStream("TestProperties"));

			logo=prop.getProperty("mob_logo");
			Assert.assertNull(logo);


			mURL=prop.getProperty("mob_url");
			Assert.assertNull(mURL);

			login=prop.getProperty("mob_logo");
			Assert.assertNull(login);

			mob=prop.getProperty("Mobile_Link");
			Assert.assertNull(mob);

			int weight=Integer.parseInt(prop.getProperty("pageWeight"));
			Assert.assertNull(weight);

			_driver.manage().timeouts().implicitlyWait(weight*timeout, TimeUnit.SECONDS);
			_WebDriverWait =new WebDriverWait(driver,weight*timeout, weight);




		} catch (Exception e) {

			logger.error("Couldnot find property file ");
			logger.error (e.getMessage());

		}
	}


	public void recharge_URL() {


		_driver.get(mURL);
		logger.info("Mobile recharge URL is displayed ");
		_driver.manage().window().maximize();

	}


	public String gettitle() {

		try {
			String thetitle=_driver.getTitle();
			logger.info("Mobile recharge page title is : "+thetitle);

		} catch (Exception e) {
			logger.error("Mobile recharge page title is not displayed ");
			return "FAIL";
		}

		return "PASS";
	}

	public String validatepage() {
		try {

			if (_driver.getPageSource().contains(logo)) {
				logger.info("Mobile recharge page LOGO  is Displayed" );
			}

		} catch (Exception e) {
			logger.error("Mobile recharge page LOGO  is not Displayed" );
			return "FAIL";
		}
		return "PASS";
	}

	public WebDriver getDriver() {

		return _driver;
	}
}
