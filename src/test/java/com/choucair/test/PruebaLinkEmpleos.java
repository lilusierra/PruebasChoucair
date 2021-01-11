package com.choucair.test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PruebaLinkEmpleos {
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();// crear una ventana de chrome 
		driver.manage().window().maximize();// máximizar la ventana
		driver.get("https://www.choucairtesting.com/");// abrir dirección
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();//cerrar ventana
	}

	@Test
	public void testPruebaLinkEmpleos() {
		WebElement searchbox= driver.findElement(By.linkText("Empleos"));//buscar el link
		searchbox.click();//click
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);//tiempo para que salga el resultado
		
		assertEquals("empleos testing – Choucair Testing", driver.getTitle());//comparación titulño pestaña
		
	}
}
