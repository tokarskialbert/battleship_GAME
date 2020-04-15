import java.util.*;

public class Ship implements ShipInterface {

    private ORIENTATION shipOrientation;
    private SHIP_STATUS ship_status = SHIP_STATUS.UNDAMAGED;
    private int mastNumber;
    private List<Field> fieldList = new ArrayList<Field>();

    public Ship(int mastNumber, Field... fields) {

        this.mastNumber = mastNumber;
        addFieldToList(fields);
    }

    @Override
    public void addFieldToList(Field[] fields) {

        for(Field field : fields) {

            this.fieldList.add(field);
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

    @Override
    public List<Field> getFieldList() {
        return fieldList;
    }

    @Override
    public void setShipOrientation(ORIENTATION shipOrientation) {
        this.shipOrientation = shipOrientation;
    }

    public ORIENTATION getShipOrientation() {
        return shipOrientation;
    }
}

