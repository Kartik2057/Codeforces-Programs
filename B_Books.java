import java.util.Arrays;
import java.util.Scanner;
 
public class B_Books {
public static void main(String[]args){
	Scanner in=new Scanner(System.in);
	int n=in.nextInt(),t=in.nextInt(),s=0,l=0;
	int []a=new int[n+1];
	for(int i=1,j; i<=n; i++){
		j=in.nextInt();
		a[i]=a[i-1]+j;
		if(a[i]-a[s]>t)s++;
		l=Math.max(l,i-s);
	}
	System.out.println(l);
	
}
}