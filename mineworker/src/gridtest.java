/**
 * Created by bing on 2015-03-29.
 */
public class gridtest {
    public static void main(String args[]){
        grid test1 = new grid(3,3);
        test1.printgrid();

        test1.updatevalue("111111111");
        test1.printgrid();

        test1.updatevalue("000000000");
        test1.printgrid();
    }
}
