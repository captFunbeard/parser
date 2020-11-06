import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {
        private static Document getPage() throws IOException {
            String car = "nissan";
            String model = "almera";
            String zapros = "шаровая";
            String url = "http://haz.com.ua/search/search_ajax?name="+zapros+"+"+car+"+"+model;
            String urlAjax= "http://haz.com.ua/search/get_search_by_name_ajax_table";
            String tableUrl="http://haz.com.ua/design/js/all.js?";
            Document page = Jsoup.parse(new URL(url), 300000);
            Document table = Jsoup.parse(new URL(urlAjax), 300000);
            Document jqeryspec = Jsoup.parse(new URL(tableUrl), 300000);

            return jqeryspec;

        }
    public static void main(String[] args) throws Exception {
        Document page = getPage();
        System.out.println(page);
        Elements searchDetail = page.select("td[class=tbl-name]");
        Elements searchDetailPrice = page.select("td");
        System.out.println(searchDetail);
        System.out.println(searchDetailPrice);

        //Element tableWth = page.select("table[class=wt]").first();
        //Elements names = tableWth.select("tr[class=wth]");
        //Elements values = tableWth.select("tr[valign=top]");
        //int index=0;



        }
    }

