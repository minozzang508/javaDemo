package playground;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class SingletonCounter {
    private static SingletonCounter singleton = new SingletonCounter();
    private int cnt = 0;
    private SingletonCounter(){
    }
    public static SingletonCounter getInstance(){
        return singleton;
    }
    public int getNextInt(){
        return ++cnt;
    }
}

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.Amethod();
        t.Bmethod();
    }
    public void Amethod(){
        SingletonCounter sc = SingletonCounter.getInstance();
        System.out.println("Amethod에서 카운터 호출 " + sc.getNextInt() );
    }
    public void Bmethod(){
        SingletonCounter sc = SingletonCounter.getInstance();
        System.out.println("Bmethod에서 카운터 호출 " + sc.getNextInt() );
    }
}

class WordCount {
    public static void main(String[] args) {
        String[] text = {
                "This is mino",
                "mino is zzang",
                "why not mino"
        };

        Map<String, Integer> wordcount = new HashMap<String, Integer>();


        String s = "";

        for(int i = 0; i < text.length; i++) {
            String[] tmp = text[i].split(" ");

            for(String word : tmp) {
                if(wordcount.containsKey(word)) {
                    int cnt = wordcount.get(word);
                    wordcount.put(word, cnt + 1);
                }
                else {
                    wordcount.put(word, 1);
                }
            }
        }

        Iterator it = wordcount.entrySet().iterator();
 
        //System.out.println(it.next());

        while(it.hasNext()) {
            System.out.println(it.next());
        }


    }
}

class person {
    private int age;
    private String name;

    static int numOfPerson = 0;

    private person soohyun = new person();

    public person getInstance() {
        return this.soohyun;
    }

    public person() {

    }
    public person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

class BwG {
    public static void main(String[] args) {
        person p1 = new person(10, "mino");
        person p2 = new person(10, "mino");

        System.out.println(p1 == p2);

        Map<person, Integer> personMap = new HashMap<person, Integer>();
        personMap.put(p1,1 );
        personMap.put(p2, 1);

        System.out.println(personMap.size());

        String a = "mino";
        String b = "mino";
        System.out.println(a == b);

        Map<String, Integer> stringMap = new HashMap<String, Integer>();

        stringMap.put(a, 1);
        stringMap.put(b, 2);

        System.out.println(stringMap.size());
    }
}