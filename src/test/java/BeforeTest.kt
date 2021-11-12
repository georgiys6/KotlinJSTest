import com.sun.xml.internal.ws.spi.db.BindingContextFactory
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import java.io.FileInputStream
import java.io.IOException
import java.util.*
import java.util.logging.Level.CONFIG

open class BeforeTest {
    val CONFIG = "src\\main\\resources\\config.properties"

    var prop = Properties()
    var fileInputStream: FileInputStream? = null

    @BeforeTest
    fun cause() {
        BindingContextFactory.LOGGER.info("Before Test")
        val browserFactory = BrowserFactory("chrome") //exist only chrome and firefox

        try {
            fileInputStream = FileInputStream(CONFIG)
            prop.load(fileInputStream)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @AfterTest
    fun aftermath() {
      //  BrowserFactory.closeDriver()
        BindingContextFactory.LOGGER.info("Test the End")
    }
}