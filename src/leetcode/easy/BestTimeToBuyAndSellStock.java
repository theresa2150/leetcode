package leetcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BestTimeToBuyAndSellStock {
	private static int[] prices1 = { 7, 1, 5, 3, 6, 4 };
	private static int[] prices2 = { 7, 6, 4, 3, 1 };
	private static int[] prices3 = { 2, 4, 1 };
	private static int[] prices4 = { 2, 2, 2, 4, 4, 1, 1, 1, 5, 5 };
	private static int[] prices5 = { 2, 1, 2, 1, 0, 1, 2 };
	private static int[] prices6 = { 3, 3, 5, 0, 0, 3, 1, 4 };
	private static int[] prices7 = { 9, 11, 5, 3, 2, 6, 8 };
	private static int[] prices8 = { 9, 11, 5, 3, 2, 6, 10 };

	public int maxProfit(int[] prices) {
		int buy = prices[0], maxProfit = 0;
		for (int price : prices) {
			if (price < buy) {
				buy = price;
			} else {
				int profit = price - buy;
				if (profit > maxProfit) {
					maxProfit = profit;
				}
			}
		}
		return maxProfit;
	}

	public int maxProfit1(int[] prices) {
		int buy = prices[0], profit = 0;
		for (int i = 0; i < prices.length; i++) {
			buy = Math.min(buy, prices[i]);
			profit = Math.max(profit, prices[i] - buy);
		}
		return profit;
	}

	@Test
	void test() {
		assertEquals(5, maxProfit(prices1));
	}

	@Test
	void test2() {
		assertEquals(0, maxProfit(prices2));
	}

	@Test
	void test3() {
		assertEquals(2, maxProfit(prices3));
	}

	@Test
	void test4() {
		assertEquals(4, maxProfit(prices4));
	}

	@Test
	void test5() {
		assertEquals(2, maxProfit(prices5));
	}

	@Test
	void test6() {
		assertEquals(4, maxProfit(prices6));
	}

	@Test
	void test7() {
		assertEquals(6, maxProfit(prices7));
	}

	@Test
	void test8() {
		assertEquals(8, maxProfit(prices8));
	}
}
