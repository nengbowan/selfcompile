package org.fsy.compile.core;


/**
 * 有穷自动机的封装
 *
 * Created by fushiyong on 2017/11/2.
 */
public class DFAMachine {
    //有穷自动机的状态集
    private String[] Q= {DataType.VARIABLE.ordinal()+"",DataType.FUNCTION.ordinal()+""};

    //有穷自动机的字母集合 也就是变量的定义  a-z A-Z 1-9 0 _
    private String []  allCharacter = {
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
    private static String forwardFunction [][] = new String[2][63];

    static{
        //初始化有穷自动机的转移函数
//        forwardFunction = {
//                {}
//        };
    }
}
