import sys
def input()   : return sys.stdin.readline().strip()
def getints() : return map(int,sys.stdin.readline().strip().split())

from math import isqrt


n = int(input())
tree = [[] for _ in range(n+2)]
for i in range(n-1):
    a, b = getints()
    tree[a].append(b)
    tree[b].append(a)

stack = [(1,0)]
visited = [False] * (n+2)

ans,node = 0, 1
for x,d in stack:
    visited[x] = True
    if len(tree[x]) == 1 and visited[tree[x][0]]: 
        if d > ans:
            ans = d
            node = x
    else:
        for y in tree[x]:
            if not visited[y]:
                stack.append((y,d+1))

final = [-1]*n

stack = [(node,0)]
visited = [False] * (n+2)

ans = 0
for x,d in stack:
    final[x-1] = max(final[x-1],d)
    visited[x] = True
    if len(tree[x]) == 1 and visited[tree[x][0]]: 
        if d > ans:
            ans = d
            node = x
    else:
        for y in tree[x]:
            if not visited[y]:
                stack.append((y,d+1))

stack = [(node,0)]
visited = [False] * (n+2)

for x,d in stack:
    final[x-1] = max(final[x-1],d)
    visited[x] = True

    for y in tree[x]:
        if not visited[y]:
            stack.append((y,d+1))

print(*final)