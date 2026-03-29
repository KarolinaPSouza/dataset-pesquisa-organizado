from typing import * # type: ignore
from collections import deque

class Solution:
    def __init__(self, n: int, m: int, grid: List[List[str]]) -> None:
        self.n = n
        self.m = m
        self.grid = grid
        self.directions = [(1,0), (0,1), (0,-1), (-1,0)]

    def count_rooms(self) -> int:
        visited = [[False]*self.m for _ in range(self.n)]
        num_rooms = 0
        for i in range(self.n):
            for j in range(self.m):
                if self.grid[i][j] == '.' and not visited[i][j]:
                    num_rooms += 1
                    self.bfs(i, j, visited)
        return num_rooms 

    def bfs(self, i: int, j: int, visited: List[List[bool]]) -> None:
        visited[i][j] = True
        q = deque([(i,j)])
        while q:
            x, y = q.popleft()
            for dx, dy in self.directions:
                r, c = x+dx, y+dy
                if r < 0 or r >= self.n or c < 0 or c >= self.m:
                    continue
                if  self.grid[r][c] == '.' and not visited[r][c]:
                    visited[r][c] = True
                    q.append((r,c))
        return 

n, m = map(int, input().split())
grid = [list(map(str, input().strip())) for _ in range(n)]
obj = Solution(n, m, grid)
print(obj.count_rooms())