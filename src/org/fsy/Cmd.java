package org.fsy;

import java.util.HashMap;

/**
 * Created by fushiyong on 2017/9/12.
 */
public class Cmd {
    HashMap<String,String> inputParams = new HashMap();

    public String getFilePath(){
        return inputParams.get("-f");
    }
    public Cmd(String inputStr){
        try {
            initMap(inputStr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initMap(String inputStr)throws IllegalArgumentException {

        String[] inputArr = inputStr.split(" ");

        //废弃第一个参数
        if(inputArr.length % 2 == 0){
            throw new IllegalArgumentException("param size is not right!");
        }else{
            for(int i=1;i + 1 <inputArr.length ;i++){
                inputParams.put(inputArr[i],inputArr[i+1]);
            }
        }

    }

}
