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

public class PruebaGoogle {

private WebDriver driver;
	
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver= new ChromeDriver();//crear una ventana de chrome ESTANDAR
		driver.manage().window().maximize();//máximi la ventana ESTANDAR
		driver.get("https://www.google.com");//abrir dirección CAMBIA EN LAPRUEBA
		
	}
	
	@Test
	public void testPruebaGoogle() {
		WebElement searchbox= driver.findElement(By.name("q"));//buscar q (cuadro de búsqueda)
		searchbox.clear();//limpiar el elmento q
		searchbox.sendKeys("prueba test");//digite el texto
		searchbox.submit();//enter
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);//tiempo para que salga el resultado
		
		assertEquals("prueba test11 - Buscar con Google", driver.getTitle());//title pestaña
		
	}
	
	@After
	public void tearDown() {
		
		driver.quit();//cerrar el explorador
		
	}

}
