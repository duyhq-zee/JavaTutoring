import java.util.Scanner;

public class Association {
    public static void main(String[] args) {
        Teams teams = new Teams();
        Season season = new Season();

        Team suns = new Team("Suns");
        teams.tryAddTeam(suns);
        suns.tryAddPlayer(new Player("Devin Booker", 2500, 26, 1));
        suns.tryAddPlayer(new Player("Chris Paul", 1500, 37, 3));
        suns.tryAddPlayer(new Player("Deandre Ayton", 2000, 24, 22));
        suns.tryAddPlayer(new Player("Kevin Durant", 3000, 34, 35));
        suns.tryAddPlayer(new Player("Terrence Ross", 1000, 32, 8));

        Team bulls = new Team("Bulls");
        teams.tryAddTeam(bulls);
        bulls.tryAddPlayer(new Player("Andre Drummond", 1500, 29, 3));
        bulls.tryAddPlayer(new Player("Zach LaVine", 3000, 28, 8));
        bulls.tryAddPlayer(new Player("Dalen Terry", 900, 20, 25));
        bulls.tryAddPlayer(new Player("Terry Taylor", 1000, 23, 32));
        bulls.tryAddPlayer(new Player("Carlik Jones", 800, 25, 22));

        Team hawks = new Team("Hawks");
        teams.tryAddTeam(hawks);
        hawks.tryAddPlayer(new Player("Trae Young", 2200, 24, 11));
        hawks.tryAddPlayer(new Player("John Collins", 2000, 25, 20));
        hawks.tryAddPlayer(new Player("Aaron Holiday", 800, 26, 3));
        hawks.tryAddPlayer(new Player("Jalen Johnson", 1000, 21, 1));
        hawks.tryAddPlayer(new Player("Trent Forrest", 1200, 24, 2));

        Team nets = new Team("Nets");
        teams.tryAddTeam(nets);
        nets.tryAddPlayer(new Player("Mikal Bridges", 2400, 26, 1));
        nets.tryAddPlayer(new Player("Ben Simmons", 2000, 26, 10));
        nets.tryAddPlayer(new Player("Patty Mills", 900, 34, 8));
        nets.tryAddPlayer(new Player("Joe Harris", 1200, 31, 12));
        nets.tryAddPlayer(new Player("Seth Curry", 1900, 32, 30));

        for (Team t: teams.getTeams()) {
            Team newT = new Team(t.getName(), t.getPlayers());
            season.getCurrentTeamList().add(newT);
        }

        while (true) {
            System.out.println("Welcome to the Association! Please make a selection from the menu:");
            System.out.println("1. Explore the teams.");
            System.out.println("2. Arrange a new season.");
            System.out.println("X. Exit the system.");

            char option = 0;
            System.out.print("Enter a choice: ");
            Scanner sc = new Scanner(System.in);
            option = sc.nextLine().charAt(0);

            switch (option) {
                case '1':
                    exploreTeamMenu(teams);
                    break;
                case '2':
                    exploreSeasonMenu(season);
                    break;
                case 'X':
                    System.out.println("Done");
                    return;

                default:
                    System.out.println("Please enter a number 1 or 2, or press X to exit.");
            }

        }

    }

    private static void exploreSeasonMenu(Season season) {
        int round = 0;
        int gameNo = 0;

        while (true) {
            System.out.println("Welcome to the season page! Please make a selection from the menu:");
            System.out.println("1. Add a team to the round.");
            System.out.println("2. Display the current round.");
            System.out.println("3. Play games.");
            System.out.println("4. Display the game result records.");
            System.out.println("R. Return to previous menu.");

            char option1 = 0;

            System.out.print("Enter a choice: ");
            Scanner sc = new Scanner(System.in);
            option1 = sc.nextLine().charAt(0);

            int currentGameIndex = 1;
            int currentPosition = 1;
            Game currentGame = new Game();

            switch (option1) {
                case '1':
                    while (!season.getCurrentTeamList().isEmpty()) {
                        System.out.println("The existing teams are as follows: ");
                        int i = 0;
                        for (Team team : season.getCurrentTeamList()) {
                            System.out.print(team.getName());
                            if (i < season.getCurrentTeamList().size() - 1) {
                                System.out.print(" ");
                            }
                            i++;
                        }

                        System.out.println();

                        int teamIndex = -1;
                        String teamName = "";

                        while (true) {
                            System.out.println("Please enter the team's name that you want to schedule: ");
                            sc = new Scanner(System.in);
                            teamName = sc.nextLine();

                            teamIndex = season.findTeamByName(teamName);

                            if (teamIndex < 0) {
                                System.out.println("No such team! Please try again");
                            } else {
                                break;
                            }
                        }


                        if (currentPosition == 1) {
                            currentGame = new Game();
                            Team team1 = season.getCurrentTeamList().get(teamIndex);
                            currentGame.addTeam(team1);
                            System.out.println("Team " + teamName + " has been added at the Game " + currentGameIndex + " position " + currentPosition);

                            currentPosition = 2;
                        } else {
                            Team team2 = season.getCurrentTeamList().get(teamIndex);
                            currentGame.addTeam(team2);
                            season.getScheduledGames().add(currentGame);
                            System.out.println("Team " + teamName + " has been added at the Game " + currentGameIndex + " position " + currentPosition);

                            currentPosition = 1;
                            currentGameIndex++;
                        }

                        season.getCurrentTeamList().remove(teamIndex);
                    }

                    break;
                case '2':
                    Utils.GameHeader();
                    for (Game g : season.getScheduledGames()) {
                        System.out.printf(Utils.GamesFormat, g.getTeams().get(0).getName(), " vs", g.getTeams().get(1).getName());
                    }
                    Utils.GameEnd();
                    break;
                case '3':
                    if (season.getScheduledGames().isEmpty()) {
                        System.out.println("No game in the current round, please add teams to the round first!");
                        break;
                    }

                    round++;
                    for (int i = 0; i < season.getScheduledGames().size(); ++i) {
                        Game g = season.getScheduledGames().get(i);
                        g.playGame();

                        Team winTeam = g.getResults().get(0);
                        Team loseTeam = g.getResults().get(1);

                        Record record = new Record(winTeam.getName(), loseTeam.getName(), i+1, round);
                        season.getRecords().add(record);

                        season.getCurrentTeamList().add(winTeam);
                    }

                    System.out.println("All games finished! You can press 4 to check the results.");
                    if (season.getScheduledGames().size() == 1) {
                        System.out.println("This season ends!");
                        int lastRecordIndex = season.getRecords().size() - 1;
                        System.out.println(season.getRecords().get(lastRecordIndex).getWinTeam() + " is the Champion!!");
                    }

                    season.getScheduledGames().clear();

                    break;
                case '4':
                    Utils.RecordHeader();
                    for (Record r: season.getRecords()) {
                        System.out.printf(Utils.RecordFormat, r.getRound(), r.getGameNo(), r.getWinTeam(), r.getLoseTeam());
                    }
                    Utils.RecordEnd();
                    break;
                case 'R':
                    break;
                default:
                    System.out.println("Please enter a valid input");
            }

            if (option1 == 'R') {
                break;
            }
        }
    }

    private static void exploreTeamMenu(Teams teams) {
        while (true) {
            System.out.println("Welcome to the Teams Page! Please make a selection from the menu:");
            System.out.println("1. Display all teams.");
            System.out.println("2. Display all players.");
            System.out.println("3. Add a new team.");
            System.out.println("4. Manage an existing team.");
            System.out.println("5. Delete an existing team.");
            System.out.println("6. Display all players by an level.");
            System.out.println("R. Return to previous menu.");

            char option1 = 0;

            System.out.print("Enter a choice: ");
            Scanner sc = new Scanner(System.in);
            option1 = sc.nextLine().charAt(0);

            switch (option1) {
                case '1':
                    Utils.teamsHeader();
                    for (Team team : teams.getTeams()) {
                        System.out.printf(Utils.teamsFormat, team.getName(), team.getPlayerList().size(), team.getAverageCredit(), team.getAverageAge());
                    }
                    Utils.teamTableEnd();
                    break;
                case '2':
                    Utils.DisplayPlayerFromAllTeamsHeader();
                    for (Team team : teams.getTeams()) {
                        for (Player player : team.getPlayerList()) {
                            System.out.printf(Utils.DisplayPlayerFromAllTeamsFormat, player.getName(), player.getCredit(), player.getLevel(), player.getAge(), player.getNo(), team.getName());
                        }
                        if (!team.getPlayerList().isEmpty()) Utils.DisplayPlayerFromAllTeamsEnd();
                    }
                    break;
                case '3':
                    System.out.print("Please enter the name of the team: ");
                    sc = new Scanner(System.in);
                    String teamName = sc.nextLine();

                    Team newTeam = new Team(teamName);

                    while (!teams.tryAddTeam(newTeam)) {
                        System.out.print("Team " + teamName + " already exist! Please enter a new name: ");
                        sc = new Scanner(System.in);
                        teamName = sc.nextLine();
                        newTeam = new Team(teamName);
                    }

                    System.out.println("Team " + teamName + " added!");

                    break;
                case '4':
                    System.out.print("Please enter the team's name that you want to manage: ");
                    sc = new Scanner(System.in);
                    String manageTeamName = sc.nextLine();

                    Team managingTeam = null;

                    for (Team team : teams.getTeams()) {
                        if (team.getName().equals(manageTeamName)) {
                            managingTeam = team;
                        }
                    }

                    if (teams.checkTeamNameExist(manageTeamName) < 0) {
                        System.out.println("Team does not exist!");
                        break;
                    }

                    System.out.println("Welcome to the " + manageTeamName + " 's Page! Please make a selection from the menu:");

                    manageTeamMenu(managingTeam);


                    break;
                case '5':
                    System.out.print("Please enter the team's name that you want to delete: ");
                    sc = new Scanner(System.in);
                    String deleteTeamName = sc.nextLine();

                    if (!teams.tryRemoveTeam(deleteTeamName)) {
                        System.out.println("Cannot found team " + deleteTeamName);
                    } else {
                        System.out.println("The team " + deleteTeamName + " has been deleted.");
                    }

                    break;
                case '6':
                    System.out.print("Please enter the player's level that you want to view: ");
                    sc = new Scanner(System.in);
                    String level = sc.nextLine();

                    if (!level.equals("Edge") &&
                            !level.equals("Common") &&
                            !level.equals("Core") &&
                            !level.equals("All Star")
                    ) {
                        while (true) {
                            System.out.print("No such level! Please re-enter the level: ");
                            sc = new Scanner(System.in);
                            level = sc.nextLine();

                            if (level.equals("Edge") ||
                                    level.equals("Common") ||
                                    level.equals("Core") ||
                                    level.equals("All Star")
                            ) {
                                break;
                            }
                        }
                    }

                    Utils.DisplayPlayerFromAllTeamsHeader();
                    for (Team team : teams.getTeams()) {
                        for (Player player : team.getPlayerList()) {
                            if (player.getLevel().equals(level)) {
                                System.out.printf(Utils.DisplayPlayerFromAllTeamsFormat, player.getName(), player.getCredit(), player.getLevel(), player.getAge(), player.getNo(), team.getName());
                            }
                        }
                    }
                    Utils.DisplayPlayerFromAllTeamsEnd();
                    break;
                case 'R':
                    break;
                default:
                    System.out.println("Please enter a valid input");
            }

            if (option1 == 'R') {
                break;
            }
        }
    }

    public static void manageTeamMenu(Team managingTeam) {
        while (true) {
            System.out.println("1. Display team's players.");
            System.out.println("2. Add a new player.");
            System.out.println("3. Update an existing player.");
            System.out.println("4. Delete an existing player.");
            System.out.println("R. Return to previous menu.");

            char option2 = 0;
            System.out.print("Enter a choice: ");
            Scanner sc = new Scanner(System.in);
            option2 = sc.nextLine().charAt(0);

            switch (option2) {
                case '1':
                    Utils.playerHeader();
                    for (Player player : managingTeam.getPlayerList()) {
                        System.out.printf(Utils.PlayerFormat, player.getName(), player.getCredit(), player.getLevel(), player.getNo(), player.getAge());
                    }
                    Utils.playerTableEnd();

                    break;
                case '2':

                    System.out.print("Please enter the player's name: ");
                    sc = new Scanner(System.in);
                    String name = sc.nextLine();

                    System.out.print("Please enter the player's credit: ");
                    sc = new Scanner(System.in);
                    float credit = sc.nextFloat();

                    System.out.print("Please enter the player's age: ");
                    sc = new Scanner(System.in);
                    int age = sc.nextInt();

                    System.out.print("Please enter the player's No: ");
                    sc = new Scanner(System.in);
                    int no = sc.nextInt();

                    Player newPlayer = new Player(name, credit, age, no);

                    while (!managingTeam.tryAddPlayer(newPlayer)) {
                        int existedPlayerIndex = managingTeam.checkPlayerNoExist(newPlayer.getNo());
                        String existedPlayerName = managingTeam.getPlayerList().get(existedPlayerIndex).getName();

                        System.out.print("This No has been occupied by: " + existedPlayerName + ". Please re-enter the No: ");
                        sc = new Scanner(System.in);
                        no = sc.nextInt();
                        newPlayer = new Player(name, credit, age, no);
                    }

                    System.out.println("Player " + name + " added!");


                    break;
                case '3':
                    System.out.print("Please enter the player's name: ");
                    sc = new Scanner(System.in);
                    String updatePlayerName = sc.nextLine();

                    boolean hasUpdatedPlayer = false;

                    int playerIndex = managingTeam.checkPlayerNameExist(updatePlayerName);

                    if (playerIndex < 0) {
                        System.out.println("Player does not exist.");
                        break;
                    }

                    Player updatingPlayer = managingTeam.getPlayerList().get(playerIndex);

                    System.out.print("Please enter name: ");
                    sc = new Scanner(System.in);
                    String newName = sc.nextLine();
                    updatingPlayer.setName(newName);

                    System.out.print("Please enter credit: ");
                    sc = new Scanner(System.in);
                    float newCredit = sc.nextFloat();
                    updatingPlayer.setCredit(newCredit);

                    System.out.print("Please enter age: ");
                    sc = new Scanner(System.in);
                    int newAge = sc.nextInt();
                    updatingPlayer.setAge(newAge);

                    System.out.print("Please enter No: ");
                    sc = new Scanner(System.in);
                    int newNo = sc.nextInt();

                    while (newNo != updatingPlayer.getNo() && managingTeam.checkPlayerNoExist(newNo) >= 0) {
                        int existedPlayerIndex = managingTeam.checkPlayerNoExist(newNo);
                        String existedPlayerName = managingTeam.getPlayerList().get(existedPlayerIndex).getName();

                        System.out.print("This No has been occupied by: " + existedPlayerName + ". Please re-enter the No: ");
                        sc = new Scanner(System.in);
                        newNo = sc.nextInt();
                    }

                    updatingPlayer.setNo(newNo);

                    System.out.println("Player information updated!");
                    break;
                case '4':
                    System.out.print("Please enter the player's name: ");
                    sc = new Scanner(System.in);
                    String deletePlayerName = sc.nextLine();

                    if (!managingTeam.tryRemovePlayer(deletePlayerName)) {
                        System.out.println("Player does not exist.");
                    } else {
                        System.out.println("Player deleted.");
                    }
                    break;
                case 'R':
                    break;
                default:
                    System.out.println("Please enter a valid input");
            }

            if (option2 == 'R') {
                break;
            }
        }
    }
}