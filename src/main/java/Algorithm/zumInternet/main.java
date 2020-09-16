package Algorithm.zumInternet;

import java.util.*;

public class main {
    public static int solution(int[] A) {
        int answer = 0;
        // write your code in Java SE 8
        int size = A.length;
        for (int i = 1; i <= size; i++){
            int[] tmp = new int[i];
            System.arraycopy(A, 0, tmp, 0, i);
            Arrays.sort(tmp);
            if(tmp.length == tmp[tmp.length - 1]){
                answer += 1;
            }
        }

        return answer;
    }

    private static int solution2(int[] A) {
        // write your code in Java SE 8
        int answer = 1;
        int size = A.length;
        int cnt = 2;
        boolean isPositive;
        boolean beforePositive;
        if(size == 1) {
            return answer;
        }else {
            beforePositive = A[1] - A[0] > 0;
        }

        for(int i = 1; i < size; i++){
            int tmp = A[i] - A[i - 1];
            isPositive = tmp > 0;
            if(tmp != 0){
                if(beforePositive != isPositive){
                    cnt++;
                    beforePositive = isPositive;
                }
            }else{
//                answer = (answer > cnt ? answer : cnt);
                cnt = 1;
            }
        }

        return answer > cnt ? answer : cnt;
    }

    public int[][] createBoard() {
        int columnLength = (int)(Math.random()*100)+1;
        int rowLength = (int)(Math.random()*100)+1;
        int[][] board = new int[rowLength][columnLength];
        for(int i=0; i<rowLength; i++){
            for(int j=0; j<columnLength; j++){
                board[i][j] = (int) (Math.random()*10);
            }
        }
        return board;
    }

    public void search(int [][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] > 0){
                    Map map = neighboringMap(board, i, j);


                }
            }
        }
    }

    public Map<String, Map<String, Integer>> neighboringMap(int [][] board, int rowPosition, int columnPosition){
        Map<String, Map<String, Integer>> map = new HashMap();

        //상측 인접 필드 유무
        if(rowPosition > 0){
            Map position = new HashMap();
            position.put("row", rowPosition-1);
            position.put("column", columnPosition);
            map.put("top", position);
        }
        //하측 인접 필드 유무
        if(rowPosition < board.length-1){
            Map position = new HashMap();
            position.put("row", rowPosition+1);
            position.put("column", columnPosition);
            map.put("bottom", position);
        }

        //좌측 인접 필드 유무
        if(columnPosition > 0){
            Map position = new HashMap();
            position.put("row", rowPosition);
            position.put("column", columnPosition-1);
            map.put("left", position);
        }
        //우측 인접 필드 유무
        if(columnPosition < board[board.length-1].length-1){
            Map position = new HashMap();
            position.put("row", rowPosition);
            position.put("column", columnPosition+1);
            map.put("right", position);
        }

        return map;
    }

    public static void main(String[] args) {
        int[] testCase = {2,1,3,5,4};

        int[] testCase2 = {50, 150, 50, 150, 50, 150, 50, 150, 50};

        System.out.println(solution2(testCase2));
    }

    public static int necklaceNo = 0; //목걸이 번호
    public static Map<Integer, ArrayList<Integer>> necklaceMap = new HashMap<>();

    public int solution3(int[] a) {


        // write your code in Java SE 8
        //엉클어진 목걸이 풀기 -> 목걸이 연결하기
        for (int beadNo = 0; beadNo < a.length; beadNo++) {
            int nextBeadNo = a[beadNo];
            if(necklaceMap.size() == 0) { // 처음돌때, 목걸이맵에 암것도 없으면  [0번째 목걸이]에 [구슬번호와 다음구슬번호] 넣음
                makeNewNecklace(beadNo, nextBeadNo);
            }else {
                boolean isMakeNew = true;
                for( Integer mapNecklaceNo : necklaceMap.keySet() ){ // 목걸이 하나씩 검토
                    ArrayList<Integer> mapNecklace = necklaceMap.get(mapNecklaceNo);
                    for (Integer mapNecklaceBeadNo : mapNecklace) { // 목걸이에서 구슬 하나씩 검토
                        Integer mapNecklaceBeadNoIdx = mapNecklace.indexOf(mapNecklaceBeadNo); //목걸이 구슬 순번과
                        if(mapNecklaceBeadNo == beadNo) { // 지금 구슬번호와 같으면
                            mapNecklace.add(mapNecklaceBeadNoIdx+1, nextBeadNo); //다음구슬번호를 끼운다
                            isMakeNew = false;
                            break;
                        }else if(mapNecklaceBeadNo == nextBeadNo) { // 다음 구슬번호와 같으면
                            mapNecklace.add(mapNecklaceBeadNoIdx, beadNo); //구슬번호를 이전에 끼운다
                            isMakeNew = false;
                            break;
                        }
                    }
                }
                //목걸이가 없으면 새 목걸이를 만든다.
                if (isMakeNew) {
                    makeNewNecklace(beadNo, nextBeadNo);
                }
            }
        }

        boolean flag = false;
        while (flag) {
            flag = mergeNecklace();
        }

        //가장 긴 목걸이 찾기
        int longNecklaceSize = 0;
        for (Integer mapNecklaceNo : necklaceMap.keySet()) {
            int mapNecklaceSize = necklaceMap.get(mapNecklaceNo).size();
            if(longNecklaceSize < mapNecklaceSize) longNecklaceSize = mapNecklaceSize;

        }

        return longNecklaceSize;
    }

    public static boolean mergeNecklace() {
        //따로 떨어져 만들어진 목걸이 연결되면 연결해서 합치기
        for (Integer mapNecklaceNo : necklaceMap.keySet()) {
            ArrayList<Integer> necklace1 = necklaceMap.get(mapNecklaceNo);
            for (Integer mapNecklaceNo2 : necklaceMap.keySet()) {
                ArrayList<Integer> necklace2 = necklaceMap.get(mapNecklaceNo2);
                boolean mergeFlag = false;
                if(!necklace1.toString().equalsIgnoreCase(necklace2.toString())) {//목걸이1과 목걸이2가 나 자신이 아닐 때 계산
                    //같은 값이 각각의 몇번째에서 몇번째인지
                    ArrayList<Integer> newNecklace = new ArrayList<>();

                    for (Integer necklace1Bead : necklace1) {
                        for (Integer necklace2Bead : necklace2) {
                            if(necklace1Bead.equals(necklace2Bead)) {
                                newNecklace.addAll(necklace1); //겹치면 목걸이 1,2를 합치고
                                newNecklace.addAll(necklace2); //겹치면 목걸이 1,2를 합치고
                                necklaceMap.put(mapNecklaceNo, newNecklace); //목걸이 1을 합친것으로 대체
                                necklaceMap.remove(mapNecklaceNo2); //2를 지운다.
                                return true;
                            }
                        }
                    }
                }
            }

        }

        return false;

    }

    public static void makeNewNecklace(int beadNo, int nextBeadNo) {
        necklaceNo = necklaceNo+1;
        ArrayList<Integer> newNecklace = new ArrayList<Integer>();
        newNecklace.add(beadNo);
        newNecklace.add(nextBeadNo);
        necklaceMap.put(necklaceNo, newNecklace);
    }
}
