import edu.princeton.cs.algs4.FlowNetwork;

import java.util.Map;

public class BaseballElimination {
    private int n;
    private Map<String, Integer> indexes;
    int[][] records;
    int[][] matches;

    private Map<String, int[]> teamRecords;

    public BaseballElimination(String filename) {

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

        FlowNetwork

        return null;
    }

    private void validateTeam(String team) {
        if (!indexes.keySet().contains(team)) {
            throw new IllegalArgumentException();
        }
    }
}
