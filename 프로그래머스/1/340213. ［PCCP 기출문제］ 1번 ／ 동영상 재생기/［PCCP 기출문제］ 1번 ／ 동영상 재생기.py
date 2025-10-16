def solution(video_len, pos, op_start, op_end, commands):
    answer = ''
    video_len = minute_to_second(video_len)
    pos = minute_to_second(pos)
    op_start = minute_to_second(op_start)
    op_end = minute_to_second(op_end)
    
    for command in commands:
        
        if command == 'prev':
            pos = max(pos - 10,0)
        else:            
            if op_start <= pos < op_end:
                pos = op_end
            pos = min(video_len,pos+10)
        if op_start <= pos < op_end:
            pos = op_end
            
    return f"{pos // 60:02d}:{pos % 60:02d}"


def minute_to_second(minute):
    minute,second = map(int,minute.split(":"))
    return minute * 60 + second