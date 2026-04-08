
from collections import Counter

# Read input
n, target_sum, *arr = map(int, open(0).read().split())

# Function to generate all possible subset sums for a given list of numbers
def generate_subset_sums(arr):
    subset_sums = [0]  # Start with the empty subset sum (which is 0)
    # For each element, add it to all existing subset sums to generate new sums
    for num in arr:
        subset_sums += [num + existing_sum for existing_sum in subset_sums]
    return subset_sums

# Split the array into two halves for the "meet in the middle" technique
half_size = n // 2

# Generate all subset sums for the first half of the array
left_subset_sums = generate_subset_sums(arr[:half_size])

# Count occurrences of each subset sum in the first half
left_sums_count = Counter(left_subset_sums)

# Generate all subset sums for the second half of the array
right_subset_sums = generate_subset_sums(arr[half_size:])

# Count the number of valid subset sum combinations that add up to the target sum
result = sum(left_sums_count[target_sum - right_sum] for right_sum in right_subset_sums)

# Output the result
print(result)
