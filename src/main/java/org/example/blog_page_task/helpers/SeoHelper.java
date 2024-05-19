package org.example.blog_page_task.helpers;

public class SeoHelper {
    public String seoUrlHelper(String text){
        //["Bavariya", "klubundan", "gozlenilmezq" ,"qerar"]
        String[] change = text.toLowerCase()
                .replaceAll("ə", "e")
                .replaceAll("ç", "c")
                .replaceAll("ö", "o")
                .replaceAll("ö", "o")
                .split(" ");
        String result = String.join("-", change);
        return result.replaceAll("[^a-z0-9-]","");
    }
}
