
public class PlusOne {
	public int[] plusOne(int[] digits) {   
		
		for (int i = digits.length-1; i >= 0; i--){
			//if digit is 9
			if (digits[i] == 9){
				digits[i] = 0;

			}
			else{
				digits[i] = digits[i]+1;
				return digits;
			}

		}
		//if all 9s
		int[] result = new int[digits.length+1];
		result[0] = 1;
		for (int i = 1; i < result.length; i++){
			result[i] = 0;
		}
		return result;

	}
}
