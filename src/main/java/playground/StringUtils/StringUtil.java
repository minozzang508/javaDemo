package playground.StringUtils;

public class StringUtil {
    //주석 및 태그 지우자.
    public static String eraseTag(String s) {
        return s.replaceAll("<(/)?([a-zA-Z!]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
    }

    //개행문자를 없애다.
    public static String eraseWhiteSpace(String s){
        System.out.println("system.getProperty(\"line.separator\") : " + System.getProperty("line.separator"));
        s = s.replaceAll(" {4}", "\t");
//        return s.replaceAll(System.getProperty("line.separator"), " ");
        return s.replaceAll("/\\s\\s+/g", " ");
    }
}
