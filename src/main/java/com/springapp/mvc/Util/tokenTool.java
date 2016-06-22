package com.springapp.mvc.Util;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by guanghaoshao on 16/4/10.
 */
public class tokenTool {
    static Map map=null;

    public static String addCookie(int maxAge){
        if(map==null) {
            map = new HashMap();
        }
            final String token=getRandomString(10);

            final Timer timer=new Timer();

            TimerTask timerTask=new TimerTask() {
                @Override
                public void run() {
                    deleteToken(token);
                }
            };
            timer.schedule(timerTask,maxAge);
            map.put(token,tokenUtil.MD5(token));

            return token;
    }
    private static int getRandom(int count) {
        return (int) Math.round(Math.random() * (count));
        }

    private static String string = "abcdefghijklmnopqrstuvwxyz";

    private static String getRandomString(int length){
        StringBuffer sb = new StringBuffer();
        int len = string.length();
        for (int i = 0; i < length; i++) {
            sb.append(string.charAt(getRandom(len-1)));
        }
        return sb.toString();
    }
    public static boolean gettoken(String token){
        if(map.containsValue(tokenUtil.MD5(token))){
            return true;
        }
        else {
            return false;
        }
    }
    public static void deleteToken(String token){
        if(map.containsKey(token)){
            map.remove(token);
        }
    }
}
