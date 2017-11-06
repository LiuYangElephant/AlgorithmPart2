import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordNet {
    private Digraph graph;
    private Map<String, Set<String>> nounToid = new HashMap<>();

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        constructSynsets(synsets);
        constructWordNet(hypernyms);
    }

    private void constructSynsets(String synsets) {
        In in = new In(synsets);
        while (!in.isEmpty()) {
            String s = in.readLine();
            String[] record = s.split(",");
            String[] nouns = record[1].split(" ");
            for (String noun : nouns) {
                if (nounToid.containsKey(noun)) {
                    nounToid.get(noun).add(record[0]);
                }
                else {
                    Set<String> id = new HashSet<>();
                    id.add(record[0]);
                    nounToid.put(noun, id);
                }
            }

        }
    }

    //164,21012,56099
    private void constructWordNet(String hypernyms) {
//        graph = new Digraph(nouns.size());
        In in = new In(hypernyms);
        while (!in.isEmpty()) {
            String s = in.readLine();
            String[] record = s.split(",");
            String node = record[0];

            for (int i = 1; i < record.length; i++) {

            }
        }
    }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
        return nounToid.keySet();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        return nounToid.keySet().contains(word);
    }

//    // distance between nounA and nounB (defined below)
//    public int distance(String nounA, String nounB)
//
//    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
//    // in a shortest ancestral path (defined below)
//    public String sap(String nounA, String nounB)

    public static void main(String[] args) {
        String synsets = "/Users/yangliu/Coursera/AlgorithmPart2/wordnet/synsets.txt";
        WordNet net = new WordNet(synsets, "");

    }
}
