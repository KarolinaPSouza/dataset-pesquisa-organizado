def find_farthest_node(graph, start):
    # 从某个节点开始进行DFS，返回最远的节点和距离
    stack = [(start, 0)]  # (节点，当前距离)
    visited = {start}
    farthest_node = start
    max_distance = 0

    while stack:
        node, dist = stack.pop()
        if dist > max_distance:
            max_distance = dist
            farthest_node = node

        for neighbor in graph[node]:
            if neighbor not in visited:
                visited.add(neighbor)
                stack.append((neighbor, dist + 1))

    return farthest_node, max_distance

def find_tree_diameter(n, graph):
    # 第一次DFS，任选节点1，找到最远的节点u
    u, _ = find_farthest_node(graph, 1)
    # 第二次DFS，从u出发，找到最远的节点v，并得到树的直径
    _, diameter = find_farthest_node(graph, u)
    return diameter

# 构建邻接表表示树
n = int(input())  # 节点数
graph = [[] for _ in range(n + 1)]

for _ in range(n - 1):  # 读取树的边
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

# 求树的直径
result = find_tree_diameter(n, graph)
print(result)