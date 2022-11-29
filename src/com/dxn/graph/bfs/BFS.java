package com.dxn.graph.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.DelayQueue;

public class BFS {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair {
        int v;
        String psf;

        Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        boolean[] isVisited = new boolean[vtces];
        Arrays.fill(isVisited, false);

        // write your code here
        ArrayDeque<Pair> dq = new ArrayDeque<>();
        dq.add(new Pair(src, src + ""));

        while (dq.size() > 0) {
            Pair vertex = dq.remove();
            if(!isVisited[vertex.v]) {
                isVisited[vertex.v] = true;
                System.out.println(vertex.v + "@" + vertex.psf);
                for (Edge e: graph[vertex.v]) {
                    if(!isVisited[e.nbr]) {
                        dq.add(new Pair(e.nbr, vertex.psf + e.nbr));
                    }
                }
            }
        }

    }

}
