import java.util.HashSet;
import java.util.Set;

public class Computer implements Player {

    private Set<ShipInterface> computerShipSet = new HashSet<>();
    private Set<Field> missedFieldsByOpponentSet = new HashSet<>(); //pudła gracza

    @Override
    public void addShipToSet(ShipInterface shipInterface) {

        this.computerShipSet.add(shipInterface);
    }

    @Override
    public Set<ShipInterface> getShipSet() {
        return this.computerShipSet;
    }

    @Override
    public Set<Field> getMissedFieldsByOpponentSet() {
        return this.missedFieldsByOpponentSet;
    }
}
