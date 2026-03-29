LINES = lambda : list(map(int, input().strip().split()))

n, m = LINES()

edges = []

for i in range(m):
    edges.append(LINES())

cost = [10000000000000] * (n + 1)
cost[0], cost[1] = 0, 0
relax = [0] * (n + 1)

negNode = 0
for _ in range(1, n + 1):
    negNode = 0
    for edge in edges:
        c, o, w = edge
        if (cost[c] + w) < cost[o]:
            cost[o] = cost[c] + w
            relax[o] = c
            negNode = o

if negNode == 0:
    print("NO")
    quit()

print("YES")

for i in range(1, n + 1):
    negNode = relax[negNode]

temp = negNode
cycle = []
cycle.append(temp)

while temp != negNode or len(cycle) <= 1:
    temp = relax[temp]
    cycle.append(temp)

ret = []
for i in range(len(cycle) - 1, -1, -1):
    ret.append(str(cycle[i]))

print(' '.join(ret))