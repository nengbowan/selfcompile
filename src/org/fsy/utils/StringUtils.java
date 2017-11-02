package org.fsy.utils;

import org.fsy.Cmd;

/**
 * Created by fushiyong on 2017/9/12.
 */
public class StringUtils {
    public static boolean replace2BlankWith1Blank(ValueObject replacedString , String inputString){

        replacedString.setValue(inputString.replace("  "," "));


        if(replacedString.getValue().contains("  ")){
            return replace2BlankWith1Blank(replacedString,replacedString.getValue());
        }else{
            return false;
        }
    }


    public static String replaceMultiBlankWith1Blank(String inputString){

        ValueObject valueObject = new ValueObject();
        replace2BlankWith1Blank(valueObject,inputString);

        return valueObject.getValue();
    }

    /**
     * 测试案例
     * @param args
     */
    public static void main(String[] args) {
        String cmdLine = "cmd  -f  c:\\windows\\system\\3.info  -c 13";
        String replacedString = replaceMultiBlankWith1Blank(cmdLine);
        Cmd cmd = new Cmd(replacedString);
        System.out.println(cmd.getFilePath());
        return;
    }
}
