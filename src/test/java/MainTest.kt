import com.sun.xml.internal.ws.spi.db.BindingContextFactory
import com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER
import org.testng.Assert
import org.testng.annotations.Test


class MainTest:BeforeTest() {
    @Test
    fun test1() {
        BrowserFactory.driver[prop.getProperty("url1")]
        val page = BasicPage()
        page.waitingElement()
        page.loggerInfoPage()
        Assert.assertTrue(page.isDisplayed(), "test crush")
        BindingContextFactory.LOGGER.info(page.getAttribute("testInfo"))
    }

    @Test
    fun test2() {
        BrowserFactory.driver[prop.getProperty("url2")]
        val page = JSPage()
        Assert.assertEquals("The Internet", BrowserFactory.driver.title)
        Assert.assertTrue(page.isDisplayedAlert(), "ButtonAlert not fined")
        if (page.isDisplayedAlert()) {
            page.clickAlert()
        }
        Assert.assertTrue(page.isDisplayedConfirm(), "ButtonConfirm not fined")
        if (page.isDisplayedConfirm()) {
            page.clickConfirm()
        }
        Assert.assertTrue(page.isDisplayedPrompt(), "ButtonPrompt not fined")
        if (page.isDisplayedPrompt()) {
            page.utilManagerSendText("random")
        }
        LOGGER.info(page.result.toString())
    }

    @Test
    fun test3() {
        BrowserFactory.driver[prop.getProperty("url3")]
        val page = HorizontalSliderPage()
        Assert.assertTrue(page.isDisplayed(), "Slider not fined")
        LOGGER.info(page.movingResult())
    }

    @Test
    fun test4() {
        BrowserFactory.driver[prop.getProperty("url4")]
        val page = HoverPage()
        LOGGER.info(page.getText1())
        Assert.assertTrue(page.isDisplayed(), "Users not fined")
        page.clickLink1()
        LOGGER.info(page.getTextFromProfile())
        page.comeback(prop.getProperty("url4"))
        LOGGER.info(page.getText3())
        page.clickLink3()
        LOGGER.info(page.getTextFromProfile())
    }
}