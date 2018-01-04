package week1;

import edu.princeton.cs.algs4.*;

import java.util.LinkedList;
import java.util.List;

public class SAP {
    private final Digraph graph;

    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G) {
        this.graph = new Digraph(G);
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        validateVertex(v);
        validateVertex(w);

        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(graph, w);

        Result result = findResult(bfsV, bfsW);
        return result.length;
    }

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        validateVertex(v);
        validateVertex(w);

        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(graph, w);

        Result result = findResult(bfsV, bfsW);
        return result.ancestor;
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        validateVertices(v);
        validateVertices(w);

        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(graph, w);

        Result result = findResult(bfsV, bfsW);
        return result.length;
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        validateVertices(v);
        validateVertices(w);

        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(graph, w);

        Result result = findResult(bfsV, bfsW);
        return result.ancestor;
    }

    private Result findResult(BreadthFirstDirectedPaths bfsV, BreadthFirstDirectedPaths bfsW) {
        Result result = new Result(-1, -1);

        int length = Integer.MAX_VALUE;
        for (int i = 0; i < graph.V(); i++) {
            if (bfsV.hasPathTo(i) && bfsW.hasPathTo(i)) {
                if (bfsV.distTo(i) >= length || bfsW.distTo(i) >= length) {
                    continue;
                }
                int len = bfsV.distTo(i) + bfsW.distTo(i);
                if (len < length) {
                    length = len;
                    result = new Result(len, i);
                }
            }
        }

        return result;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = graph.V();
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertices(Iterable<Integer> vertices) {
        if (vertices == null) {
            throw new IllegalArgumentException("argument is null");
        }
        int V = graph.V();
        for (int v : vertices) {
            if (v < 0 || v >= V) {
                throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
            }
        }
    }

    private class Result{
        int length;
        int ancestor;
        Result(int length, int ancestor) {
            this.length = length;
            this.ancestor = ancestor;
        }
    }

//    public static void main(String[] args) {
//        In in = new In(args[0]);
////        Digraph G = new Digraph(in);
//
//        Digraph G = new Digraph(6);
//        G.addEdge(1, 0);
//        G.addEdge(1, 2);
//        G.addEdge(2, 3);
//        G.addEdge(3, 4);
//        G.addEdge(4, 5);
//        G.addEdge(5, 0);
//
//        week1.SAP s  = new week1.SAP(G);
//        int anc = s.ancestor(1 , 5);
//        System.out.println(anc);
//        int len = s. length(1, 5);
//        System.out.println(len);
//
//        List<Integer> v = new ArrayList<>();
//        v.add(4);
//        v.add(12);
//        List<Integer> w = new ArrayList<>();
//        w.add(1);
//        int anc2 = s.length(v, w);
//        System.out.println(anc2);
//    }


    public static void main(String[] args) {
//        In in = new In(args[0]);
//        Digraph G = new Digraph(in);
//        week1.SAP sap = new week1.SAP(G);
//
//            int v = 1;
//            int w = 6;
//            int length = sap.length(v, w);
//            int ancestor = sap.ancestor(v, w);
//            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        List l1 = new LinkedList();
        List l2 = new LinkedList();
        l1.addAll(l2);

    }

}
