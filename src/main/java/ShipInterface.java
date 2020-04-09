import java.util.List;

public interface ShipInterface {

    void damageShip();
    int getMastNumber();
    void setMastNumber(int mastNumber);
    SHIP_STATUS getShip_status();
    void setShip_status(SHIP_STATUS ship_status);
    void addFieldToSet(Field[] fields);
}
