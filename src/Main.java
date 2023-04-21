import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> teamList = new ArrayList();

        // ADD NEW TEAMS
        teamList.add("Suns");       // 0
        teamList.add("Team 1");     // 1
        teamList.add("Team 2");     // 2

        // DISPLAY TEAMS
//        for (String team: teamList){
//            System.out.println(team);
//        }

        // UPDATE A TEAM
//        for qua từng team, team nào có tên giống với tên cần update -> teamList.set(...)
//        System.out.print("Enter name of the team you want to update: ");
//        Scanner sc = new Scanner(System.in);
//        String updateTeamName = sc.nextLine();
//
//        System.out.print("New name: ");
//        sc = new Scanner(System.in);
//        String newName = sc.nextLine();
//
//        for (int i = 0; i < teamList.size(); ++i) {
//            String team = teamList.get(i);
//
//            if (team.equals(updateTeamName)) {
//                teamList.set(i, newName);
//                break;
//            }
//        }


        // REMOVE A TEAM
//        System.out.println("Enter name of the team you want to delete: ");
//        Scanner sc = new Scanner(System.in);
//        String deleteTeamName = sc.nextLine();
//
//        for (int i = 0; i < teamList.size(); ++i) {
//            String team = teamList.get(i);
//
//            if (team.equals(deleteTeamName)) {
//                teamList.remove(i);
//                break;
//            }
//        }

        for (String team : teamList) {
            System.out.println(team);
        }
    }
}
