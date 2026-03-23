import sys
import math

def main():
    data = sys.stdin.read().split()
    data = list(map(int, data))
    n, m = data[0], data[1]
    h = data[2:n+2]
    queries = data[n+2:]

    # n, m = 5, 3
    # h = [3, 5, 5, 7, 8]
    # queries = [4, 8, 3]

    def bin_search(lst, targ):
        l, r = 0, len(lst) - 1
        ans = -1
        while l <= r:
            mid = (l + r) // 2
            if lst[mid] <= targ:
                ans = mid
                l = mid + 1
            else:
                r = mid - 1
        return ans

    h.sort()

    size = 2**(math.ceil(math.log2(len(h))))
    tree = [0]*(2*size)
    for i in range(size):
        tree[size+i] = 1
    for i in range(size-1, 0, -1):
        tree[i] = tree[2*i] + tree[2*i + 1]

    def query(l, r):
        l += size
        r += size
        total = 0
        while l <= r:
            if l % 2 == 1:
                total += tree[l]
                l += 1
            if r % 2 == 0:
                total += tree[r]
                r -= 1
            l = l // 2
            r = r // 2
        return total

    def update(i):
        tree[i] = 0
        i = i // 2
        while i > 0:
            tree[i] = tree[2*i] + tree[2*i + 1]
            i = i // 2

    def find(val):
        i = 1
        while i < size:
            if tree[2*i] >= val:
                i = 2*i
            else:
                val -= tree[2*i]
                i = 2*i + 1
        return i - size

    output = []
    for each in queries:
        up_bound =  bin_search(h, each)
        # print(each, up_bound)
        if up_bound < 0:
            output.append(-1)
        else:
            total = query(0,up_bound)
            if total == 0:
                output.append(-1)
            else:
                ind = find(total)

                # print(total, ind)
                # print(tree)
                update(ind+size)
                output.append(h[ind])

    sys.stdout.write("\n".join(map(str, output)))




if __name__ == '__main__':
    main()