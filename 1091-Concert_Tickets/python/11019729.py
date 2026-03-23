import bisect 
[tickets, customers] =  [int(_) for _ in input().split(' ')] 
prices =  [-1] + sorted([int(_) for _ in input().split(' ')])
next_index = list(range(len(prices)))
targets =  [int(_) for _ in input().split(' ')]
payments = []
prices.sort() 
for target in targets:
    index = bisect.bisect(prices, target) - 1
    while next_index[index] != index:
        next = next_index[index]
        next_index[index] = next_index[next]
        index = next_index[next]
    payments.append(prices[index])
    if index != 0: next_index[index] -= 1
print(*payments, sep='\n')