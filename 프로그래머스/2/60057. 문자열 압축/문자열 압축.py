def solution(s):
    size = 1001

    # 자르는 문자열 단위 길이
    for i in range(1,len(s)//2+2):
        # 압축한 문자열 결과, 단위 개수, 현재 문자열 단위
        result, count, temp = '', 1, s[:i]
        
        for j in range(i, len(s)+i, i):
            if temp==s[j:j+i]:
                count += 1
            else:
                if count==1:
                    result += temp
                else:
                    result += str(count)+temp

                temp= s[j:j+i]
                count = 1
                
        size = min(size, len(result))
    
    return size