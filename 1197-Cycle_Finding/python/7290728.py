import math
from collections import defaultdict
from collections import Counter
from collections import deque
import heapq

def InputStr(): return input()
def InputInt(): return int(input())
def InputIterables(): return map(int, input().split())
def InputList(): return list(map(int, input().split()))
def InputSortedList(): return sorted(list(map(int, input().split())))
def InputRevSortedList(): return list(reversed(sorted(list(map(int, input().split())))))
def InpStrToList(): return list(input())

def main():
  N, M = InputList()
  graph = []
  distances = [0 for _ in range(N)]
  relaxants = [float('inf') for _ in range(N)]

  for i in range(M):
    a, b, w = InputList()
    graph.append((a-1, b-1, w))

  for _ in range(N-1):
    for i, j, w in graph:
      if distances[i] != float('inf') and distances[i]+w < distances[j]:
        distances[j] = distances[i]+w
        relaxants[j] = i

  cycles = False
  lastRelaxed = 0
  for i, j, w in graph:
    if distances[i] != float('inf') and distances[i]+w < distances[j]:
      cycles = True
      lastRelaxed = j

  visited = set()
  path = []
  if cycles == True:
    print("YES")

    while True:
      if lastRelaxed == float('inf'):
        path.append(1)
        break
      path.append(lastRelaxed+1)
      if lastRelaxed in visited:
        break

      visited.add(lastRelaxed)
      lastRelaxed = relaxants[lastRelaxed]

    print(*reversed(path))
  else:
    print("NO")

T = 1
for _ in range(T):
  main()