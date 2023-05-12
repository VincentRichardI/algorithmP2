package Day2;

/*
* 饿汉式单例：类加载时就创建，线程安全，消耗内存。只提供外部访问的方法
* */
public class MyEhSingleton {
    private MyEhSingleton(){

    }
    private static  MyEhSingleton mySingleton = new MyEhSingleton();
    public static MyEhSingleton getSingleton(){
        return mySingleton;
    }
}
