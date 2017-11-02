package org.fsy.compile.core;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Fu编程语言编译器
 *
 *
 * 包含的语言特性:
 * 脚本语言 逐行执行
 * 打印
 * Created by fushiyong on 2017/11/1.
 */
public class FuCompile {

    private final  String DEFAULT_WORKDIR = "~";


    Map<String,String> variableMap = new HashMap<>();

    public FuCompile(String filePath){

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            String sb = null;
            while((sb = br.readLine()) != null){
                //打印
                //移除头尾的空格并把多个空格变为一个空格
                if(sb.contains("print")){
                    //print a  打印 a
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        new FuCompile("");
        Integer a = null;
        main2(Optional.ofNullable(a),"13");
    }

    public static void main2(Optional<Integer> i,String str){
        String s = "     3     4   ";
        String ss = removeBlank(s);
        return;
    }

    /**
     * 将 "     3     4   " 改成 "3 4"
     * @return
     */
    public static String removeBlank(String str){
        //去除头空格
        str = removeBeforeBlank(str);
        //去除尾空格
        str = removeAfterBlank(str);
        //去除中间多余空格为1个空格
        while(str.contains("  ")){
            str = str.replaceAll("  ","");
        }
        return str;
    }

    private static String removeAfterBlank(String str) {
        while(str.charAt(str.length()-1) == ' '){
            str = str.substring(0,str.length()-1);
        }
        return str;
    }

    private static String removeBeforeBlank(String str) {

        while(str.charAt(0) == ' '){
           str = str.substring(1);
        }
        return str;

    }
}
