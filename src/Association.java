import java.util.ArrayList;
import java.util.Scanner;

public class Association {
    public static void main(String[] args) {
        Teams teams = new Teams();

        Team suns = new Team("Suns");
        teams.tryAddTeam(suns);
        suns.tryAddPlayer(new Player("A", 1000, 30, 7));
        suns.tryAddPlayer(new Player("B", 2000, 32, 10));


        Team bulls = new Team("Bulls");
        teams.tryAddTeam(bulls);
        bulls.tryAddPlayer(new Player("C", 1000, 30, 7));
        bulls.tryAddPlayer(new Player("D", 2000, 32, 10));

        teams.tryAddTeam(new Team("Hawks"));

        while (true) {
            System.out.println("1. Explore the teams");
            System.out.println("2. Arrange new season");
            System.out.println("X. Exit the system");

            char option = 0;
            System.out.print("Enter a choice: ");
            Scanner sc = new Scanner(System.in);
            option = sc.nextLine().charAt(0);

            switch (option) {
                case '1':
                    exploreTeamMenu(teams);
                    break;
                case '2':
                    System.out.println("2");
                    break;
                case 'X':
                    return;
                default:
                    System.out.println("Please enter a valid input");
            }
        }
    }

    private static void exploreTeamMenu(Teams teams) {
        while (true) {
            System.out.println("1. Display all teams");
            System.out.println("2. Display all players");
            System.out.println("3. Add a new team");
            System.out.println("4. Manage an existing team");
            System.out.println("5. Delete an existing team");
            System.out.println("6. Display all player by level");
            System.out.println("R. Return to previous menu");

            char option1 = 0;

            System.out.print("Enter a choice: ");
            Scanner sc = new Scanner(System.in);
            option1 = sc.nextLine().charAt(0);

            switch (option1) {
                case '1':
                    Utils.teamsHeader();
                    for (Team team : teams.getTeams()) {
                        System.out.printf(Utils.teamsFormat, team.getName(), team.getPlayers().size(), team.getAverageCredit(), team.getAverageAge());
                    }
                    Utils.teamTableEnd();
                    break;
                case '2':
                    Utils.DisplayPlayerFromAllTeamsHeader();
                    for (Team team : teams.getTeams()) {
                        for (Player player : team.getPlayers()) {
                            System.out.printf(Utils.DisplayPlayerFromAllTeamsFormat, player.getName(), player.getCredit(), player.getLevel(), player.getAge(), player.getNo(), team.getName());
                        }
                        if (!team.getPlayers().isEmpty()) Utils.DisplayPlayerFromAllTeamsEnd();
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
                    System.out.print("Please enter team's name you want to manage: ");
                    sc = new Scanner(System.in);
                    String manageTeamName = sc.nextLine();

                    Team managingTeam = null;

                    for (Team team : teams.getTeams()) {
                        if (team.getName().equals(manageTeamName)) {
                            managingTeam = team;
                        }
                    }

                    if (teams.checkTeamNameExist(manageTeamName) < 0) {
                        System.out.println("Cannot found team " + manageTeamName);
                        break;
                    }

                    System.out.println("Welcome to " + manageTeamName + " page! Please make a selection from the menu: ");

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
                    System.out.print("Please enter the player's level you want to view: ");
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
                        for (Player player : team.getPlayers()) {
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
            System.out.println("1. Display team's players");
            System.out.println("2. Add a new player");
            System.out.println("3. Update an existing player");
            System.out.println("4. Delete an existing player");
            System.out.println("R. Return to previous");

            char option2 = 0;
            System.out.print("Enter a choice: ");
            Scanner sc = new Scanner(System.in);
            option2 = sc.nextLine().charAt(0);

            switch (option2) {
                case '1':
                    Utils.playerHeader();
                    for (Player player : managingTeam.getPlayers()) {
                        System.out.printf(Utils.PlayerFormat, player.getName(), player.getCredit(), player.getLevel(), player.getNo(), player.getAge());
                    }
                    Utils.playerTableEnd();

                    break;
                case '2':

                    System.out.print("Please enter player's name: ");
                    sc = new Scanner(System.in);
                    String name = sc.nextLine();

                    System.out.print("Please enter player's credit: ");
                    sc = new Scanner(System.in);
                    float credit = sc.nextFloat();

                    System.out.print("Please enter player's age: ");
                    sc = new Scanner(System.in);
                    int age = sc.nextInt();

                    System.out.print("Please enter player's No: ");
                    sc = new Scanner(System.in);
                    int no = sc.nextInt();

                    Player newPlayer = new Player(name, credit, age, no);

                    while (!managingTeam.tryAddPlayer(newPlayer)) {
                        int existedPlayerIndex = managingTeam.checkPlayerNoExist(newPlayer.getNo());
                        String existedPlayerName = managingTeam.getPlayers().get(existedPlayerIndex).getName();

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
                        System.out.println("Cannot found player " + updatePlayerName);
                        break;
                    }

                    Player updatingPlayer = managingTeam.getPlayers().get(playerIndex);

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
                        String existedPlayerName = managingTeam.getPlayers().get(existedPlayerIndex).getName();

                        System.out.print("This No has been occupied by: " + existedPlayerName + ". Please re-enter the No: ");
                        sc = new Scanner(System.in);
                        newNo = sc.nextInt();
                    }

                    updatingPlayer.setNo(newNo);

                    System.out.println("Player information updated!");
                    break;
                case '4':
                    System.out.print("Please enter the player's name that you want to delete: ");
                    sc = new Scanner(System.in);
                    String deletePlayerName = sc.nextLine();

                    if (!managingTeam.tryRemovePlayer(deletePlayerName)) {
                        System.out.println("Cannot found player " + deletePlayerName);
                    } else {
                        System.out.println("The player " + deletePlayerName + " has been deleted.");
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
