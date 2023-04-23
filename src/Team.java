import java.util.ArrayList;

public class Team {
    private String name;
    private Players players;

    public Team(String name) {
        this.name = name;
        this.players = new Players();
    }

    public Team(String name, Players players) {
        this.name = name;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Players getPlayers() {
        return players;
    }

    public ArrayList<Player> getPlayerList() {
        return players.getPlayers();
    }

    public float getAverageCredit() {
        float sumCredit = 0;
        for (Player player : players.getPlayers()) {
            sumCredit += player.getCredit();
        }
        return sumCredit / players.getPlayers().size();
    }

    public float getAverageAge() {
        float sumAge = 0;
        for (Player player : players.getPlayers()) {
            sumAge += player.getAge();
        }
        return sumAge / players.getPlayers().size();
    }

    public int checkPlayerNameExist(String name) {
        return players.checkPlayerNameExist(name);
    }

    public int checkPlayerNoExist(int no) {
        return players.checkPlayerNoExist(no);
    }

    public boolean tryAddPlayer(Player player) {
        return players.tryAddPlayer(player);
    }

    public boolean tryRemovePlayer (String name) {
        return players.tryRemovePlayer(name);
    }

    public void updateCredit(float amount) {
        for (Player p: players.getPlayers()) {
            p.setCredit(p.getCredit() + amount);
        }
    }
}
