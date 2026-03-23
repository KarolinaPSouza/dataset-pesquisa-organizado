from bisect import *
import sys
sys.setrecursionlimit(200000)
n,m=map(int,input().split())
h=list(map(int,input().split()))
t=list(map(int,input().split()))
h.sort()
def get_endpoint(idx):
    if idx == -1 or idx == endpoints[idx]: 
        return idx
    endpoints[idx] = get_endpoint(endpoints[idx])  
    return endpoints[idx]
endpoints = list(range(n))
for i in t:
    pos = get_endpoint(bisect(h, i) - 1)
    if pos >= 0:
        print(h[pos])
        endpoints[pos] = pos - 1
    else:
        print(-1)