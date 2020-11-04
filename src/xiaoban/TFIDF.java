package xiaoban;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TFIDF {
    // fields
    private static Map<Integer, Map<String, Double>> tf; // key: doc id   value: <key: term, value: frequency>
    private static Map<String, Double> idf; //

    // constructor
    public TFIDF(List<List<String>> docs) {

        tf = new HashMap<>();
        idf = new HashMap<>();

        // compute tf
        computeTf(docs);

        // compute idf(docs);
        computeIdf(docs);
    }


    // API

    // time O(1)
    // space O(1)
    public double tfidf(int id, String term) {
        // sanity check
        if (!tf.containsKey(id) || !tf.get(id).containsKey(term)) return 0.0;

        return tf.get(id).get(term) * idf.get(term);
    }

    private void computeTf(List<List<String>> docs) {
        // iterate each documnet
        int i = 0;
        for (List<String> doc: docs) {
            Map<String, Integer> count = new HashMap<>(); // key: term ,  value: # of term
            for (String s : doc) {
                count.put(s, count.getOrDefault(s, 0) + 1);
            }

            Map<String, Double> tfMap = new HashMap<>();
            int total = doc.size(); // total words in one doc

            for (Map.Entry<String, Integer> entry: count.entrySet()) {
                String term = entry.getKey();
                int num = entry.getValue();
                tfMap.put(term, (double) num / total);
            }
            tf.put(i, tfMap);
            i++;
        }
    }

    private void computeIdf(List<List<String>> docs) {
        int total = docs.size(); // num of documents

        // iterate each doc
        for (List<String> doc: docs) {
            // iterate each term
            for (String s : doc) {
                if (idf.containsKey(s)) continue;

                int count = 0;
                // iterate each doc again
                for (List<String> doc1: docs) {
                    if (doc1.contains(s)) {
                        count++;
                    }
                }

                idf.put(s, Math.log((double)total / count));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("a");
        List<String> doc0 = Arrays.asList("Lorem", "ipsum", "dolor", "ipsum", "sit", "ipsum");
        List<String> doc1 = Arrays.asList("Vituperata", "incorrupte", "at", "ipsum", "pro", "quo");
        List<String> doc2 = Arrays.asList("Has", "persius", "disputationi", "id", "simul");
        List<String> doc3 = Arrays.asList("Has", "persius", "disputationi", "id", "simul", "id","id", "id");

        List<List<String>> docs = Arrays.asList(doc0, doc1, doc2, doc3);

        TFIDF tfidf = new TFIDF(docs);

        double res = tfidf.tfidf(0, "ipsum");
        double res1 = tfidf.tfidf(1, "ipsum");
        double res2 = tfidf.tfidf(2,"ipsum");

        System.out.println(res + " , " + res1 + ", " + res2);
    }
}