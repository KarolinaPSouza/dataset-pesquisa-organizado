import sys
from bisect import bisect_right

# Tăng giới hạn đệ quy cho DSU phòng trường hợp chuỗi dài
sys.setrecursionlimit(200005)

def solve():
    # Đọc toàn bộ input một lần để xử lý nhanh (Fast I/O)
    input_data = sys.stdin.read().split()

    if not input_data:
        return

    iterator = iter(input_data)
    n = int(next(iterator))
    m = int(next(iterator))

    # Đọc danh sách vé
    tickets = []
    for _ in range(n):
        tickets.append(int(next(iterator)))

    # Đọc danh sách giá khách hàng trả
    customers = []
    for _ in range(m):
        customers.append(int(next(iterator)))

    # Sắp xếp vé để dùng bisect
    tickets.sort()

    # DSU setup
    # parent[i] lưu chỉ số của vé khả dụng nằm ngay tại i hoặc bên trái i
    # Ban đầu chưa vé nào bị bán, nên parent[i] = i
    parent = list(range(n + 1)) 

    def get_available_index(i):
        # Nếu i < 0 nghĩa là đã tìm hết về bên trái mà không có vé
        if i < 0:
            return -1
        # Nếu parent[i] == i nghĩa là vé tại i chưa bị bán
        if parent[i] == i:
            return i
        # Path compression: cập nhật trực tiếp cha để lần sau tìm nhanh hơn
        parent[i] = get_available_index(parent[i])
        return parent[i]

    results = []

    for max_price in customers:
        # Tìm vị trí vé lớn nhất có giá <= max_price
        # bisect_right trả về vị trí chèn để giữ nguyên thứ tự -> index - 1 là phần tử <= max_price
        idx = bisect_right(tickets, max_price) - 1

        # Tìm vé thực sự còn lại (chưa bị bán) tại vị trí idx hoặc bên trái nó
        available_idx = get_available_index(idx)

        if available_idx != -1:
            # Nếu tìm thấy vé, thêm giá vé vào kết quả
            results.append(str(tickets[available_idx]))

            # Đánh dấu vé này đã bán bằng cách trỏ nó sang vị trí bên trái (available_idx - 1)
            # Lần sau ai hỏi vị trí này, DSU sẽ tự động nhảy sang trái
            parent[available_idx] = available_idx - 1
        else:
            # Không tìm thấy vé nào phù hợp
            results.append("-1")

    # In kết quả
    sys.stdout.write("\n".join(results) + "\n")

if __name__ == "__main__":
    solve()