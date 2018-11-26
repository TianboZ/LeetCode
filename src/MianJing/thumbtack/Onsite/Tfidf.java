package MianJing.thumbtack.Onsite;


import practice.MaxHeap;

import java.util.*;

/*
*
* 1. clarify use case
*
*   compute the tf-idf
*   tf * idf
*
* 2. design API
*   tfidf(String s, int docId)    input: term and the id of document contains this term, return tfidf
*
*   time O(1)
*   space O(1)
*
* 3. design member fields, internal state
*
* Map<key: docId, value: <key: term, value: frequency>>  tfMap
*
* Map<key: term, value: # of docs that contains this term>   idfMap
*
* 4. constructor
*   initialize maps
*   pre-process the input documents: List<List<String>> documents
*
*  5. implement API
*
* */
public class Tfidf {
    // fields
    private Map<Integer, Map<String, Double>> tfMap;
    private Map<String, Integer> idfMap;
    private int totalDocs = 0;

    // constructor
    public Tfidf(List<List<String>> docs) {
        tfMap = new HashMap<>();
        idfMap = new HashMap<>();
        totalDocs = docs.size();

        // iterate each document, compute term frequency of each document
        for (int i = 0; i < docs.size(); i++) {
            int size = docs.get(i).size();
            Map<String, Integer> map = new HashMap<>(); // key: term  value: count # of it
            for (String s : docs.get(i)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }

            Map<String, Double> tf = new HashMap<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                tf.put(entry.getKey(), (double)entry.getValue() / size);
            }

            tfMap.put(i, tf);

        }

        // iterate each document, compute idf of each term
        for (List<String> doc : docs) {
            for (String term : doc) {
                if (idfMap.containsKey(term)) continue; // we have already computed this term

                int count = 0;
                // iterate each document
                for (List<String> document : docs) {
                    if (document.contains(term)) count++;
                }
                idfMap.put(term, count);
            }
        }
        //System.out.println(tfMap);
    }

    // API
    public double tfidf(String term, int id) {
        double tf = getTf(term, id);
        double idf = getIdf(term);

        return tf * idf;
    }

    private double getTf(String s, int id) {
        if (!tfMap.containsKey(id) || !tfMap.get(id).containsKey(s)) return 0.0; // not exist

        return tfMap.get(id).get(s);
    }

    private double getIdf(String s) {
        if (!idfMap.containsKey(s)) return 0.0; // not exist

        int count = idfMap.get(s);
        return Math.log((double) totalDocs / count);
    }

    // return list of index of document
    public List<Integer> topK(List<String> query, int k) {

        Queue<Cell> minHeap = new PriorityQueue<>(new CP());

        // iterate each document
        for (int i = 0; i < totalDocs; i++) {
            double score = 0;
            // iterate each term in the query
            for (String term : query) {
                score = score + tfidf(term, i);
            }

            if (i < k) {
                minHeap.offer(new Cell(i, score));
            } else {
                if (minHeap.peek().score < score) {
                    minHeap.poll();
                    minHeap.offer(new Cell(i, score));
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll().index);
        }
        return res;
    }

    private static class Cell {
        int index;
        double score;

        Cell(int i, double s) {
            index = i;
            score = s;
        }
    }
    private static class  CP implements Comparator<Cell> {
        @Override
        public int compare(Cell c1, Cell c2) {
            if (c1.score == c2.score) return 0;
            return c1.score < c2.score ? -1 : 1; // increasing order
        }
    }

    public static void main(String[] args) {
        List<String> doc0 = Arrays.asList("Lorem", "ipsum", "dolor", "ipsum", "sit", "ipsum");
        List<String> doc1 = Arrays.asList("Vituperata", "incorrupte", "at", "ipsum", "pro", "quo");
        List<String> doc2 = Arrays.asList("Has", "persius", "disputationi", "id", "simul");
        List<String> doc3 = Arrays.asList("Has", "persius", "disputationi", "id", "simul", "id","id", "id");

        List<List<String>> docs = Arrays.asList(doc0, doc1, doc2, doc3);

        Tfidf tfidf = new Tfidf(docs);

        double res = tfidf.tfidf("ipsum", 0);
        double res1 = tfidf.tfidf("ipsum", 1);
        double res2 = tfidf.tfidf("ipsum", 2);

        System.out.println(res + " , " + res1 + ", " + res2);

        List<String> quries = Arrays.asList("Has", "id", "at");
        System.out.println(tfidf.topK(quries, 2));

    }
}
