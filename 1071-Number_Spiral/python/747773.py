def solution(arr: list):
 for i in range(len(arr)):
  x = arr[i][0]
  y = arr[i][1]
  m = max(x, y)
  print((x - y) * (-1) ** m + m * m - m + 1)

def main():
 arr = []
 for i in range(int(input())):
  arr.append(list(map(int, input().split())))
 solution(arr)

if __name__ == "__main__":
 main()