package contest.sf2020;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyuzhou on 2020/1/18.
 * https://leetcode-cn.com/contest/sf-2020/problems/werewolves-of-leetcode/
 * https://leetcode-cn.com/problems/werewolves-of-leetcode/
 * STATUS: NOT PASS
 */
public class CanVillagersWin {
    private int bearIndex = 0;
    private int hunterIndex = 0;
    Map<Integer, Integer> bearHauledMap = new HashMap();
    int[] tombs = new int[12];
    private int wolfCount = 4;
    private int vilSideCount = 8;
    int[] wolfs = new int[12];

    public boolean canVillagersWin(String[] players, int[] credibility) {

        //init role
        for (int i = 0; i < credibility.length; i ++) {
            if (isWolf(players[i])) {
                wolfs[i] = 1;
            }

            if (isBear(players[i])) {
                bearIndex = i;
            }

            if (isHunter(players[i])) {
                hunterIndex = i;
            }
        }

        int stageCheckResult = 0;

        while(stageCheckResult == 0) {
            int maxIndex = 0;
            int max = -1;
            int minIndex = 0;
            int min = Integer.MAX_VALUE;
            boolean isHauled = false;
            int right = 0;
            int left = 0;
            //night
            //find max credit non-wolf and alive player
            for (int i = 0; i < credibility.length; i ++) {
                if (credibility[i] > max && !isWolf(players[i]) && isAlive(i)) {
                    max = credibility[i];
                    maxIndex = i;
                }

                if (credibility[i] < min && isAlive(i)) {
                    min = credibility[i];
                    minIndex = i;
                }
            }
            kill(maxIndex, credibility);
            //daytime
            //if hunter got killed in the night
            if (isHunter(players[maxIndex])) {
                shoot(minIndex, isIdiot(players[minIndex]), isWolf(players[minIndex]), credibility);
            }
            //bear haul if he is alive
            if (isAlive(bearIndex)) {
                left = findBearLeftAlive(bearIndex);
                right = findBearRightAlive(bearIndex);
                if (left == bearIndex || right == bearIndex) {
                    return true;
                }
                isHauled = isWolf(right) || isWolf(left);
                //show his role
                credibility[bearIndex] = 100;
            } else {
                isHauled = false;
            }
            if (isHauled) {
                bearHauledMap.put(right, left);
                bearHauledMap.put(left, right);
                if (credibility[right] == 100) {
                    credibility[left] = 0;
                } else if (credibility[left] == 100) {
                    credibility[right] = 0;
                }
            }

            stageCheckResult = checkIsEnd();
            if (stageCheckResult == 1) {
                return true;
            } else if (stageCheckResult == -1) {
                return false;
            }

            minIndex = findMinCred(credibility);
            out(minIndex, isIdiot(players[minIndex]), isWolf(players[minIndex]), credibility);
            //if hunter got killed in the vote
            if (isHunter(players[minIndex])) {
                minIndex = findMinCred(credibility);
                shoot(minIndex, isIdiot(players[minIndex]), isWolf(players[minIndex]), credibility);
            }
            stageCheckResult = checkIsEnd();
            if (stageCheckResult == 1) {
                return true;
            } else if (stageCheckResult == -1) {
                return false;
            }
        }
        return false;
    }

    private int findMinCred(int[] credibility) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < credibility.length; i ++) {
            if (credibility[i] < min && isAlive(i)) {
                min = credibility[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private int checkIsEnd() {
        if (wolfCount <= 0) {
            return 1;
        } else if (wolfCount >= vilSideCount) {
            return -1;
        } else {
            return 0;
        }
    }

    private int findBearLeftAlive(int bearIndex) {
        int j = (bearIndex == 0) ? 11 : bearIndex - 1;
        while (j != bearIndex && !isAlive(j)) {
            j = (j == 0) ? 11 : j - 1;
        }
        return j;
    }

    private int findBearRightAlive(int bearIndex) {
        int j = (bearIndex == 11) ? 0 : bearIndex + 1;
        while (j != bearIndex && !isAlive(j)) {
            j = (j == 11) ? 0 : j + 1;
        }
        return j;
    }

    private boolean isWolf(int playerIndex) {
        return wolfs[playerIndex] == 1;
    }

    private boolean isWolf(String role) {
        return role.equals("ww");
    }

    private boolean isIdiot(String role) {
        return role.equals("idiot");
    }

    private boolean isBear(String role) {
        return role.equals("bear");
    }

    private boolean isHunter(String role) {
        return role.equals("hunter");
    }

    private boolean isAlive(int playerIndex) {
        return tombs[playerIndex] == 0;
    }

    //wolf action in night
    private void kill(int playerIndex, int[] credibility) {
        vilSideCount --;
        tombs[playerIndex] = 1;
        credibility[playerIndex] = 100;
        // if the killed player has been hauled, the other side must be wolf;
        if (bearHauledMap.containsKey(playerIndex)) {
            credibility[bearHauledMap.get(playerIndex)] = 0;
        }
    }

    //hunter action in night
    private void shoot(int playerIndex, boolean isIdiot, boolean isWolf, int[] credibility) {
        out(playerIndex, isIdiot, isWolf, credibility);
    }

    private void out(int playerIndex, boolean isIdiot, boolean isWolf, int[] credibility) {
        if (isIdiot || hunterIndex == playerIndex) {
            credibility[playerIndex] = 100;
            // if the killed player has been hauled, the other side must be wolf;
            if (bearHauledMap.containsKey(playerIndex)) {
                credibility[bearHauledMap.get(playerIndex)] = 0;
            }
        } else {
            if (isWolf) {
                credibility[playerIndex] = 0;
                wolfCount --;
            } else {
                vilSideCount --;
            }
            tombs[playerIndex] = 1;
        }
    }

    public static void main(String[] args) {
        CanVillagersWin test = new CanVillagersWin();
//        String[] players = new String[]{"bear","vil","vil","ww","vil","vil","idiot","ww","hunter","ww","ww","vil"};
//        int[] credibility = new int[]{9,55,62,74,43,70,13,23,15,78,61,66};
//        String[] players = new String[]{"vil", "vil", "vil", "ww", "vil", "ww", "ww", "vil", "ww", "bear", "hunter", "idiot"};
//        int[] credibility = new int[]{81, 71, 88, 31, 34, 40, 70, 94, 73, 79, 98, 48};
//        String[] players = new String[]{"vil","ww","bear","hunter","ww","idiot","vil","vil","ww","vil","ww","vil"};
//        int[] credibility = new int[]{45,67,32,25,1,27,99,85,3,54,3,25};
        String[] players = new String[]{"bear", "vil", "vil", "ww", "vil", "vil", "idiot", "ww", "hunter", "ww", "ww", "vil"};
        int[] credibility = new int[]{9, 55, 62, 74, 43, 70, 13, 23, 15, 78, 61, 66};
        boolean result = test.canVillagersWin(players, credibility);
        System.out.println("result: " + result);
    }
}
