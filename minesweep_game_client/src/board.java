/**
 * Created by bingxuhu on 4/9/2015.
 */

interface board{
    String get_board_string(); //returns the board in the form of a string
    void insert_bombs(); //inserts bombs based on a random basis
    void insert_bombs(int [] key); //inserts bombs based on the string set
}

