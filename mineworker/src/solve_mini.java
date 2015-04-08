/**
 * Created by bing on 2015-03-29.
 */
public class solve_mini {
    int ar;
    int a;
    int al;
    int r;
    int v;
    int l;
    int br;
    int b;
    int bl;

    solve_mini(cell cent){

        if (cent.al() != null) al = cent.al().value;
        if (cent.above != null) a = cent.above.value;
        if (cent.ar() != null) ar = cent.ar().value;
        if (cent.left != null) l = cent.left.value;
        if (cent != null) v = cent.value;
        if (cent.right != null) r = cent.right.value;
        if (cent.bl() != null) bl = cent.bl().value;
        if (cent.below != null) b = cent.below.value;
        if (cent.br() != null) br = cent.br().value;;
    }

    public void solve_3b3(){

    }

}
