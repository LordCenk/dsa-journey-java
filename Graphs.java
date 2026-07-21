public class Graphs {
    public boolean hasCycle(int V, List<List<Integer>> graph){
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(dfs(i, -1, visited, graph))
                    return true;
            }
        }
    }

    
}
