# n nodes
# diameter is max between 2 nodes

# input
# n, 1-indexed
# n - 1 lines of a b, meaning edge exists between a & b

# output
# diameter

'''
def dfs(start, depth):
    visited[start] = True
    farthest = start
    maxDepth = depth
    for neighbor in adjList[start]:
        if not visited[neighbor]:
            visited[neighbor] = True
            n, ndepth = dfs(neighbor, depth + 1)
            if ndepth > maxDepth:
                maxDepth = ndepth
                farthest = n
    return farthest, maxDepth
  n = int(input())
adjList = [[] for i in range(n)]
for i in range(n - 1):
    ab = input().split()
    a = int(ab[0]) - 1
    b = int(ab[1]) - 1
    adjList[a].append(b)
    adjList[b].append(a)
visited = [False for j in range(n)]
farthest, temp = dfs(0, 0)
visited = [False for j in range(n)]
maxDepth = 0
temp, diameter = dfs(farthest, 0)
print(diameter)
'''


from collections import deque

def dfs(start):
    visited = [False for j in range(n)]
    stack = deque()
    stack.append((start, 0))
    visited[start] = True
    farthest = start
    maxDepth = 0
    while stack:
        node, depth = stack.pop()
        if depth > maxDepth:
            maxDepth = depth
            farthest = node
        for neighbor in adjList[node]:
            if not visited[neighbor]:
                visited[neighbor] = True
                stack.append((neighbor, depth + 1))
    return farthest, maxDepth


n = int(input())
adjList = [[] for i in range(n)]
for i in range(n - 1):
    ab = input().split()
    a = int(ab[0]) - 1
    b = int(ab[1]) - 1
    adjList[a].append(b)
    adjList[b].append(a)
farthest, temp = dfs(0)
temp, diameter = dfs(farthest)
print(diameter)