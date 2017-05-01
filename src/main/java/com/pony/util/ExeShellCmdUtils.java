package com.pony.util;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/5/1
 */
public class ExeShellCmdUtils {

    public static String exec(String cmd) {
        try {
            String[] cmdA = { "/bin/sh", "-c", cmd };
            Process process = Runtime.getRuntime().exec(cmdA);
            LineNumberReader br = new LineNumberReader(new InputStreamReader(
                    process.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sb.append(line).append("\n");
            }

            return sb.length() > 0 ? sb.deleteCharAt(sb.length()-1).toString() : sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String pwdString = exec("pwd").toString();
        String netsString = exec("netstat -nat|grep -i \"80\"|wc -l").toString();

        System.out.println("==========获得值=============");
        System.out.println(pwdString);
        System.out.println(netsString);
    }

}