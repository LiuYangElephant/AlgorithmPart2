import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordNet {
    private final Digraph graph;
    private final SAP sap;
    private final Map<String, Set<Integer>> nounToId = new HashMap<>();
    private final Map<Integer, Set<String>> idToNoun = new HashMap<>();

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        if (synsets == null || hypernyms == null) {
            throw new IllegalArgumentException();
        }
        constructSynsets(synsets);
        graph = new Digraph(idToNoun.size());
        constructWordNet(hypernyms);
        sap = new SAP(graph);
        checkGraphRooted();
    }

    private void constructSynsets(String synsets) {
        In in = new In(synsets);
        while (!in.isEmpty()) {
            String s = in.readLine();
            String[] record = s.split(",");
            int id = Integer.parseInt(record[0]);
            String[] nouns = record[1].split(" ");
            for (String noun : nouns) {
                if (nounToId.containsKey(noun)) {
                    nounToId.get(noun).add(id);
                } else {
                    Set<Integer> ids = new HashSet<>();
                    ids.add(id);
                    nounToId.put(noun, ids);
                }
            }

            // construct id to nouns map.
            idToNoun.put(id, new HashSet<String>());

            for (String noun : record[1].split(" ")) {
                idToNoun.get(id).add(noun);
            }
        }
    }

    //164,21012,56099
    private void constructWordNet(String hypernyms) {

        In in = new In(hypernyms);
        while (!in.isEmpty()) {
            String s = in.readLine();
            String[] record = s.split(",");

            for (int i = 1; i < record.length; i++) {
                graph.addEdge(Integer.parseInt(record[0]), Integer.parseInt(record[i]));
            }
        }

    }

    private void checkGraphRooted() {
        int rootNum = 0;
        for (int i = 0; i < graph.V(); i++) {
            if (graph.outdegree(i) == 0) {
                rootNum++;
            }
        }
        if (rootNum != 1) {
            throw new IllegalArgumentException();
        }
     }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
        return nounToId.keySet();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        if (word == null) {
            throw new IllegalArgumentException();
        }
        return nounToId.containsKey(word);
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        if (!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException();
        }
        return sap.length(nounToId.get(nounA), nounToId.get(nounB));
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        if (!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException();
        }

        int ancestorId = sap.ancestor(nounToId.get(nounA), nounToId.get(nounB));
        StringBuilder sb = new StringBuilder();
        for (String noun : idToNoun.get(ancestorId)) {
            sb.append(noun);
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }


   public static void main(String[] args) {
//        String synsets = "/localdisk/Coursera/wordnet/synsets3.txt";
//        String hypernyms = "/localdisk/Coursera/wordnet/hypernyms3InvalidTwoRoots.txt";
//        WordNet net = new WordNet(synsets, hypernyms);
//        String ans = net.sap("a", "c");
//        System.out.println(ans);

    }


}
