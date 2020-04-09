import java.util.HashSet;
import java.util.Set;

public class Computer implements Player {

    private Set<ShipInterface> computerShipSet = new HashSet<>();

    @Override
    public void addShipToSet(ShipInterface shipInterface) {

        this.computerShipSet.add(shipInterface);
    }
}
