package oj.hot200;

import oj.dto.HtmlParser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1236 {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> set = new HashSet<>();
        String host = "http://" + startUrl.substring(7).split("/")[0];
        List<String> pre = htmlParser.getUrls(startUrl), next = new ArrayList<>();
        List<String> res = new ArrayList<>();
        res.add(startUrl);
        set.add(startUrl);
        while (!pre.isEmpty()) {
            for (String s : pre) {
                if (s.startsWith(host) && !set.contains(s)) {
                    next.add(s);
                    res.add(s);
                    set.add(s);
                }
            }
            pre = new ArrayList<>();
            for (String s : next) {
                pre.addAll(htmlParser.getUrls(s));
            }
            next = new ArrayList<>();
        }
        return res;
    }
}
