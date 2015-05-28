package mine_game;

import java.util.Random;

// Legend
// Each "cell" in each board can have 13 states
// '0' to '8' depending on haw many bombs surrounds the square
// 'u' for unknown
// 'b' for bomb
// 'c' for can be clicked
// 'n' for null value (used for solving)

public class hidden_key {
    int h; //tracks height of the board
    int w; //tracks the width of the board
    int m_num; //number of mines in the game
    private int[] track; //keeps track of bombs
    private int[] bomb; //list of bomb locations
    private StringBuffer secret_key; //hidden board

    hidden_key(int h, int w, int m_num){
        this.h = h;
        this.w = w;
        this.m_num = m_num;
        secret_key = new StringBuffer(h*w); //sets the board to 0
        for (int count=0;count<h*w;count++){
            secret_key.append('0');
        }
        track = new int[h*w];
        bomb = new int[m_num];
        generate_blist();
        update_hkey();
    }

    hidden_key(int h, int w, int[] bomb){
        this.h = h;
        this.w = w;
        this.bomb = bomb;
        m_num = bomb.length;
        secret_key = new StringBuffer(h*w); //sets the board to 0
        for (int count=0;count<h*w;count++){
            secret_key.append('0');
        }
        update_hkey();
    }

    // creates a bomb list (uses track list to make sure there are m_num of bombs)
    private void generate_blist(){
        Random randomGenerator = new Random();
        for(int b_num=0; b_num < m_num;b_num++){
            int temp = 0;
            while(temp==0){ //make sure that a bomb_loc is created
                int ran_loc = randomGenerator.nextInt(h*w);
                if (track[ran_loc]==0){
                    track[ran_loc] = 1;
                    bomb[b_num]=ran_loc;
                    temp = 1; // exit the while loop
                }
            }
        }
    }

    private void update_hkey(){
        for(int loc:bomb){
            if (loc%w==0){
                for(int t_loc=0 ; t_loc<9 ; t_loc++){
                    int curr_loc = loc - 5 + t_loc;

                    System.out.println("New Loop");
                    System.out.println("current location:" + curr_loc);

                    if(curr_loc>=0 && curr_loc<=w*h-1){
                        int curr_val = Character.getNumericValue(secret_key.charAt(curr_loc));

                        System.out.println("current value at current location:" + curr_val);

                        if(curr_val>=0){
                            if (t_loc==4){

                                System.out.println("Before:" + secret_key.charAt(curr_loc));

                                secret_key.setCharAt(curr_loc, 'b');

                                System.out.println("After:" + secret_key.charAt(curr_loc));

                            }
                            else if (t_loc%3!=0){

                                System.out.println("Before:" + secret_key.charAt(curr_loc));

                                secret_key.setCharAt(curr_loc, (char) ('0' + curr_val + 1));

                                System.out.println("After:" + secret_key.charAt(curr_loc));

                            }
                        }
                    }
                }
            }
            else if ((loc-w+1)%w==0){
                for(int t_loc=0 ; t_loc<9 ; t_loc++){
                    int curr_loc = loc - 5 + t_loc;
                    if(curr_loc>=0 && curr_loc<=w*h-1){
                        int curr_val = Character.getNumericValue(secret_key.charAt(curr_loc));
                        if(curr_val>=0){
                            if (t_loc==4){
                                secret_key.setCharAt(curr_loc, 'b');
                            }
                            else if ((t_loc-2)%3!=0){
                                secret_key.setCharAt(curr_loc, (char) ('0' + curr_val + 1));
                            }
                        }
                    }
                }
            }
            else {
                for(int t_loc=0 ; t_loc<9 ; t_loc++){
                    int curr_loc = loc - 5 + t_loc;
                    if(curr_loc>=0 && curr_loc<=w*h-1){
                        int curr_val = Character.getNumericValue(secret_key.charAt(curr_loc));
                        if(curr_val>=0){
                            if (t_loc==4){
                                secret_key.setCharAt(curr_loc, 'b');
                            }
                            secret_key.setCharAt(curr_loc, (char) ('0' + curr_val + 1));
                        }
                    }
                }
            }
        }
    }

    public StringBuffer reveal_key(){
        for (int eum=0;eum<(w*h);eum++) {
            System.out.print(secret_key.charAt(eum));
            if ((eum-w+1)%w==0){
                System.out.print("\n");
            }
        }
        System.out.print("bomb:");
        for (int eum=0;eum<m_num;eum++){
            System.out.print(bomb[eum] + " ");
        }
        return secret_key;
    }
}
