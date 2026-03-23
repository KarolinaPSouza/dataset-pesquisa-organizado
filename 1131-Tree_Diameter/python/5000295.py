import sys


def main():
    # input_lines = sys.stdin.read().split('\n')
    n = int(input())
    if n == 1:
        print(0)
        return

    edges = [[] for _ in range(n)]

    for i in range(1, n):
        a, b = map(int, input().split())
        edges[a-1].append(b-1)
        edges[b-1].append(a-1)

    end_node = None
    max_diam = 0

    for node in range(n):
        if len(edges[node]) == 1:
            diam, end_node = calc_diameter(edges, node)
            max_diam = max(max_diam, diam-1)
            break

    diam, _ = calc_diameter(edges, end_node)
    max_diam = max(max_diam, diam-1)

    print(max_diam)


def calc_diameter(edges, node):
    """Calculate the max diameter from the node you are starting at"""
    diam = 0
    children = edges[node]
    visited = [False] * len(edges)
    visited[node] = True

    end_node = None

    while children:
        new_children = []

        for child in children:
            if visited[child]:
                continue
            end_node = child
            visited[child] = True
            new_children.extend(edges[child])

        children = new_children
        diam += 1

    return diam, end_node


if __name__ == '__main__':
    main()