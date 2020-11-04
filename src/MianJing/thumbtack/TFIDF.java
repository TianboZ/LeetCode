package MianJing.thumbtack;

import java.util.*;

public class TFIDF {
    public static void main(String[] args) {

        List<String> raw1 = Arrays.asList("Lorem", "ipsum", "dolor", "ipsum", "sit", "ipsum");
        List<String> raw2 = Arrays.asList("Vituperata", "incorrupte", "at", "ipsum", "pro", "quo");
        List<String> raw3 = Arrays.asList("Has", "persius", "disputationi", "id", "simul");

        Document doc1 = new Document(raw1);
        Document doc2 = new Document(raw2);
        Document doc3 = new Document(raw3);

        List<Document> docs = Arrays.asList(doc1, doc2, doc3);

        TFIDF tfidf = new TFIDF(docs);

        double res = tfidf.tfidf("ipsum", doc2);

        System.out.println(res);
    }

    // fields
    private Map<String, Integer> idf;
    private int totalDocs;

    // helper class
    private static class Document{
        // fields
        private Map<String, Integer> words;
        private int wordsCount;

        // constructor
        private Document(List<String> raw) {
            wordsCount = raw.size();
            words = new HashMap<>();

            // count words
            for (String s : raw) {
                words.put(s, words.getOrDefault(s, 0) + 1);
            }
        }
    }



    // constructor
    private TFIDF (List<Document> docs) {
        this.idf = new HashMap<>();
        this.totalDocs = docs.size();

        // iterate each document
        for (Document doc : docs) {
            Set<String> words = doc.words.keySet();
            for (String word : words) {
                if (idf.containsKey(word)) continue;

                int count = 0;
                // iterate each document again
                for (Document doc1 : docs) {
                    if (doc1.words.containsKey(word)) count++;
                }
                idf.put(word, count);
            }
        }
    }

    // API
    public double tfidf(String term, Document document) {
        double tf = getTf(term, document);
        double idf = getIdf(term);
        return tf * idf;
    }

    private double getTf(String input, Document docs) {
        int count = docs.words.get(input);
        return (double) count / docs.wordsCount;
    }
    private double getIdf(String input) {
        int count = idf.get(input);
        return Math.log((double) totalDocs / count);
    }
}