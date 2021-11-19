package tests;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "User data")
    public static Object[][] userData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "Sauce Labs Bolt T-Shirt", "$16.99"},
                {"problem_user", "secret_sauce", "Sauce Labs Backpack", "$29.99"},
        };
    }
}
