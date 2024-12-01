board = input()

ans : str=""

index: int = 0
while index < len(board):
    count: int =0
    while index < len(board) and board[index] == "X" :
        count+=1
        index+=1
    if count % 2 != 0:
        print(-1)
        exit(0)

    ans += count//4  * "A" * 4 + count%4 *"B"
    while index < len(board) and board[index] == "." :
        index += 1
        ans +="."
print(ans)



