import java.util.ArrayList;

public class Season {
    private ArrayList<Game> scheduledGames;
    private ArrayList<Team> currentTeamList;

    private ArrayList<Record> records;

    public Season() {
        currentTeamList = new ArrayList<>();
        scheduledGames = new ArrayList<>();
        records = new ArrayList<>();
    }

    public ArrayList<Team> getCurrentTeamList() {
        return currentTeamList;
    }

    public void setCurrentTeamList(ArrayList<Team> currentTeamList) {
        this.currentTeamList = currentTeamList;
    }

    public ArrayList<Game> getScheduledGames() {
        return scheduledGames;
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public int findTeamByName(String name) {
        for (int i = 0; i < currentTeamList.size(); ++i) {
            Team team = currentTeamList.get(i);

            if (team.getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }
}