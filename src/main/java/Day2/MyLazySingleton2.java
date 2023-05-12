package Day2;

/*
* 升级后的懒汉单例模式，使用双重校验机制：只在实例未创建前加锁，且双重校验机制可以避免多个线程同时进入
* 先考虑当前myLazySingleton2是否为空，若为空则锁定当前类，再询问当前
* 既保证线程安全，又保证性能
* */
public class MyLazySingleton2 {
    private MyLazySingleton2(){}
    private static MyLazySingleton2 myLazySingleton2;

    public static MyLazySingleton2 getMyLazySingleton2(){
        if (myLazySingleton2 == null){
            synchronized (MyLazySingleton2.class){
                /*
                * 第二次校验是为了防止其他线程实例为空时再次生成实例从而违反单例模式初衷
                * */
                if (myLazySingleton2 == null){
                    myLazySingleton2 = new MyLazySingleton2();
                }
            }
        }
        return myLazySingleton2;

    }
}
