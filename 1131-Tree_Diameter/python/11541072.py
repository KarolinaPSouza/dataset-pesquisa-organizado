from collections import defaultdict,deque

n=int(input())
graph=defaultdict(list)
for _ in range(n-1):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

def BFS(node):
    q=deque([node])
    farthest_node,dist=node,0
    seen=set()
    seen.add(node)
    while q:
        for _ in range(len(q)):
            cur=q.popleft()
            farthest_node=cur
            for next_node in graph[cur]:
                if next_node not in seen:
                    q.append(next_node)
                    seen.add(next_node)
        if q:dist+=1

    return farthest_node,dist


farthest_node,dist=BFS(1)
next_end,dia=BFS(farthest_node)
print(dia)