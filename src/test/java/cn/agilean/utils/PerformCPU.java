package cn.agilean.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zxg on 16/4/25.
 */
public class PerformCPU {
    public static String getCpuByDump(String packageName) {
        String str3=null;
        Runtime runtime = Runtime.getRuntime();
        Process proc = null;
        try {
            proc = runtime.exec("adb shell dumpsys cpuinfo | grep "+packageName);
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
            String str2=str1.substring(str1.indexOf(packageName),str1.indexOf(packageName)+28);
            str3=str2.substring(18,23);


        } catch (Exception e) {
            System.err.println(e);
        }finally{
            try {
                proc.destroy();
            } catch (Exception e2) {
            }
        }
        return str3;

    }

    public static double getCpuByTop(String PackageName) {
        double cpuVal = 0;
        try{
            Runtime runtime = Runtime.getRuntime();
            Process proc = runtime.exec("adb shell top -n 1| grep "+PackageName);
            try {
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
                String  str3=str1.substring(str1.indexOf(PackageName)-43,str1.indexOf(PackageName));
                String cpu= str3.substring(0,4);
                cpu=cpu.trim();
                cpuVal=Double.parseDouble(cpu);

            } catch (InterruptedException e) {
                System.err.println(e);
            }finally{
                try {
                    proc.destroy();
                } catch (Exception e2) {
                }
            }
        }
        catch (Exception StringIndexOutOfBoundsException)
        {

            System.out.print("请检查设备是否连接");

        }

        return cpuVal;

    }

}
