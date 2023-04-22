import java.util.ArrayList;

public class Players {
    private ArrayList<Player> players;

    public Players() {
        this.players = new ArrayList<>();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public boolean tryAddPlayer(Player player) {
        if (checkPlayerNoExist(player.getNo()) < 0) {
            players.add(player);
            return true;
        }

        return false;
    }

    public boolean tryRemovePlayer(String name) {
        int playerIndex = checkPlayerNameExist(name);

        if (playerIndex >= 0) {
            players.remove(playerIndex);
            return true;
        }

        return false;
    }

    public int checkPlayerNameExist(String name) {
        for (int i = 0; i < players.size(); ++i) {
            Player player = players.get(i);
            if (player.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int checkPlayerNoExist(int no) {
        for (int i = 0; i < players.size(); ++i) {
            Player player = players.get(i);
            if (no == player.getNo()) {
                return i;
            }
        }
        return -1;
    }
}
