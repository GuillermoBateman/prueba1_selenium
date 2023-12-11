package cps;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
<<<<<<< HEAD
import org.openqa.selenium.interactions.Actions;
=======
>>>>>>> origin/main
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CasosDePrueba {
    //Atributos
    WebDriver driver;
<<<<<<< HEAD

    JavascriptExecutor js;
    String rutaProyecto = System.getProperty("user.dir");
    String rutaDriver = rutaProyecto + "\\src\\test\\resources\\drivers\\chromedriver.exe";

    @BeforeEach
    public void preCondiciones() {
=======
    JavascriptExecutor js;
    String rutaProyecto = System.getProperty("user.dir"); //no es de la prueba

    String rutaDriver = rutaProyecto + "\\src\\test\\resources\\drivers\\chromedriver.exe";

    @BeforeEach
    public void preCondiciones(){
>>>>>>> origin/main
        System.setProperty("webdriver.chrome.driver", rutaDriver);
        driver = new ChromeDriver();

        js = (JavascriptExecutor) driver;

<<<<<<< HEAD
        driver.get("https://www.pcfactory.cl");
=======
        driver.get("https://open.spotify.com/");
>>>>>>> origin/main

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();
    }

    @AfterEach
<<<<<<< HEAD
    public void posCondiciones() {
=======
    public void posCondiciones(){
>>>>>>> origin/main
        driver.quit();
    }

    @Test
<<<<<<< HEAD
    public void CP001_enviar_consulta() throws InterruptedException {
        //driver.findElement(By.id("button-mi-entel")).click();
        //(//*[@aria-modal='true'])[3]
        //contains(text(),'Pagar cuenta')
        //contains(id,'Pagar cuenta')

        Actions actions = new Actions(driver);
        Thread.sleep(1000);

        WebElement Contactanos = driver.findElement(By.xpath("//a[@href='/contactenos'][1]"));
        Contactanos.click();
        driver.findElement(By.id("id_nombre_contacto")).sendKeys("santiago");
        driver.findElement(By.id("id_apellido_contacto")).sendKeys("querido");
        driver.findElement(By.id("id_rut_contacto")).sendKeys("111213220-1");
        driver.findElement(By.id("id_telefono_contacto")).sendKeys("945454545");
        driver.findElement(By.id("id_email_contacto")).sendKeys("correo@correo.cl");
        driver.findElement(By.id("id_nro_boleta")).sendKeys("111213220");
        driver.findElement(By.id("id_lista_motivo")).sendKeys("Consultas");
        driver.findElement(By.id("id_lista_motivo")).sendKeys("Consultas");
        driver.findElement(By.id("id_lista_clasificacion_motivo")).sendKeys("Otras Consultas");
        driver.findElement(By.id("id_comentarios_contacto")).sendKeys("puros comentarios");
        WebElement enviar = driver.findElement(By.id("id_enviar_formulario"));
        Thread.sleep(5000);

        // No se envia consulta
        // enviar.click();
        Assertions.assertTrue(true);
    }

    @Test
    public void CP002_error_enviar_consulta() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(1000);

        WebElement Contactanos = driver.findElement(By.xpath("//a[@href='/contactenos'][1]"));
        Contactanos.click();
        driver.findElement(By.id("id_nombre_contacto")).sendKeys(" ");
        driver.findElement(By.id("id_apellido_contacto")).sendKeys(" ");
        driver.findElement(By.id("id_rut_contacto")).sendKeys("111213220-1");
        driver.findElement(By.id("id_telefono_contacto")).sendKeys("945454545");
        driver.findElement(By.id("id_email_contacto")).sendKeys("correo@correo.cl");
        driver.findElement(By.id("id_nro_boleta")).sendKeys("");
        driver.findElement(By.id("id_lista_motivo")).sendKeys("Consultas");
        driver.findElement(By.id("id_lista_motivo")).sendKeys("Consultas");
        driver.findElement(By.id("id_lista_clasificacion_motivo")).sendKeys("Otras Consultas");
        driver.findElement(By.id("id_comentarios_contacto")).sendKeys("puros comentarios");
        WebElement enviar = driver.findElement(By.id("id_enviar_formulario"));
        // se envia consulta sin llenar todos los datos
        enviar.click();
        WebElement errorNombre = driver.findElement(By.id("error_nombre"));
        //System.out.println(errorNombre.isEnabled());
        Assertions.assertTrue(errorNombre.isEnabled());
    }

    @Test
    public void CP003_seguir_mi_pedido() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(1000);

        WebElement Despacho = driver.findElement(By.xpath("//a[@href='/despacho'][1]"));
        Despacho.click();
        driver.findElement(By.id("id_rut_despacho")).sendKeys("1121322-1 ");
        driver.findElement(By.id("id_boleta_despacho")).sendKeys("415263 ");
        WebElement enviar = driver.findElement(By.id("id_buscar_documento"));
        // NO se envia consulta
        //enviar.click()
        Thread.sleep(5000);
        Assertions.assertTrue(true);
    }

    @Test
    public void CP004_error_seguir_mi_pedido() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(1000);

        WebElement Despacho = driver.findElement(By.xpath("//a[@href='/despacho'][1]"));
        Despacho.click();
        driver.findElement(By.id("id_rut_despacho")).sendKeys(" ");
        driver.findElement(By.id("id_boleta_despacho")).sendKeys(" ");
        WebElement enviar = driver.findElement(By.id("id_buscar_documento"));
        // NO se envia consulta
        enviar.click();
        Thread.sleep(5000);

        WebElement errorDocumento = driver.findElement(By.id("id_buscar_documento"));
        //System.out.println(errorNombre.isEnabled());
        Assertions.assertTrue(errorDocumento.isEnabled());
    }

    @Test
    public void CP005_Registrarse() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(1000);

        WebElement Despacho = driver.findElement(By.xpath("//a[@href='/despacho'][1]"));
        Despacho.click();

        WebElement Registro = driver.findElement(By.xpath("//a[@href='/registro'][1]"));
        Registro.click();

        driver.findElement(By.id("id_rut_man_cliente")).sendKeys("11213220-1 ");
        driver.findElement(By.id("id_nombre_man_cliente")).sendKeys("nombre del cliente");
        driver.findElement(By.id("phone")).sendKeys("945454545");
        driver.findElement(By.id("id_email_man_cliente")).sendKeys("correo@correo.cl");
        driver.findElement(By.id("autocomplete")).sendKeys("carlos antunez, providencia, chile");
        driver.findElement(By.id("nombre_direccion")).sendKeys("casa");
        driver.findElement(By.id("route")).sendKeys("direccion de la casa");
        driver.findElement(By.id("street_number")).sendKeys("5544");
        driver.findElement(By.id("locality")).sendKeys("Santiago");
        driver.findElement(By.id("id_clave_man_cliente")).sendKeys("A526398");
        driver.findElement(By.id("id_reingrese_man_cliente")).sendKeys("A526398");

        WebElement guardarCliente = driver.findElement(By.id("btn_guardar_cliente"));
        // NO se envia consulta
        //guardarCliente.click();
        Thread.sleep(5000);

        Assertions.assertTrue(true);
    }
}

=======
    public void CP001_creacion_cta() throws InterruptedException {
        By localizadorRegistrarte = By.xpath("//button[contains(text(),'Reg')]");

        WebElement btnRegistrarte = driver.findElement(localizadorRegistrarte);

        btnRegistrarte.click();

        driver.findElement(By.id("username")).sendKeys("emailTest123456@algo.com");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@data-testid='submit']")).click();

        driver.findElement(By.id("new-password")).sendKeys("Frre3232");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@data-testid='submit']")).click();

        Thread.sleep(1000);
        driver.findElement(By.id("displayName")).sendKeys("Curso BCI Selenium");

        WebDriverWait wait = new WebDriverWait(driver,10);


        WebElement txtDay = wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//input[@id='day']")));

        txtDay.sendKeys("28");

        Select drpCountry = new Select(wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//select[@id='month']"))));

        drpCountry.selectByValue("10");

        WebElement txtYeah = wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//input[@id='year']")));

        txtYeah.sendKeys("1991");

        Thread.sleep(3000);


        js.executeScript("window.scrollBy(0,100)");

        List<WebElement> generos = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//label[contains(@for,'gender')]")));

        generos.get(0).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@data-testid='submit']")).click();

        Thread.sleep(3000);

        List<WebElement> checks = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//label[contains(@for,'checkbox')]")));

        if(checks.size()==2){
            checks.get(0).click();
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//button[@data-testid='submit']")).click();

        Thread.sleep(4000);

        String username = driver.findElement(By.xpath("//button[@data-testid='user-widget-link']")).getAttribute("aria-label");

        Assertions.assertEquals("Curso BCI Selenium",username);
    }

    @Test
    public void CP002_iniciar_sesion() throws InterruptedException {

        By localizadorIniciarSesion = By.xpath("//button[@data-testid='login-button']");

        WebElement btnIniciarSesion = driver.findElement(localizadorIniciarSesion);

        btnIniciarSesion.click();

        driver.findElement(By.id("login-username")).sendKeys("emailTest123456@algo.com");

        Thread.sleep(1000);

        driver.findElement(By.id("login-password")).sendKeys("Frre3232");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@data-testid='login-button']")).click();
        Thread.sleep(2000);
        String username = driver.findElement(By.xpath("//button[@data-testid='user-widget-link']")).getAttribute("aria-label");

        Assertions.assertEquals("Curso BCI Selenium",username);
    }

    @Test
    public void CP003(){

    }

    @Test
    public void CP004(){

    }

    @Test
    public void CP005(){

    }

}
>>>>>>> origin/main
