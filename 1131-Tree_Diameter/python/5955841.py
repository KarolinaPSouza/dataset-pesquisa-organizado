def main():
    n = int(input())

    adj = [[] for i in range(n+1)]

    for i in range(n-1):
        u, v = map(int, input().split())

        adj[u].append(v)
        adj[v].append(u)

    queue = [1]
    q = 1 

    vis = [0]*(n+1)
    vis[1] = 1 

    dist = [0]*(n+1)

    ans = 0 

    while q > 0:
        s = queue[-1]

        flag = True 

        for z in adj[s]:
            if not vis[z]:
                vis[z] = 1 
                queue.append(z)
                q += 1 
                flag = False

        if flag:
            mx = 0

            arr = []

            for z in adj[s]:
                arr.append(dist[z])

            arr.sort()

            if arr:
                mx = arr[-1]

            ans = max(ans, mx)

            dist[s] = mx+1 

            # print(arr, s)

            if len(arr) > 1:
                ans = max(ans, arr[-1]+arr[-2])

            queue.pop()
            q -= 1 

    # print(dist) 
    # print(vis)

    return ans

print(main())



