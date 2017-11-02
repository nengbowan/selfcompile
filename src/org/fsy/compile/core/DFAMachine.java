package org.fsy.compile.core;


import java.util.ArrayList;
import java.util.List;

/**
 * 有穷自动机的封装
 *
 * Created by fushiyong on 2017/11/2.
 */
public class DFAMachine {
    //有穷自动机的状态集
    // 0 初始类型
    // 1 字符串类型
    // 2 变量
    // 3 数字
    // 4 违规定义
    private int[] Q= {0,1,2,3,4};

    //有穷自动机的字母集合 也就是变量的定义  a-z A-Z 1-9 0 _
    private static String []  allCharacter = {
            "a",
            "b",
            "c",
            "d",
            "e",
            "f",
            "g",
            "h",
            "i",
            "j",
            "k",
            "l",
            "m",
            "n",
            "o",
            "p",
            "q",
            "r",
            "s",
            "t",
            "u",
            "v",
            "w",
            "x",
            "y",
            "z",
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L",
            "M",
            "N",
            "O",
            "P",
            "Q",
            "R",
            "S",
            "T",
            "U",
            "V",
            "W",
            "X",
            "Y",
            "Z",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "0",
            "_"

    };

    //有穷自动机的转移函数
    private static String forwardFunction [][] = {
            {"1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","3","3","3","3","3","3","3","3","3","3","1"},
            {"1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"},
            {"2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2"},
            {"4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","4","3","3","3","3","3","3","3","3","3","3","3"}
    };

    private static int [][] arr = {{123},{456}};



    //有穷自动机的结束符
    private static String [] endFlag = {
            //赋值运算符
            "=",
            "+=",
            "-=",
            "*=",
            "/=",
            "%=",
            //基本运算符
            "+",   //加法
            "-",   //减法
            "*",
            "/",
            "%",
            //比较运算符
            "<",
            "<=",
            ">",
            ">=",
            "==",
            "!=",
            //逻辑运算符
            //位运算符
            "&",  //位与运算
            "|",  //位或运算
            "^",  //位亦或运算
            " ",  //空格
            ";",  //语句结束符


    };

    private static List<String> typeList = new ArrayList<>();
    public void init() {

        //数据类型关键词
        //字节
        typeList.add("byte");

        //短整
        typeList.add("short");

        //单字符
        typeList.add("char");

        //整型
        typeList.add("int");

        //单精度浮点数
        typeList.add("float");

        //双精度浮点数
        typeList.add("double");



    }


        //根据当前状态 + 下一次输入的字符 得到 是否到了最终态

        //判断一个单词是
        //1.开始类型
        //2.变量
        //3.字符串
        //4.数字
        public static int getTokenType(String string){
            //最终状态默认为-1
            int  finalStatus = -1;

            //当前状态为初始状态
            int row = 0 ;

            //当前输入字符
            int column = -1;

            int length = string.length();

            for(int i = 0;i<length;i++){


                //取出当前输入字符 soa
                char currentChar = string.charAt(i);

                //获取当前输入字符在变量字母表的下标
                column = findCharAtArray(currentChar+"",allCharacter);

                if(column == -1){
                    throw new IllegalArgumentException("变量输入违法!!!");
                }

                finalStatus =  Integer.valueOf(forwardFunction[row][column])  ; // 当前状态

                row = finalStatus;
                //变换行的值继续轮询


            }


            return finalStatus;
    }

    public static int findCharAtArray(String str , String[] strings){
        int index = -1;
        for(int i = 0;i<strings.length;i++){
            if(strings[i].equals(str)){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int a = getTokenType("11");

        switch (a){
            case 0 : System.out.println("数据类型为初始化类型");break;
            case 1 : System.out.println("数据类型为字符串");break;
            case 2 : System.out.println("数据类型为变量");break;
            case 3 : System.out.println("数据类型为数字");break;
            case 4 : System.out.println("数据类型变量定义违规");break;
            default: throw new IllegalArgumentException("未找到数据类型定义");
        }
        return ;
    }

}
