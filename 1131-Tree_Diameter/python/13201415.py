def solve():
    n = int(input())
    adj = [[] for _ in range(n)]
    for _ in range(n-1):
        a, b = map(int, input().split())
        adj[a-1].append(b-1)
        adj[b-1].append(a-1)

    # format: (root, parent that called this node, state (0 is children not added, 1 is children added))
    stack = [(0, -1, 0)]
    # for each node: the max 2 children depths, and the maximum diameter that was found so far, total
    node_stats = [[0] * 3 for _ in range(n)]

    while stack:
        root, parent, state = stack.pop()
        if state == 0:
            stack.append((root, parent, 1))
            for child in adj[root]:
                if child == parent: continue
                stack.append((child, root, 0))
        elif state == 1:
            for child in adj[root]:
                if child == parent: continue
                if node_stats[child][0] + 1 > node_stats[root][0]:
                    node_stats[root][1] = node_stats[root][0]
                    node_stats[root][0] = node_stats[child][0] + 1
                elif node_stats[child][0] + 1 > node_stats[root][1]:
                    node_stats[root][1] = node_stats[child][0] + 1

                node_stats[root][2] = max(node_stats[root][2], node_stats[child][2])
            node_stats[root][2] = max(node_stats[root][2], node_stats[root][0] + node_stats[root][1])

    print(node_stats[0][2])






solve()