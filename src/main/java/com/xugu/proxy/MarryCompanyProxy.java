package com.xugu.proxy;

/*增强用户行为*/

public class MarryCompanyProxy implements Marry {
    //通过对象注入增强
    private Marry target;
    /*代理对象获取到目标对象*/
    public MarryCompanyProxy(Marry target) {
        this.target = target;
    }
    @Override
    public void toMarry() {
        //行为增强
        before();
        target.toMarry();
        //行为增强
        after();


    }

    @Override
    public String toMarry02() {
        return null;
    }

    public void before(){
        System.out.println("happy wedding");
    }
    public void after(){
        System.out.println("wedding  is ending");
    }

}
