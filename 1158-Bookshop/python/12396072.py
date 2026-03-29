n, x = map(int, input().split())

cost= list(map(int, input().split()))
pg= list(map(int, input().split()))

prev = [0] * (x+1)

for C, P in zip(cost, pg):
    for c in range(x, C - 1, -1):
        prev[c] = max(prev[c], prev[c-C] + P)

print(prev[x])