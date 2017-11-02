package org.fsy.compile.core;

import java.io.*;
import java.util.*;

/**
 * Fu编程语言编译器
 *
 *
 * 包含的语言特性:
 * 脚本语言 逐行执行
 * 非面向对象 面向过程
 * 打印
 * Created by fushiyong on 2017/11/1.
 */
public class FuCompile {

    private final  String DEFAULT_WORKDIR = "~";

    //系统关键词列表
    private static final List<String> keywordList = new ArrayList<>();

    //常量列表
    private static final List<String> constantList = new ArrayList<>();

    Map<String,String> variableMap = new HashMap<>();

    //脚本环境初始化
    static{
        //关键词初始化
        keywordList.add("print");
        //每个关键词的通用结构
        // 词 值 词类型  (0就是无绑定值)
        // 例如 print 0 function
        // 例如 a     13 variable
        // 或者 按词的类型 分别建立映射表 functionMap variableMap
        //词法扫描需要有穷机 识别一个输入 是否是单词 还是函数
    }
    public FuCompile(String filePath){

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            String sb = null;
            while((sb = br.readLine()) != null){
                //打印
                //移除头尾的空格并把多个空格变为一个空格
                sb = removeBlank(sb);

                //按空格分割的单词组
                String [] tokens = sb.split(" ");
                //系统关键词不处理
                for(int i= 0;i<tokens.length;i++){
                    String currentToken = tokens[i];

                    //系统关键词略过
                    if(keywordList.contains(currentToken)){
                        continue;
                    }else{
                        //


                    }
                }


                if(sb.startsWith("print")){
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
