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
        boolean validateResult = gameConfigurator.checkIfThereIsNoShipOnField(new Field(5,6), testPlayer);

        //then
        Assert.assertFalse(validateResult);
    }

    @Test
    public void testCheckIfFieldsAroundTheShipAreFree1() {
        //statek pionowy, weryfikacja pól wokół pierwszego pola

        //given
        GameConfigurator gameConfigurator = new GameConfigurator();
        Player testPlayer = new User();
        gameConfigurator.setTargetNumberOfShips(2);

        Field testField1 = new Field(2, 5);
        Field testField2 = new Field(3, 5);
        Field testField3 = new Field(4, 5);
        Ship testShip1 = new Ship(3, testField1, testField2, testField3);
        testShip1.setShipOrientation(ORIENTATION.VERTICAL);
        testPlayer.addShipToSet(testShip1);

        Field testField4 = new Field(5, 4);
        Field testField5 = new Field(6, 6);
        Field testField6 = new Field(7, 6);
        Ship testShip2 = new Ship(3, testField4, testField5, testField6);
        testShip2.setShipOrientation(ORIENTATION.VERTICAL);

        //when
        boolean validateResult = gameConfigurator.checkIfFieldsAroundTheShipAreFreeVERTICAL(testShip2, testPlayer);

        //then
        Assert.assertFalse(validateResult);
    }

    @Test
    public void testCheckIfFieldsAroundTheShipAreFree2() {
        //statek pionowy, weryfikacja pól wokół pól "wewnątrz" (bez pierwszego i ostatniego)

        //given
        GameConfigurator gameConfigurator = new GameConfigurator();
        Player testPlayer = new User();
        gameConfigurator.setTargetNumberOfShips(2);

        Field testField1 = new Field(4, 4);
        Ship testShip1 = new Ship(1, testField1);
        testShip1.setShipOrientation(ORIENTATION.HORIZONTAL);
        testPlayer.addShipToSet(testShip1);

        Field testField4 = new Field(2, 5);
        Field testField5 = new Field(3, 5);
        Field testField6 = new Field(4, 5);
        Field testField7 = new Field(5, 5);
        Ship testShip2 = new Ship(4, testField4, testField5, testField6, testField7);
        testShip2.setShipOrientation(ORIENTATION.VERTICAL);

        //when
        boolean validateResult = gameConfigurator.checkIfFieldsAroundTheShipAreFreeVERTICAL(testShip2, testPlayer);

        //then
        Assert.assertFalse(validateResult);
    }

    @Test
    public void testCheckIfFieldsAroundTheShipAreFree3() {
        //statek pionowy, weryfikacja pól wokół ostatniego pola

        //given
        GameConfigurator gameConfigurator = new GameConfigurator();
        Player testPlayer = new User();
        gameConfigurator.setTargetNumberOfShips(2);

        Field testField1 = new Field(5, 4);
        Ship testShip1 = new Ship(1, testField1);
        testShip1.setShipOrientation(ORIENTATION.HORIZONTAL);
        testPlayer.addShipToSet(testShip1);

        Field testField4 = new Field(2, 5);
        Field testField5 = new Field(3, 5);
        Field testField6 = new Field(4, 5);
        Field testField7 = new Field(5, 5);
        Ship testShip2 = new Ship(4, testField4, testField5, testField6, testField7);
        testShip2.setShipOrientation(ORIENTATION.VERTICAL);

        //when
        boolean validateResult = gameConfigurator.checkIfFieldsAroundTheShipAreFreeVERTICAL(testShip2, testPlayer);

        //then
        Assert.assertFalse(validateResult);
    }

    @Test
    public void testCheckIfFieldsAroundTheShipAreFree4() {
        //statek poziomy, weryfikacja pól od lewej strony

        //given
        GameConfigurator gameConfigurator = new GameConfigurator();
        Player testPlayer = new User();
        gameConfigurator.setTargetNumberOfShips(2);

        Field testField1 = new Field(5, 2);
        Ship testShip1 = new Ship(1, testField1);
        testShip1.setShipOrientation(ORIENTATION.HORIZONTAL);
        testPlayer.addShipToSet(testShip1);

        Field testField4 = new Field(6, 3);
        Field testField5 = new Field(6, 4);
        Field testField6 = new Field(6, 5);
        Field testField7 = new Field(6, 6);
        Ship testShip2 = new Ship(4, testField4, testField5, testField6, testField7);
        testShip2.setShipOrientation(ORIENTATION.HORIZONTAL);

        //when
        boolean validateResult = gameConfigurator.checkIfFieldsAroundTheShipAreFreeHORIZONTAL(testShip2, testPlayer);

        //then
        Assert.assertFalse(validateResult);
    }

    @Test
    public void testCheckIfFieldsAroundTheShipAreFree5() {
        //statek poziomy, weryfikacja pól "wewnątrz" (poza pierwszym i ostatnim)

        //given
        GameConfigurator gameConfigurator = new GameConfigurator();
        Player testPlayer = new User();
        gameConfigurator.setTargetNumberOfShips(2);

        Field testField1 = new Field(5, 4);
        Ship testShip1 = new Ship(1, testField1);
        testShip1.setShipOrientation(ORIENTATION.HORIZONTAL);
        testPlayer.addShipToSet(testShip1);

        Field testField4 = new Field(6, 2);
        Field testField5 = new Field(6, 3);
        Field testField6 = new Field(6, 4);
        Field testField7 = new Field(6, 5);
        Ship testShip2 = new Ship(4, testField4, testField5, testField6, testField7);
        testShip2.setShipOrientation(ORIENTATION.HORIZONTAL);

        //when
        boolean validateResult = gameConfigurator.checkIfFieldsAroundTheShipAreFreeHORIZONTAL(testShip2, testPlayer);

        //then
        Assert.assertFalse(validateResult);
    }

    @Test
    public void testCheckIfFieldsAroundTheShipAreFree6() {
        //statek poziomy, weryfikacja pól wokol ostatniego pola od lewej

        //given
        GameConfigurator gameConfigurator = new GameConfigurator();
        Player testPlayer = new User();
        gameConfigurator.setTargetNumberOfShips(2);

        Field testField1 = new Field(5, 4);
        Ship testShip1 = new Ship(1, testField1);
        testShip1.setShipOrientation(ORIENTATION.HORIZONTAL);
        testPlayer.addShipToSet(testShip1);

        Field testField4 = new Field(6, 1);
        Field testField5 = new Field(6, 2);
        Field testField6 = new Field(6, 3);
        Field testField7 = new Field(6, 4);
        Ship testShip2 = new Ship(4, testField4, testField5, testField6, testField7);
        testShip2.setShipOrientation(ORIENTATION.HORIZONTAL);

        //when
        boolean validateResult = gameConfigurator.checkIfFieldsAroundTheShipAreFreeHORIZONTAL(testShip2, testPlayer);

        //then
        Assert.assertFalse(validateResult);
    }

    @Test
    public void testCheckIfShipIsStraightVertical() {

        //given
        GameConfigurator gameConfigurator = new GameConfigurator();

        Field testField4 = new Field(1, 1);
        Field testField5 = new Field(2, 1);
        Field testField6 = new Field(3, 2);
        Field testField7 = new Field(4, 1);
        Ship testShip2 = new Ship(4, testField4, testField5, testField6, testField7);


        //when
        boolean validateResult = gameConfigurator.checkIfShipIsStraight(testShip2);

        //then
        Assert.assertFalse(validateResult);
    }

    @Test
    public void testCheckIfShipIsStraightHorizontal() {

        //given
        GameConfigurator gameConfigurator = new GameConfigurator();

        Field testField4 = new Field(2, 1);
        Field testField5 = new Field(1, 2);
        Field testField6 = new Field(1, 3);
        Field testField7 = new Field(1, 4);
        Ship testShip2 = new Ship(4, testField4, testField5, testField6, testField7);


        //when
        boolean validateResult = gameConfigurator.checkIfShipIsStraight(testShip2);

        //then
        Assert.assertFalse(validateResult);
    }
}
