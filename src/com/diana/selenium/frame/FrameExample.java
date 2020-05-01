package com.diana.selenium.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "//Users//DSV//Downloads//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		// count of frames in the page
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		// indicamos a selenium la existencia de un frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		driver.findElement(By.id("draggable")).click();
		Actions drop = new Actions(driver);
		drop.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build()
				.perform();
		//when you finish to work in the frame 
		driver.switchTo().defaultContent();

		/*
		 * WebElement source = driver.findElement(By.id("draggable")); WebElement target
		 * = driver.findElement(By.id("droppable")); drop.dragAndDrop(source,
		 * target).build().perform();
		 */
	}

}
