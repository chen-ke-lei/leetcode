package oj.hot200;

import java.util.*;

public class Q588 {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/c/d", "hello");
        System.out.println(fileSystem.ls("/"));
        System.out.println(fileSystem.readContentFromFile("/a/b/c/d"));
    }
}

class FileSystem {
    File root;

    public FileSystem() {
        root = new File(true, "");
    }

    public List<String> ls(String path) {
        File file = findFile(path);
        if (file == null) return new ArrayList<>();
        if (!file.dir)
            return Arrays.asList(new String[]{file.name});

        List<String> res = new ArrayList<>(file.children.keySet());
        res.sort((a, b) -> a.compareTo(b));
        return res;
    }

    public void mkdir(String path) {
        String[] names = path.split("/");
        File tmp = root;
        for (String name : names) {
            if (name.length() == 0)
                continue;
            if (!tmp.children.containsKey(name)) {
                File file = new File(true, name);
                tmp.children.put(name, file);
            }
            tmp = tmp.children.get(name);
        }
    }

    public void addContentToFile(String filePath, String content) {
        File file = findFile(filePath);
        if (file == null) {
            mkdir(filePath.substring(0,
                    filePath.lastIndexOf("/") + 1));
            file = findFile(filePath.substring(0, filePath.lastIndexOf("/") + 1));
            File file1 = new File(false, filePath.substring(filePath.lastIndexOf("/") + 1));
            file1.content.append(content);
            file.children.put(file1.name, file1);
        } else if (!file.dir) {
            file.content.append(content);
        }
    }

    public String readContentFromFile(String filePath) {
        File file = findFile(filePath);
        if (file == null || file.dir) {
            return "";
        }
        return file.content.toString();
    }

    File findFile(String filePath) {
        String[] names = filePath.split("/");
        File tmp = root;
        for (String name : names) {
            if (name.length() == 0)
                continue;
            if (tmp.children.containsKey(name)) {
                tmp = tmp.children.get(name);
            } else {
                return null;
            }
        }
        return tmp;
    }
}

class File {
    boolean dir;
    Map<String, File> children;
    String name;
    StringBuffer content;

    public File(boolean dir, String name) {
        this.dir = dir;
        this.children = new HashMap<>();
        this.name = name;
        this.content = new StringBuffer();
    }
}