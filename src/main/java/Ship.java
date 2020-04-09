import java.util.HashSet;
import java.util.Set;

public class Ship implements ShipInterface {

    private SHIP_STATUS ship_status = SHIP_STATUS.UNDAMAGED;
    private int mastNumber;
    private Set<Field> fieldSet = new HashSet<>();

    public Ship(int mastNumber, Field... fields) {

        this.mastNumber = mastNumber;
        addFieldToSet(fields);
    }

    @Override
    public void addFieldToSet(Field[] fields) {

        for(Field field : fields) {

            this.fieldSet.add(field);
        }
    }

    @Override
    public void damageShip() {

        mastNumber --;

        if(mastNumber == 0) {

            ship_status = SHIP_STATUS.SUNKEN;
        } else {

            ship_status = SHIP_STATUS.DAMAGED;
        }
    }

    @Override
    public int getMastNumber() {
        return mastNumber;
    }

    @Override
    public void setMastNumber(int mastNumber) {
        this.mastNumber = mastNumber;
    }

    @Override
    public SHIP_STATUS getShip_status() {
        return ship_status;
    }

    @Override
    public void setShip_status(SHIP_STATUS ship_status) {
        this.ship_status = ship_status;
    }
}

