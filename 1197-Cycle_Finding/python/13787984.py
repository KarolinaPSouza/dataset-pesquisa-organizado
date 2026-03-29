import sys
input = sys.stdin.readline

def main():
    n, m = map(int, input().split())
    edges = []

    for _ in range(m):
        a, b, c = map(int, input().split())
        edges.append((a, b, c))

    dist = [0] * (n + 1)
    parent = [-1] * (n + 1)
    x = -1  # Nodo en el que se detecta relajación en la n-ésima iteración

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
        # Reconstruir el ciclo
        for _ in range(n):
            x = parent[x]

        cycle = []
        curr = x
        while True:
            cycle.append(curr)
            if len(cycle) > 1 and curr == x:
                break
            curr = parent[curr]

        cycle.reverse()
        print("YES")
        print(" ".join(map(str, cycle)))

if __name__ == "__main__":
    main()