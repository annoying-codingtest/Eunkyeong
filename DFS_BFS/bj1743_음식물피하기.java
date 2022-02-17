package DFS_BFS;
import java.io.*;
import java.util.StringTokenizer;

public class bj1743_음식물피하기{
    public static int n, m; //맵의 크기
    public static int[][] map; //맵
    public static boolean[][] visited; //방문여부
    public static int result; //연결된 묶음 속 요소의 개수
    
    public static int[] dx = {-1, 0, 1, 0}; //상하좌우 방향 배열 -> 움직임 저장
    public static int[] dy = {0, -1, 0, 1};
    public static void solution(){ 
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (map[i][j] == 1 && !visited[i][j]) { // 값이 1이면서 아직 방문하지 않은 곳 탐색
                    int temp = result; // temp에 현재 result 저장
                    result = 0;
                    dfs(i, j);
                    result = Math.max(result, temp); //저장해둔 result 값이랑 현재 result값 비교해 최대값 저장
                }
            }
        }

    }

    public static void dfs(int curR, int curC){ //노드번호를 인자로 받음
        visited[curR][curC] = true; //방문 처리
        result ++; // 방문할 때마다 개수 추가

        for (int dir = 0; dir < 4; dir++) { //현재 위치에서 상하좌우 탐색
            int nextR = curR + dx[dir]; 
            int nextC = curC + dy[dir];

            if(nextR < 1 || nextC < 1 || nextR >= n+1 || nextC >= m+1) continue; //범위 설정
            else if (map[nextR][nextC] == 1 && !visited[nextR][nextC]) //상하좌우 중 값이 1이면서 방문하지 않은 곳 탐색
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