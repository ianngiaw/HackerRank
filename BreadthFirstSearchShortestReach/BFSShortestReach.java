import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	ArrayList<ArrayList<Integer>> adjList;

	public Solution(int n) {
		adjList = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < n; i++) {
			adjList.add(new ArrayList<Integer>());
		}
	}

	public void insertEdge(int from, int to) {
		adjList.get(from - 1).add(to - 1);
		adjList.get(to - 1).add(from - 1);
	}

	// returns max depth
	public int[] BFS(int start) {
		start = start - 1;
		int[] visited = new int[adjList.size()];
		for(int i = 0; i < visited.length; i++) {
			visited[i] = -1;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		int depth = 0;
		do {
			Queue<Integer> tempQueue = new LinkedList<Integer>();
			while(!queue.isEmpty()) {
				int next = queue.poll();
				if (visited[next] != -1) continue;
				visited[next] = depth * 6;
				for(int i : adjList.get(next)) {
					if (visited[i] == -1) {
						tempQueue.offer(i);
					}
				}
			}
			queue = tempQueue;
			depth++;
		} while (!queue.isEmpty());
		return visited;
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T > 0) {
        	int N = sc.nextInt(), M = sc.nextInt();
        	Solution s = new Solution(N);
        	for(int i = 0; i < M; i++) {
        		int from = sc.nextInt(), to = sc.nextInt();
        		s.insertEdge(from, to);
        	}
        	int start = sc.nextInt();
        	int[] res = s.BFS(start);
        	StringBuilder sb = new StringBuilder();
        	for(int i = 0; i < N; i++) {
        		if(i != start - 1) {
        			sb.append(res[i]);
        			sb.append(" ");
        		}
        	}
        	System.out.println(sb.toString().trim());
        	T--;
        }
    }
}