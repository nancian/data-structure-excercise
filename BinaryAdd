import java.util.ArrayList;


public class BinaryAdd {
	public String addBinary(String a, String b) {
		int i = a.length()-1;
		int j = b.length()-1;
		ArrayList<Character> result = new ArrayList<Character>();
		int carry = 0;
		while (i >= 0 && j >= 0){
			if (carry == 1){
				if (a.charAt(i) == '1'){
					if (b.charAt(j) == '1'){
						result.add('1');
					}
					else {
						result.add('0');
					}

				}
				else{
					if (b.charAt(j) == '1'){
						result.add('0');
						
					}
					else {
						result.add('1');
						carry = 0;
					}
				}
			}
			else{
				if (a.charAt(i) == '1'){
					if (b.charAt(j) == '1'){
						result.add('0');
						carry = 1;
					}
					else {
						result.add('1');
					}

				}
				else{
					if (b.charAt(j) == '1'){
						result.add('1');
					}
					else {
						result.add('0');
					}
				}
			}
			i--;
			j--;
		}
		while (i >= 0){
			if (carry == 1){
				if (a.charAt(i) == '1'){
					result.add('0');
				}
				else{
					result.add('1');
					carry = 0;
				}
			}
			//carry == 0
			else{
				result.add(a.charAt(i));
			}
			i--;

		}
		while (j >= 0){
			if (carry == 1){
				if (b.charAt(j) == '1'){
					result.add('0');
				}
				else{
					result.add('1');
					carry = 0;
				}
			}
			//carry == 0
			else{
				result.add(b.charAt(j));
			}
			j--;

		}
		if (carry == 1)
			result.add('1');
		StringBuffer s = new StringBuffer();
		//i is used before!!
		//reverse order
		for (int x = result.size()-1; x >= 0; x--){
			s.append(result.get(x));
		}
		return s.toString();

	}
}
