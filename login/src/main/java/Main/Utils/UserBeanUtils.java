package Main.Utils;

import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class UserBeanUtils {
    public  static <T> T BeanUt(Map value, T clazz){
        try {
            BeanUtils.populate(clazz,value);
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return clazz;
    }

    public static String getJsonString(Map<String, Object> tmp){
        Gson gson = new Gson();
        String json = gson.toJson(tmp);
        //4.返回结果

        return json;
    }

    public static int parseInt(String value,int defaultValue){
        if(value == null){
            return defaultValue;
        }
        return Integer.parseInt(value);
    }
}
