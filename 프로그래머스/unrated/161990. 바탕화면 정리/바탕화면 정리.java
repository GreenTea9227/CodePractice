class Solution {
    public int[] solution(String[] wallpaper) {
        int sx = Integer.MAX_VALUE;
        int sy = Integer.MAX_VALUE;
        int ex = 0;
        int ey = 0;
        for (int i=0;i<wallpaper.length;i++) {
            if (wallpaper[i].contains("#")) {
                sy = Math.min(sy,i);
                ey =Math.max(ey,i);
            }
            for (int j=0;j<wallpaper[i].length();j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    sx = Math.min(sx,j);
                    ex =Math.max(ex,j);
                }
            }
        }
        return new int[]{sy,sx,ey+1,ex+1};
    }
}