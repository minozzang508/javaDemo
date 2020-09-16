package Algorithm.lc7;

//997,287,242,841,684,785 갈

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//There are N rooms and you start in room 0,
//Each room has a distinct number in 0~ n-1 and each room may have some keys to access the next room
//Formally, each room i has a list of keys rooms[i]

public class alg_841_KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms){
         Queue<Integer> dpSearch = new LinkedList<>();

         for(int i : rooms.get(0)){

             for(int j : rooms.get(i)){
                 dpSearch.offer(j);
             }
         }

         return true;
    }
}
