package com.xugu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
* JDK动态代理
* public static Object newProxyInstance(ClassLoader loader,
                                      class<?>[] interfaces,
                                      InvocationHandler h)
                               throws IllegalArgumentException
   1、类加载器
   2、接口数组
   3、每一个jdk动态代理都需要实现InvocationHandler接口
* */
public class JdkHandler implements InvocationHandler {

    //目标对象不固定
    private Object obj;
    //通过带参构造器传递目标对象
    public JdkHandler(Object obj) {
        this.obj = obj;
    }

    //获取代理对象，1、当前的类加载器,目标对象接口，接口的实现类
    public Object getProxy(){
        Object object= Proxy.newProxyInstance(this.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
        return  object;
    }

    /*
    *调用目标对象的方法
    * 增强目标对象行为
    *
    * proxy代理对象
    * method，目标对象方法
    * args，目标对象方法的函数
    * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //增强行为
        System.out.println("日志记录");
        //调用目标对象方法，返回object
       // Object obj=method.invoke(args);
      //  return obj;
        Object object=method.invoke(obj,args);
        return object;
        //method.invoke(args);
        //        return null;返回空
    }
}
