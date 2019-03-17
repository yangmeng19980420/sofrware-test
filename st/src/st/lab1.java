package st;

public class lab1 {
    static boolean triangle(int x){
  	boolean p = false;
  	int fifty = 1;
  	int twenty = 1;
  	int five = 2;
  	int one = 3;
  	int sum = 0;
  	for(int i = 0;i <= fifty; i++){
  		for(int j = 0;j <= twenty; j++){
  			for(int k = 0;k <= five; k++){
  				for(int l = 0;l <= one; l++){
  				    sum = i*50 + j*20 + k*5 + l*1;   			    
  				    if(x == sum){  				    	
  				    	p = true;	
  				    }
  				}
  			}
  		}  			
  	}
		return p;	
    }

}
