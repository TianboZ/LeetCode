package MianJing.thumbtack;

import java.util.*;

public class ThumbtackOA {
    public String[][] categorySuggestions(String[] categories, String[] projects, int k) {
        if (categories == null || projects == null || k < 0) {
            return null;
        }
        Map<String, Map<String, Double>> graph = new HashMap<>(); //Build the undirected graph for Categories.
        if (!buildGraph(categories, graph)) {
            return null;
        }
        Map<String, ProjectScorePair> projToScoreMap = new HashMap<>(); //Store the current mapping from Project to Score.
        SortedSet<ProjectScorePair> projScoreSet = new TreeSet<>(); //Store the top results

        int projectLen = projects.length;
        String[][] result = new String[projectLen][];
        int i = 0;
        for (String project : projects) {
            Map<String, Double> projectToUpdate = graph.getOrDefault(project, new HashMap<>());
            for (Map.Entry<String, Double> entry : projectToUpdate.entrySet()) {
                updateProjectScore(projScoreSet, projToScoreMap, entry.getKey(), entry.getValue(), k);
            }
            result[i++] = getTopKProjects(projScoreSet, k);
        }
        return result;
    }

    public String[] getTopKProjects(SortedSet<ProjectScorePair> projectScorePairs, int k) {
        String[] result = new String[k];
        int i = 0;
        for (ProjectScorePair pair : projectScorePairs) {
            result[i++] = pair.project;
        }
        return Arrays.copyOf(result, i);
    }

    public void updateProjectScore(SortedSet<ProjectScorePair> projScoreSet, Map<String, ProjectScorePair> projToScoreMap, String project, double score, int k) {
        ProjectScorePair originalPair = projToScoreMap.getOrDefault(project, null);
        if (originalPair != null && originalPair.score >= score) {
            return;
        }
        ProjectScorePair pair = new ProjectScorePair(project, score);
        if (originalPair != null && projScoreSet.contains(originalPair)) {
            projScoreSet.remove(originalPair);
        }
        projScoreSet.add(pair);
        if (projScoreSet.size() > k) {
            projScoreSet.remove(projScoreSet.last());
        }
        projToScoreMap.put(project, pair);
    }

    public boolean buildGraph(String[] categories, Map<String, Map<String, Double>> graph) {
        for (String category : categories) {
            String[] projects = category.split(",");
            if (projects.length != 3) {
                return false;
            }
            String project1 = projects[0];
            String project2 = projects[1];
            Double score = Double.parseDouble(projects[2]);
            if (!graph.containsKey(project1)) {
                graph.put(project1, new HashMap<>());
                graph.get(project1).put(project1, 1.0); //Score to itself should be 1.0
            }
            if (!graph.containsKey(project2)) {
                graph.put(project2, new HashMap<>());
                graph.get(project2).put(project2, 1.0); //Score to itself should be 1.0
            }
            graph.get(project1).put(project2, score);
            graph.get(project2).put(project1, score);
        }
        return true;
    }

    class ProjectScorePair implements Comparable<ProjectScorePair> {
        String project;
        double score;

        public ProjectScorePair(String project, double score) {
            this.project = project;
            this.score = score;
        }

        @Override
        public int compareTo(ProjectScorePair other) {
            if (this.score == other.score) {
                return this.project.compareTo(other.project);
            }
            return Double.compare(other.score, this.score);
        }
    }

    public static void main(String[] args) {
        String[] categories = {"House Painting,Interior Painting,0.3",
                "Handyman,Massage Therapy,0.1",
                "Handyman,House Painting,0.5",
                "House Painting,House Cleaning,0.6",
                "Furniture Assembly,Handyman,0.8",
                "Furniture Assembly,Massage Therapy,0.1",
                "Plumbing Drain Repair,Junk Removal,0.3",
                "Handyman,Interior Painting,0.9"};
        String[] projects = {"House Painting", "Handyman"};
        int k = 0;
        ThumbtackOA s = new ThumbtackOA();
        String[][] result = s.categorySuggestions(categories, projects, k);
        for (String[] res : result) {
            System.out.println(Arrays.toString(res));
        }
    }


}
