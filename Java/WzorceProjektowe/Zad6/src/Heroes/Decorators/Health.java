package Heroes.Decorators;

import Heroes.Base;

public class Health extends HeroDecorator
{

    public Health(Base Hero)
    {
        super(Hero);
    }

    @Override
    public void Change(int Value)
    {
        if (base.GetMaxHealth()!=base.GetCurrentHealth())
        {
            if ((Value+base.GetCurrentHealth())>base.GetMaxHealth())
            {
                base.ChangeCurrentHealth(base.GetMaxHealth());
            }
            else
            {
                base.ChangeCurrentHealth(base.GetCurrentHealth()+Value);
            }
        }
    }
}
