package MianJing.ixl;

import java.util.ArrayList;
import java.util.List;

class Coord {
    double x;
    double y;
    Coord(double _x, double _y) {
        x = _x;
        y = _y;
    }
}
class School {
    String name;
    Coord cord;
    School(String n, Coord c) {
        name = n;
        cord = c;
    }
}
class Node {
    List<School> schools;
    Coord c1;
    Coord c2;
    List<Node> neis;

}
public class QuadrantTree {

    // return true if added success
    public boolean addSchool(Node root, School school) {
        // base case
        if (root == null) return false;

        // recursive rule
        if (root.neis == null || root.neis.size() == 0) {
            // leaf
            if (isInArea(school, root)) {
                // add school to this area
                root.schools.add(school);
                return true;
            }
        } else {
            List<Node> neis = root.neis;
            if (neis != null) {
                for (Node nei : neis) {
                    if (addSchool(nei, school)) return true;
                }
            }
        }
        return false;
    }

    /*
    *
    *                   x    school: 9   k=2
    *                 /| | \
    *                x x x  x (3 schools left)   3 > 2, continue split
    *                2 2 2 /\\ \
    *                      x x x x
    *                      1 1 1
    * */
    private Node split(Node root, int k, List<School> list) {
        // base case
        if (root == null) return null;

        // recursive rule
        if (isLeaf(root) ) {
            if (root.schools.size() > k) {
                // need to split

                for (int i = 0; i * k <= list.size() && i < 4; i++) {
                    Node node = new Node();
                    root.neis.add(node);
                    //split(node, k, newList);
                }


                return root;
            } else {
                // build new leaf node
                root.schools = new ArrayList<>(list);
                return root;
            }

        } else {
            return root;
        }
    }

    private boolean isLeaf(Node n) {
        return false;
    }

    private boolean isInArea(School school, Node node) {
        Coord c1 = node.c1;
        Coord c2 = node.c2;
        Coord c3  = school.cord;

        Coord tr = null;   // top right
        Coord bl = null;   // bottom left
        if (c1.x >= c2.x && c1.y >= c2.y) {
            tr = c1;
            bl = c2;
        } else {
            tr = c2;
            bl = c1;
        }

        return (bl.x <= c3.x && c3.x <= tr.x && bl.y <= c3.y && c3.y <= tr.y);
    }

    public static void main(String[] args) {

    }



}
