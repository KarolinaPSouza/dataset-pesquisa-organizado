import io,os
import sys
import heapq
from collections import deque
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

def main():


    n = int(input())
    neigh = [[] for _ in range(n)]
    for _ in range(n-1):
        u,v = map(int,input().split())
        neigh[u-1].append(v-1)
        neigh[v-1].append(u-1)

    queue = deque()
    children = [[] for _ in range(n)]

    parent = [-2]*n
    parent[0] = -1
    queue.append(0)


    seq = []

    while queue:
        index = queue.popleft()
        seq.append(index)
        for nextindex in neigh[index]:
            if parent[nextindex] > -2: continue 
            parent[nextindex] = index 
            children[index].append(nextindex)
            queue.append(nextindex)


#    print(1)

    maxdepth = [[] for _ in range(n)]
    maxparent = [0]*n


    for index in seq[::-1]:
        if len(children[index])==0:  
            heapq.heappush(maxdepth[index],0)
            continue 
        for nextindex in children[index]:
            heapq.heappush(maxdepth[index], maxdepth[nextindex][-1] + 1)
            if len(maxdepth[index]) > 2:  heapq.heappop(maxdepth[index])



    ans = [0]*n
    ans[0] = maxdepth[0][-1]
    maxparent = [0]*n


    for index in seq[1:]:
        p = parent[index]
        maxparent[index] = maxparent[p] + 1
        if len(children[p])==1:
            ans[index] = max(maxparent[index], maxdepth[index][-1])
            continue 

        if maxdepth[index][-1] == maxdepth[p][-1] - 1:
            maxparent[index] = max(maxparent[index], maxdepth[p][0] + 1)
        else:
            maxparent[index] = max(maxparent[index], maxdepth[p][-1] + 1)

        ans[index] = max(maxparent[index], maxdepth[index][-1] )




    s = " ".join(map(str,ans))
    sys.stdout.write(s+"\n")



main()


