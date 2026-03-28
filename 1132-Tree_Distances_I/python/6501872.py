#Tree Distance I

# import sys
#--------------------- RECURSION ---------------------#
from sys import setrecursionlimit
setrecursionlimit(int(1e5))
#-----------------------------------------------------#
# import math
# import bisect
# from sys import stdin,stdout
# from math import gcd,floor,sqrt,log
# from collections import defaultdict as dd
# from bisect import bisect_left as bl,bisect_right as br
# from functools import cmp_to_key
# from math import gcd
# from heapq import heapify, heappop, heappush
# from collections import defaultdict
from sys import maxsize


#-------------------------------- FAST INPUT ----------------------------------#
from io import BytesIO
from os import read, fstat
input = BytesIO(read(0,fstat(0).st_size)).readline
#-------------------------------- FAST INPUT ----------------------------------#

#-------------------------------- FAST OUTPUT ----------------------------------#

#-------------------------------- FAST OUTPUT ----------------------------------#


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
def KMP(text, pattern):
    n = len(text)
    m = len(pattern)
    ans = []

    def LPS(pattern: str) -> list:
        m = len(pattern)
        LPSArr = [0]*m
        i = 0
        j = 1
        while j < m:
            if pattern[i] == pattern[j]:
                LPSArr[j] = i+1
                i+=1
                j+=1
            else:
                if i:
                    i = LPSArr[i-1]
                else:
                    LPSArr[j] = 0
                    j +=1
        return LPSArr

    LPSArr = LPS(pattern)

    i = 0
    j = 0
    while (n-i) >= (m-j):
        if pattern[j] == text[i]:
            i +=1
            j +=1

        if j == m:
            ans.append(i-j)
            j = LPSArr[j-1]
        elif i < n and pattern[j] != text[i]:
            if j:
                j = LPSArr[j-1]
            else:
                i +=1
    return ans


#--------------------------------------------------CODE---------------------------------------------------------#
def run():
    def DFS(node, parent):
        distances = [0 for i in range(n+1)]
        visited = [False for i in range(n+1)]

        stack = []
        stack.append(node)
        while stack:
            s = stack.pop() 
            visited[s] = True
            for e in adj[s]:
                if not visited[e] and parent != e:
                    distances[e] = distances[s] +1
                    stack.append(e)

        return distances

    distancesRoot = DFS(1, 0)
    diam1 = distancesRoot.index(max(distancesRoot))
    distancesD1 = DFS(diam1, 0)
    diam2 = distancesD1.index(max(distancesD1))
    # print(distancesRoot)
    distancesD2 = DFS(diam2, 0)
    for node in range(1, n+1):
        print(max(distancesD1[node], distancesD2[node]), end=' ')

    return



#-------------------------------------------------INPUTS--------------------------------------------------------#
n = inp()
adj = [[] for i in range(n+1)]
for i in range(n-1):
    a, b = mulintinp()
    adj[a].append(b)
    adj[b].append(a)
run()
