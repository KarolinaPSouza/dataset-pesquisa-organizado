n, m = map(int, input().split(" "))
b = []
visited = []
for i in range(n):
    b.append(list(input()))
    v = [False] * m
    visited.append(v)
ct = 0


def bfs(r, c):
    st = [(r, c)]
    while len(st) > 0:
        r, c = st.pop()
        if r < 0 or r >= n or c < 0 or c >= m or visited[r][c] or b[r][c] == "#":
            continue
        visited[r][c] = True
        st.append((r+1, c))
        st.append((r-1, c))
        st.append((r, c+1))
        st.append((r, c-1))


for i in range(0, n):
    for j in range(0, m):

        if not visited[i][j] and b[i][j] == '.':
            ct += 1

            bfs(i, j)


print(ct)