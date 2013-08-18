/*
 *  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);

convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
import java.util.ArrayList;
import java.util.Iterator;

public class zigzag{
	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING",3));
	}

	public static String convert(String s, int nRows) {

		char[] c = s.toCharArray();
		int loop = nRows * 2 - 2;
		StringBuffer buf = new StringBuffer();
		//if nRows == 1, exception occur!!
		if (nRows == 1)
			return s;
		for (int i = 0; i < nRows; i++){
			if (i == 0 || i == nRows-1){
				for (int j = i;j < c.length;j = j+loop){
					buf.append(c[j]);    
				}

			}else{
				for(int j = i; j < c.length; j = j + loop){
					buf.append(c[j]);
					//test if this is out of bound!!
					if (j + loop -2 *i < c.length)
						buf.append(c[j + loop -2 *i]);
				}
			}
		}

		return buf.toString();
	}
}
/**
    public static String convert(String s, int nRows) {

        char[] c = s.toCharArray();
        int loop = nRows * 2 - 2;
        ArrayList<Character> l = new ArrayList<Character>();
        for (int i = 0; i < nRows; i++){
            if (i == 0 || i == nRows-1){
                for (int j = i;j < c.length;j = j+loop){
                    l.add(c[j]);    
                }

            }else{
                for(int j = i; j < c.length; j = j + loop){
                    l.add(c[j]);
                  //test if this is out of bound!!
                    if (j + loop -2 *i < c.length)
                    	l.add(c[j + loop -2 *i]);
                }
            }
        }
        StringBuffer buf = new StringBuffer();
        for (Iterator<Character> itr = l.iterator(); itr.hasNext();){
            buf.append(itr.next());
        }
        return buf.toString();
    }**/
