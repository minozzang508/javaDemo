package Performance.story02;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class story02_SystemClass {
    public static void main(String[] args) {
        String[] arr = new String[] {"AAA", "BBB", "CCC", "DDD", "EEE" };
        String [] copiedArr = new String[3];

        System.arraycopy(arr, 2, copiedArr, 0, 3);
        for(String value : copiedArr) {
            System.out.println(value);
        }

        //Get Properties
        System.setProperty("JavaTuning", "Minho Kim");

        Properties prop = System.getProperties();

        Set key = prop.keySet();
        Iterator i = key.iterator();

        while(i.hasNext()) {
            String curKey = i.next().toString();
            System.out.format("%s = %s\n", curKey, prop.getProperty(curKey));
        }

        System.out.println("==========================Environment==============================");
        Map envMap = System.getenv();

        key = envMap.keySet();
        Iterator i2 = key.iterator();

        while(i2.hasNext()) {
            String curKey = i2.next().toString();
            System.out.format("%s = %s\n", curKey, envMap.get(curKey));
        }
    }
}
