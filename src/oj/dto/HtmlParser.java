package oj.dto;


import java.util.List;

// This is the HtmlParser's API interface.
// You should not implement it, or speculate about its implementation
public interface HtmlParser {
    public List<String> getUrls(String url);
}
