/**
 * Created by bing on 2015-03-19.
 */
public class grid {
    int w;
    int h;
    String pop;
    cell[][] grid;

    grid(int height, int width, String population){
        h = height;
        w = width;
        pop = population;
        grid = new cell[w][h];

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
        System.out.println("Printing Grid");
        for(int k = 0; k < h; k++) {
            for (int j = 0; j < w; j++) {
                System.out.print(grid[k][j].value + "|");
            }
            System.out.println();
        }
    }
}
