
public class Sqrt {
	public int sqrt(int x) {
		//precise to digit
		long result = 0;
		int low = 0;
		int high = x;
		while(true){
			result = low+(high-low)/2;
			//possible overflow
			if (result*result > Integer.MAX_VALUE  || (int)result*result > x){
				high = (int)result-1;
			}
			else if((result+1)*(result+1) <= x){
				low = (int)result+1;
			}
			else
				return (int)result;

		}

	}
}
