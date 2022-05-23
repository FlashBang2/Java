package Heroes;

public class Mage extends Base
{

    public Mage ()
    {
        currenthealth=10;
        maxhealth=currenthealth;
        armor=0;
        gold=10;
        setName("Mage");
        SetHealth(currenthealth,maxhealth);
        SetArmor(armor);
    }

}
