
public class jump {
	public static void main(String[] arg){
		int[] A = {1,1,-1,1};
		System.out.println(numOfJump(A));
	}
	public static int numOfJump(int[] A){
		int i = 0;
		int jump = 0;
		
		while(true){
			System.out.println("jump to: " + i);
			jump++;
			if (A[i] == 0)
				return -1;
			else if (A[i]+i >= A.length || A[i]+i < 0)
				return jump;
			else{
				int tmp = i;
				i = A[i]+i;
				A[tmp] = 0;
			}
			
		}
	}
}
