import sys
import bisect

def main():
    data = list(map(int, sys.stdin.buffer.read().split()))
    n, m = data[0], data[1]
    h = data[2:2+n]
    t = data[2+n:2+n+m]

    h.sort()

    # 1-based DSU: positions 1..n, 0 = sentinel meaning "none available"
    parent = list(range(n + 1))

    def find(x: int) -> int:
        while parent[x] != x:
            parent[x] = parent[parent[x]]
            x = parent[x]
        return x

    out = []
    for x in t:
        # i is number of tickets <= x (0..n)
        i = bisect.bisect_right(h, x)
        j = find(i)
        if j == 0:
            out.append("-1")
        else:
            out.append(str(h[j - 1]))          # convert back to 0-based for array access
            parent[j] = find(j - 1)            # remove j

    sys.stdout.write("\n".join(out))

if __name__ == "__main__":
    main()