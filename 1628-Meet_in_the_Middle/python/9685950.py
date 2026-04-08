def main():
    def read_int():
        return int(input().strip())

    def read_ints():
        return list(map(int, input().strip().split()))

    def read_ints_min_one():
        return [int(x) - 1 for x in input().strip().split()]

    _, x = read_ints()
    nums = read_ints()
    ans = solve(x, nums)
    print(ans)

def solve(x, nums):
    n = len(nums)
    cnts = {}

    def dfs(acc, depth, max_depth, on_finish):
        if depth > max_depth:
            on_finish(acc)
            return
        dfs(acc, depth + 1, max_depth, on_finish)
        dfs(acc + nums[depth], depth + 1, max_depth, on_finish)

    def merge_counts(acc):
        if acc in cnts:
            cnts[acc] += 1
        else:
            cnts[acc] = 1

    dfs(0, 0, n // 2 - 1, merge_counts)
    cnts[0] = 1

    count = 0

    def update_count(acc):
        nonlocal count
        count += cnts.get(x - acc, 0)

    dfs(0, n // 2, n - 1, update_count)

    return count

if __name__ == "__main__":
    main()