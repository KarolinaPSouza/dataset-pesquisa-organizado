from collections import Counter

# Duyệt đệ quy để sinh tổng các tập con
def generate_sums(arr, index, current_sum, sums):
    if index == len(arr):
        sums.append(current_sum)
        return
    # Không chọn phần tử
    generate_sums(arr, index + 1, current_sum, sums)
    # Chọn phần tử
    generate_sums(arr, index + 1, current_sum + arr[index], sums)

# Hàm chính
def count_subsets_with_sum_x(n, x, arr):
    half = n // 2
    left = arr[:half]
    right = arr[half:]

    left_sums = []
    right_sums = []

    generate_sums(left, 0, 0, left_sums)
    generate_sums(right, 0, 0, right_sums)

    right_counter = Counter(right_sums)

    count = 0
    for s in left_sums:
        remain = x - s
        count += right_counter[remain]

    return count

# Nhập dữ liệu
n, x = map(int, input().split())
arr = list(map(int, input().split()))

# Xuất kết quả
print(count_subsets_with_sum_x(n, x, arr))