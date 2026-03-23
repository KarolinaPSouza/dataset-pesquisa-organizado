import collections
def solve():
    n=int(input())
    adj_list = [[] for _ in range(n+1)]
    for _ in range (n-1):
        u,v=list(map(int,input().split()))
        adj_list[u].append(v)
        adj_list[v].append(u)
    visted=[0]*(n+1)
    level=[0]*(n+1)
    def bfs(source):
        d = collections.deque()
        d.append(source)
        visted[source]=1
        while(len(d)):
            cur_v=d.popleft()      
            for child in adj_list[cur_v]:
                if(not visted[child]):
                    d.append(child)
                    visted[child]=1
                    level[child]=level[cur_v]+1
    bfs(1)
    visted=[0]*(n+1)
    m=0
    for i in range(1,n+1):
        if level[i]>=level[m]:
            m=i
    level=[0]*(n+1)
    bfs(m)
    print(max(level))

solve()