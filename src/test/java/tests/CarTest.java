package tests;

import lombok.extern.log4j.Log4j2;
import objects.Car;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class CarTest{

    @Test
    public void carComparisonTest() {
        Car car1 = new Car();
        car1.setMake("tesla");
        car1.setModel("model S");
        Car car2 = new Car();
        car2.setMake("tesla");
        car2.setModel("model X");
        car2.setSpeed(100);
        Car car3 = new Car("bmw", "3", 200, 5);
        Assert.assertEquals(car1.getModel(), car2.getModel());
    }

    @Test
    public void carComparison2Test() {
        objects.Car car1 = Car.builder()
                .make("bmw")
                .model("5")
                .build();
        Car car2 = Car.builder()
                .make("tesla")
                .model("model S")
                .speed(200)
                .build();
    }

    @Test
    public void loggerTest() {
        log.fatal("fatal");
        log.error("error");
        log.warn("warn");
        log.info("info");
        log.debug("debug");
        log.trace("trace");
    }

    //equals
    //hashcode
    //toString
}
