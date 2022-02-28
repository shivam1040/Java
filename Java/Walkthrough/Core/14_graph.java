import java.nio.channels.Pipe.SourceChannel;
import java.util.*; //using adjancey method implementation
class Gra {
    LinkedList<Integer> adj[]; //declaring linkedlist off array type
    Gra(int v){
        adj=new LinkedList[v]; //intiallizing linkedlist
        for(int i=0; i<v; i++){
            adj[i]=new LinkedList<Integer>();
        }
    }

    void addedge(int source, int desti){
        adj[source].add(desti);
        adj[desti].add(source);
    }

    int bfs(int source, int desti){ //bfs, traverses every neighbour from source till destiniation, used to find shortest path: key points:make a visited array to keep track of nodes visited, make a queue and put source in it and iterate until evey neigbour until dest is found, and keep marking visited true for every element visit| if not visited then put in queued and iterate until dest is found
        boolean vis[]=new boolean[adj.length];
        int parent[]=new int[adj.length];
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(source);
        parent[source]=-1; 
        vis[source]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            if(curr==desti){
                break;
            }
            for(int neighbor: adj[curr]){ //adj[curr] means list stored at index curr of adj
                if(!vis[neighbor]){
                    vis[neighbor]=true;
                    q.add(neighbor);
                    parent[neighbor]=curr;
                }
            }
        }
        int curr=desti;
        int dist=0;
        while(parent[curr]!=-1){
            System.out.print(curr+"->");
            curr=parent[curr];
            dist++;
        }
        System.out.println("min dist is: "+dist);
        return dist;
    }

    boolean dfs(int source, int desti, boolean vis[]){ //dfs using recursion
        if(source==desti){
            return true;
        }
        for(int neighbor:adj[source]){
            if(!vis[neighbor]){
                vis[neighbor]=true;
                boolean isconnect=dfs(neighbor, desti, vis);
                if(isconnect){
                    return true;
                }
                }
            }
            return false;
        }
    
        boolean dfs1(int source, int desti){
            boolean vis[]=new boolean[adj.length];
            vis[source]=true;
            return dfs(source, desti, vis);
        }

        boolean dfsstack(int source, int desti){ //dfs using stack , dfs takes less space
            boolean vis[]=new boolean[adj.length];
            vis[source]=true;
            Stack<Integer> stack=new Stack<Integer>();
            stack.push(source);
            while(!stack.isEmpty()){
                int curr=stack.pop();
                if(curr==desti){
                    return true;
                }
                for(int neighbor:adj[curr]){
                    if(!vis[neighbor]){
                        vis[neighbor]=true;
                        stack.push(neighbor);
                    }
                }
            }
            return false;
        }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter count of vertice& edge: ");
        int v=sc.nextInt();
        int e=sc.nextInt();
        Gra obj=new Gra(v);
        System.out.println("Enter "+e+" edges");
        for(int i=0; i<e; i++){
            int source=sc.nextInt();
            int desti=sc.nextInt();
            obj.addedge(source, desti);
        }
        System.out.println("Enter source and desti for shortest path");
        //obj.bfs(sc.nextInt(), sc.nextInt());
        //System.out.println(obj.dfs1(sc.nextInt(), sc.nextInt()));
        System.out.println(obj.dfsstack(sc.nextInt(), sc.nextInt()));
        sc.close();
    }

}
