package com.choucair.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class PruebaLinkPrepararseParaAplicar {
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();// crear una ventana de chrome
		driver.manage().window().maximize();// m�ximizar la ventana
		driver.get("https://www.choucairtesting.com/empleos-testing/");// abrir direcci�n
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();//cerrar ventana
	}

	@Test
public void testPruebaLinkPrepararseParaAplicar() throws InterruptedException  {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);//elemento agregar espera antes de dar el click para la otra pesta�a
		WebElement searchbox= wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Modelo de calidad de software")));//buscar el link
		 Actions actions = new Actions(driver);//crear elemento que permita movernos en la pantalla
		 actions.moveToElement(searchbox);//muevase
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", searchbox);//click sobre el link (cuando es para abrir otra pesta�a)
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);//tiempo espera nop influye, mejor usar l�nea 44 porwque espera no es timeout
		Thread.sleep(3000); //agregar espera para que cargue la otra pagina
		Set<String> handles = driver.getWindowHandles(); // obtener todas las pesta�as de la ventana
		Iterator<String> iterator = handles.iterator(); //listar las pesta�as
		String subWindowHandler = null; //definir una variable para moverse a la siguiente pesta�a
		while (iterator.hasNext()){//recorre lista de pesta�as hasta la �ltima
		    subWindowHandler = iterator.next();//obtener a la siguiente pesta�a
		}
		driver.switchTo().window(subWindowHandler); // moverse a la siguiente pesta�a

		driver.switchTo().window(driver.getWindowHandle());// Obtener control de la pesta�a abierta
		
		assertEquals("ISO 25010", driver.getTitle());//comparaci�n titul�o pesta�a
		
	}

}
