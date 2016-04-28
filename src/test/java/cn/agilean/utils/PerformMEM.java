package cn.agilean.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by zxg on 16/4/25.
 */
public class PerformMEM {
    public static String GetMemory(String packageName) {

        String str3=null;
        Runtime runtime = Runtime.getRuntime();
        Process proc = null;
        try {
            proc = runtime.exec("adb shell dumpsys meminfo "+packageName);
            if (proc.waitFor() != 0) {
                System.err.println("exit value = " + proc.exitValue());
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    proc.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String line = null;
            while ((line = in.readLine()) != null) {
                stringBuffer.append(line+" ");

            }
            String str1=stringBuffer.toString();
            String str2=str1.substring(str1.indexOf("Objects")-60,str1.indexOf("Objects"));
            str3=str2.substring(0,10);
            str3.trim();
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            try {
                proc.destroy();
            } catch (Exception e2) {
            }
        }
        return str3 ;
    }

}
