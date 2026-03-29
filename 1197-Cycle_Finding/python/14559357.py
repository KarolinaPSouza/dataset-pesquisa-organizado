#!/usr/bin/env python3
# ---------- CP / CSES Python Template (fast & flexible) ----------
# Usage:
#   - Put problem-specific logic inside solve() (or solve_one() + T loop).
#   - Keep helpers here; remove ones you don't need to shrink code before submit.
#   - Works with: single case, multiple test cases, graphs, grids, etc.

import sys
from collections import deque, defaultdict
import math
import heapq
from typing import List, Tuple, Iterable

INF = math.inf
# ---------- FAST INPUT ----------
# Read-all-at-once token scanner (best for typical CSES)
_tokens = sys.stdin.buffer.read().split()
_it = iter(_tokens)

def ni() -> int:
    """next int"""
    return int(next(_it))
def ns() -> str:
    """next token as str (decoding once)"""
    return next(_it).decode()
def nb() -> bytes:
    """next token as raw bytes"""
    return next(_it)
def nf() -> float:
    """next float"""
    return float(next(_it))

# If you need streaming-by-line (rare on CSES), replace the block above with:
# for line in sys.stdin.buffer: ...   (keep this template but don't use ni/ns).

# ---------- FAST OUTPUT ----------
out_lines: List[str] = []
def out(*args, sep=" ", end="\n"):
    """buffered printing"""
    out_lines.append(sep.join(map(str, args)) + ("" if end == "" else end))

def flush():
    if out_lines:
        sys.stdout.write("".join(out_lines))

# ---------- COMMON PARSING HELPERS ----------
def read_list_int(n: int) -> List[int]:
    """read n integers"""
    return [ni() for _ in range(n)]

def read_matrix_int(n: int, m: int) -> List[List[int]]:
    """read n x m matrix of ints"""
    return [[ni() for _ in range(m)] for __ in range(n)]
# ---- graph helper ------
def inb(r, c, n, m) -> bool:
    return 0 <= r < n and 0 <= c < m



# ---------- SOLVE ----------
def solve() -> None:
    # Idea here is to use bellman Ford, run it N times. If on the last time, we have an update, then we have a negative cycle.
    # how would we find such cycle? 
    # keep a parent dict for a shortest path


    N, M = read_list_int(2)
    edges = [tuple(read_list_int(3)) for _ in range(M)]  # (u, v, w)
    for i in range(N):
        edges.append((0, i + 1, 0))


    def bellman_ford(n, edges, start):
        dist = [float("inf")] * n
        pred = [None] * n

        dist[start] = 0

        for _ in range(n):
            for u, v, d in edges:
                if dist[u] + d < dist[v]:
                    dist[v] = dist[u] + d
                    pred[v] = u
        """Sanity Check"""
        cycle_start = -1
        for u, v, d in edges:
            if dist[u] + d < dist[v]:
                cycle_start = v
                pred[v] = u
                print('YES')
                break


        return dist, pred, cycle_start

    dist, pred, v = bellman_ford(N + 1, edges, 0)
    #print(f'cycle starts at {v}')
    if v > 0:
        seen = set()
        nodes = []
        for _ in range(N + 1):
            nodes.append(v)
            if v in seen:
                break
            seen.add(v)
            v = pred[v]
        #print(nodes)
        seen = set()
        cycle = []
        for v in nodes[::-1]:
            cycle.append(v)
            if v in seen:

                break
            seen.add(v)
        print(*cycle)
    else:
        print('NO')


# ---------- MAIN ----------
if __name__ == "__main__":
    # For quick local testing without files, set _TEST to a bytes string:
    # _TEST = b"""\
    # 5
    # """
    _TEST = None
    if _TEST is not None:
        data = _TEST.split()
        _it = iter(data)  # rebind scanner
    solve()
    flush()