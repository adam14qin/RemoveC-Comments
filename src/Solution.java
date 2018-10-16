import java.util.ArrayList;
import java.util.List;

public class Solution {
	private List<String> removeComments(String[] source) {
        boolean inBlock=false;
        List<String> list1=new ArrayList<String>();
        List<String> list2=new ArrayList<String>();
        StringBuilder sb2=new StringBuilder();
        
        for (String line:source){
            int i=0;
            StringBuilder sb1=new StringBuilder();
            if (inBlock==false){sb2=new StringBuilder();} 
            
            while (i<line.length()){
                if (inBlock==false && i<line.length()-1 && line.charAt(i)=='/' && line.charAt(i+1)=='*'){
                    inBlock=true; 
                    sb1.append(line.charAt(i));sb1.append(line.charAt(i+1));
                    i+=1;
                }
                else if (inBlock==true && i<line.length()-1 && line.charAt(i)=='*' && line.charAt(i+1)=='/'){
                    inBlock=false;i+=1;
                }
                else if (inBlock==false && i<line.length()-1 && line.charAt(i)=='/' && line.charAt(i+1)=='/'){
                    break;
                }
                else if (inBlock==false){
                    sb2.append(line.charAt(i));
                    sb1.append(line.charAt(i));
                }
                else {
                    sb1.append(line.charAt(i));
                }
                i++;
            }
            
            if (inBlock==false && sb2.length()>0){
                list2.add(sb2.toString());
            }
           
            list1.add(sb1.toString());
            
        }
        return (inBlock==true)? list1:list2;
    }
	public static void main(String[] args) {
		String[] in={"a/*comment", "line", "more_comment*/b"};
		Solution sol=new Solution();
		List<String> res=sol.removeComments(in);
		for (String str:res){
			System.out.println(str);
		}
			
	}

}
