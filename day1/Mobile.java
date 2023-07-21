package week1.day1;

public class Mobile {

	public void makeCall()
	{
		String mobileModel="Redmi note 10 pro";
		float mobileWeight=140f;
		System.out.println("My mobile model is: "+mobileModel);
		System.out.println("My mobile weight is: "+mobileWeight+" grams");
	}
	public void sendMsg()
	{
		boolean fullCharged=true;
		int mobileCost=16500;
				
		System.out.println("My mobile is fully charged: "+fullCharged);
		System.out.println("My mobile cost: "+mobileCost);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Mobile n=new Mobile();
n.makeCall();
n.sendMsg();
System.out.println("This is my mobile");
	}

}
