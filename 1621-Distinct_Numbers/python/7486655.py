def main():
    # Read the value of n
    n = int(input())

    # Read n numbers
    numbers = list(map(int, input().split()))

    # a prime number
    p = 52711

    hashmap = dict()

    for n in numbers:
        x = n%p 
        if x not in hashmap:
            hashmap[n%p] = [n]
        else:
            hashmap[n%p].append(n)

    # for i in hashmap:
    #     hashmap[i] = sorted(hashmap[i])

    N = 0
    for i in hashmap:
        last = -1
        N += len(set(hashmap[i]))
        # for j in range(len(hashmap[i])):
        #     if hashmap[i][j] == last:
        #         continue
        #     N += 1
        #     last = hashmap[i][j]


    # Print n
    print(N)

if __name__ == "__main__":
    main()