"""
n = number of nodes
m = number of edges
edges = list of edges (node_A, node_B, cost)
"""

from sys import stdin
rd = lambda: list(map(int, stdin.readline().split()))

class Edge:
  def __init__(self, a, b, cost):
    self.a = a
    self.b = b
    self.cost = cost

  def __repr__(self):
    return f"(a: {self.a}   b: {self.b}   cost: {self.cost})"

  def __str__(self):
    return f"(a: {self.a}   b: {self.b}   cost: {self.cost})"


# Read Input
n, m = rd()
edges = []
for _ in range(m):
  a, b, cost = rd()
  edges.append(Edge(a, b, cost))  

n += 1 # verticies go up to n

distances = [0] * n # Stores distances/cost of getting to each node
path = [-1] * n # Each index represents a vertex and stores the previous vertex in the path

lastUpdated = -1
for i in range(n):
  lastUpdated = -1
  for edge in edges:
    newABCost = distances[edge.a] + edge.cost
    if newABCost < distances[edge.b]:
      distances[edge.b] = newABCost
      path[edge.b] = edge.a
      lastUpdated = edge.b

if lastUpdated == -1:
  # No negative cycle found
  print("NO")
else:
  # Find start vertex
  start = lastUpdated
  for i in range(n):
    start = path[start]

  # Find cycle path
  cycle = []
  vertex = start
  while (True):
    cycle.append(vertex)
    if vertex == start and len(cycle) > 1:
      break
    vertex = path[vertex]

  cycle.reverse()

  print("YES")
  print(*cycle, sep=" ")