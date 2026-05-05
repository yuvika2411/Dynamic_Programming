import java.util.*;

public class NaivePatternMatching {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String s= sc.nextLine();
        String pattern= sc.nextLine();

        int n=s.length();
        int m=pattern.length();

        boolean found=false;

        for(int i=0;i<=n-m;i++){
            int j;
            for(j=0;j<m;j++){
                if(s.charAt(i+j)!=pattern.charAt(j)){
                    break;
                }
            }

            if(j==m){
                System.out.print(i+" ");
                found=true;
            }
        }

        if(!found){
            System.out.println("No Match");
        }
    }
}
