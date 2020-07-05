import sun.rmi.server.InactiveGroupException;

import java.util.*;

public class RobotSim {


    public int robotSim(int[] commands, int[][] obstacles) {
        int res = 0;

        Set<String> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            set.add(obstacles[i][0] + "-" + obstacles[i][1]);
        }
        int x = 0;
        int y = 0;

        //一开始向北走
        int xi = 0;
        int yi = 1;
        for (int i = 0; i < commands.length; i++) {
            //左转
            if (commands[i] == -2) {
                int temp = xi;
                xi = -yi;
                yi = temp;
            }
            //右转
            else if (commands[i] == -1) {
                int temp = xi;
                xi = yi;
                yi = -temp;
            } else {

                for (int k = 0; k < commands[i]; k++) {
                    int x_next = x + xi*1;
                    int y_next = y + yi*1;
                    //若当前点为障碍，则结束本次移动
                    if (!set.contains(x_next + "-" + y_next)) {
                        break;
                    }
                    x = x_next;
                    y = y_next;
                    res = Math.max(res, x*x + y*y);
                }
            }
        }
        return res;
    }

}
