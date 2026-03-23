import sys


def number_spiral():
    row, col = list(map(int, input().split()))
    layer = max(row, col)
    if layer % 2 == 1:
        row, col = col, row
    if layer == col:
        val = (layer - 1) ** 2 + 1 + row - 1
    else:
        val = layer ** 2 - col + 1
    print(val)

def main():
    t = int(input())
    for _ in range(t):
        number_spiral()

if __name__ == "__main__":
    main()
# 3
# 2 3
# 1 1
# 4 2