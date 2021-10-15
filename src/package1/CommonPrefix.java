package package1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CommonPrefix 
{
	private String findCommonPrefix(String[] s) {
		String prefix = "";
		int min = s[0].length();
		for(int i=1;i<s.length;i++)
		{
			if(s[i].length()<min)
			{
				min = s[i].length();
			}
		}
		int k =0;
		String sub = String.valueOf(s[0].charAt(k));
		for(int i=0;i<min;i++)
		{
			if(match(s,sub))
			{
				k++;
				sub = sub + s[0].charAt(k);
				prefix = s[0].substring(0,k);
			}
			else	
				break;
		}
		return prefix;
	}
	
	private boolean match(String[] s,String sub)
	{
		boolean flag = false;
		for(String s1 : s)
		{
			if(s1.matches(sub+"(.*)"))
			{
				flag = true;
			}
			else
			{
				flag = false;
			}
		}
		return flag;
	}
	
	@Test
	public void testCase1()
	{
		String[] s = {"flower","flow","flight"};
		Assert.assertEquals(findCommonPrefix(s), "fl");
	}
	
	@Test
	public void testCase2()
	{
		String[] s = {"dog","racecar","car"};
		Assert.assertEquals(findCommonPrefix(s), "");
	}

}
