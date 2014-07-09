
public class Test{
	public static String output=" ";
	
	public static void foo(int i){
		try{
			if(i==1){
				throw new Exception();
			}
			output+="1";
		}catch(Exception e){
			output+="2";
			return;//有return的话catch异常后最后的那个语句output+="4";不会执行
		}finally{//finally块不管是否catch异常都会执行
			output+="3";
		}
		output+="4";
	}
	
	public static void main(String[] args){
	//	foo(0);
		foo(1);
		System.out.println(Test.output);
	}
}