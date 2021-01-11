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

public class PruebaEmpleoKeywordsNoEncontrado {
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();// crear una ventana de chrome ESTANDAR
		driver.manage().window().maximize();// máximi la ventana ESTANDAR
		driver.get("https://www.choucairtesting.com/empleos-testing/");// abrir dirección CAMBIA EN LAPRUEBA
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();//cerrar ventana
	}

	@Test
	public void testPruebaEmpleoKeywordsNoEncontrado() {
		WebElement searchbox= driver.findElement(By.name("search_keywords"));//buscar q (cuadro de búsqueda)
		searchbox.clear();//limpiar el elmento q
		searchbox.sendKeys("aeronautica");//digite el texto
		
		WebElement buttonSearch= driver.findElement(By.cssSelector("input[value=\"Search Jobs\"]"));
		buttonSearch.click();//enter , equivalencia button search jobs
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);//tiempo para que salga el resultado
		
		WebElement resulElement= driver.findElement(By.cssSelector("li[class=\"no_job_listings_found\"]"));
		//equivalencia para mensaje de cantidad de trabajos encontrados
		
		assertTrue(resulElement.isDisplayed());//lista resultados
	}

}
