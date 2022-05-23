package Heroes.Decorators;

import Heroes.Base;

public class Buy extends HeroDecorator
{

    public Buy(Base hero)
    {
        super(hero);
    }

    @Override
    public void Change(int value)
    {
        base.ChangeGold(base.GetGold()-value);
    }
}
