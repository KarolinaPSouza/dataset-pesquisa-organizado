from bisect import bisect_right

SPLIT_SIZE = 2000

input()
prices = sorted(map(int, input().split()))
prices = [prices[pos: pos + SPLIT_SIZE] for pos in range(0, len(prices), SPLIT_SIZE)]
splits = [p[0] for p in prices]

for offer in map(int, input().split()):
    split = bisect_right(splits, offer) - 1
    if split == -1:
        print(-1)
        continue
    prices_split = prices[split]
    index = bisect_right(prices_split, offer) - 1
    print(prices_split.pop(index))
    if len(prices_split) == 0:
        del splits[split]
        del prices[split]
    elif index == 0:
        splits[split] = prices_split[0]