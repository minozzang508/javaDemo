package Algorithm.tp9;

public class alg_07_CrazyBot {
    boolean[][] grid = new boolean[100][100];
    int vx[] = {1,-1,0,0};
    int vy[] = {0,0,1,-1};

    double[] prob = new double[4];

    public double getProbability(int n, int east, int west, int south, int north){
        prob[0] = east / 100;
        prob[1] = west / 100;
        prob[2] = south / 100;
        prob[3] = north / 100;

        return dfs(50,50,n);
    }

    double dfs(int x, int y, int n){
        if(grid[x][y]) return 0;
        if(n==0) return 1;

        grid[x][y] = true;
        double ret = 0;
        for(int i = 0; i < 4; i++){
            //east,west,south,north 순서로 로봇 움직이기
            ret += dfs(x + vx[i], y + vy[i], n - 1) * prob[i];
        }

        grid[x][y] = false;

        return ret;
    }
}
