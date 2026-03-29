from itertools import permutations, combinations, accumulate
from collections import defaultdict, deque, Counter
from heapq import heapify, heappush, heappop, merge
from bisect import bisect_right, bisect_left
from io import StringIO,BytesIO
from math import gcd
_MOD = 998244353
MOD = 10**9 + 7
import sys,os


printf=print
defaultdictdict=defaultdict
lcm=lambda x,y:x*y//gcd(x,y)
input=sys.stdin.buffer.readline
getonestr=lambda:input().strip()
getone=lambda:int(input().strip())
getstr=lambda:list(input().split())
CEIL_DIV=lambda a,b:(a//b)+bool(a%b)
SINGLE_TESTCASE=CALL=lambda func:func()
odd=lambda N:N&1;even=lambda N:not(odd(N))
write=lambda obj:sys.stdout.write(f"{obj}")
writeln=lambda obj:sys.stdout.write(f"{obj}\n")
get=getarr=lambda:list(map(int,input().split()))
def MULTIPLE_TESTCASE(func): [func() for _ in range(getone())]
_2D_ARRAY_SPAWN=lambda i,j,T=None: [[(0 if T is None else T) for _j in range(j)] for _i in range(i)]
_3D_ARRAY_SPAWN=lambda i,j,k,T=None: [[[(0 if T is None else T) for _k in(k)] for _j in range(j)] for _i in range(i)]
rgane=rgaen=rgnae=rgnea=rgean=rgena=ragne=ragen=raneg=raegn=raeng=rngae=rngea=rnage=rnaeg=rnega=rneag=regan=regna=reagn=reang=renga=renag=range
# input = BytesIO(os.read(0,os.fstat(0).st_size)).readline
# try:from __pypy__.builders import StringBuilder
# except Exeption as e:print("You didn't use PyPy") 


def solve():

        ...
        # Solution here!
        ten18 = 10**18
        n,m = get()
        adj = defaultdict(dict)
        adj_rev = defaultdict(dict)

        for i in range(m) :
                u,v,w = get()
                adj[u][v] = w if v not in adj[u] or adj[u][v] > w else adj[u][v]
                adj_rev[v][u] = w if u not in adj_rev[v] or adj_rev[v][u] > w else adj_rev[v][u]

        pq = [(0, 1)]
        srcdist = [ten18] * (n + 1)
        srcdist[1] = 0
        heapify(pq)

        while pq :
                dist, u = heappop(pq)
                if srcdist[u] < dist : continue

                for v in adj[u] :
                        if dist + adj[u][v] < srcdist[v]  :
                                srcdist[v] = dist + adj[u][v]
                                heappush(pq, (dist + adj[u][v], v))

        pq = [(0, n)]
        dstdist = [ten18] * (n + 1)
        dstdist[n] = 0
        heapify(pq)

        ans = 10**18
        while pq :
                dist, u = heappop(pq)
                if dstdist[u] < dist : continue


                for v in adj_rev[u] :
                        ans = min(ans, srcdist[v] + dist + (adj_rev[u][v] // 2))
                        if dist + adj_rev[u][v] < dstdist[v]  :
                                dstdist[v] = dist + adj_rev[u][v]
                                heappush(pq, (dist + adj_rev[u][v], v))

        return ans


@SINGLE_TESTCASE
def main() :
        ans=solve()
        if ans is not None: writeln(ans)