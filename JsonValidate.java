import java.io.*;
public class JsonValidate
{
	
	static int i=0;
	static char ch;
    static String s;
    static  int len;
	
	public static void main(String[] args)throws IOException
	{
	BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
	s=b.readLine();
	s=s.replaceAll("\\s","");
	System.out.println(s);
	 len=s.length();
	//System.out.println(len);
	
	if(s.charAt(i)!='{' || s.charAt(len-1)!='}')
	    System.out.println("Invalid");
	else if(s.equals("{{}}"))
		System.out.println("empty object");
	else if(s.equals("{[]}"))
	System.out.println("Empty Array");
	else
	parseJson();
	}
 
 
	static public void parseJson() {

		  
		  
		  ch = next();
		  
			  switch(ch) {
			    case '{':
			    	
			    	
			       object();
			       
			       break;
			       
			    case '[':
			       array();
			       break;
			       
			    case '"':
			       string();
			       
			       break;
			       
			    case 't':
			    case 'f':
			       boole();
			       break;
			     
			    case 'n':
			    	Jnull();
			    	break;
			       
			    
			    case '0': case '1': case '2': case'3': case '4': case '5': case '6': case '7': case '8': case '9':
			         number();
			         break;
			      
			      default:
			        System.out.println("Invalidate ");
			      break;
			  }
			}
	
	static public char next()
	{
		i++;
		ch=s.charAt(i);
		
		return ch;
	}
	
	
	
	static public void object()
	{
		
	
	
	
		
        parseJson();
           i++;
		  if(s.charAt(i)=='}')
		  {
			  System.out.println("Valid obj");
			  
		  }
		  else
			  System.out.println("Invali obj");
		
	
	}
	
	static public void string()
		 {
			 
			 
				 ch=next();
				 while(ch!='"'&& i!=(len-1))
				 {
					 ch=next();
				 }
				 ch=next();
				 if(ch==':'|| ch==',')
				 {
					 
					 
					 parseJson();
					 
				 }
				 else if(ch=='}' || ch==']')
					 System.out.println("valid str");
				 else
					 System.out.println("Invalid str");
				 
			 }
			  
			
			 	
					
	
	
			
		
	
	
	
	static public void array()
	{
	
		
		
				parseJson();
			
				
				if(s.charAt(i+1)=='}')
					System.out.println("valid arr");
				else
					System.out.println("Invalid arr");
	        }
		
	
	
	static public void number()
	{    
		ch=next();
		while( ch>='0'&& ch<='9'  )
		{
			ch=next();
		}
		if(ch=='}'||ch==']')
			System.out.println("valid number");
		else
		{
			if(ch==',')
				parseJson();
		}
	}
	
	static public void boole()
	{
		
		
		if(ch=='t' && s.substring(i,i+4).equals("true") )
			{
				i=i+4;
				if(s.charAt(i)=='}')
				System.out.println("valid bool");
			}
			
			else if(ch=='f' && s.substring(i,i+5).equals("false") )
			{
				i=i+5;
				if(s.charAt(i)=='}')
				System.out.println("valid bool");
			}	
			
		else
		System.out.println("Invalid bool");
			
	}
	
	static public void Jnull()
	{
		if(s.substring(i,i+4).equals("null"))
			i=i+4;
		if(s.charAt(i)=='}')
			System.out.println("valid json null");
		
			
	}
			


}

