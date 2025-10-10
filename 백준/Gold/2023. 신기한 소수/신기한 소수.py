N = int(input())

def is_pirme(number):
    for i in range(2,int(number**1/2)+1):
        if number % i == 0:
            return False
    return True

def dfs(depth, number):
    if depth == N:
        print(number)
        return

    for i in range(1,10,2):
        next_num_str = number + str(i)
        next_num_int = int(next_num_str)

        if is_pirme(next_num_int):
            dfs(depth + 1, next_num_str)

for i in [2, 3, 5, 7]:
    dfs(1, str(i))