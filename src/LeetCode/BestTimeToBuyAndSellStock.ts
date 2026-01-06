function maxProfit(prices: number[]): number {
    let minIndex = 0;
    let curr = 0;

    for (let i = 0; i < prices.length; i++) {
        const profit = prices[i] - prices[minIndex];
        if (profit > curr)
            curr = profit;

        if (prices[i] < prices[minIndex])
            minIndex = i;
    }

    return curr;
}
