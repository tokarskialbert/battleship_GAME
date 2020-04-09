import java.util.HashSet;
import java.util.Set;

public class User implements Player {

    private Set<ShipInterface> userShipSet = new HashSet<>();

    @Override
    public void addShipToSet(ShipInterface shipInterface) {

        this.userShipSet.add(shipInterface);
    }

    @Override
    public Set<ShipInterface> getShipSet() {
        return this.userShipSet;
    }
}
