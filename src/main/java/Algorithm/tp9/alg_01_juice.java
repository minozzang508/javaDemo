package Algorithm.tp9;

//주스 75 ㅅㅂ
public class alg_01_juice {
    public static int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId){
        for(int i = 0; i < fromId.length; i++){
            if(bottles[toId[i]] + bottles[fromId[i]] > capacities[toId[i]]){
                bottles[fromId[i]] = bottles[toId[i]] + bottles[fromId[i]] - capacities[toId[i]];
                bottles[toId[i]] = capacities[toId[i]];
            }else{
                bottles[toId[i]] += bottles[fromId[i]];
                bottles[fromId[i]] = 0;
            }
        }

        return bottles;
    }

    public static void main(String[] args) {
        int[] capacities = {20,20};
        int[] bottles = {5,8};
        int[] fromId = {0};
        int[] toId = {1};

        int[] answer = thePouring(capacities,bottles,fromId,toId);

        for(int i : answer){
            System.out.println(i);
        }



    }
}
