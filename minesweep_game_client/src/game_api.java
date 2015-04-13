/**
 * Created by bingxuhu on 4/10/2015.
 */
public class game_api implements board{

    StringBuffer answer_key;
    StringBuffer visible;
    game_api(int h, int w, int bomb){
        initiate_game board = new initiate_game(h,w,bomb);
        answer_key = new StringBuffer(board.get_board_string());
        visible = new StringBuffer(h*w-1);
        for(int j=0;j<(h*w-1);j++){
            visible.setCharAt(j,'0');
        }
    }
    public String get_board_string();
    public void insert_bombs();
    public void insert_bombs(int [] key);
}
