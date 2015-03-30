/**
 * Created by bing on 2015-03-28.
 */

// Value is:
// -2 - unknown
// -1 - bomb
// 0 - blank
// 1 to 8 - how many bombs surround it

public class cell {
    int value;
    cell above;
    cell below;
    cell right;
    cell left;

    cell(int value, cell above, cell below, cell right, cell left) {
        this.value = value;
        this.above = above;
        this.below = below;
        this.right = right;
        this.left = left;
    }

    public cell ar() {
        if (this.above == null) {
            return null;
        }
        return this.above.right;
    }

    public cell al() {
        if (this.above == null) {
            return null;
        }
        return this.above.left;
    }

    public cell br() {
        if (this.below == null) {
            return null;
        }
        return this.below.right;
    }

    public cell bl() {
        if (this.below == null) {
            return null;
        }
        return this.below.left;
    }
}
