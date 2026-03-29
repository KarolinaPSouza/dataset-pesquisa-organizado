from heapq import heappush,heappop
import sys
n,m = map(int,input().split())
edges = [[] for i in range(n)]
for i in range(m):
    a,b,c = sys.stdin.readline().split()
    edges[int(a)-1].append((int(b)-1,int(c)))
dist1 = [float("inf")]*n
dist2 = [float("inf")]*n
nums = []
dist1[0]=0
dist2[0]=0

heappush(nums,(0,0))
while nums:
    curr,node = heappop(nums)
    ab = abs(node)
    if (node<=0 and curr!=dist1[ab]) or (node>0 and curr!=dist2[ab]):
        continue
    for i in edges[ab]:
        i0=i[0]
        i1=i[1]
        dist2i0=dist2[i0]
        part2 = float("inf") if node>0 else curr+i1//2
        part1 = curr+i1
        if node<=0 and dist1[i0]>part1:
            dist1[i0]=part1
            heappush(nums,(part1,-i0))
        if dist2i0>part2:
            dist2[i0]=part2
            heappush(nums,(part2,i0))
        elif dist2i0>part1:
            dist2[i0]=part1
            heappush(nums,(part1,i0))

print(dist2[-1])