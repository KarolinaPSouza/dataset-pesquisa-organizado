import sys
import bisect
def find_max(arr, target):
    i = 0
    j = len(arr) - 1
    while i <= j:
        mid = (i + j) // 2
        val = arr[mid]
        if val <= target:
            i = mid + 1
        else:
            j = mid - 1
    return j
def main():
    input = sys.stdin.readline
    n, m = map(int, input().split())
    h = list(map(int, input().split()))
    t = list(map(int, input().split()))
    h.sort()

    # uf[i] = if ticket i is unused, uf[i]==i,
    # otherwise uf[i] = find(i-1) = the next free slot to the left
    uf = list(range(n))

    def find(u):
        if u < 0:
            return -1
        if uf[u] != u:
            uf[u] = find(uf[u])
        return uf[u]

    out = []
    for ti in t:
        # 1) binary‐search highest index j with h[j] ≤ ti
        j = find_max(h, ti)
        # 2) find the actual available slot ≤ j
        rep = find(j)
        if rep < 0:
            out.append("-1")
        else:
            out.append(str(h[rep]))
            # mark rep as used: link it to rep-1’s representative
            uf[rep] = find(rep - 1)

    sys.stdout.write("\n".join(out))

if __name__ == "__main__":
    main()