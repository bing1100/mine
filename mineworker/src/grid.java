/**
 * Created by bing on 2015-03-28.
 */
public class grid {
    int w;
    int h;

    cell origin;

    grid(int width, int height){
        w=width;
        h=height;
        origin = new cell(0,null,null,null,null);

        cell store = origin;
        cell current = store;

        for (int j=0; j<w;j++){
            for (int k=0;k<h;k++) {
                current.below = new cell(0, null, null, null, null);
                current.below.above = current;
                if (current.left != null) {
                    current.below.left = current.left.below;
                    current.left.below.right = current.below;
                }
                current=current.below;
            }
            store.right=new cell(0,null,null,null,null);
            store.right.left=store;

            store=store.right;
            current=store;
        }
    }

    public void printgrid(){
        System.out.println("Printing...");
        cell store=origin;
        cell curr=origin;
        for (int j=0; j<h;j++){
            for(int k=0;k<w;k++){
                System.out.print((char) curr.value + "|");
                curr=curr.right;
            }
            System.out.println();
            store=store.below;
            curr=store.below;
        }
    }

    public void updatevalue(String key){
        cell store=origin;
        cell curr=origin;
        for (int j=0; j<h;j++){
            for(int k=0;k<w;k++){
                curr.value= key.charAt(j*w+k);
                curr=curr.right;
            }
            store=store.below;
            curr=store.below;
        }
    }


}
