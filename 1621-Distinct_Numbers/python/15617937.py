import sys

def solve():
    # 1. Đọc toàn bộ dữ liệu vào một chuỗi khổng lồ (Cực nhanh)
    input_data = sys.stdin.read().split()

    if not input_data:
        return

    # input_data[0] là n (số lượng phần tử), ta có thể bỏ qua
    # Các phần tử còn lại là dãy số: input_data[1:]

    # 2. Dùng set() để lọc trùng. 
    # Python set được viết bằng C, rất tối ưu.
    s = set(input_data[1:])

    # 3. In kết quả
    print(len(s))

if __name__ == "__main__":
    solve()