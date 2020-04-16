import java.util.Set;

public interface Player {

    void addShipToSet(ShipInterface shipInterface);
    Set<ShipInterface> getShipSet();
    Set<Field> getMissedFieldsByOpponentSet();


}
