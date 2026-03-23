from collections import defaultdict, deque

n = int(input())

tree = defaultdict(list)

for i in range(n - 1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

visited = set([1])
q = deque([1])
lastNode = 1
while q:
    currNode = q.popleft()
    lastNode = currNode
    for neighbor in tree[currNode]:
        if neighbor not in visited:
            q.append(neighbor)
            visited.add(neighbor)

q = deque([lastNode])
visited = set([lastNode])
ans = 0
while q:
    size = len(q)

    for _ in range(size):
        currNode = q.popleft()
        lastNode = currNode
        for neighbor in tree[currNode]:
            if neighbor not in visited:
                q.append(neighbor)
                visited.add(neighbor)
    ans += 1

print(ans - 1)
