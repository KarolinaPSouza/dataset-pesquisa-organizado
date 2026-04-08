def solve(target, nums):
    h1 = len(nums) // 2 - 1
    assert h1 <= 19, "h1 should be less than or equal to 19"

    sums = [0]
    for i in range(h1 + 1):
        current_size = len(sums)
        for j in range(current_size):
            sums.append(nums[i] + sums[j])

    sums.sort()

    def size(target):
        lo = len(sums) - 1
        b = len(sums)
        while b != 0:
            while lo - b >= 0 and sums[lo - b] >= target:
                lo -= b
            b //= 2
        if sums[lo] != target:
            return 0
        hi = lo
        b = len(sums)
        while b != 0:
            while hi + b < len(sums) and sums[hi + b] <= target:
                hi += b
            b //= 2
        return hi - lo + 1

    count = [0]

    def dfs(curr, hi, acc):
        if curr > hi:
            count[0] += size(target - acc)
            return
        dfs(curr + 1, hi, acc)
        dfs(curr + 1, hi, acc + nums[curr])

    dfs(h1 + 1, len(nums) - 1, 0)

    return count[0]

def main():
    import sys
    input = sys.stdin.read
    data = input().split()

    _, x = int(data[0]), int(data[1])
    nums = list(map(int, data[2:]))

    ans = solve(x, nums)
    print(ans)

if __name__ == "__main__":
    main()