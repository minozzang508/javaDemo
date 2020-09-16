package Algorithm.tp9;

public class alg_05_ThePalindrome {
    public static int find(String s) {
        int answer = 0;
        int answer2 = 0;
        int size = s.length();

        for(int i = 0; i < size; i++){
            String tmp = s.substring(i);
            String endStr = new StringBuilder(tmp.substring(tmp.length() / 2)).reverse().toString();
            String startStr = tmp.substring(0, endStr.length());

            if(startStr.equals(endStr)){
                answer = size + i;
                break;
            }
        }

        for(int i = 0; i < size; i++){
            String tmp = s.substring(0, size - i);
            String startStr = new StringBuilder(tmp.substring(0, tmp.length() / 2)).reverse().toString();
            String endStr = tmp.substring(startStr.length() + 1);

            if(startStr.equals(endStr)){
                answer2 = size + i;
                break;
            }
        }

        return answer > answer2 ? answer2 : answer;
    }

    public static void main(String[] args) {
        String s = "1o1a";

        //7 나와야 댐
        System.out.println(find(s));
    }
}