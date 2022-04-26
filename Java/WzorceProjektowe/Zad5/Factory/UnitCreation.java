package Factory;
import Main.OverallFactory;
import Main.UnitInterface;
import javax.swing.*;
public class UnitCreation extends OverallFactory
{
    public UnitInterface CreateUnit(String type, JLabel SpawnArea)
    {
        switch(type)
        {
            case "Vulture":
                return new Vulture(SpawnArea);
            case "SiegeTank":
                return new SiegeTank(SpawnArea);
            case "Goliath":
                return new Goliath(SpawnArea);
            default:
                return null;
        }
    }
}
