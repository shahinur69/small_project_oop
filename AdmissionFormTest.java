import javax.swing.JFrame;
public class AdmissionFormTest {
    public static void main(String[] args) {
        AdmissionForm admissionForm = new AdmissionForm();
        admissionForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        admissionForm.setSize(220, 350);
        admissionForm.setVisible(true);
    }
}
/*
 #include<bits/stdc++.h>
using namespace std;
#define INF INT_MAX
char path[100][100];
void printPath(int s, int d)
{
    if(s == d) cout<<(char)(s + 'A')<<" "<<endl;
    else if(path[s][d] == -1) cout<<" not found: ";
    else
    {
        printPath(s, path[s][d]);
        cout<<(char)(d + 'A')<<" "<<endl;
    }
}
int main()
{
    int n, e, w;
    cout<<"Vertex and edge: ";
    cin>>n>>e;
    int dist[n][n];
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n; j++)
        {
            if(i == j)
            {
                dist[i][j] = 0;
                path[i][j] = i;
            }
            else
            {
                dist[i][j] = INF;
                path[i][j] = -1;
            }
        }
    }
    cout<<"S D W: "<<endl;
    for (int i = 0; i < e; i++) {
        char u, v;
        cin >> u >> v >> w;
        dist[u - 'A'][v - 'A'] = w;
        path[u - 'A'][v - 'A'] = u - 'A';
    }
    for(int k = 0; k < n; k++)
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < 0; j++)
            {
                if(dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j])
                {
                    dist[i][j] = dist[i][k] + dist[k][j];
                    path[i][j] = path[k][j];
                }
            }
        }
    }
    char srcChar, destchar;
    cout<<"Sources and destination: "<<endl;
    cin>>srcChar>>destchar;
    int src = srcChar - 'A';
    int dest = destchar - 'A';
    cout<<"Shortest path: "<<endl;
    printPath(src, dest);
    cout<<"Cost: "<<dist[src][dest];
}

 */
// END FLOYED WARSHELL ------------------------------------------------------
/*
 #include<bits/stdc++.h>
using namespace std;
bool bellmanFord(int V, int E, int edges[][3], int src, int dist[])
{
    const int INF = INT_MAX;
    for(int i = 0; i < V; i++)
    {
        dist[i] = INF;
    }
    dist[src] = 0;
    for(int i = 0; i < V - 1; i++)
    {
        for(int j = 0; j < E; j++)
        {
            int u = edges[j][0];
            int v = edges[j][1];
            int w = edges[j][2];
            if(dist[u] != INF && dist[u] + w < dist[v])
            {
                dist[v] = dist[u] + w;
            }
        }
    }
    for(int j = 0; j < E; j++)
    {
        int u = edges[j][0];
        int v = edges[j][1];
        int w = edges[j][2];
        if(dist[u] != INF && dist[u] + w < dist[v])
        {
            return false;
        }
    }
    return true;
}
int main()
{
    int V, E;
    cin>>V>>E;
    int edges[E][3];
    cout<<"Edges enter (u to v and weight: ";
    for(int i = 0; i < E; i++)
    {
        //cin>>edges[i][0]>>edges[i][1]>>edges[i][2];
        char u, v; int w;  cin>>u>>v>>w;
        edges[i][0] = u - 'A';
        edges[i][1] = v - 'A';
        edges[i][2] = w;
    }
    char srcchar;
    cout << "Enter source vertex (0 to " << 'A' + V - 1 << "): ";
    cin>>srcchar;
    int src = srcchar - 'A';
    int dist[V];
    if(!bellmanFord(V, E, edges, src, dist)){
        cout<<"Negative weight";
    }
    else{
        cout<<"Shortest distance from "<<(char)(src + 'A')<<":"<<endl;
        for(int i = 0; i < V; i++){
            cout<<(char)(i + 'A')<<" : ";
            if(dist[i] == INT_MAX){
                cout<<"INF";
            }
            else{
                cout<<dist[i]<<endl;
            }
        }
        cout<<endl;
    }
}

 */

 //// end the lcs 
 /*#include <bits/stdc++.h>
using namespace std;
int LCS(string s1, string s2, int x, int y, int c[1000][1000])
{
    for(int i = 1; i <= x; i++)
    {
        for(int j = 1; j <= y; j++)
        {
            if(s1[i - 1] == s2[j - 1]) c[i][j] = c[i - 1][j - 1] + 1;
            else c[i][j] = max(c[i][j - 1], c[i - 1][j]);
        }
    }
    return c[x][y];
}

string getLCS(string s1, string s2, int x, int y, int c[1000][1000])
{
    string lcs = "";
    int i = x, j = y;
    while(i > 0 && j > 0)
    {
        if(s1[i - 1] == s2[j - 1])
        {
            lcs = s1[i - 1] + lcs;
            i--;
            j--;
        }
        else if(c[i - 1][j] >= c[i][j - 1]) i--;
        else j--;
    }
    return lcs;
}

void printTable(int c[1000][1000], int x, int y)
{
    for(int i = 0; i <= x; i++)
    {
        for(int j = 0; j <= y; j++) cout << c[i][j] << " ";
        cout << '\n';
    }
}

int main()
{
    string s1 = "BDCABA";
    string s2 = "ABCBDAB";
    int x = s1.size();
    int y = s2.size();

    int c[1000][1000] = {0};

    int lcs_length = LCS(s1, s2, x, y, c);

    cout << "DP Table: " << '\n';
    printTable(c, x, y);
    cout << '\n';

    string lcs = getLCS(s1, s2, x, y, c);

    cout << "Length of LCS: " << lcs_length << '\n';
    cout << "LCS: " << lcs << '\n';
    return 0;
}
*/