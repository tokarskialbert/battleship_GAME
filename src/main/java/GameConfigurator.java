import java.util.Set;
import java.util.stream.Collectors;

public class GameConfigurator {

    //ustawiany przez checkbox
    private int targetNumberOfShips;

    public int getTargetNumberOfShips() {
        return targetNumberOfShips;
    }

    public void setTargetNumberOfShips(int targetNumberOfShips) {
        this.targetNumberOfShips = targetNumberOfShips;
    }

    public boolean checkIfShipCanBeAddedToSet(Player player) {

        if(player != null) {

            Set<ShipInterface> shipSet = player.getShipSet().stream()
                    .filter(shipInterface -> shipInterface.getMastNumber() == targetNumberOfShips)
                    .collect(Collectors.toSet());

            if (shipSet.size() < targetNumberOfShips) {

                return true;
            } else {

                return false;
            }
        } else {

            return false;
        }
    }
}
