import java.util.ArrayList;

public class Solution {

	public int p, n, d, q, coins;
	
	public Solution(int p, int n, int d, int q) {
		this.p = p;
		this.n = n;
		this.q = q;
		this.d = d;
		coins = p+n+d+q;
	}
	
	public String toString() {
		return p+" pennies, "+n+" nickels, "+d+" dimes, "+q + " quarters ---> coins: "+ coins;
	}
	
	public static void main(String[] args) {
		int value = 50;
		ArrayList<Solution> theSolutions = new ArrayList<Solution>();
		for(int p = 0; p<=value; p++) {
			for(int n = 0; n<=value/5; n++) {
				for(int d = 0; d<=value/10; d++) {
					for(int q = 0; q<=value/25; q++) {
						if( value == p+n*5+d*10+q*25) {
							theSolutions.add(new Solution(p,n,d,q));
						}
					}
				}
			}
		}
		for(Solution s: theSolutions) {
			System.out.println(s);
		}
		
	}
	
}
