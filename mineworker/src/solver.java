

public class solver {

    solver(grid cgrid){
        for(int j=0;j<cgrid.passkey.length();j++){
            mini_solve(cgrid,j);
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
            StringBuffer key;
            m_grid(StringBuffer key){
                this.key=key;
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
                private void set_sollist(int location){
                    for(int j=0; j<70; j++){
                        if(sollist[j]==-1){
                            sollist[j]=location;
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
                    if(key.charAt(j)=='*'){
                        count++;
                    }
                }
                return count;
            }
            public int count_free(){
                int count=0;
                for(int j=0; j<9; j++){
                    if(key.charAt(j)=='0'){
                        count++;
                    }
                }
                return count;
            }
            public void set_click(){
                for(int j=0; j<9; j++){
                    if(key.charAt(j)=='0'){
                        key.setCharAt(j,'#');
                    }
                }
            }
            public void set_bomb(){
                for(int j=0; j<9; j++){
                    if(key.charAt(j)=='0'){
                        key.setCharAt(j,'*');
                    }
                }
            }
            public void simple(){
                key.setCharAt(5, (char) (((int) key.charAt(5))- count_bombs()));
            }
            public StringBuffer smart_solve(StringBuffer mini_grid, storage store){
                m_grid n_curr = new m_grid(mini_grid);
                for(int j =0; j<9;j++){
                    if(mini_grid.charAt(j)==0){
                        mini_grid.setCharAt(j,'*');
                        
                        if(mini_grid.charAt(5)!='0'){
                            if(mini_grid.charAt(5)!='*'){
                                n_curr.simple();
                                int loc_int = (int) mini_grid.charAt(5);
                                int bombsnum=n_curr.count_bombs();
                                int freesnum=n_curr.count_free();
                                if(bombsnum==loc_int){
                                    n_curr.set_click();
                                } else if (freesnum==loc_int){
                                    n_curr.set_bomb();
                                } else {
                                    n_curr.smart_solve(mini_grid,store);
                                }
                            }
                        }
                    }
                }
            }
            public int[] smart_solve_initiate(StringBuffer mini_grid){
                StringBuffer work = mini_grid;
                storage store = new storage();
                smart_solve(mini_grid,store);
                return store.sollist;
            }
        }

        m_grid curr = new m_grid(key);

        if(mini_grid.charAt(5)!='0'){
            if(mini_grid.charAt(5)!='*'){
                curr.simple();
                int loc_int = (int) mini_grid.charAt(5);
                int bombsnum=curr.count_bombs();
                int freesnum=curr.count_free();
                if(bombsnum==loc_int){
                    curr.set_click();
                } else if (freesnum==loc_int){
                    curr.set_bomb();
                } else {
                    curr.smart_solve_initiate(curr.key);
                }
            }
        }







    }

}
