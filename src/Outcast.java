import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Outcast {
    WordNet wordnet;

    public Outcast(WordNet wordnet) {
        this.wordnet = wordnet;
    }
    public String outcast(String[] nouns) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < nouns.length; i++) {
            max += wordnet.distance(nouns[0], nouns[i]);
        }
        int[] distance = new int[nouns.length];
        for (int i = 1; i < nouns.length; i++) {
            for (int j = 0; j < nouns.length; j++) {
                distance[i] += wordnet.distance(nouns[i], nouns[j]);
            }
            if (distance[i] > max) {
                max = distance[i];
                index = i;
            }
        }
        return nouns[index];
    }

    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        String[] nouns = {"apple", "pear", "peach", "banana", "lime", "lemon", "blueberry", "strawberry", "mango", "watermelon", "potato"};
        StdOut.println( outcast.outcast(nouns));
    }

}
