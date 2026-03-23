import sys
input = sys.stdin.readline

def main():
    n, m, k = map(int, input().split())
    customers = list(map(int, input().split()))
    laptops = list(map(int, input().split()))

    # Sắp xếp cả hai danh sách
    customers.sort()
    laptops.sort()

    count = 0
    i = 0
    j = 0

    # Two pointers
    while i < n and j < m:
        if abs(customers[i] - laptops[j]) <= k:
            # Tìm được cặp phù hợp - bán được máy
            count += 1
            i += 1
            j += 1
        elif customers[i] < laptops[j]:
            # Ổ cứng quá lớn, chuyển sang khách hàng tiếp theo
            i += 1
        else:
            # Ổ cứng quá nhỏ, chuyển sang máy tiếp theo
            j += 1

    print(count)

if __name__ == "__main__":
    main()