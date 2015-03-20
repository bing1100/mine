/**
 * Created by bing on 2015-03-19.
 */
public class grid {
    int w;
    int h;
    String pop;
    cell[][] grid = new cell[w][h];

    grid(int h, int w, String pop){
        h = h;
        w = w;
        pop = pop;
    }

    public void create() {
        System.out
        for(int k = 0; k < h; k++) {
            for (int j = 0; j < w; j++) {
                grid[j][k] = new cell();
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

    public void print(int a, int b){
        System.out.println(grid[a][b].value);
    }

    public void print_grid(){
        for(int k = 0; k < h; k++) {
            for (int j = 0; j < w; j++) {
                System.out.println(grid[k][j].value + "|");
            }
            System.out.println();
        }
    }
}
