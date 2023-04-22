import java.util.ArrayList;

public class Game {
    private Team team1;
    private Team team2;

    public Game() {

    }

    public Team getTeam(int i) {
        if (i == 1) {
            return team1;
        } else if (i == 2) {
            return team2;
        }

        return null;
    }

    public void setTeam(int i, Team team) {
        if (i == 1) {
            this.team1 = team;
        } else if (i == 2) {
            this.team2 = team;
        }
    }
}