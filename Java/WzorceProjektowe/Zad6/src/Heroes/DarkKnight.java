package Heroes;

public class DarkKnight extends Base
{

    public DarkKnight ()
    {
        currenthealth=10;
        maxhealth=currenthealth;
        armor=10;
        gold=0;
        setName("DarkKnight");
        SetHealth(currenthealth,maxhealth);
        SetArmor(armor);
    }

}
