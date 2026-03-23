def main():
    n, m, k = map(int, input().split())
    clients = list(map(int, input().split()))
    apartments = list(map(int, input().split()))

    clients.sort()
    apartments.sort()

    index = 0
    answer = 0

    for i in range(n):
        while index < m:
            if apartments[index] + k < clients[i]:
                index += 1
            elif apartments[index] - k > clients[i]:
                break
            else:
                index += 1
                answer += 1
                break

    print(answer)

if __name__ == "__main__":
    main()