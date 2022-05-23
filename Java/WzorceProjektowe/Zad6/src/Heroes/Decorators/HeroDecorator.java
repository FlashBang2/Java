package Heroes.Decorators;

import Heroes.Base;
import Heroes.Interfaces.Hero;
import javax.swing.*;

public abstract class HeroDecorator extends JPanel implements Hero
{
    protected Base base;

    public HeroDecorator(Base hero)
    {
        base=hero;
    }

}
