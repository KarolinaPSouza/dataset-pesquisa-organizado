from sys import stdin
from collections import deque


class Graph:
    def __init__(self, row, col, graph):
        self.row = row
        self.col = col
        self.graph = graph
        self.visited = [[False for i in range(self.col)] for j in range(self.row)]

    def is_safe(self, row, col):
        if row < 0 or col < 0 or row >= self.row or col >= self.col or self.graph[row][col] != '.' or self.visited[row][col]:
            return False
        return True

    def bfs(self, row, col):
        neighbour_row = [-1, 1, 0, 0]
        neighbour_col = [0, 0, -1, 1]
        q = deque()
        q.append([row, col])

        self.visited[row][col] = True        
        while(len(q) > 0):
            temp = q.popleft()
            x = temp[0]
            y = temp[1]

            for k in range(4):
                if self.is_safe(x + neighbour_row[k], y + neighbour_col[k]):
                    self.visited[x + neighbour_row[k]][y + neighbour_col[k]] = True
                    q.append([x + neighbour_row[k], y + neighbour_col[k]])

    def count_rooms(self):
        count = 0 
        for i in range(self.row):
            for j in range(self.col):
                if self.graph[i][j] == '.' and not self.visited[i][j]:
                    self.bfs(i, j)
                    count += 1
        return count    

if __name__ == '__main__':
    n, m = list(map(int, stdin.readline().strip().split()))
    graph = [list(stdin.readline().strip()) for i in range(n)]
    g = Graph(n, m, graph)
    print(g.count_rooms())