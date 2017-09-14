package com.Evry.Mob_Recharge.TestClass;

import org.testng.annotations.Test;

	import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Evry.Mob_Recharge.GenericClass.BrowserFactory;
import com.Evry.Mob_Recharge.GenericClass.WebPage;
import com.Evry.Mob_Recharge.PageClass.Mob_login;

	
	public class mob_loginTestPage extends Mob_login {
		private Map<String,WebPage>session;
		private String driver;
		private static Logger logger;
		private int timeout;
		@Test
		public mob_loginTestPage(WebDriver driver, int timeout) {
			super(driver, timeout);


			Mob_login ml=(Mob_login)session.get("Mob_login");


		}

		@BeforeClass(enabled=true)
		@Parameters( {"driver","timeout"})
		public void beforeclass(String browserDriver,int timeout)
		{
			driver=browserDriver;
			timeout=timeout;

			session=new HashMap<String,WebPage>();
			WebDriver Webdriver=null;
			logger =Logger.getLogger(this.getClass().getName());
			logger.info("Select the driver ");

			BrowserFactory bf=new BrowserFactory(driver);
			Webdriver=bf.getWebDriver();
			try {
				Mob_login ml=new Mob_login(Webdriver, timeout);

				session.put("Mob_login", ml);
			} catch (Exception e) {
				Webdriver.quit();
			}

		}
	}


