package MianJing.thumbtack;

import java.util.*;

public class TFIDF1 {
    // fields
    Map<String, Double> idf; // key: string   value: idf
    Map<Integer, Map<String, Double>> documents;   // key: index of documents     value: Map<term: tf>

    // constructor
    TFIDF1(List<List<String>> docs) {
        this.idf = new HashMap<>();
        this.documents = new HashMap<>();

        getIdf(docs);
        getTf(docs);
    }
    private void getTf(List<List<String>> docs) {
        for (int i = 0; i < docs.size(); i++) {
            List<String> doc = docs.get(i);
            int size = doc.size();
            Map<String, Integer> map = new HashMap<>(); // key: term  value: number of this term

            for (String term : doc) {
                map.put(term, map.getOrDefault(term, 0) + 1);
            }

            Map<String, Double> tf = new HashMap<>(); // key: term  value: frequency of this term

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                tf.put(entry.getKey(), (double)entry.getValue() / size);
            }

            documents.put(i, tf);
        }
    }

    private void getIdf(List<List<String>> docs) {
        int totalDocs = docs.size();

        // iterate each documents
        for (List<String> doc: docs) {
            // iterate each word in the doc
            for (String term : doc) {
                if (idf.containsKey(term)) continue;

                int count = 0;
                // iterate each documents
                for (List<String> doc1 : docs) {
                    if (doc1.contains(term)) count++;
                }

                idf.put(term, Math.log((double)totalDocs / count));
            }
        }
    }

    // API  time O(1)
    public double tfidf(String term, int index) {
        Double tf = documents.get(index).get(term);
        if (tf == null) return 0;

        Double idf = this.idf.get(term);
        //System.out.println(idf);
        if (idf == null || idf.isInfinite()) return 0;

        return tf * idf;
    }

    // return top k documents' index
    // time O( n * m +  nlogn )     n is number of documents         m is size of query
    // space O(n + k)
    public List<Integer> topKdocs(List<String> queries, int k) {
        int totalDocuments = documents.size();

        List<Wrapper> res = new ArrayList<>();

        //iterate each document, compute total tfidf of each term in the query
        for (int i = 0; i < totalDocuments; i++) {
            double score = 0.0;
            for (String query : queries) {
                score = score + tfidf(query, i);
            }
            Wrapper wrapper = new Wrapper(i, score);
            res.add(wrapper);
        }

        Collections.sort(res, new CP());

        // final result
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < k && i < res.size(); i++) {
            index.add(res.get(i).index);
        }
        return index;
    }

    class CP implements Comparator<Wrapper> {
        @Override
        public int compare(Wrapper w1, Wrapper w2) {
            if (w1.score == w2.score) return 0;
            return w1.score < w2.score ? 1 : -1; // decreasing order
        }
    }

    class Wrapper {
        int index;
        double score;
        Wrapper (int index, double score) {
            this.index = index;
            this.score = score;
        }
    }

    public static void main(String[] args) {

        List<String> doc0 = Arrays.asList("Lorem", "ipsum", "dolor", "ipsum", "sit", "ipsum");
        List<String> doc1 = Arrays.asList("Vituperata", "incorrupte", "at", "ipsum", "pro", "quo");
        List<String> doc2 = Arrays.asList("Has", "persius", "disputationi", "id", "simul");
        List<String> doc3 = Arrays.asList("Has", "persius", "disputationi", "id", "simul", "id","id", "id");

        List<List<String>> docs = Arrays.asList(doc0, doc1, doc2, doc3);

        TFIDF1 tfidf1 = new TFIDF1(docs);

        double res = tfidf1.tfidf("ipsum", 0);
        double res1 = tfidf1.tfidf("ipsum", 1);
        double res2 = tfidf1.tfidf("ipsum", 2);

        System.out.println(res + " , " + res1 + ", " + res2);

        List<String> quries = Arrays.asList("Has", "id", "at");

        System.out.println(tfidf1.topKdocs(quries, 2));


    }
}