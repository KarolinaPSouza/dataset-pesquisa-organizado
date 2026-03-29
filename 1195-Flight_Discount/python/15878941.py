from heapq import heappush, heappop

def read_input():
    cities, flights = map(int, input().split())
    cities += 1
    adj = [[] for _ in range(cities)] 

    for _ in range(flights):
        a,b,c = map(int, input().split())
        adj[a].append((b,c))

    MAX_INT = 1000000000000000
    vis = [[MAX_INT, MAX_INT] for _ in range(cities)]
    cities -= 1
    return adj, cities, vis

def solve_tc(adj, cities, vis):
    q = [] # (price, city, distcount)
    heappush(q, (0,1,1))
    vis[1][1], vis[1][0] = 0, 0

    while q:
        p, st, c = heappop(q)
        if p > vis[st][c]:
            continue
        if st == cities:
            return p

        for ed, dis in adj[st]:
            nxt_d = dis + p
            if nxt_d < vis[ed][c]:
                vis[ed][c] = nxt_d
                heappush(q, (nxt_d, ed, c))
            if c:
                nxt_d = dis//2 + p
                if nxt_d < vis[ed][c-1]:
                    vis[ed][c-1] = nxt_d
                    heappush(q, (nxt_d, ed, c-1)) 

if __name__ == '__main__':
    adj, cities, vis = read_input()
    ans = solve_tc(adj, cities, vis)
    print(ans)