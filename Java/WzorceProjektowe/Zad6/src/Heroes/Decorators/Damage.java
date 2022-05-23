package Heroes.Decorators;

import Heroes.Base;
import Windows.Game;

public class Damage extends HeroDecorator
{
    Game myFrame;

    public Damage(Base Hero, Game game)
    {
        super(Hero);
        myFrame=game;
    }

    @Override
    public void Change(int value)
    {
        if (base.GetArmor()>0 && base.GetArmor()>=value)
        {
            base.ChangeArmor(base.GetArmor()-value);
        }
        else if (base.GetArmor()>0 && base.GetArmor()<value)
        {
            base.ChangeCurrentHealth(base.GetCurrentHealth()-(value-base.GetArmor()));
            base.ChangeArmor(0);
            if (base.GetCurrentHealth()<=0)
                myFrame.DeadState();
        }
        else
        {
            base.ChangeCurrentHealth(base.GetCurrentHealth()-value);
            if (base.GetCurrentHealth()<=0)
                myFrame.DeadState();
        }
    }
}
