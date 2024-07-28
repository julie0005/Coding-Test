package programmers.dp;
class IntTriangle{
    public int solution(int[][] triangle) {
        int max=0;
        if(triangle.length==1) return triangle[0][0];
        for(int i=triangle.length-1; i>=0; i--){
            for(int j=0; j<triangle[i].length-1; j++){
                int s1=triangle[i][j]+triangle[i-1][j];
                int s2=triangle[i][j+1]+triangle[i-1][j];
                triangle[i-1][j]=Math.max(s1,s2);
            }
        }
        return triangle[0][0];
    }
    
}