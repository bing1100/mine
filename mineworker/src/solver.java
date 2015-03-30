/**
 * Created by bing on 2015-03-29.
 */
public class solver {
    cell current;


    solver(grid cgrid){
        current = cgrid.origin;
        int h = cgrid.h;
        int w = cgrid.w;

        cell store=cgrid.origin;
        cell cur=cgrid.origin;
        solve_mini a;

        for (int j=0; j<h;j++){
            for(int k=0;k<w;k++){
                if (cur.value>0) {
                    a = new solve_mini(cur);

                }
                cur=cur.right;
            }
            System.out.println();
            store=store.below;
            cur=store.below;
        }
    }

}
