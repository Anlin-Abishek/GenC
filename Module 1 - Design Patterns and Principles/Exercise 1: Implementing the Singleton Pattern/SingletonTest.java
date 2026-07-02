public class SingletonTest {
    public static void main(String[] args) {
        Logger log1=Logger.getInstance();
        Logger log2= Logger.getInstance();  

        log1.log("Test run 1");
        log2.log("Test run 2");

        System.out.println("instance are same...??"+(log1==log2));
    }
    
}
