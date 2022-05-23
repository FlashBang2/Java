package Heroes.Decorators;

import Heroes.Base;

public class LifePotion extends HeroDecorator
{

    public LifePotion(Base hero)
    {
        super(hero);
    }

    @Override
    public void Change(int value)
    {
        base.ChangeMaxHealth((int)(base.GetMaxHealth()*1.25));
    }
}
