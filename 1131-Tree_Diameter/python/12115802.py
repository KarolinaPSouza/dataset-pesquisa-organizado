import sys
import collections

def build_tree(n):
    tree = collections.defaultdict(list)
    for _ in range(n - 1):
        a, b = map(int, sys.stdin.readline().split())
        tree[a].append(b)
        tree[b].append(a)
    return tree

def dfs_iterative(start, tree):
    stack = [(start, -1, 0)]
    farthest_node, max_depth = start, 0
    while stack:
        node, parent, depth = stack.pop()
        if depth > max_depth: farthest_node, max_depth = node, depth
        for neighbor in tree[node]:
            if neighbor != parent: stack.append((neighbor, node, depth + 1))
    return farthest_node, max_depth

def find_tree_diameter(n, tree):
    if n == 1: return 0
    start_node = next(iter(tree.keys()))
    farthest, _ = dfs_iterative(start_node, tree)
    _, diameter = dfs_iterative(farthest, tree)
    return diameter


if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    if n == 1: print(0)
    else:
        tree = build_tree(n)
        print(find_tree_diameter(n, tree))