def solution(common):
    if (len(common) == 2):
        return common[1] + common[1] -common[0]
    if (abs(common[1]-common[0]) == abs(common[2]-common[1])):
        return common[-1] + common[1] - common[0]
    return common[-1] * common[1] / common[0]