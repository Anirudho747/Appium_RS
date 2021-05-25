package QAATMTNFRMWRK;

public class AppiumLibrary {

//    private AppiumDriver driver;
//    private Device device;
//
//    private ElementLocator elementLocator = new ElementLocator();
//    private LogUtility logUtility = new LogUtility(AppiumLibrary.class);
//
//    public AppiumLibrary(SessionManager sessionManager) {
//        this.driver = sessionManager.getDriver();
//        this.device = sessionManager.getCurrentTestDevice();
//        this.logUtility.setExtentLogger(sessionManager.getExtentReporter().getExtentlogger());
//    }
//
//    /*
//        Element related helper methods
//     */
//
//    public void clickOnMobileElement(CubiiMobileBy locator) {
//        isElementPresent(locator, 60);
//        MobileElement element = getMobileElement(locator);
//        element.click();
//    }
//
//    public void clickOnMobileElement(String locator) {
//        isElementPresent(locator, 60);
//        MobileElement element = getMobileElement(locator);
//        element.click();
//    }
//
//    public void clickOnMobileElement(MobileElement mobileElement) {
//        mobileElement.click();
//    }
//
//    public void clickOnMobileElementIfPresent(CubiiMobileBy locator) {
//        if (isElementPresent(locator, 7)) {
//            logUtility.logInfo("Element " + locator.getMobileBy(driver).toString() + " present and clicking on it.");
//            MobileElement element = getMobileElement(locator);
//            element.click();
//        } else {
//            logUtility.logWarning("Element " + locator.toString() + " not present so not clicking on it.");
//        }
//    }
//
//    public void clickOnMobileElementIfPresent(String locator) {
//        if (isElementPresent(locator, 7)) {
//            logUtility.logInfo("Element " + locator.toString() + " present and clicking on it.");
//            MobileElement element = getMobileElement(locator);
//            element.click();
//        } else {
//            logUtility.logWarning("Element " + locator.toString() + " not present so not clicking on it.");
//        }
//    }
//
//    public boolean isElementPresent(CubiiMobileBy locator, int timeout) {
//        boolean found = false;
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, timeout);
//            //for ios presenceOfElementLocated is more reliable than visibilityOfElementLocated
//            wait.until(ExpectedConditions.presenceOfElementLocated(locator.getMobileBy(driver)));
//            found = true;
//        } catch (TimeoutException timeoutException) {
//            logUtility.logWarning(ExceptionUtils.getStackTrace(timeoutException));
//        }
//        return found;
//    }
//
//    public boolean isElementPresent(String locator, int timeout) {
//        boolean found = false;
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, timeout);
//            wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator.elements(locator)));
//            found = true;
//        } catch (TimeoutException timeoutException) {
//            logUtility.logWarning(ExceptionUtils.getStackTrace(timeoutException));
//        }
//        return found;
//    }
//
//    public String getAttribute(CubiiMobileBy locator, String attribute) {
//        return getMobileElement(locator).getAttribute(attribute);
//    }
//
//    public String getAttribute(String locator, String attribute) {
//        return getMobileElement(locator).getAttribute(attribute);
//    }
//    
//    public String getCSSValue(CubiiMobileBy locator, String Val) {
//        return getMobileElement(locator).getCssValue(Val);
//    }
//
//    public String getCSSValue(String locator, String Val) {
//        return getMobileElement(locator).getCssValue(Val);
//    }
//
//
//    public String getText(CubiiMobileBy locator) {
//        if(driver instanceof AndroidDriver) {
//            return getAttribute(locator, "text");
//        }
//        else {
//            return getAttribute(locator, "value");
//        }
//    }
//
//    public String getText(String locator) {
//        return getAttribute(locator, "text");
//    }
//
//    public String getText(MobileElement element) {
//        return element.getAttribute("text");
//    }
//
//    public String getValue(CubiiMobileBy locator) {
//        return getAttribute(locator, "value");
//    }
//
//    public String getValue(String locator) {
//        return getAttribute(locator, "value");
//    }
//
//    public boolean areElementsPresent(CubiiMobileBy locator, int timeout) {
//        boolean found = false;
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, timeout);
//            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator.getMobileBy(driver)));
//            found = true;
//        } catch (TimeoutException timeoutException) {
//            logUtility.logWarning("Element " + locator + " not present.");
//            logUtility.logWarning(ExceptionUtils.getStackTrace(timeoutException));
//        }
//        return found;
//    }
//
//    public MobileElement getMobileElement(CubiiMobileBy locator) {
//        isElementPresent(locator, 60);
//        return (MobileElement) driver.findElement(locator.getMobileBy(driver));
//    }
//
//    public MobileElement getMobileElement(String locator) {
//        isElementPresent(locator, 60);
//        return (MobileElement) driver.findElement(elementLocator.elements(locator));
//    }
//
//    public List<MobileElement> getListOfMobileElements(CubiiMobileBy locator) {
//        areElementsPresent(locator, 10);
//        return driver.findElements(locator.getMobileBy(driver));
//    }
//
//    public MobileElement scrollToElement(CubiiMobileBy locator) {
//        int retryCount = 0;
//        MobileElement element = null;
//        while (retryCount < 15) {
//            if(!isElementPresent(locator, 10)) {
//                scrollDownHalfScreen();
//                retryCount++;
//            }
//            else {
//                element = getMobileElement(locator);
//                break;
//            }
//        }
//        Assert.assertNotNull(element);
//        return element;
//    }
//    public MobileElement bringElementToTop(CubiiMobileBy locator) {
//        MobileElement element = getMobileElement(locator);
//        scroll(element.getCenter().getX(), element.getLocation().getY(), element.getCenter().getX(), 80);
//        return element;
//    }
//
//    public boolean isElementTextCorrect(CubiiMobileBy mobileBy, String expectedText) {
//        boolean result = false;
//        if(isElementPresent(mobileBy, 10)) {
//            MobileElement element = getMobileElement(mobileBy);
//            result = element.getText().equals(expectedText);
//        }
//        else {
//            Assert.fail("Element " + mobileBy.toString() + " not present.");
//        }
//        return result;
//    }
//
//    /*
//        Keyboard related helper methods
//     */
//
//    public void hideKeyboard() {
//        if (TestConfiguration.getPlatformOs().equalsIgnoreCase("android")) {
//            driver.hideKeyboard();
//        }
//        else {
//            clickOnMobileElement(new CubiiMobileBy(MobileBy.xpath("//XCUIElementTypeButton[@name='Done']")));
//        }
//    }
//
//    public void pressSearchOnKeyboard() {
//        if (EnvironmentParameters.getPlatformOs().equalsIgnoreCase("android")) {
//            driver.getKeyboard().pressKey(Keys.ENTER);
//        }
//        else {
//            clickOnMobileElement(new CubiiMobileBy(MobileBy.AccessibilityId("Search")));
//        }
//    }
//
//    public void pressKeyOnKeypad(String keys) {
//        driver.getKeyboard().pressKey(keys);
//    }
//
//    public void pressBack() {
//        driver.navigate().back();
//    }
//
//    public void enterText(CubiiMobileBy locator, String text) {
//        clickOnMobileElement(locator);
//        getMobileElement(locator).clear();
//        getMobileElement(locator).sendKeys(text);
//        hideKeyboard();
//    }
//
//    public void enterText(CubiiMobileBy locator, int integer) {
//        clickOnMobileElement(locator);
//        getMobileElement(locator).sendKeys(String.valueOf(integer));
//        hideKeyboard();
//    }
//
//    public void sendKeysTo(CubiiMobileBy locator, String text) {
//        clickOnMobileElement(locator);
//        getMobileElement(locator).sendKeys(text);
//    }
//
//
//    public String getTextOfElement(CubiiMobileBy locator) {
//        return getMobileElement(locator).getAttribute("text");
//    }
//
//    public void tapOnCentreOfScreen() {
//        TouchAction action = new TouchAction(driver);
//        int startX = getScreenWidth() / 2;
//        int startY = getScreenHeight() / 2;
//        action.tap(PointOption.point(startX, startY)).perform();
//    }
//
//    public void tapOnCoordinates(int x, int y) {
//        TouchAction action = new TouchAction(driver);
//        action.tap(PointOption.point(x, y)).perform();
//    }
//
//    public void scroll(int startX, int startY, int endX, int endY) {
//        TouchAction action = new TouchAction(driver);
//        action.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
//    }
//
//    public void scrollUpFullScreen() {
//        int startX = getScreenWidth() / 2;
//        int startY = driver.manage().window().getSize().height /2;
//        int endY = driver.manage().window().getSize().height * 8/9;
//        scroll(startX, startY, startX, endY);
//    }
//
//    public void scrollDownFullScreen() {
//        int startX = getScreenWidth() / 2;
//        int startY = getScreenHeight() * 8/9;
//        int endY = getScreenHeight() / 9;
//        scroll(startX, startY, startX, endY);
//    }
//
//    public void scrollUpHalfScreen() {
//        int startX = getScreenWidth() / 2;
//        int startY = driver.manage().window().getSize().height /2;
//        int endY = driver.manage().window().getSize().height * 7/9;
//        scroll(startX, startY, startX, endY);
//    }
//
//    public void scrollDownHalfScreen() {
//        int startX = getScreenWidth() / 2;
//        int startY = driver.manage().window().getSize().height * 7/9;
//        int endY = driver.manage().window().getSize().height /2;
//        scroll(startX, startY, startX, endY);
//    }
//
//    public void scrollUpALittle() {
//        int startX = getScreenWidth() / 2;
//        int startY = getScreenHeight() * 2/3;
//        int endY = getScreenHeight() * 8/9;
//        scroll(startX, startY, startX, endY);
//    }
//
//    public void scrollDownALittle() {
//        int startX = getScreenWidth() / 2;
//        int startY = getScreenHeight() * 8/9;
//        int endY = getScreenHeight() * 2/3;
//        scroll(startX, startY, startX, endY);
//    }
//
//    public void swipeToRefresh() {
//        int startX  = getScreenWidth() / 2;
//        int endY = getScreenHeight() * 3/5;
//        int startY = getScreenHeight() /2;
//        scroll(startX, startY, startX, endY);
//    }
//
//    public void swipeToRefreshFromMiddle() {
//        int endY;
//        if (EnvironmentParameters.getPlatformOs().equalsIgnoreCase("android")) {
//            endY = getScreenHeight() * 3/5;
//        } else {
//            endY = getScreenHeight() * 4/5;
//        }
//        int startY = getScreenHeight() /3;
//        int startX = getScreenWidth() /2;
//
//        scroll(startX, startY, startX, endY);
//    }
//
//    public void swipeUpOnElementFromItsCenter(CubiiMobileBy locator, int offest) {
//        MobileElement element = getMobileElement(locator);
//        int startX = element.getCenter().getX();
//        int startY = element.getCenter().getY();
//        int endY = startY - offest;
//        scroll(startX, startY, startX, endY);
//    }
//
//    public void swipeDownOnElementFromItsCenter(CubiiMobileBy locator, int offest) {
//        MobileElement element = getMobileElement(locator);
//        int startX = element.getCenter().getX();
//        int startY = element.getCenter().getY();
//        int endY = startY + offest;
//        scroll(startX, startY, startX, endY);
//    }
//
//    public void swipeLeftOnElementFromItsCenter(CubiiMobileBy locator) {
//        MobileElement element = getMobileElement(locator);
//        int startX = element.getCenter().getX();
//        int startY = (element.getCenter().getY())-200;
//        int endX = 20;
//        scroll(startX, startY, endX, startY);
//    }
//
//    public void swipeLeftOnElementFromItsRightMostPoint(CubiiMobileBy locator) {
//        MobileElement element = getMobileElement(locator);
//        int startX = element.getLocation().getX() + element.getSize().getWidth() - 60;
//        int startY = element.getCenter().getY();
//        int endX = 40;
//        scroll(startX, startY, endX, startY);
//    }
//
//    public void swipeRightOnElementFromItsCenter(CubiiMobileBy locator) {
//        MobileElement element = getMobileElement(locator);
//        int startX = element.getCenter().getX();
//        int startY = element.getCenter().getY();
//        int endX = getScreenWidth() - 20;
//        scroll(startX, startY, endX, startY);
//    }
//
//    public void swipeRightOnElementFromItsLeftMostPoint(CubiiMobileBy locator) {
//        MobileElement element = getMobileElement(locator);
//        int startX = element.getLocation().getX() + 60;
//        int startY = element.getCenter().getY();
//        int endX = getScreenWidth() - 20;
//        scroll(startX, startY, endX, startY);
//    }
//
//    public int getScreenWidth() {
//        return driver.manage().window().getSize().width;
//    }
//
//    public int getScreenHeight() {
//        return driver.manage().window().getSize().height;
//    }
//
//    public void terminateApp(String packageName) {
//        driver.terminateApp(packageName);
//    }
//
//    public void activateApp(String packageName) {
//        driver.activateApp(packageName);
//    }
//
//    public void resetApp() {
//        driver.resetApp();
//    }
//
//    public CubiiMobileBy getDynamicMobileBy(CubiiMobileBy by,String ...strReplace) {
//        By mobileBy = by.getMobileBy(driver);
//        {
//            int wildCardCount;
//            int countOfStringArguments = strReplace.length;
//            String byType;
//            String locatorString;
//            try {
//                locatorString = mobileBy.toString();
//                wildCardCount = strReplace.length;
//                if (wildCardCount == countOfStringArguments) {
//                    locatorString = String.format(locatorString, strReplace).split("\\.",2)[1].trim();
//                    byType = locatorString.split(":",2)[0].trim();
//                    locatorString = locatorString.split(":",2)[1].trim();
//                    mobileBy =(By) By.class.getMethod(byType, java.lang.String.class).invoke(null, locatorString);
//                } else {
//                    System.out.println("No of wild cards and No of strings passed in argument not matched");
//                }
//            } catch (Exception e) {
//                logUtility.logException(ExceptionUtils.getStackTrace(e));
//            }
//            //a hack to return CubiiMobileBy object because we cannot cast it to By
//            return new CubiiMobileBy(mobileBy);
//        }
//    }
//
//    public void toggleWifi() {
//    	((AndroidDriver)driver).toggleWifi();	
//    }
//    
//    public void disableData() {
//    	
//    	ConnectionState state = ((AndroidDriver)driver).setConnection(new ConnectionStateBuilder().withDataDisabled().build());
//    }
//    
//    public void enableData() {
//    	
//    	ConnectionState state = ((AndroidDriver)driver).setConnection(new ConnectionStateBuilder().withDataEnabled().build());
//    }
//
//    public boolean isElementSelected(CubiiMobileBy locator) {
//        isElementPresent(locator, 60);
//        MobileElement element = getMobileElement(locator);
//        return element.isSelected();
//    }
//    
//    public boolean isElementEnabled(CubiiMobileBy locator){
//        isElementPresent(locator, 60);
//        MobileElement element = getMobileElement(locator);
//        return element.isEnabled();
//    }
//
//    public void refresh()
//    {
//    	driver.navigate().refresh();
//    }
}

