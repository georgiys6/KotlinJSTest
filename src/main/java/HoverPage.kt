import BrowserFactory.Companion.driver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class HoverPage : PageObject() {
    private val user1 = By.xpath("//div[@id=\"content\"]/div/div[1]/img")
    private val user3 = By.xpath("//div[@id=\"content\"]/div/div[3]/img")
    private val name1 = By.xpath("//div/div[1]/div/h5")
    private val name3 = By.xpath("//div/div[3]/div/h5")
    private val link1 = By.xpath("//div[@id=\"content\"]/div/div[1]/div/a")
    private val link3 = By.xpath("//div[@id=\"content\"]/div/div[3]/div/a")
    private val textProfile = By.xpath("//h1")

    private val user1Element: WebElement = driver.findElement(user1)
    private val user3Element: WebElement = driver.findElement(user3)
    private val name1Element: WebElement = driver.findElement(name1)
    private val name3Element: WebElement = driver.findElement(name3)
    private val link1Element: WebElement = driver.findElement(link1)
    private val link3Element: WebElement = driver.findElement(link3)
    private lateinit var profileElement: WebElement


    fun getText1(): String {
        move(user1Element)
        return name1Element.text
    }


    fun getText3(): String {
        move(user3Element)
        return name3Element.text
    }

    fun clickLink1() {
        move(user1Element)
        link1Element.click()
    }

    fun clickLink3() {
        move(user3Element)
        link3Element.click()
    }

    fun getTextFromProfile(): String? {
        profileElement = driver.findElement(textProfile)
        return profileElement.text
    }

    fun comeback(url: String) {
        BrowserFactory.driver[url]
    }

    fun isDisplayed(): Boolean {
        return user1Element.isDisplayed && user3Element.isDisplayed
    }
}