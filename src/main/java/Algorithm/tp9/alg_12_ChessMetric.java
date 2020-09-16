package Algorithm.tp9;

public class alg_12_ChessMetric {
    long [][][] ways = new long[100][100][55];

    int[] dx = new int[] {1,1,1,0,-1-1-1,0,2,1,-1,-2,-2,-1,1,2};
    int[] dy = new int[] {1,0,-1,-1,-1,0,1,1,-1,-2,-2,-1,1,2,2,1};

    public long howMany(int size, int[] start, int[] end, int numMoves){
        int x,y,i,j;

        int sx = start[0], sy = start[1], ex = end[0], ey = end[1];

        ways[sy][sx][0] = 1;

        for(i = 1; i <= numMoves; i++){
            for(x = 0; x < size; x++){
                for(y = 0; y < size; y++){
                    for (j = 0; j < 16; j++){
                        int nx = x + dx[j];
                        int ny = y + dy[j];

                        if(nx < 0 || ny < 0 || nx >= size || ny >= size){
                            continue;
                        }

                        ways[ny][nx][i] += ways[y][x][i - 1];
                    }
                }
            }
        }

        return ways[ey][ex][numMoves];
    }

    //Enum과 point class를 활용해서 만들어보자
    private enum Move {
        LEFT(-1, 0), RIGHT(1, 0), UP(0, 1), DOWN(0, -1),
        UP_LEFT(-1, 1), UP_RIGHT(1, 1), DOWN_LEFT(-1, -1), DOWN_RIGHT(1, -1),
        UUL(-1, 2), UUR(1, 2), ULL(-2, 1), URR(2, 1),
        DDL(-1, -2), DDR(1, -2), DLL(-2, -1), DRR(2, -1);

        public int x;
        public int y;

        Move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // a1 = 1
    // a2 = a1 + a1 = 2
    // a3 = a2 * 2 + a1 * a1 = 5
    // a4 = a3 * 2 + a2 * a1 + a1 * a2 = 14
    // a4 = a2 * 2 + a1 * a1 + a2 * a1 + a2 * a1 = 4 * a2 + 1
    // a5 = 2 * (a4 + a3 * a2 + a3 * a1 + a2 * a2)
    // a6 = 2 * (a5 + a4 * a1 + a3 * a2)
    // an = 2 * a (n - 1)  + a(n - 2) * a(n - 2)
}
