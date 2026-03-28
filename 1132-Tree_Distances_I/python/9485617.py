n = int(input())
adj_list = [[] for _ in range(n)]
for _ in range(n - 1):
    a, b = map(int, input().split())
    a -= 1; b -= 1
    adj_list[a].append(b)
    adj_list[b].append(a)

def furthest_node(v):
    visited = [False] * n
    dist = [0] * n
    stack = [v]
    while stack:
        v = stack.pop()
        visited[v] = True
        for w in adj_list[v]:
            if not visited[w]:
                dist[w] = dist[v] + 1
                stack.append(w)

    return max(enumerate(dist), key=lambda t: t[1]), dist

(a, _), _ = furthest_node(0)
(b, _), a_dists = furthest_node(a)
(_, _), b_dists = furthest_node(b)
for i in range(n):
    print(max(a_dists[i], b_dists[i]), end=' ')