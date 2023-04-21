import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        ArrayList<String> teamList = new ArrayList();

        // ADD NEW TEAMS
        teamList.add("Suns");       // 0
        teamList.add("Team 1");     // 1
        teamList.add("Team 2");     // 2

        while (true) {
            System.out.println("1. Display");
            System.out.println("2. Add a team");
            System.out.println("3. Update a team");
            System.out.println("4. Delete a team");

            char option = 0;
            System.out.print("Select an option: ");
            Scanner sc = new Scanner(System.in);
            option = sc.nextLine().charAt(0);

            switch (option) {
                case '1':
                    for (String team : teamList) {
                        System.out.println(team);
                    }
                    break;
                case '2':
                    System.out.print("Enter name of the team you want to add: ");
                    sc = new Scanner(System.in);
                    String teamName = sc.nextLine();

                    boolean hasExisted = false;

                    for (String team : teamList) {
                        if (team.equals(teamName)) {
                            hasExisted = true;
                            break;
                        }
                    }

                    if (!hasExisted) {
                        teamList.add(teamName);
                        System.out.println("Added team " + teamName);
                    } else {
                        System.out.println("Team " + teamName + " has existed");
                    }

                    break;
                case '3':
                    System.out.print("Enter name of the team you want to update: ");
                    sc = new Scanner(System.in);
                    String updateTeamName = sc.nextLine();

                    System.out.print("New name: ");
                    sc = new Scanner(System.in);
                    String newName = sc.nextLine();

                    boolean hasUpdated = false;

                    for (int i = 0; i < teamList.size(); ++i) {
                        String team = teamList.get(i);

                        if (team.equals(updateTeamName)) {
                            teamList.set(i, newName);
                            hasUpdated = true;
                            break;
                        }
                    }

                    if (!hasUpdated) {
                        System.out.println("Cannot found team " + updateTeamName);
                    } else {
                        System.out.println("The team " + updateTeamName + " has been updated to " + newName);
                    }

                    break;
                case '4':
                    System.out.println("Enter name of the team you want to delete: ");
                    sc = new Scanner(System.in);
                    String deleteTeamName = sc.nextLine();

                    boolean hasDeleted = false;

                    for (int i = 0; i < teamList.size(); ++i) {
                        String team = teamList.get(i);

                        if (team.equals(deleteTeamName)) {
                            teamList.remove(i);
                            hasDeleted = true;
                            break;
                        }
                    }

                    if (!hasDeleted) {
                        System.out.println("Cannot found team " + deleteTeamName);
                    } else {
                        System.out.println("The team " + deleteTeamName + " has been deleted");
                    }

                    break;
                case 'X':
                    return;
                default:
                    System.out.println("Please enter a valid input");
            }
        }

    }
}
