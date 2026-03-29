n,m = list(map(int,input().split()))
graph = []
ans = [0]*(n+1)
for _ in range(n+1):
    graph.append([])
for _ in range(m):
    start,end,dist = list(map(int,input().split()))
    graph[start].append((end,dist))
for i in range(1,n+1):
    graph[0].append((i,0))
relaxant = [0]*(n+1)
bNode = None
finish = False
for i in range(n+1):
    for node in range(n+1):
        for child,dist in graph[node]:
            if ans[child] > ans[node] + dist:
                ans[child] = ans[node] + dist
                relaxant[child] = node
                if i == n:
                    bNode = child
                    finish = True
                    break
        if finish:
            break
    if finish:
        break


if bNode is None:
    print("NO")
else:
    for _ in range(n):
        bNode = relaxant[bNode]
    ANS = []
    length = 0
    while not(length > 1 and ANS[0] == ANS[-1]):
        ANS.append(bNode)
        length += 1
        bNode = relaxant[bNode]
    print("YES")
    print(" ".join(list(map(str,ANS[::-1]))))




