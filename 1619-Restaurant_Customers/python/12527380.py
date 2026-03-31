import sys

def main():
    n = int(sys.stdin.readline())
    arrivals = []
    departures = []
    for _ in range(n):
        a, b = map(int, sys.stdin.readline().split())
        arrivals.append(a)
        departures.append(b)

    arrivals.sort()
    departures.sort()

    max_customers = 0
    current_customers = 0
    i = j = 0
    while i < n and j < n:
        if arrivals[i] < departures[j]:
            current_customers += 1
            i += 1
            if current_customers > max_customers:
                max_customers = current_customers
        else:
            current_customers -= 1
            j += 1

    print(max_customers)

if __name__ == "__main__":
    main()