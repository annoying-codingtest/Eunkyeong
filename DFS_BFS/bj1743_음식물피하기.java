package DFS_BFS;
import java.io.*;
import java.util.StringTokenizer;

public class bj1743_음식물피하기{
    public static int n, m;
    public static int[][] map;
    public static boolean[][] visited;
    public static int result;
    // 상좌하우
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void solution(){
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int temp = result;
                    result = 0;
                    dfs(i, j);
                    result = Math.max(result, temp);
                }
            }
        }

    }

    public static void dfs(int curR, int curC){
        visited[curR][curC] = true;
        result ++; // 방문할 때마다 개수 추가

        for (int dir = 0; dir < 4; dir++) {
            int nextR = curR + dx[dir];
            int nextC = curC + dy[dir];

            if(nextR < 1 || nextC < 1 || nextR >= n+1 || nextC >= m+1) continue;
            else if (map[nextR][nextC] == 1 && !visited[nextR][nextC])
                dfs(nextR, nextC);
        }

    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 1; i < k+1; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1;
        }

        solution();

        bw.write(result+"");

        br.close();
        bw.close();
    }
}