package com.xugu.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibInterceptor implements MethodInterceptor {
    private Object obj;

    public CglibInterceptor(Object obj) {
        this.obj = obj;
    }

    //获取代理对象
    public Object getProxy(){
        //通过Enhancer对象create方法生成一个类
        Enhancer enhancer=new Enhancer();
        //设置父类
        enhancer.setSuperclass(obj.getClass());
        //设置拦截器，回调对象为本身对象
        enhancer.setCallback(this);
        //生成代理对象
        return enhancer.create();
    }

    //类似invoke方法
    /*
    * o:代理对象
    * method：目标方法
    * objects:参数
    * methodProxy：用于执行invoke方法
    * */

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法开始");
        Object object=methodProxy.invoke(obj,objects);
        System.out.println("方法结束");
        return null;
    }
}
