while True:
    try:
        first, second = input().split(" ")

        f_start = 0

        for c in second:
            if first[f_start] == c:
                f_start+=1
            if f_start == len(first):
                break

        if f_start == len(first):
            print('Yes')
        else:
            print('No')
    except:
        break


