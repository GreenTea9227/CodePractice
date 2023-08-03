class Solution {
    public long[] solution(long[] numbers) {
        long[] answers = new long[numbers.length];

        for (int i=0;i<numbers.length;i++) {
            long cur = numbers[i];
            String b1 = Long.toString(cur,2);

            if ( cur %2 ==0) {
                answers[i] = Long.parseLong(b1.substring(0,b1.length()-1) + "1",2);
                continue;
            }
            b1 = "0" + b1;
            int i1 = b1.lastIndexOf("0");
            answers[i] = Long.parseLong(b1.substring(0,i1) + "10" + b1.substring(i1 + 2),2);
        }

        return answers;
    }
}