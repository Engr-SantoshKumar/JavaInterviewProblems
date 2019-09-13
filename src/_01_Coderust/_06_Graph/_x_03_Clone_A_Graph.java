package _01_Coderust._06_Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;


// Java program to Clone an Undirected Graph
// GraphNode class represents each
// Node of the Graph
class GraphNode
{
    int val;

    // A neighbour Vector which contains references to
    // all the neighbours of a GraphNode
    Vector<GraphNode> neighbours;
    public GraphNode(int val)
    {
        this.val = val;
        neighbours = new Vector<GraphNode>();
    }
}

class GraphCreation
{
    // A method which clones the graph and
    // returns the reference of new cloned source node
    public GraphNode cloneGraph(GraphNode source)
    {
        Queue<GraphNode> q = new LinkedList<GraphNode>();
        q.add(source);

        // An HashMap to keep track of all the
        // nodes which have already been created
        HashMap<GraphNode,GraphNode> hm =
                new HashMap<GraphNode,GraphNode>();

        //Put the node into the HashMap
        hm.put(source,new GraphNode(source.val));

        while (!q.isEmpty())
        {
            // Get the front node from the queue
            // and then visit all its neighbours
            GraphNode u = q.poll();

            // Get corresponding Cloned Graph Node
            GraphNode cloneNodeU = hm.get(u);
            if (u.neighbours != null)
            {
                Vector<GraphNode> v = u.neighbours;
                for (GraphNode graphNode : v)
                {
                    // Get the corresponding cloned node
                    // If the node is not cloned then we will
                    // simply get a null
                    GraphNode cloneNodeG = hm.get(graphNode);

                    // Check if this node has already been created
                    if (cloneNodeG == null)
                    {
                        q.add(graphNode);

                        // If not then create a new Node and
                        // put into the HashMap
                        cloneNodeG = new GraphNode(graphNode.val);
                        hm.put(graphNode,cloneNodeG);
                    }

                    // add the 'cloneNodeG' to neighbour
                    // vector of the cloneNodeG
                    cloneNodeU.neighbours.add(cloneNodeG);
                }
            }
        }

        // Return the reference of cloned source Node
        return hm.get(source);
    }

    // Build the desired graph
    public GraphNode buildGraph()
    {
        /*
            Note : All the edges are Undirected
            Given Graph:
            1--2
            |  |
            4--3
        */
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        Vector<GraphNode> v = new Vector<GraphNode>();
        v.add(node2);
        v.add(node4);
        node1.neighbours = v;
        v = new Vector<GraphNode>();
        v.add(node1);
        v.add(node3);
        node2.neighbours = v;
        v = new Vector<GraphNode>();
        v.add(node2);
        v.add(node4);
        node3.neighbours = v;
        v = new Vector<GraphNode>();
        v.add(node3);
        v.add(node1);
        node4.neighbours = v;
        return node1;
    }

    // BFS traversal of a graph to
    // check if the cloned graph is correct
    public void bfs(GraphNode source)
    {
        Queue<GraphNode> q = new LinkedList<GraphNode>();
        q.add(source);
        HashMap<GraphNode,Boolean> visit =
                new HashMap<GraphNode,Boolean>();
        visit.put(source,true);
        while (!q.isEmpty())
        {
            GraphNode u = q.poll();
            System.out.println("Value of Node " + u.val);
            System.out.println("Address of Node " + u);
            if (u.neighbours != null)
            {
                Vector<GraphNode> v = u.neighbours;
                for (GraphNode g : v)
                {
                    if (visit.get(g) == null)
                    {
                        q.add(g);
                        visit.put(g,true);
                    }
                }
            }
        }
        System.out.println();
    }
}

// Driver code
class _x_03_Clone_A_Graph
{
    public static void main(String args[])
    {
        GraphCreation graph = new GraphCreation();
        GraphNode source = graph.buildGraph();
        System.out.println("BFS traversal of a graph before cloning");
        graph.bfs(source);
        GraphNode newSource = graph.cloneGraph(source);
        System.out.println("BFS traversal of a graph after cloning");
        graph.bfs(newSource);
    }
}