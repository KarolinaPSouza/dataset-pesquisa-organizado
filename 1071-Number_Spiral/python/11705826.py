def main(queries):
  for (r,c) in queries:
    mn,mx = min(r,c), max(r,c)
    prev_sum = (mx - 1) * (mx - 1)
    row_sum = mn
    if (mx % 2 == 0): row_sum = mx * 2 - row_sum
    if (c > r): row_sum = mx * 2 - row_sum
    print(prev_sum + row_sum)

if __name__ == '__main__':
  k = int(input())
  main([[int(x) for x in input().split()] for _ in range(k)])