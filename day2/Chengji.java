package zuoye2;

import java.util.Random;

public class Chengji {

	public static void main(String[] args) {
		
		
		//���Ƴ�Ա
		String[][] score=new String[21][6];
		score[0][0]=new String(" ");
		score[0][1]=new String("core C++");
		score[0][2]=new String("coreJava");
		score[0][3]=new String("servlet");
		score[0][4]=new String("JSP");
		score[0][5]=new String("EJB");
		
		
		
		
		//���ɷ���
		for (int i = 1; i < 21; i++) {
			score[i][0]=new String("student")+i;
		}
		for (int i = 1; i < 21; i++) {
			for (int j = 1; j < 6; j++) {
				Random a=new Random();
			score[i][j]	=String.valueOf(a.nextInt(100));
			}
			
		}
		
		
		//�����
		//i=Integer.valueOf(s).intValue(); 
		//Ϊ�˱���ģʽ   ���Բ�������
		
			System.out.print("      "+score[0][0]+"          ");
			System.out.print("      "+score[0][1]+"        ");
			System.out.print(score[0][2]+"       ");
			System.out.print(score[0][3]+"          ");
			System.out.print(score[0][4]+"              ");
			System.out.print(score[0][5]+"       ");
		System.out.println();
		
		for (int i = 1; i < 21; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(score[i][j]+"        "+"\t");
			}
			System.out.println();
		}
		
		
		
		
		for (int i = 1; i < 21; i++) {
			int sum=0;
			for (int j =1; j < 6; j++) {
				
				sum+=Integer.valueOf(score[i][j]);
			}
			System.out.println("student"+i+"���ܷ�"+sum +"  ƽ����"+(sum/5));
		}
		
			
			
		//������Ƶ�ƽ����
   for (int j = 1; j < 6; j++) {
	     int sum=0;
	    for (int i = 1; i <21; i++) {
		sum+=Integer.valueOf(score[i][j]);
	}
	System.out.println(score[0][j]+"��ƽ����"+(sum/20));
}
		
		
	}

}

