import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.Map;

public class BaseballElimination {
    private int n;
    private Map<String, Integer> indexes;
    int[][] records;
    int[][] matches;

    private Map<String, int[]> teamRecords;

    public BaseballElimination(String filename) {
        In in = new In(filename);
        n = in.readInt();

        indexes = new HashMap<>();
        records = new int[n][3];
        matches = new int[n][n];


        for (int teamNum = 0; teamNum < n; teamNum++) {
            String teamName = in.readString();git

            for (int i = 0; i < 3; i++) {
                records[teamNum][i] = in.readInt();
            }

            for (int i = 0; i < n; i++) {
                matches[teamNum][i] = in.readInt();
            }

            indexes.put(teamName, teamNum);

        }
    }

    public int numberOfTeams() {
        return n;
    }

    public Iterable<String> teams() {
        return indexes.keySet();
    }

    public int wins(String team) {
        validateTeam(team);

        int index = indexes.get(team);
        return records[index][0];
    }

    public int losses(String team) {
        validateTeam(team);

        int index = indexes.get(team);
        return records[index][1];
    }

    public int remaining(String team) {
        validateTeam(team);

        int index = indexes.get(team);
        return records[index][2];
    }

    public int against(String team1, String team2) {
        validateTeam(team1);
        validateTeam(team2);

        int index1 = indexes.get(team1);
        int index2 = indexes.get(team2);
        return matches[index1][index2];
    }

    public boolean isEliminated(String team) {
        validateTeam(team);

        return false;
    }

    public Iterable<String> certificateOfElimination(String team) {
        validateTeam(team);

//        FlowNetwork

        return null;
    }

    private void validateTeam(String team) {
        if (!indexes.keySet().contains(team)) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        String fileStr = "/Users/yangLiu/Coursera/AlgorithmPart2/baseball/teams4.txt";
        In in = new In(fileStr);

        BaseballElimination b = new BaseballElimination(fileStr);
//        while(in.hasNextLine()) {
//            System.out.println(in.readInt());
//            System.out.println(in.readString());
//        }
//        System.out.println(in.readInt());
//        System.out.println(in.readString());
    }
}
