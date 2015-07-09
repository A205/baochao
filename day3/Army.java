package zuoye3;

public class Army {
        Weapon [] w=null;
        private int size=0;
        public Army(int i){
        		w=new Weapon[i];
        }
        
        void addWeapon(Weapon wa) {
			if(size>=w.length){
				System.out.println("军队装备足够了");
				return;
			}else {
				w[size]=wa;
				size++;
			}
		}
        void attackAll()
        {
        	for (Weapon wea:w) {
				if(wea!=null){
					wea.attack();
				}
			}
        }
        
        void moveAll()
        {
        	for (Weapon wea : w) {
				if (wea!=null) {
					wea.move();
				}
			}
        }
        
}