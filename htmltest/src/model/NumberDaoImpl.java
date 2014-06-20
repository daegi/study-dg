package model;
// dao : Data Access Object
public class NumberDaoImpl implements NumberDao {
	public int getSum(int n){
		int sum=0;
		for(int i=1; i<=n; i++){
			sum += i;
		}
		return sum;
	}
}
