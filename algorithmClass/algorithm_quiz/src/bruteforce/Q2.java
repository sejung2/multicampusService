package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Q2 {
    public static void main(String[] args) {
        // brute_force 문제 : 일곱 난쟁이
        //일과를 마치고 아홉 명의 난쟁이가 돌아왔다.
        //아홉 명의 난쟁이는 모두 자신이 ＂백설 공주와 일곱 난쟁이＂의 주인공이라고 주장했다.
        //백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
        //아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
        int[] dwarfs = {20, 7, 23, 19, 10, 15, 25, 8, 13};

        q2(dwarfs);
        answer();
    }

    private static void answer() {
        List<Integer> dwarfs = nineDwarfs();
        int sum = dwarfs.stream().mapToInt(e -> e).sum();
        int diff = sum - 100;

        boolean flg = false;
        for (int i = 0; i < dwarfs.size() - 1; i++) {
            for (int j = 0; j < dwarfs.size(); j++) {
                if(flg) break;
                if (diff == dwarfs.get(i) + dwarfs.get(j)) {
                    dwarfs.remove(dwarfs.get(i));
                    dwarfs.remove(dwarfs.get(j));
                    flg = true;
                    break;
                }
            }
        }
        System.out.println("일곱 난쟁이는: " + dwarfs);
    }

    private static List<Integer> nineDwarfs() {
        List<Integer> dwarfs = new ArrayList<>();
        Random random = new Random();

        int sum = 0;
        for (int i = 0; i < 6; i++) {
            int n = random.nextInt(11, 15);
            sum += n;
            dwarfs.add(n);
        }

        dwarfs.add(100 - sum);
        dwarfs.add(random.nextInt(11, 15));
        dwarfs.add(random.nextInt(11, 15));
        return dwarfs;
    }

    private static void q2(int[] dwarfs) {
        ArrayList<Integer> list = new ArrayList<>();
        int total = 0;
        Arrays.sort(dwarfs);
        for (int dwarf : dwarfs) {
            total += dwarf;
        }

        for (int i = 0; i < dwarfs.length - 1; i++) {
            for (int j = i + 1; j < dwarfs.length; j++) {
                if (total - (dwarfs[i] + dwarfs[j]) == 100) {
                    for (int k = 0; k < dwarfs.length; k++) {
                        if (k != i && k != j) {
                            list.add(dwarfs[k]);
                        }
                    }
                    break;
                }
            }
        }
        System.out.println("일곱 난쟁이는: " + list);
    }
}
