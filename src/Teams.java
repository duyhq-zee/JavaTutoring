import java.util.ArrayList;

public class Teams {
    private ArrayList<Team> teams;

    public Teams() {
        this.teams = new ArrayList<>();
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public boolean tryAddTeam(Team team) {
        if (checkTeamNameExist(team.getName()) < 0) {
            teams.add(team);
            return true;
        }

        return false;
    }

    public boolean tryRemoveTeam(String name) {
        int teamIndex = checkTeamNameExist(name);

        if (teamIndex >= 0) {
            teams.remove(teamIndex);
            return true;
        }

        return false;
    }

    public int checkTeamNameExist(String name) {
        for (int i = 0; i < teams.size(); ++i) {
            Team team = teams.get(i);

            if (team.getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }
}
