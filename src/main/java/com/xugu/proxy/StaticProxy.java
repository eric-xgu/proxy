package com.xugu.proxy;

public class StaticProxy {
    public  static  void main(String args[]) {
        You you = new You();
        MarryCompanyProxy marryCompanyProxy = new MarryCompanyProxy(you);
        marryCompanyProxy.toMarry();
    }
}
