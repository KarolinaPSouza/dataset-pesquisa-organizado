# import sys
# input = sys.stdin.readline
# oo = 1 << 63


# n, m = map(int, input().split())
# edges = []
# for _ in range(m):
#     u, v, w = [int(i) - 1 for i in input().split()]; w += 1
#     if u==v and w<0: print("YES"); print(u + 1,u + 1); exit()
#     edges.append((u, v, w))

# def bellman_ford(n, edges, start):
#     dist = [oo] * n
#     pred = [None] * n

#     dist[start] = 0

#     for _ in range(n):
#         for u, v, d in edges:
#             if dist[u] + d < dist[v]:
#                 dist[v] = dist[u] + d
#                 pred[v] = u
#     cycle = False
#     pth = []
#     par = pred
#     for u, v, d in edges:
#         if dist[u] + d < dist[v]:
#             cycle = True
#             pth.append(u + 1)
#             cur = par[u]
#             while cur != u:
#             # for _ in range(5):
#                 pth.append(cur + 1)
#                 cur = par[cur]
#             pth.append(cur + 1)
#             pth.reverse()
#             break

#     return cycle, pth

# cycle, pth = bellman_ford(n, edges, 0)
# if cycle:
#     print('YES')
#     print(*pth)
# else:
#     print('NO')




import sys, os.path
import math

def solve(fin, fou):
    inputfile = fin
    ouputfile = fou
    fi = sys.stdin
    fo = sys.stdout
    # if(os.path.exists(inputfile)):
    #     fi = open(inputfile,'r')
    #     fo = open(ouputfile,'w')

    n, m = map(int, fi.readline().split())
    e = []
    for _ in range(m):
        u, v, w = map(int, fi.readline().split())
        u -= 1
        v -= 1
        e.append((u,v,w))
        if u == v and w < 0 :
            fo.write("YES\n%d %d\n" % (u+1,v+1))
            return

    ## Bellman-Ford
    limit = 10**15
    parent = [-1 for i in range(n)]
    dist = [limit]*n
    dist[0] = 0
    for k in range(n):
        finish = -1
        for (u, v, w) in e:
            if dist[u] + w < dist[v]:
                dist[v] = dist[u]+ w
                parent[v] = u
                finish = v

    if finish == -1:
        fo.write("NO\n")
    else:
        for i in range(n):
            finish = parent[finish]
        cycle = []
        v = finish
        while True:
            cycle.append(v+1)
            if (v == finish and len(cycle) > 1):
                break
            v = parent[v]

        ## Reverse cycle[]
        cycle.reverse()
        fo.write("YES\n")
        for v in cycle:
            fo.write("%d " % v)
    fi.close()
    fo.close()

solve('i18.txt','o18.txt')