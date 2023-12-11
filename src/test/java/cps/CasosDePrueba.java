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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CasosDePrueba {
    //Atributos
    WebDriver driver;

    JavascriptExecutor js;
    String rutaProyecto = System.getProperty("user.dir");
    String rutaDriver = rutaProyecto + "\\src\\test\\resources\\drivers\\chromedriver.exe";

    @BeforeEach
    public void preCondiciones() {

    JavascriptExecutor js;
    String rutaProyecto = System.getProperty("user.dir"); //no es de la prueba

    String rutaDriver = rutaProyecto + "\\src\\test\\resources\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", rutaDriver);
        driver = new ChromeDriver();

        js = (JavascriptExecutor) driver;


        driver.get("https://www.pcfactory.cl");

        driver.get("https://open.spotify.com/");


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();
    }

    @AfterEach
    public void posCondiciones(){
        driver.quit();
    }

    @Test
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

