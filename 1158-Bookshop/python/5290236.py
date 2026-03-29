from sys import stdin
input = stdin.buffer.readline

def main():
    n, x = map(int,input().split())
    price = list(map(int,input().split()))
    pages = list(map(int,input().split()))
    prev = [0] * (x + 1)
    cur = [0] * (x + 1)
    for i in range(n + 1):
        prix = price[i - 1]
        gain = pages[i - 1]
        for j in range(x + 1):
            cur[j] = prev[j]
            left = j - prix
            if left >= 0:
                cur[j] = max(cur[j], prev[left] + gain)
        prev, cur = cur, prev
    print(cur[x])
main()