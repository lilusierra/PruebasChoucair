package com.choucair.test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PruebaEmpleoDisponibleSeleccionarVacante {

	private WebDriver driver;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();// crear una ventana de chrome 
		driver.manage().window().maximize();// máximizar la ventana
		driver.get("https://www.choucairtesting.com/empleos-testing/");// abrir dirección
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();//cerrar ventana
	}

	@Test
	public void testPruebaEmpleoDisponibleSeleccionarVacante() {
		WebDriverWait wait = new WebDriverWait(driver, 10);//elemento agregar espera antes de dar el click para la otra pestaña
		WebElement searchbox= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class=\"position\"]")));//buscar el link
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", searchbox);//click sobre el link (cuando es para abrir otra pestaña)
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);//tiempo para que salga el resultado
		
		assertEquals("Analista de Pruebas sector Bancario – Choucair Testing", driver.getTitle());//comparación titulo pestaña
	}

}
