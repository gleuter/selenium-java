package TIM;
import org.junit.Test;
import org.junit.Before;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestesTIM {
	private WebDriver driver;
	private final String pathChromeDriver = "src/test/resources/chromedriver.exe";
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", pathChromeDriver);		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tim.com.br/rj");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@After
	public void closeDriver() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();		
	}
	
	
	@Test
	public void Teste02() {
		driver.findElement(By.linkText("Meu TIM")).click();
		driver.findElement(By.cssSelector(".btn-close")).click();
	    driver.findElement(By.id("campo-numero")).click();
	    driver.findElement(By.id("campo-numero")).sendKeys("(21) 99999-9999");
	    driver.findElement(By.id("campo-senha")).click();
	    driver.findElement(By.id("campo-senha")).sendKeys("1234");
	    driver.findElement(By.id("btn-entrar")).click();
	    String validacaoTexto = driver.findElement(By.id("mensagem-erro-login")).getText();
	    Assert.assertEquals(validacaoTexto, "Usuário ou senha inválida.\nPreencha novamente os campos de usuário e senha.");
	    //Assert.assertEquals(validacaoTexto, "Usuário ou senha inválida.");	    
	}
	
	@Test
	public void Teste03() {
		driver.findElement(By.linkText("Meu TIM")).click();
		driver.findElement(By.xpath("//*[@id=\"alert-update-browser\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"campo-numero\"]")).sendKeys("219999999999");
		driver.findElement(By.xpath("//*[@id=\"campo-senha\"]")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@id=\"numero-acesso\"]/div[4]/label/span")).click();
		driver.findElement(By.xpath("//*[@id=\"btn-entrar\"]")).click();	    
	}

	
}
