def main():
    solve()


def solve():
    # Read n and x from the first line
    n, x = map(int, input().split())
    # Read the array from the second line
    arr = list(map(int, input().split()))

    # Split the array into two halves
    left_part = arr[:n // 2]
    right_part = arr[n // 2:]

    # Generate all possible subset sums for a given list of numbers
    def generate_sums(nums):
        sums = []

        def dfs(idx, current_sum):
            if idx == len(nums):
                sums.append(current_sum)
                return
            # Do not include the current number
            dfs(idx + 1, current_sum)
            # Include the current number
            dfs(idx + 1, current_sum + nums[idx])

        dfs(0, 0)
        return sums

    left_sums = generate_sums(left_part)
    right_sums = generate_sums(right_part)

    # Count frequencies of sums in left_sums using a basic dictionary
    left_count = {}
    for s in left_sums:
        left_count[s] = left_count.get(s, 0) + 1

    # For each sum in right_sums, look for the complementary sum in left_count
    ways = 0
    for s in right_sums:
        need = x - s
        ways += left_count.get(need, 0)

    print(ways)

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/