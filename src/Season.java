import java.util.ArrayList;

public class Season {
    private ArrayList<Game> scheduledGames;
    private Teams currentTeams;

    private ArrayList<Record> records;

    public Season() {
        scheduledGames = new ArrayList<>();
        records = new ArrayList<>();
    }

    public Teams getCurrentTeams() {
        return currentTeams;
    }

    public void setCurrentTeams(Teams currentTeams) {
        this.currentTeams = currentTeams;
    }

    public ArrayList<Game> getScheduledGames() {
        return scheduledGames;
    }

    public ArrayList<Record> getRecords() {
        return records;
    }
}