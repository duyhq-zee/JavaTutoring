import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Team> teamList = new ArrayList<>();

        teamList.add(new Team("Suns"));
        teamList.add(new Team("Bulls"));
        teamList.add(new Team("Hawks"));

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
                        sc = new Scanner(System.in);
                        option1 = sc.nextLine().charAt(0);

                        switch (option1) {
                            case '1':
                                for (Team team : teamList) {
                                    System.out.println(team.getName());
                                }
                                break;
                            case '2':
                                break;
                            case '3':
                                while (true) {
                                    System.out.print("Please enter a new name: ");
                                    sc = new Scanner(System.in);
                                    String teamName = sc.nextLine();

                                    boolean hasExisted = false;

                                    for (Team team : teamList) {
                                        if (team.getName().equals(teamName)) {
                                            hasExisted = true;
                                            break;
                                        }
                                    }

                                    if (!hasExisted) {
                                        Team newTeam = new Team(teamName);
                                        teamList.add(newTeam);
                                        System.out.println("Team " + teamName + " added!");
                                        break;
                                    } else {
                                        System.out.print("Team " + teamName + " already exist! ");
                                    }
                                }

                                break;
                            case '4':
                                System.out.print("Please enter team's name you want to manage: ");
                                sc = new Scanner(System.in);
                                String manageTeamName = sc.nextLine();

                                Team managingTeam = null;

                                for (Team team: teamList) {
                                    if (team.getName().equals(manageTeamName)){
                                        managingTeam = team;
                                    }
                                }

                                System.out.println("Welcome to " + manageTeamName + " page! Please make a selection from the menu: ");

                                while (true) {
                                    System.out.print("1. Display team's players");
                                    System.out.print("2. Add a new player");
                                    System.out.print("3. Update an existing player");
                                    System.out.print("4. Delete an existing player");
                                    System.out.print("R. Return to previous");

                                    char option2 = 0;
                                    System.out.print("Enter a choice: ");
                                    sc = new Scanner(System.in);
                                    option2 = sc.nextLine().charAt(0);

                                    switch (option2) {
                                        case '1':
                                            for (Player player: managingTeam.getPlayerList()) {
                                                System.out.println(player.getName());
                                            }

                                            break;
                                        case '2':
                                            System.out.println("Please enter player's name: ");
                                            sc = new Scanner(System.in);
                                            String name = sc.nextLine();

                                            System.out.println("Please enter player's credit: ");
                                            sc = new Scanner(System.in);
                                            float credit = sc.nextFloat();

                                            System.out.println("Please enter player's age: ");
                                            sc = new Scanner(System.in);
                                            int age = sc.nextInt();

                                            System.out.println("Please enter player's no: ");
                                            sc = new Scanner(System.in);
                                            int no = sc.nextInt();

                                            Player newPlayer = new Player(name, credit, age, no);

                                            managingTeam.addPlayer(newPlayer);
                                            break;
                                        case '3':
                                            break;
                                        case '4':
                                            
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

                                break;
                            case '5':
                                System.out.print("Please enter the team's name that you want to delete: ");
                                sc = new Scanner(System.in);
                                String deleteTeamName = sc.nextLine();

                                boolean hasDeleted = false;

                                for (int i = 0; i < teamList.size(); ++i) {
                                    Team team = teamList.get(i);

                                    if (team.getName().equals(deleteTeamName)) {
                                        teamList.remove(i);
                                        hasDeleted = true;
                                        break;
                                    }
                                }

                                if (!hasDeleted) {
                                    System.out.println("Cannot found team " + deleteTeamName);
                                } else {
                                    System.out.println("The team " + deleteTeamName + " has been deleted.");
                                }

                                break;
                            case '6':
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
}
