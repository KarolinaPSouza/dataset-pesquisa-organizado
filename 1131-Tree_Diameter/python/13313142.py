import sys

input = sys.stdin.readline  # redefine input for performance reasons
sys.setrecursionlimit(10**7)

n = int(input())
adj = [[] for _ in range(n)]
for _ in range(n - 1):
 a, b = map(int, input().split())
 a -= 1
 b -= 1
 adj[a].append(b)
 adj[b].append(a)

height = [0] * n
diameter = 0

# iterative DFS necessary in order to AC; recursive TLEs
stack = [(0, -1, 0)]  # node, parent, state (0=pre, 1=post)

while stack:
 u, p, state = stack.pop()
 if state == 0:
  stack.append((u, p, 1))  # convert current state to post-processing
  for v in adj[u]:
   if v != p:
    stack.append((v, u, 0))  # pre-process children
 else:
  # post-processing: after processing all children, recalculate max heights of subtrees
  max1 = max2 = 0
  for v in adj[u]:
   if v == p:
    continue
   h = height[v] + 1
   if h > max1:
    max2 = max1
    max1 = h
   elif h > max2:
    max2 = h
  height[u] = max1
  # diameter will equal the max of the sum of the heights of the two tallest subtrees
  diameter = max(diameter, max1 + max2)

print(diameter)