import org.junit.Assert;
import org.junit.Test;

public class BattleshipGameTestSuite {

    @Test
    public void testCompareFields() {

        //given
        Field field1 = new Field(1,2);
        Field field2 = new Field(1, 2);

        //when
        boolean validateResult = field1.equals(field2);

        //then
        Assert.assertTrue(validateResult);
    }

    @Test
    public void testDamageShip() {

        //given
        ShipInterface ship = new Ship(2);

        //when
        ship.damageShip();

        //then
        Assert.assertTrue(ship.getMastNumber() == 1);
    }

    @Test
    public void testDamageShipSUNKEN() {

        //given
        ShipInterface ship = new Ship(1);

        //when
        ship.damageShip();

        //then
        Assert.assertTrue(ship.getShip_status().equals(SHIP_STATUS.SUNKEN));

    }

    @Test
    public void testCompareShips() {

        //given
        Field[] field = new Field[1];
            field[0] = new Field(2, 4);

        Field[] field2 = new Field[1];
            field2[0] = new Field(4, 2);

        //when
        ShipInterface ship = new Ship(1, field);
        ShipInterface ship2 = new Ship(1, field2);

        //then
        Assert.assertFalse(ship.equals(ship2));
    }

    @Test
    public void testCheckIfShipCanBeAddedToSet() {

        //given
        GameConfigurator gameConfigurator = new GameConfigurator();
        Player testPlayer = new User();
        Field testField = new Field(2, 3);
        ShipInterface testShip = new Ship(1, testField);
        testPlayer.addShipToSet(testShip);

        //when
        gameConfigurator.setTargetNumberOfShips(1);
        boolean validateResult = gameConfigurator.checkIfShipCanBeAddedToSet(testPlayer);

        //then
        Assert.assertFalse(validateResult);
    }

    @Test
    public void testCheckIfShipCanBeAddedToSet2() {

        //given
        GameConfigurator gameConfigurator = new GameConfigurator();
        Player testPlayer = new User();

        Field testField1 = new Field(2, 3);
        Field testField2 = new Field(2, 4);
        ShipInterface testShip1 = new Ship(2, testField1, testField2);

        Field testField3 = new Field(5, 5);
        Field testField4 = new Field(5, 6);
        ShipInterface testShip2 = new Ship(2, testField3, testField4);

        testPlayer.addShipToSet(testShip1);
        testPlayer.addShipToSet(testShip2);

        //when
        gameConfigurator.setTargetNumberOfShips(3);
        boolean validateResult = gameConfigurator.checkIfShipCanBeAddedToSet(testPlayer);

        //then
        Assert.assertTrue(validateResult);
    }

    @Test
    public void testCheckIfCorrectNumberOfFields() {

        //given
        GameConfigurator gameConfigurator = new GameConfigurator();
        gameConfigurator.setTargetNumberOfFields(3);

        Field[] field = new Field[3];
            field[0] = new Field(1, 1);
            field[1] = new Field(1, 2);
            field[2] = new Field(1, 3);

        //when
        boolean validateResult = gameConfigurator.checkIfCorrectNumberOfFields(field);

        //then
        Assert.assertTrue(validateResult);
    }

    @Test
    public void testCheckIfFieldIsAvailable() {

        //given
        GameConfigurator gameConfigurator = new GameConfigurator();
        Player testPlayer = new User();

        Field testField1 = new Field(2, 3);
        Field testField2 = new Field(2, 4);
        Field testField3 = new Field(2, 5);
        ShipInterface testShip1 = new Ship(3, testField1, testField2, testField3);

        Field testField4 = new Field(5, 5);
        Field testField5 = new Field(5, 6);
        Field testField6 = new Field(5, 7);
        ShipInterface testShip2 = new Ship(2, testField4, testField5, testField6);

        testPlayer.addShipToSet(testShip1);
        testPlayer.addShipToSet(testShip2);

        //when
        boolean validateResult = gameConfigurator.checkIfFieldIsAvailable(new Field(5,6), testPlayer);

        //then
        Assert.assertFalse(validateResult);
    }
}
