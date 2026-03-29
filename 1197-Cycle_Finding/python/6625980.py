# import sys
# import math
# from math import sqrt, gcd
# from functools import reduce
# from fractions import gcd
# import bisect
# from sys import stdin,stdout
# from math import gcd,floor,sqrt,log
# from collections import defaultdict as dd
# from bisect import bisect_left as bl,bisect_right as br
# sys.setrecursionlimit(100000000)
# from functools import cmp_to_key
# from math import gcd
import heapq
# from collections import defaultdict
from sys import maxsize
# from sys import setrecursionlimit
# setrecursionlimit(int(1e7))
#--------------------- RECURSION ---------------------#
from types import GeneratorType
def bootstrap(f, stack=[]):
    def wrappedfunc(*args, **kwargs):
        if stack:
            return f(*args, **kwargs)
        else:
            to = f(*args, **kwargs)
            while True:
                if type(to) is GeneratorType:
                    stack.append(to)
                    to = next(to)
                else:
                    stack.pop()
                    if not stack:
                        break
                    to = stack[-1].send(to)
            return to
    return wrappedfunc
#-----------------------------------------------------#


inp    =lambda: int(input())
# strinp  =lambda: input().strip()
# jn     =lambda x,l: x.join(map(str,l))
listinp   =lambda: list(map(int, input().split()))
liststrinp   =lambda: list(map(str, input().split()))
mulintinp    =lambda: map(int,input().strip().split())
# mulflotinp   =lambda: map(float,input().strip().split())
# # seq    =lambda: list(map(int,input().strip().split()))

# ceil   =lambda x: int(x) if(x==int(x)) else int(x)+1
# ceildiv=lambda x,d: x//d if(x%d==0) else x//d+1
INT_MIN = -maxsize+1
INT_MAX = maxsize


# flush  =lambda: stdout.flush()
# stdstr =lambda: stdin.readline()
# stdint =lambda: int(stdin.readline())
# stdpr  =lambda x: stdout.write(str(x))

mod=1e9 +7

#----------------------------------------------Standard Algos----------------------------------------------------------#
def djikstra(adj, s):
    n = len(adj)
    dist = [maxsize for i in range(n)]
    dist[s] = 0
    u = [False for i in range(n)]
    pred = [-1 for i in range(n)]
    for i in range(1, n):
        v = -1
        for j in range(1, n):
            if not u[j] and (v == -1 or dist[j] < dist[v]):
                v = j 
        if dist[v] == maxsize:
            break

        u[v] = True
        for edge in adj[v]:
            to = edge[0]
            weight = edge[1]

            if (dist[v] + weight < dist[to]):
                dist[to] = dist[v] + weight
                pred[to] = v

    return dist, pred

def getPathDjikstra(s, t, pred):
    path = []
    v = t
    while v != s:
        path.append(v)
        v = pred[v]
    return path.reverse()

def DFS(s:int):
    visited = [False for i in range(n+1)]
    parent = []

    @bootstrap
    def DFSRec(s:int):
        if visited[s]:
            yield True

        visited[s] = True
        for x in adj[s]:
            if not visited[x]:
                parent.append(x)
                yield DFSRec(x)
        yield
    DFSRec(s)
    return visited, parent


def djikstraSparse():
    dist = [maxsize for i in range(n+1)]
    prev = [-1 for i in range(n+1)]
    start = 1
    dist[start] = 0

    Q = []
    heapq.heapify(Q)
    heapq.heappush(Q, (start, 0))

    while Q:
        v, d = heapq.heappop(Q)
        if d != dist[v]:
            continue

        for to, d in adj[v]:
            if dist[v] + d < dist[to]:
                dist[to] = dist[v] + d
                heapq.heappush(Q, (to, dist[to]))
                prev[to] = v
    return dist, prev

def bellmanFord(src:int, n:int) -> list:
    dist = [INT_MAX for i in range(n+1)]
    dist[src] = 0
    x = -1
    parent = [-1 for i in range(n+1)]
    for i in range(n):
        x = -1
        for e in edgeList:
            if dist[e[0]] < INT_MAX:
                if dist[e[1]] > dist[e[0]] + e[2]:
                    dist[e[1]] = dist[e[0]] + e[2]
                    dist[e[1]] = max(dist[e[1]], INT_MIN)
                    parent[e[1]] = e[0]

                    x = e[1]

    if x == -1: #No -ve cycle
        return dist, None
    else:
        for i in range(n):
            x = parent[x]
        cycle = []
        v = x
        while True:
            cycle.append(v)
            if v == x and len(cycle) >1:
                break
            v = parent[v]
    cycle.reverse()
    return dist, cycle



#--------------------------------------------------CODE---------------------------------------------------------#
def run():
    #We need Bellman-Ford because graph has -ve edge and possible -ve cycles
    distances, cycle = bellmanFord(1, n)
    # print(visited)
    if not cycle:
        print("NO")
        return
    else:
        print("YES")
        print(*cycle)  
    return




#-------------------------------------------------INPUTS--------------------------------------------------------#


#-------------------------------- FAST INPUT ----------------------------------#
from io import BytesIO
from os import read, fstat
input = BytesIO(read(0,fstat(0).st_size)).readline
#-------------------------------- FAST INPUT ----------------------------------#

#-------------------------------- FAST OUTPUT ----------------------------------#

#-------------------------------- FAST OUTPUT ----------------------------------#



n, m = mulintinp()

edgeList = []
adj = [[] for i in range(n+1)]
for i in range(m):
    a, b, x = mulintinp()
    # -ve self loop
    if a == b and x <0:
        print("YES")
        print(a, b)
        break
    edgeList.append((a, b, x))
    adj[b].append(a)
else:
    for edge in edgeList:
        for edge2 in edgeList:
            if (edge[0], edge[1]) == (edge2[1], edge2[0]) and edge[2] + edge2[2] < 0:
                print("YES")
                print(edge[0], edge[1], edge[0])
                exit()
    run()