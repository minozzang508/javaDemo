package Algorithm;

public class prgmrs0830 {
    public static long solution(int[][] rectangles) {
        long answer = 0;

        int[][] tmp = new int[rectangles.length][4];
        int[][] gyup = new int[rectangles.length - 1][4];
        int tmpIdx = 0;
        int gyupIdx = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        do{
            for(int[] i : rectangles){
                answer += (i[2] - i[0]) * (i[3] - i[1]);
                tmp[tmpIdx] = i;

                if(tmpIdx >= 1){
                    gyupIdx = 0;
                    for(int[] j : tmp) {
                        int leftLimit = i[0];
                        int rightLimit = i[2];
                        int topLimit = i[3];
                        int botLimit = i[1];
                        int width = 0;
                        int height = 0;

                        if(gyupIdx < tmp.length - 1){
                            //중복가로기리
                            if(leftLimit <= j[0]){
                                if(j[2] < rightLimit){
                                    width = j[2] - j[0];
                                    gyup[gyupIdx][0] = j[0];
                                    gyup[gyupIdx][2] = j[2];
                                }else{
                                    width = rightLimit - j[0];
                                    gyup[gyupIdx][0] = j[0];
                                    gyup[gyupIdx][2] = rightLimit;
                                }
                            }else{
                                if(leftLimit < j[2] && j[2] <= rightLimit) {
                                    width = j[2] - leftLimit;
                                    gyup[gyupIdx][0] = leftLimit;
                                    gyup[gyupIdx][2] = j[2];
                                }else {
                                    width = rightLimit - leftLimit;
                                    gyup[gyupIdx][0] = leftLimit;
                                    gyup[gyupIdx][2] = rightLimit;
                                }
                            }
                            //세로중복가로기리
                            if(topLimit <= j[1]){
                                if(j[3] < botLimit){
                                    height = j[3] - j[1];
                                    gyup[gyupIdx][1] = j[1];
                                    gyup[gyupIdx][3] = j[3];
                                }else{
                                    height = topLimit - j[3];
                                    gyup[gyupIdx][1] = topLimit;
                                    gyup[gyupIdx][3] = j[3];
                                }
                            }else{
                                if(botLimit < j[1] && j[1] <= topLimit) {
                                    height = j[3] - botLimit;
                                    gyup[gyupIdx][1] = botLimit;
                                    gyup[gyupIdx][3] = j[3];
                                }else {
                                    height = topLimit - botLimit;
                                    gyup[gyupIdx][1] = botLimit;
                                    gyup[gyupIdx][3] = topLimit;
                                }
                            }

                            if(width*height != 0) {
                                gyupIdx++;
                                answer -= width*height;
                            }
                        }
                    }
                }
                tmpIdx++;
            }
            tmp = gyup;
            gyup = new int[tmp.length - 1][4];
        }while(gyup.length > 1);

        return answer;
    }

    public static void main(String[] args) {
        int[][] case1 = {{0, 1, 4, 4}, {3, 1, 5, 3}};
        int[][] case2 = {{1, 1, 6, 5}, {2, 0, 4, 2}, {2, 4, 5, 7}, {4, 3, 8, 6}, {7, 5, 9, 7}};

        System.out.println(solution(case1));
        System.out.println(solution(case2));
        
    }
}