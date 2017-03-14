package list;

/**
 * Created by joe wang on 2017/3/1.
 * This isn't from Leetcode
 */

public class JosephCircle {

    /**
     * @param
     */
    public void josephCircle(int n,int k, int m){
        int flag= m % n;
        boolean[] kick = new boolean[n];
        //set kick flag to False;
        for(int i=0;i<n-1;i++){
            kick[i]=false;
        }
        int counter=0;
        int accumulate=0;
        while(true){
            if(!kick[flag]){
                accumulate++;
                if(counter==n-1){
                    System.out.println("kick last person===="+(flag+1));
                    break;
                }
                if(accumulate==k){
                    kick[flag]=true;
                    System.out.println("kick person===="+(flag+1));
                    accumulate=0;
                    counter++;
                    flag = (flag + m + 1) % n;
                    continue;
                }
            }
            flag=(flag+1)%n;
        }

    }
    public static void main(String[] args) {
        JosephCircle jCircle = new JosephCircle();
        jCircle.josephCircle(20, 3, 4);

    }

}
