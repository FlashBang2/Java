package Heroes;

public class Warrior extends Base
{

    public Warrior ()
    {
       currenthealth=20;
       maxhealth=currenthealth;
       armor=0;
       gold=0;
       setName("Warrior");
       SetHealth(currenthealth,maxhealth);
       SetArmor(armor);
    }

}
