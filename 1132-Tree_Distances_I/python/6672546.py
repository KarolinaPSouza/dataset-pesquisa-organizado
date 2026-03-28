import math
import string
import sys
# sys.setrecursionlimit(2**30)
# sys.stdin = open(".in", "r")
# sys.stdout = open(".out", "w")
input = sys.stdin.readline
def print(*args, end='\n', sep=' ') -> None:
    sys.stdout.write(sep.join(map(str, args)) + end)
def map_int():
    return map(int, input().split())
def list_int():
    return list(map(int, input().split()))
def matrixPrint(matrix):
    for x in matrix:
        print(*x)
from collections import defaultdict, deque, Counter
from math import sqrt, gcd, comb, perm, factorial
from itertools import permutations
# from random import shuffle
# from heapq import heappop, heappush, heapify

def findSubtreeDepth(root,adj,  diameterNodes, subTreeDepths):
    visited = set()
    visited.add(root)
    d = 0
    stack = [(root, d)]
    while stack:
        node, depth = stack.pop()
        subTreeDepths[node][0] = root
        subTreeDepths[node][1] = depth
        for neighbor in adj[node]:
            if neighbor not in visited and neighbor not in diameterNodes:
                visited.add(neighbor)
                stack.append((neighbor, depth+1 ))

def findFurthest(start, d,  adj, n):
    visited = [0 for i in range(n+1)]
    parents = [-1 for i in range(n+1)]
    visited[start] = 1
    stack = [(start, 0)]
    mxDist = 0
    mxNode = start
    while stack:
        node, dd = stack.pop()
        if dd > mxDist:
            mxDist = dd
            mxNode = node
        for neighbor in adj[node]:
            if not visited[neighbor]:
                visited[neighbor] = 1
                parents[neighbor] = node
                stack.append((neighbor, dd+1))

    return mxNode, mxDist, parents



def solve():
    n = int(input())
    adj = defaultdict(list)
    for i in range(n-1):
        v1, v2 = map_int()
        adj[v1].append(v2)
        adj[v2].append(v1)

    '''
    find the two end-points of the diameter
    for each node in the diameter find the distance to the furthest end-pont
    for each subtree in the diameter find the depth of each node in that subree
    to find the mx distance for any node add the depth and 
    the distance of the root node
    '''

    a, dist, parents = findFurthest(1, 0, adj, n)
    b, dist, parents = findFurthest(a, 0, adj, n)
    diameterNodes = defaultdict(int)
    cur = b
    c = 0
    while cur != -1:
        diameterNodes[cur] = max(dist-c, c)
        c += 1
        cur = parents[cur]

    subTreeDepths = defaultdict(lambda : [0, 0])
    for root in diameterNodes:
        findSubtreeDepth(root, adj, diameterNodes, subTreeDepths)

    answer = [0 for i in range(n)]
    for i in range(n):
        node = i + 1
        root, depth = subTreeDepths[node]
        answer[i] = depth + diameterNodes[root]

    print(*answer)




if __name__ == '__main__':
    # NumberOfTestcases = int(input())
    # for _ in range(NumberOfTestcases):
    solve()