/**
 * Created by bingxuhu on 4/9/2015.
 */

interface board{
    String get_board_string(); //returns the board in the form of a string
    String insert_bombs(); //inserts bombs based on a random basis
    String insert_bombs(int [] key); //inserts bombs based on the string set
}

