package bean;


//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MyTools {
    public MyTools() {
    }

    public static int strToint(String str) {
        if (str == null || str.equals("")) {
            str = "0";
        }

        boolean var1 = false;

        int i;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException var3) {
            i = 0;
            var3.printStackTrace();
        }

        return i;
    }

    public static float strToFloat(String str) {
        if (str == null || str.equals("")) {
            str = "0";
        }

        float f = 0.0F;

        try {
            f = Float.parseFloat(str);
        } catch (NumberFormatException var3) {
            f = 0.0F;
            var3.printStackTrace();
        }

        return f;
    }

    public static String toChinese(String str) {
        if (str == null) {
            str = "";
        }

        try {
            str = new String(str.getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException var2) {
            str = "";
            var2.printStackTrace();
        }

        return str;
    }
    public static int find(ArrayList<ContextInfo> contexts,int id){
        int flag=0;
        for(int i=0;i<contexts.size();i++){
            if (contexts.get(i).getId()==id){
                flag=i;
                break;
            }
        }
        return flag;
    }
    public static int finduser(ArrayList<UserInfo> users,int id){
        int flag=0;
        for(int i=0;i<users.size();i++){
            if (users.get(i).getId()==id){
                flag=i;
                break;
            }
        }
        return flag;
    }
}
