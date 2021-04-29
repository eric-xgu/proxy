package com.xugu;

import com.xugu.proxy.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      /*  System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //动态代理
        You you = new You();
        //获取代理类
        JdkHandler jdkHandler=new JdkHandler(you);
        //获取代理对象
        Marry marry=(Marry) jdkHandler.getProxy();
        marry.toMarry();
*/
        Ower owner=new Ower();
        CglibInterceptor cg=new CglibInterceptor(owner);
       Ower ower=(Ower) cg.getProxy();
        ower.rentHouse();
}
}
