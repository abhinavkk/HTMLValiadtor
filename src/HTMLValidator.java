
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HTMLValidator {
	private static String HTML;
    
    public static void main(String[] args) throws Exception {
    	System.out.println("Enter your html string:");
    	Scanner input = new Scanner(System.in);
    	HTML = input.nextLine();
        parseWithJsoup();
    }
    private static void parseWithJsoup() {
        Document doc = Jsoup.parseBodyFragment(HTML);
        doc.outputSettings().prettyPrint(false);
        
        String parsedhtml = doc.body().html();
        System.out.println("Output HTML String:");
        System.out.printf("%s\n\n", parsedhtml);
        
        if(HTML.equals(parsedhtml))
        	System.out.println("Inputted html is correct");
        else
        {
        	System.out.println("Inputted html is not correct");
        }
    	System.out.println("\nHTML Format:");
    	doc.outputSettings().prettyPrint(true);
    	System.out.printf("%s\n", doc.body());
        System.out.println();
    }
}