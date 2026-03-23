import sys
sys.setrecursionlimit(100000)

input = sys.stdin.read
output = sys.stdout.write

def dfs(v, parent, G, dist):
    stack = [(v, parent, dist)]
    farthest_node = v
    max_distance = dist
    while stack:
        v, parent, dist = stack.pop()
        if dist > max_distance:
            max_distance = dist
            farthest_node = v
        i = 0
        while i < len(G[v]):
            to = G[v][i]
            if to != parent:
                stack.append((to, v, dist + 1))
            i += 1
    return farthest_node, max_distance

def main():
    data = input().split()
    N = int(data[0])
    G = [[] for _ in range(N + 1)]

    index = 1
    count = 0
    while count < N - 1:
        a = int(data[index])
        b = int(data[index + 1])
        G[a].append(b)
        G[b].append(a)
        index += 2
        count += 1

    # First DFS to find the farthest node from node 1
    farthest_node, _ = dfs(1, -1, G, 0)

    # Second DFS from the farthest node found to get the diameter
    _, diameter = dfs(farthest_node, -1, G, 0)

    output(str(diameter) + '\n')

if __name__ == "__main__":
    main()