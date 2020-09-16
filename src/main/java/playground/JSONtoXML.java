package playground;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import org.json.*;      //Downloads : http://bit.ly/12O4D2w


/**
        Import .jar to IntelliJ Java project

        Open the project that you want to pack as a jar.
        Go to File -> Project structure.
        Select the Artifacts menu.
        Click on the green plus and select JAR -> From modules with dependencies... click Apply and then OK.
        Go to Build -> Build artifacts... -> Build
        Copy the .jar file that can be found in out/artifacts/<name>/<name>.jar
        Open your other project where you want to use your jar file.
        Create a folder named lib/ and put your jar file there.
        Go to File -> Project structure.
        Select the Modules menu on the left and the Dependencies tab.
        Click the green plus on the right side, select JARs or directories... and then select your jar file.
        You are ready to go.
*/

public class JSONtoXML
{
    private static String InputPath = "./input.json";
    private static String OutputPath = "./output.xml";

    public static void main(String[] args) throws FileNotFoundException, IOException, Exception
    {
        //Read JSON File
        long startTime = System.currentTimeMillis();
        String json = readFile(InputPath);//Read File
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Read File Duration: "+duration);

        //Convert JSON to XML
        startTime = System.currentTimeMillis();
        String xml = convert(json, "root");//State name of root element tag
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Process Data Duration: "+duration);

        //Write XML File
        startTime = System.currentTimeMillis();
        writeFile(OutputPath, xml);
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Write File Duration: "+duration);
    }

    public static String convert(String json, String root) throws Exception
    {
        JSONObject jsonFileObject = new JSONObject(json);
        String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-15\"?>\n<"+root+">"
                + org.json.XML.toString(jsonFileObject) + "</"+root+">";
        return xml;
    }

    public static String readFile(String filepath) throws FileNotFoundException, IOException
    {

        StringBuilder sb = new StringBuilder();
        InputStream in = new FileInputStream(InputPath);
        Charset encoding = Charset.defaultCharset();

        Reader reader = new InputStreamReader(in, encoding);

        int r = 0;
        while ((r = reader.read()) != -1)//Note! use read() rather than readLine()
        //Can process much larger files with read()
        {
            char ch = (char) r;
            sb.append(ch);
        }

        in.close();
        reader.close();

        return sb.toString();
    }

    public static void writeFile(String filepath, String output) throws FileNotFoundException, IOException
    {
        FileWriter ofstream = new FileWriter(filepath);
        try (BufferedWriter out = new BufferedWriter(ofstream)) {
            out.write(output);
        }
    }
}