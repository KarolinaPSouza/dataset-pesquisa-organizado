def dfs(i, j, n, m, matrix, visited):
    pilha = [(i,j)]
    while pilha:
        ci, cj = pilha.pop()
        if not visited[ci][cj]:
            visited[ci][cj] = True
            vis = [(ci-1, cj), (ci+1, cj), (ci, cj-1), (ci, cj+1)]

            for ni, nj in vis:
                if 0 <= ni < n and 0 <= nj < m and not visited[ni][nj] and matrix[ni][nj] == '.':
                    pilha.append((ni,nj))

n, m = map(int, input().split(" "))
matrix = [input().strip() for _ in range(n)]

visited = [[False] * m for _ in range(n)]
roomCount = 0
for i in range(n):
    for j in range(m):
        if matrix[i][j] == "." and not visited[i][j]:
            dfs(i, j, n, m, matrix, visited)
            roomCount += 1
print(roomCount)