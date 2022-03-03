import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");

            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();

            scanner.close();

            content = content.replaceAll("\\n+", "");

            Pattern p = Pattern.compile("name_song\">(.*?)</a>");
            Matcher m = p.matcher(content);
            while (m.find()) {
                System.out.println(m.group(1));
            }
        } catch (MalformedParameterizedTypeException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
