import org.junit.Assert;
import org.junit.Test;

public class BattleshipGameTestSuite {

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
}
