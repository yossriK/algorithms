

public class Fibonacii {
	
	public static int [][] fm=new int [2][2];
	public static int [][] base= {{1,1},{1,0}};
	public static int n =20;  // the nth term in the Fibonacci serie 
	
	public static int algorithm1( int n) {
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else
			return algorithm1(n-1)+algorithm1(n-2);
	}
	
	public static long algorithm2(int n) {
		long num=0, num1=1, fibo=0;
		for(int i=0;i<n;i++) {
			fibo=num+num1;
			num=num1;
			num1=fibo;	
		}
		return num;
	}
	
	public static int algorithm3(int n) {
		if(n==0)
			return 0;
		fm[0][0]=1;
		fm[0][1]=1;
		fm[1][0]=1;
		fm[1][1]=0;
		
		matrixPower(n-1);
		
		return fm[0][0];		
	}
	
	public static void matrixPower( int n) {
		if(n>1) {
			matrixPower(n/2);
			matMul(fm,fm);
			
			if(n%2==1) {
				matMul(fm,base);
			}
		}
	}
	
	private static void matMul(int[][] mat1, int [][] mat2) {
       int a  = mat1[0][0] * mat2[0][0] +  mat1[0][1] * mat2[1][0];
       int b  = mat1[0][0] * mat2[0][1] +  mat1[0][1] * mat2[1][1];
       int c  = mat1[1][0] * mat2[0][0] +  mat1[1][1] * mat2[1][0];
       int d  = mat1[1][0] * mat2[0][1] +  mat1[1][1] * mat2[1][1];
       
       fm[0][0]=a;
       fm[0][1]=b;
       fm[1][0]=c;
       fm[1][1]=d;
      
      
    }

	
	public  static void main(String [] args) {
		long F1=0,F2=0,F3=0;
		for(int i=0;i<n;i++) {
			long beg=System.currentTimeMillis();
			for(int j=0;j<10000;j++) { // call the algorithm 1000 times to be able to calculate the time of the run of the processor
				F1=algorithm1(i);
			}
			long end=System.currentTimeMillis();
			long total=(end-beg);
			System.out.printf("%d *10^-2 ms is time taken to compute F=%d  using alg1 \n",total,F1);

			}
		System.out.printf("------------------------------ \n");
	for(int i=0;i<n;i++) {
			long beg=System.currentTimeMillis();
			for(int j=0;j<1000000;j++) { // call the algorithm 1000000 times to be able to calculate the time of the run of the processor
				F2=algorithm3(i);
			}
			long end=System.currentTimeMillis();
			long total=(end-beg);
			
			
			System.out.printf("%d * 10^-6 ms is time taken to compute F=%d   using alg2 \n",total,F2);

			}
	
	
	System.out.printf("------------------------------\n");
		
		for(int i=0;i<n;i++) {
			long beg=System.currentTimeMillis();
			for(int j=0;j<1000000;j++) { // call the algorithm 1000000 times to be able to calculate the time of the run of the processor
				F3=algorithm3(i);
			}
			long end=System.currentTimeMillis();
			long total=(end-beg);
			System.out.printf("%d * 10^-6 ms is time taken to compute F=%d  using alg3 \n",total,F3);

			}
		
		
	}
	
}
