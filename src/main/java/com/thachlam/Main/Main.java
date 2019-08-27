package com.thachlam.Main;

/**
 *
 * @author Lam Du Thach
 */
public class Main {
    
    public static void main(String[] args) {
        Main m = new Main();
    }
    
    private String checkUrlResult(String url, String check){
        return url + check;
    }
    
    public String test1(){
        return checkUrlResult("this test1");
    }
}
