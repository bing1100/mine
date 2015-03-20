/**
 * Created by bing on 2015-03-19.
 */
public class grid {
    int w;
    int h;
    String pop;
    cell[][] grid = new cell[w][h];


    public void create(){
        for(int k = 0; k < h; k++) {
            for (int j = 0; j < w; j++) {
                grid[j][k] = new cell();
                grid[j][k].value = (int) pop.charAt(k * h + j);
            }
        }
    }

    public void populate(){
        for(int k = 0; k < h; k++) {
            for(int j = 0; j < w; j++){
                grid[j][k].value = (int) pop.charAt(k * h + j);
            }
        }
    }

    public void print(){
        for(int k = 0; k < h; k++) {
            for (int j = 0; j < w; j++) {
                System.out.println(grid[k][j].value + " ");
            }
            System.out.println();
        }
    }
}
