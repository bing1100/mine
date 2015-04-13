/**
 * Created by bingxuhu on 4/9/2015.
 */

import java.util.Random;

public class initiate_game implements board{
    int hieght;
    int width;
    int bombs_num;
    StringBuffer game_board;
    initiate_game(int h, int w, int bombs_num){
        hieght=h;
        width=w;
        this.bombs_num=bombs_num;
        game_board=new StringBuffer(h*w-1);
        for(int j = 0; j<(h*w-1);j++){
            game_board.setCharAt(j, '0');
        }
        insert_bombs();
    }

    initiate_game(int h, int w, int bombs_num, int[] key){
        hieght=h;
        width=w;
        this.bombs_num=bombs_num;
        game_board=new StringBuffer(h*w-1);
        for(int j = 0; j<(h*w-1);j++){
            game_board.setCharAt(j, '0');
        }
        insert_bombs(key);
    }

    public String get_board_string(){
        return game_board.toString();
    }

    public void insert_bombs(){
        Random randomGenerator = new Random();
        int[] key = new int[bombs_num-1];
        int[] track = new int[hieght*width -1];

        for (int iter=0;iter<bombs_num;iter++){
            int ran = randomGenerator.nextInt(hieght*width -1);
            if(track[ran]==0){
                key[iter]=ran;
                track[ran]=1;
            }
        }
        insert_bombs(key);
    }

    public void insert_bombs(int[] key){
        if (key.length!=(hieght*width-1)){
            System.out.println("Key has wrong length!");
        }
        for (int bombloc: key){
            game_board.setCharAt(bombloc,'*');
            for (int increment=0; increment<9; increment++){
                int currloc = bombloc-width-1+increment;
                if (game_board.charAt(currloc)!='*'){
                    int value = Character.getNumericValue(game_board.charAt(currloc))+1;
                    game_board.setCharAt(currloc,(char) value);
                }
            }
        }
    }
}
