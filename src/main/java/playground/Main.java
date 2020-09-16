package playground;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Stack s = new Stack();
        String test = "{}{}}}";

        char tmp = '\0';

        for(int i = 0; i < test.length(); i++) {
            tmp = test.charAt(i);
            s.push(tmp);
            if(tmp == ')' )
            {
                s.pop();
                if('(' == (char) s.peek())
                {
                    s.pop();
                }
                else
                {
                    System.out.println("false");
                    break;
                }
            }
            if(tmp == '}' )
            {
                s.pop();
                if('{' == (char) s.peek())
                {
                    s.pop();
                }
                else
                {
                    System.out.println("false");
                    break;
                }
            }
            if(tmp == ']' ) {
                s.pop();
                if('[' == (char) s.peek())
                {
                    s.pop();
                }
                else
                {
                    System.out.println("false");
                    break;
                }
            }
            if(i == test.length() - 1 && s.size() == 0) {
                System.out.println("true");
            }
        }

    }
}
