package com.sist.main;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // ����� ��û => ����Ŭ�� �ִ� �����͸� �����ش� 
		ZipcodeDAO dao=new ZipcodeDAO(); // ����Ŭ �����ϴ� Ŭ����
		// ����ڷκ��� dong �Է°��� �޴´� 
		Scanner scan=new Scanner(System.in);
		System.out.print("�� �Է�:");
		String dong=scan.next();
		
		// ����� ��� 
		int count=dao.zipcodeFindCount(dong);
		List<Zipcode> list=dao.zipcodeListData(dong); // ã�� ��� 
		
		if(count==0)
		{
			System.out.println("�ڡڡڡڡ� �˻��� ����� �����ϴ�!! �ڡڡڡڡ�");
		}
		else
		{
			System.out.println("�˻����:"+count+"��");
			for(Zipcode z:list)
			{
				System.out.println(z.getZipcode()+" "
						+z.getAddress());
			}
		}
	}

}
