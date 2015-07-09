package zuoye3;

public class Zhuhanshu {

	public static void main(String[] args) {
		Army a=new Army(3);
		a.addWeapon(new Tank());
		a.addWeapon(new Filghter());
		a.addWeapon(new WarShip());
        a.attackAll();
        a.moveAll();
	}

}
