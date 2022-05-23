package Heroes.Decorators;

import Heroes.Base;

public class Gold extends HeroDecorator
{

    public Gold(Base Hero)
    {
        super(Hero);
    }

    @Override
    public void Change (int Value)
    {
        base.ChangeGold(base.GetGold()+Value);
    }
}
