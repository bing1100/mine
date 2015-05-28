package mine_game;

/**
 * Created by bing on 2015-05-04.
 */
public class hidden_key_test {
    public static void main(String args[]){
        //hidden_key test_ob1 = new hidden_key(16,30,1);
        //test_ob1.reveal_key();

        int[] array = {4};
        hidden_key test_ob2 = new hidden_key(4,4,array);
        test_ob2.reveal_key();
    }
}
