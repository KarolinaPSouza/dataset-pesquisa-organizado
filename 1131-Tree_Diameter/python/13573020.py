from collections import *
import sys
input = sys.stdin.readline

n = int(input())
tree = defaultdict(list)
for i in range(n-1):
    arr = list(map(int, input().split()))
    u, v = arr[0], arr[1]
    tree[u].append(v)
    tree[v].append(u)


order = []
stack = [(1, -1)]

while stack:
    cur, parent = stack.pop()
    order.append((cur, parent))

    for children in tree[cur]:
        if children != parent:
            stack.append((children, cur))

order[::-1]

dp = [0]*(n+1)
diameter = 0

while order:
    cur, parent = order.pop()
    depth1, depth2 = 0, 0

    for children in tree[cur]:
        if children != parent:
            dp[children] += 1

            if dp[children] > depth1:
                depth2 = depth1
                depth1 = dp[children]

            elif depth1 >= dp[children] > depth2:
                depth2 = dp[children]

    dp[cur] = max(dp[cur], depth1)
    diameter = max(diameter, depth1 + depth2)


print(diameter)



