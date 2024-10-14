package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试类L2022211862_6_Test
 * 测试用例设计原则：
 * 1. 等价类划分：将输入空间划分为多个等价类，选取每个等价类中的典型值进行测试。
 * 2. 边界值分析：选取输入空间的边界值进行测试，确保程序在边界条件下的正确性。
 * 3. 特殊情况处理：测试特殊或极端情况，验证程序的鲁棒性。
 */
public class L2022211862_6_Test {

    // 测试目的：验证多个用户中存在子集关系
    // 用例：favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
    // 预期输出：[0, 1, 4]，因为用户2和用户3的清单是其他人的子集
    @Test
    public void testPeopleIndexes_withSubset() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = Arrays.asList(
                Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("google", "microsoft"),
                Arrays.asList("google", "facebook"),
                Arrays.asList("google"),
                Arrays.asList("amazon")
        );
        List<Integer> expected = Arrays.asList(0, 1, 4);
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);
        assertEquals(expected, result);
    }

    // 测试目的：验证所有用户清单都是独立的，没有子集关系
    // 用例：favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
    // 预期输出：[0, 1, 2, 3]，因为没有任何子集关系
    @Test
    public void testPeopleIndexes_noSubset() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = Arrays.asList(
                Arrays.asList("leetcode"),
                Arrays.asList("google"),
                Arrays.asList("facebook"),
                Arrays.asList("amazon")
        );
        List<Integer> expected = Arrays.asList(0, 1, 2, 3);
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);
        assertEquals(expected, result);
    }

    // 测试目的：验证边界条件，输入为空列表
    // 用例：favoriteCompanies = []
    // 预期输出：[]，因为没有用户
    @Test
    public void testPeopleIndexes_emptyList() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = new ArrayList<>();  // 空列表的初始化
        List<Integer> expected = new ArrayList<>();
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);
        assertEquals(expected, result);
    }

    // 测试目的：验证边界条件，只有一个用户
    // 用例：favoriteCompanies = [["leetcode"]]
    // 预期输出：[0]，因为没有其他用户的清单
    @Test
    public void testPeopleIndexes_singleUser() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = Arrays.asList(
                Arrays.asList("leetcode")
        );
        List<Integer> expected = Arrays.asList(0);
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);
        assertEquals(expected, result);
    }

    // 测试目的：验证大输入集的处理能力（边界条件，100个用户）
    // 用例：favoriteCompanies = 100个用户，每个用户的收藏清单不同，彼此没有子集关系
    // 预期输出：[0, 1, ..., 99]，因为没有子集关系
    @Test
    public void testPeopleIndexes_largeInput() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = new ArrayList<>();  // 使用 ArrayList 进行初始化
        for (int i = 0; i < 100; i++) {
            favoriteCompanies.add(Arrays.asList("company" + i));
        }
        List<Integer> expected = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            expected.add(i);
        }
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);
        assertEquals(expected, result);
    }
}
