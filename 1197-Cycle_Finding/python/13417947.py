import sys
input = sys.stdin.read
sys.setrecursionlimit(100000)

def main():
    data = input().split()
    n, m = int(data[0]), int(data[1])
    edges = []
    index = 2
    for _ in range(m):
        a = int(data[index]) - 1
        b = int(data[index + 1]) - 1
        c = int(data[index + 2])
        edges.append((a, b, c))
        index += 3

    dist = [0] * n
    parent = [-1] * n
    x = -1

    for i in range(n):
        x = -1
        for a, b, c in edges:
            if dist[a] + c < dist[b]:
                dist[b] = dist[a] + c
                parent[b] = a
                x = b

    if x == -1:
        print("NO")
    else:
        # There is a cycle. To find it, move n times up the parent chain to get into the cycle
        for _ in range(n):
            x = parent[x]

        cycle = []
        cur = x
        while True:
            cycle.append(cur)
            if len(cycle) > 1 and cur == x:
                break
            cur = parent[cur]

        cycle.reverse()
        print("YES")
        print(' '.join(str(i + 1) for i in cycle))

main()