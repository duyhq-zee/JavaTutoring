import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> playerList;

    public Team(String name) {
        this.name = name;
        this.playerList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public void addPlayer(Player player) {
        this.playerList.add(player);
    }
}
