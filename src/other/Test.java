package other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Test {
    public static void main(String[] args) {
        File file=new File("C:\\cooding\\NCalendar-master");
        System.out.println(dfs(file));
    }
    static  int dfs(File f){
        int res=0;
        if(f.isDirectory() && !f.getName().toLowerCase().contains("test")){
            for(File nf:f.listFiles())
                res+=dfs(nf);
        }else if(f.getName().endsWith(".java")&&!f.getName().toLowerCase().contains("test")) {
            try {
                BufferedReader reader=new BufferedReader(new FileReader(f));
                String line=null;
                while ((line=reader.readLine())!=null){
                    if(line.trim().length()>0)
                        res++;
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return res;
    }
}
