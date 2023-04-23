public class Record {
    private String WinTeam;
    private String LoseTeam;
    private Integer GameNo;
    private Integer Round;

    public Record(String winTeam, String loseTeam, Integer gameNo, Integer round) {
        WinTeam = winTeam;
        LoseTeam = loseTeam;
        GameNo = gameNo;
        Round = round;
    }

    public String getWinTeam() {
        return WinTeam;
    }

    public void setWinTeam(String winTeam) {
        WinTeam = winTeam;
    }

    public String getLoseTeam() {
        return LoseTeam;
    }

    public void setLoseTeam(String loseTeam) {
        LoseTeam = loseTeam;
    }

    public Integer getGameNo() {
        return GameNo;
    }

    public void setGameNo(Integer gameNo) {
        GameNo = gameNo;
    }

    public Integer getRound() {
        return Round;
    }

    public void setRound(Integer round) {
        Round = round;
    }
}