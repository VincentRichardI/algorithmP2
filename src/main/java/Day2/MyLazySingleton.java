package Day2;

/*懒汉式单例模式：调用时再生成，可能存在线程安全问题
* */
public class MyLazySingleton {
    private MyLazySingleton(){}
    private static MyLazySingleton lazySingleton;

    public static MyLazySingleton getLazySingleton(){
        if (lazySingleton == null){
            lazySingleton = new MyLazySingleton();
        }
        return lazySingleton;
    }
}
