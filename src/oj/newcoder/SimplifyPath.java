package oj.newcoder;

import java.util.ArrayList;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] subPath = path.split("/");
        ArrayList<String> tmp = new ArrayList<>();
        for (int i = 0; i < subPath.length; i++) {
            if (subPath[i].equals("..")) {
                if (tmp.size() > 0)
                    tmp.remove(tmp.size() - 1);
            } else if (subPath[i].equals("."))
                continue;
            else if (subPath[i].length() > 0)
                tmp.add(subPath[i]);
        }
        String res = "";
        for (int i = 0; i < tmp.size(); i++) {
            res =res+ "/" + tmp.get(i) ;
        }
        if (res.length() == 0)
            res = "/";

        return res;
    }
}
