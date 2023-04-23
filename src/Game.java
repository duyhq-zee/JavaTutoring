import java.util.ArrayList;

public class Game {
    private ArrayList<Team> teams;
    private String result;

    // result[0] = win; result[1] = lose
    private ArrayList<Team> results;
    public Integer term;

    public Game() {
        teams = new ArrayList<>();
        result = "";
        results = new ArrayList<>();
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public ArrayList<Team> getResults() {
        return results;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void playGame() {
        Team winTeam = null;
        Team loseTeam = null;

        if (teams.get(0).getAverageCredit() > teams.get(1).getAverageCredit()) {
            result = teams.get(0).getName() + " wins";
            winTeam = teams.get(0);
            loseTeam = teams.get(1);
        } else {
            result = teams.get(1).getName() + " wins";
            winTeam = teams.get(1);
            loseTeam = teams.get(0);
        }

        results.add(winTeam);
        results.add(loseTeam);

        float difference = winTeam.getAverageCredit() - loseTeam.getAverageCredit();

        winTeam.updateCredit(difference/5);
        loseTeam.updateCredit(-difference/5);
    }
}