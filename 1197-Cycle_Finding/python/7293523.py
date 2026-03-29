from sys import stdin, stdout


def inp():
    return int(stdin.readline())


def inlt():
    return list(map(int, stdin.readline().strip().split()))


def insr():
    s = stdin.readline().strip()
    return list(s[:len(s)])


def invr():
    return map(int, stdin.readline().strip().split())

def find_negative_cycle(n, edges):
    dist = [0] * n
    prev = [-1] * n
    x = -1

    for i in range(n):
        x = -1
        for j in range(len(edges)):
            u, v, w = edges[j]
            if dist[v] > dist[u] + w:
                dist[v] = dist[u] + w
                prev[v] = u
                x = v

    if x == -1:
        print("NO")  # No negative cycle
    else:
        cycle = []
        for i in range(n):
            x = prev[x]
        v = x
        while True:
            cycle.append(v + 1)
            if v == x and len(cycle) > 1:
                break
            v = prev[v]
        cycle.reverse()
        print("YES")
        print(" ".join(map(str, cycle)))


def main():
    n, m = invr()
    edges = []

    for _ in range(m):
        u, v, w = invr()
        edges.append((u - 1, v - 1, w))

    find_negative_cycle(n, edges)


if __name__ == "__main__":
    main()