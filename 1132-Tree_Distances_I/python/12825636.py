from collections import deque

node_count = int(input())

edges = [[] for _ in range(node_count)]
for _ in range(node_count - 1):
    x, y = map(int, input().split())
    edges[x-1].append(y-1)
    edges[y-1].append(x-1)

root = 0

def get_extreme_node():
   nxt = deque([(root, 0)])
   visited = [False] * node_count
   visited[root] = True
   max_depth = (0, root)
   while len(nxt) > 0:
       curr_node, _depth = nxt.popleft()
       depth = _depth + 1
       for each in edges[curr_node]:
           if not visited[each]:
               visited[each] = True
               nxt.append((each, depth))
               if max_depth[0] < depth:
                   max_depth = (depth, each)
   return max_depth

def get_distances_from(node):
   distances = [0] * node_count
   nxt = deque([(node, 0)])
   visited = [False] * node_count
   visited[node] = True
   while len(nxt) > 0:
       curr_node, _depth = nxt.popleft()
       depth = _depth + 1
       for each in edges[curr_node]:
           if not visited[each]:
               visited[each] = True
               nxt.append((each, depth))
               distances[each] = depth
   return distances 

def get_max_index(arr):
    m = arr[0]
    j = 0
    for i in range(1, len(arr)):
        if arr[i] > m:
            m = arr[i]
            j = i
    return j 

# get extreme node from root -- say this is north
_, north = get_extreme_node()
# get farethest node from from north node, while doing this update lengths to nodes from north node
distances_to_north = get_distances_from(north)
south = get_max_index(distances_to_north)
# update lengts from node to south node
distances_to_south = get_distances_from(south)
# get max of lengts for each node
print(' '.join(map(str, [max(distances_to_north[i], distances_to_south[i]) for i in range(node_count)])))



