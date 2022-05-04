package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {

    //TODO: Test Garage class
    private Garage garage = new Garage();
    private Car porsche;
    private Car mercedes;
    private Car audi;

    @Before
    public void setUp(){
        this.garage = new Garage();
        porsche = new Car("Porsche", 300, 1200);
        mercedes = new Car("Mercedes", 220, 1100);
        audi = new Car("Audi", 200, 1000);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAdd(){
    garage.addCar(null);
    }
    @Test
    public void testAddCarSuccessfully(){
        garage.addCar(porsche);
        Assert.assertEquals(1, garage.getCount());
        garage.addCar(mercedes);
        Assert.assertEquals(2, garage.getCount());
    }
    @Test
    public void testGetCarsSuccessfully(){
        garage.addCar(porsche);
        List<Car> carsInGarage = garage.getCars();
        Assert.assertEquals(1, garage.getCount());
        Assert.assertEquals(porsche.getBrand(), carsInGarage.get(0).getBrand());
    }
    @Test
    public void testMaxSpeedAbove(){
        garage.addCar(porsche);
        garage.addCar(mercedes);
        garage.addCar(audi);
        List<Car> carsWithSpeedAbove = garage.findAllCarsWithMaxSpeedAbove(250);
        Assert.assertEquals(porsche.getBrand(), carsWithSpeedAbove.get(0).getBrand());
    }
    @Test
    public void testMostExpensiveCar(){
        garage.addCar(porsche);
        garage.addCar(mercedes);
        garage.addCar(audi);
        Car theMostExpensiveCar = garage.getTheMostExpensiveCar();
        Assert.assertEquals(porsche.getBrand(), theMostExpensiveCar.getBrand());

    }
    @Test
    public void testFindAllCarsByBrand(){
        garage.addCar(porsche);
        garage.addCar(porsche);
        garage.addCar(audi);
        List<Car> cars = garage.findAllCarsByBrand(porsche.getBrand());
        Assert.assertEquals(2, cars.size());
    }
}