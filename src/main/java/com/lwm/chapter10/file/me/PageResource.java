package com.lwm.chapter10.file.me;

import java.io.*;

/**
 * @author weeming
 * @date 2021/12/1 20:25
 */
public class PageResource {

    private final static String TEMPLATE_PATH = "src/main/resources/template.html";
    private static StringBuilder htmlStr;
    private static String liStr = "<li><a href=\"{name}/\">{name}</a></li>\n";
    private String li;
    private String title;
    private String path;

    static {
        htmlStr = new StringBuilder();
        File f = new File(TEMPLATE_PATH);
        if (!f.exists()) {
            throw new RuntimeException("template file not found");
        }
        try (FileReader reader = new FileReader(f);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            bufferedReader.lines().forEach(htmlStr::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PageResource() {}

    public static PageResource instance() {
        return new PageResource();
    }

    public void newLi(String name) {
        li += liStr.replace("{name}", name);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String toHtmlString() {
        return htmlStr.toString()
                .replace("{title}", title)
                .replace("{path}", path)
                .replace("{list}", li);
    }

}
