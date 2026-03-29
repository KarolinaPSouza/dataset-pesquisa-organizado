#
# def mex(a):
#     n=len(a)
#     for i in range(n):
#         while(a[i]<n and a[a[i]]!=a[i]):
#               temp=a[a[i]]
#               a[a[i]]=a[i]
#               a[i]=temp
#
#     for i in range(n):
#         if(a[i]!=i):
#            return i
#
#     return n

# import numpy as np
#
# def outside_points(ndim):
#      npoints=100000
#      points=np.random.rand(npoints,ndim)
#
#      # dfo=np.zeros((npoints,1))
#      # outside=0
#      #
#      # for i in range(npoints):
#      #     for j in range(ndim):
#      #         dfo[i]+=points[i,j]**2
#      #
#      #     dfo[i]=np.sqrt(dfo[i])
#      #     if dfo[i]>1:
#      #        outside+=1
#
#      outside=np.sum(np.sqrt(np.sum(points*points,axis=1))>1)
#      return outside/npoints


from collections import deque

def bfs(graph,vis,r,w):
    row=len(graph)
    col=len(graph[0])

    dx=[0,-1,0,1]
    dy=[1,0,-1,0]

    vis[r][w]=True
    q=deque()

    q.append((r,w))

    while q:
          loc=q.popleft()
          u=loc[0]
          v=loc[1]

          for k in range(4):
              rw=u+dx[k]
              cl=v+dy[k]

              if 0 <= rw < row and 0 <= cl < col and  graph[rw][cl]=='.' and vis[rw][cl]==False:
                  vis[rw][cl]=True
                  q.append((rw,cl))

if __name__ == "__main__":
     n,m=map(int,input().strip().split())
     graph=[]

     for i in range(n):
         string =input()
         chars=[]
         for ch in string:
             chars.append(ch)
         graph.append(chars)

     vis=[[False for i in range(m)] for j in range(n)]
     rooms=0

     for i in range(n):
         for j in range(m):
             if graph[i][j]=='.' and vis[i][j]==False:
                bfs(graph,vis,i,j)
                rooms+=1

     print(rooms)

























































































































































