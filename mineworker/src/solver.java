public class solver {
    solver(grid cgrid) {
        for (int j = 0; j < cgrid.passkey.length(); j++) {
            mini_solve(cgrid, j);
        }
    }

    private void reinsert(int loc, int h, int w, StringBuffer mini_grid,StringBuffer key){
        if (loc%w==0){
            for(int j=0; j<9; j++) {
                if(j%3!=0){
                    if(loc-w+j>0 && loc-w+j<w*h-1){
                        key.setCharAt(loc-w-1+j,mini_grid.charAt(j));
                    }
                }
            }
        } else if ((loc-w+1)%w==0){
            for(int j=0; j<9; j++) {
                if((j-w+1)%3==0){
                    if(loc-w+j>0 && loc-w+j<w*h-1){
                        key.setCharAt(loc-w-1+j,mini_grid.charAt(j));
                    }
                }
            }
        } else{
            for(int j=0; j<9; j++) {
                if(loc-w+j>0 && loc-w+j<w*h-1){
                    key.setCharAt(loc-w-1+j,mini_grid.charAt(j));
                }
            }
        }
    }

    private StringBuffer mini_grid(int loc ,int h, int w, StringBuffer key){
        StringBuffer work = new StringBuffer();
        if (loc%w==0){
            for(int j=0; j<9; j++) {
                if(j%3==0){
                    work.setCharAt(j,'-');
                }
                if(loc-w+j<0){
                    work.setCharAt(j,'-');
                }
                if(loc-w+j>w*h-1){
                    work.setCharAt(j,'-');
                }
                work.setCharAt(j, key.charAt(loc-w+j-1));
            }
        } else if ((loc-w+1)%w==0){
            for(int j=0; j<9; j++) {
                if((j-w+1)%3==0){
                    work.setCharAt(j,'-');
                }
                if(loc-w+j<0){
                    work.setCharAt(j,'-');
                }
                if(loc-w+j>w*h-1){
                    work.setCharAt(j,'-');
                }
                work.setCharAt(j, key.charAt(loc-w+j-1));
            }
        } else{
            for(int j=0; j<9; j++) {
                if(loc-w+j<0){
                    work.setCharAt(j,'-');
                }
                if(loc-w+j>w*h-1){
                    work.setCharAt(j,'-');
                }
                work.setCharAt(j, key.charAt(loc-w+j-1));
            }
        }
        return work;
    }
    private void mini_solve(grid grid, int loc){
        int h = grid.h;
        int w = grid.w;
        StringBuffer key = grid.passkey;
        StringBuffer mini_grid = mini_grid(loc,h,w,key);

        class m_grid{
            StringBuffer mini_grid;
            m_grid(StringBuffer key){
                String temp = key.toString();
                mini_grid=new StringBuffer(temp);
            }
            class storage{
                StringBuffer[] list;
                int[] sollist;
                Character var1='-';

                storage(){
                    list=new StringBuffer[70];
                    sollist=new int[9];
                    for(int j=0; j<70; j++){
                        list[j]=new StringBuffer(var1);
                    }
                    for(int j=0; j<9; j++){
                        sollist[j]=1;
                    }
                }
                public void set_new(StringBuffer solution){
                    for(int j=0; j<70; j++){
                        if(list[j]==new  StringBuffer(var1)){
                            list[j]=solution;
                            break;
                        }
                    }
                }
                public void compare_sol(){
                    for(int j=0; j<9; j++){
                        for(StringBuffer k:list){
                            if(j!=5){
                                if(k.charAt(j)!='*'){
                                    sollist[j]=0;
                                    break;
                                }
                            }
                        }
                    }
                }

            }
            public int count_bombs(){
                int count=0;
                for(int j=0; j<9; j++){
                    if(mini_grid.charAt(j)=='*'){
                        count++;
                    }
                }
                return count;
            }
            public int count_free(){
                int count=0;
                for(int j=0; j<9; j++){
                    if(mini_grid.charAt(j)=='0'){
                        count++;
                    }
                }
                return count;
            }
            public void set_click(){
                for(int j=0; j<9; j++){
                    if(mini_grid.charAt(j)=='0'){
                        mini_grid.setCharAt(j,'#');
                    }
                }
            }
            public void set_bomb(){
                for(int j=0; j<9; j++){
                    if(mini_grid.charAt(j)=='0'){
                        mini_grid.setCharAt(j,'*');
                    }
                }
            }
            private int bomb_check(int ... var){
                int count=0;
                for (int aVar : var) {
                    if (mini_grid.charAt(aVar) == '*') {
                        count++;
                    }
                }
                return count;
            }
            public boolean checkall(){
                if(((int) mini_grid.charAt(0))>=48&&((int) mini_grid.charAt(0))!=bomb_check(1,3,4)){
                    return false;
                }
                if(((int) mini_grid.charAt(1))>=48&&((int) mini_grid.charAt(1))!=bomb_check(0,2,3,4,5)){
                    return false;
                }
                if(((int) mini_grid.charAt(2))>=48&&((int) mini_grid.charAt(2))!=bomb_check(1,4,5)){
                    return false;
                }
                if(((int) mini_grid.charAt(3))>=48&&((int) mini_grid.charAt(3))!=bomb_check(0,1,4,6,7)){
                    return false;
                }
                if(((int) mini_grid.charAt(4))>=48&&((int) mini_grid.charAt(4))!=bomb_check(0,1,2,3,5,6,7,8,9)){
                    return false;
                }
                if(((int) mini_grid.charAt(5))>=48&&((int) mini_grid.charAt(5))!=bomb_check(1,2,4,7,8)){
                    return false;
                }
                if(((int) mini_grid.charAt(6))>=48&&((int) mini_grid.charAt(6))!=bomb_check(3,4,7)){
                    return false;
                }
                if(((int) mini_grid.charAt(7))>=48&&((int) mini_grid.charAt(7))!=bomb_check(6,8,3,4,5)){
                    return false;
                }
                return !(((int) mini_grid.charAt(8)) >= 48 && ((int) mini_grid.charAt(8)) != bomb_check(7, 4, 5));
            }
            public void simple(){
                mini_grid.setCharAt(4, (char) (((int) mini_grid.charAt(4))- count_bombs()));
            }
            public void smart_solve(StringBuffer mini_grid, storage store){
                for(int j =0; j<9;j++){
                    m_grid n_curr = new m_grid(mini_grid);
                    n_curr.simple();
                    if(n_curr.mini_grid.charAt(4)=='0'){
                        store.set_new(n_curr.mini_grid);
                        break;
                    }
                    if(n_curr.mini_grid.charAt(j)==0){
                        n_curr.mini_grid.setCharAt(j,'*');
                        if(n_curr.checkall()){
                            if(n_curr.mini_grid.charAt(4)!='*'){
                                n_curr.simple();
                                int loc_int = (int) n_curr.mini_grid.charAt(5);
                                int free_num=n_curr.count_free();
                                if(loc_int==0){
                                    n_curr.set_click();
                                } else if (free_num==loc_int){
                                    n_curr.set_bomb();
                                    n_curr.simple();
                                } else {
                                    n_curr.smart_solve(n_curr.mini_grid,store);
                                }
                            }
                        }
                    }
                }
            }
            public int[] smart_solve_initiate(StringBuffer mini_grid){
                storage store = new storage();
                smart_solve(mini_grid,store);
                store.compare_sol();
                return store.sollist;
            }
        }
        m_grid curr = new m_grid(mini_grid);
        if(curr.mini_grid.charAt(4)!='0'){
            if(curr.mini_grid.charAt(4)!='*'){
                curr.simple();
                int loc_int = (int) curr.mini_grid.charAt(5);
                int free_num=curr.count_free();
                if(loc_int==0){
                    curr.set_click();
                } else if (free_num==loc_int){
                    curr.set_bomb();
                    curr.simple();
                } else {
                    int[] sollist = curr.smart_solve_initiate(curr.mini_grid);
                    for(int j=0;j<9;j++){
                        if(sollist[j]==1){
                            curr.mini_grid.setCharAt(j,'*');
                        }
                    }
                }
            }
        }
        reinsert(loc, h, w, curr.mini_grid,key);
    }
}
