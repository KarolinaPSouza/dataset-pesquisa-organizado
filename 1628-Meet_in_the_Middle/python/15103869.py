def generate_subset_sums(arr):
    sums = [0]
    for num in arr:
        sums += [num + s for s in sums]
    return sums

def count_subsets_with_sum(n, x, t):
    half = n // 2
    left, right = t[:half], t[half:]

    left_sums = generate_subset_sums(left)
    right_sums = generate_subset_sums(right)

    # Use a dict for fast counting: sum -> number of ways to get this sum
    count_right = {}
    for s in right_sums:
        count_right[s] = count_right.get(s, 0) + 1

    count = 0
    for s in left_sums:
        count += count_right.get(x - s, 0)
    return count

# Example usage:
n, x = map(int, input().split())
t = list(map(int, input().split()))
print(count_subsets_with_sum(n, x, t))