package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Collections.sort(a);
        if (b < a.get(0)) {
            return result;
        }
        combinationHelper(a, temp, result, b, 0);
        return result;
    }

    private void combinationHelper(
            ArrayList<Integer> a,
            ArrayList<Integer> temp,
            ArrayList<ArrayList<Integer>> result,
            int b,
            int index
    ) {
        if (b == 0) {
            if (!contains(temp, result)) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        if (b < 0 || index > a.size() - 1) {
            return;
        }
        temp.add(a.get(index));
        combinationHelper(a, temp, result, b - a.get(index), index);
        temp.remove(temp.size() - 1);
        combinationHelper(a, temp, result, b, index + 1);
    }

    private boolean contains(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {
        loop1:
        for (ArrayList<Integer> a: result) {
            if (a.size() != list.size()) {
                continue;
            }
            for (int i = 0; i < a.size(); i++) {
                if (!a.get(i).equals(list.get(i))) {
                    continue loop1;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CombinationSum ins = new CombinationSum();
        ins.combinationSum(new ArrayList<>(Arrays.asList(8, 10, 6, 11, 1, 16, 8)), 28);
    }
}
