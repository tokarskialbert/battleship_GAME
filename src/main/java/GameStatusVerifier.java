public class GameStatusVerifier {

    public boolean checkIfPlayerLost(Player player) {

        boolean ifGameOver = player.getShipSet().stream()
            .map(shipInterface -> shipInterface.getShipStatus())
            .allMatch(ship_status -> ship_status == SHIP_STATUS.SUNKEN);

        if(ifGameOver) {

            return true;
        } else {

            return false;
        }
    }
}

//tu jeszcze czyj jest ruch