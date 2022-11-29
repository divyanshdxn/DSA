package com.dxn.graph.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class HasCycle {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        // write your code here
        boolean[] isVisited = new boolean[edges];
        for (int i = 0; i < edges; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                if (checkCycle(i, graph)) {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }

    public static class Pair {
        int v;
        String psf;

        Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }
    }

    public static boolean checkCycle(int src, ArrayList<Edge>[] graph) {
        ArrayDeque<Pair> dq = new ArrayDeque<>();
        dq.add(new Pair(src, src + ""));
        boolean[] isVisited = new boolean[graph.length];
        while (dq.size() > 0) {
            Pair vertex = dq.remove();
            if (isVisited[vertex.v]) {
                return true;
            }
            isVisited[vertex.v] = true;
            for (Edge e : graph[vertex.v]) {
                if (!isVisited[e.nbr]) {
                    dq.add(new Pair(e.nbr, vertex.psf + e.nbr));
                }
            }
        }
        return false;
    }
}
