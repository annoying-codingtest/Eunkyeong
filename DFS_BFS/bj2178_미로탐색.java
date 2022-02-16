package DFS_BFS;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int x;
    int y;
    Pair(){}
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class bj2178_미로탐색 {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Pair> queue;
    static Queue<Integer> count;
    static int cnt;
    static int step;

    // 방향 - 우측, 하단, 상단, 좌측
    static int dr[] = {0,1,-1, 0};
    static int dc[] = {1,0,0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        queue = new LinkedList<Pair>();

        for(int i=0;i<N;i++) {
            String str = sc.next();
            for(int j=0;j<M;j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }
        // 배열의(0,0)에서 출발하여 배열의 (n-1,m-1)까지 이동
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(chk(i,j)==true && visited[i][j]==false && map[i][j]==1) {
                    bfs(i,j);
                }
            }
        }
        // 이동 횟수 출력
        System.out.println(map[N-1][M-1]);
    }

    static void bfs(int x, int y) {

        // 방문 체크 및 큐에 삽입
        visited[x][y] = true;
        queue.add(new Pair(x,y));

        while(!queue.isEmpty()) {
            Pair idx = queue.poll();
            for(int i=0;i<4;i++) {
                int nr = idx.x+dr[i];
                int nc = idx.y+dc[i];
                if(chk(nr, nc)==true && visited[nr][nc]==false && map[nr][nc]==1) {
                    visited[nr][nc] = true;
                    queue.add(new Pair(nr, nc));
                    // 전의 좌표 값을 새로운 값에 넣어준다 = 이동거리를 의미
                    // ex) 시작죄표는 1이니까 다음 이동값은 1+1=2가 된다.
                    map[nr][nc] = (map[idx.x][idx.y]+1);
                }
            }
        }
    }
    static boolean chk(int x, int y) {
        return 0<=x && x<N && 0<=y && y<M;
    }
}