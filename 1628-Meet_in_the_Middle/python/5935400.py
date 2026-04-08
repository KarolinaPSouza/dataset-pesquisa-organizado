#from sortedcontainers import SortedList

# class Solution:
#     def kItemsWithMaximumSum(self, numOnes: int, numZeros: int, numNegOnes: int, k: int) -> int:
#         ans=min(numOnes,k)
#         k-=numOnes
#         if k>0:
#             k-=numZeros
#             if k>0:
#                 ans-=min(numNegOnes,k)
#                 k-=numNegOnes
#         return ans





# def longestCycle( edges) -> int:
#     n=len(edges)
#     visited=[0]*n
#     curv=[0]*n
#     def dfs(node):
#         nonlocal visited,curv
#         slow=node
#         fast=node
#         curlen=1
#         while edges[fast]!=-1:
#             slow=edges[fast]
#             fast=edges[edges[fast]]
#             curlen+=1
#             if curv[slow] or curv[fast]:
#                 return curlen
#             if visited[slow] or visited[fast]:
#                 return -1
#             visited[slow]=1
#             visited[fast]=1
#             curv[slow]=1
#             curv[fast]=1
#         return -1
#     ans=-1
#     for i in range(n):
#         if not visited[i]:
#             ans=max(ans,dfs(i))
#     return ans

# print(longestCycle([2,-1,3,1]))

def kItemsWithMaximumSum( numOnes: int, numZeros: int, numNegOnes: int, k: int) -> int:
        ans=min(numOnes,k)
        k-=numOnes
        if k>0:
            k-=numZeros
            if k>0:
                ans-=min(numNegOnes,k)
                k-=numNegOnes
        return ans

#print(kItemsWithMaximumSum(3,2,0,4))


#print([SortedList(range(m)) for _ in range(n)])

n,x=map(int,input().split())
arr=list(map(int,input().split()))
def dc(start,end):
     if start>end:
          return {}
     if start==end:
          return {arr[start]:1}
     m=(start+end)//2
     left=dc(start,m)
     right=dc(m+1,end)
     ans={}
     for k2,v2 in right.items():
        if k2<=x:
                if k2 in ans:
                        ans[k2]+=v2
                else:
                        ans[k2]=v2
     for k,v in left.items():
        if k<=x:
                if k in ans:
                        ans[k]+=v
                else:
                        ans[k]=v
                for k2,v2 in right.items():
                        if k+k2<=x:
                                if k+k2 in ans:
                                        ans[k+k2]+=v2*v
                                else:
                                        ans[k+k2]=v2*v
     return ans
arr.sort()
l=0
r=n-1
rb=0
while l<=r:
      m=(l+r)//2
      if arr[m]>x:
            r=m-1
      else:
            rb=m
            l=m+1

t=dc(0,rb//2)
t2=dc(rb//2+1,rb)
ans=0
if x in t:
     ans+=t[x]
if x in t2:
     ans+=t2[x]
for k,v in t.items():
        if x-k in t2:
            ans+=v*t2[x-k]
print(ans)