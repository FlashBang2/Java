package Heroes.Decorators;

import Heroes.Base;

public class Armor extends HeroDecorator
{

    public Armor(Base Hero)
    {
        super(Hero);
    }

    @Override
    public void Change(int Value)
    {
        base.ChangeArmor(base.GetArmor()+Value);
    }

}
