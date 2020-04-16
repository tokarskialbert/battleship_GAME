public class Game {

    public boolean checkIfThereIsShipOnFiled(Player player, Field field){

        return player.getShipSet().stream()
                .flatMap(shipInterface -> shipInterface.getFieldList().stream())
                .anyMatch(i -> i.equals(field));
    }

    public void addMissedFieldToSet(Player player, Field field) {

        if(!(checkIfThereIsShipOnFiled(player, field))) {

            player.getMissedFieldsByOpponentSet().add(field);
        }
    }
}
