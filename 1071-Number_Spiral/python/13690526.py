def find(row, col):
    n = max(row, col)
    base = n**2 - n + 1
    diff = (-1)**(n & 1)*(row-col)
    return base + diff


def main():
    t = int(input())
    ans = []
    for _ in range(t):
        y, x = input().split()
        ans.append(find(int(y), int(x)))
    for num in ans:
        print(num)


main()