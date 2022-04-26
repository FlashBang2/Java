package Barracks;
import Main.OverallFactory;
import Main.UnitInterface;
import javax.swing.*;
public class UnitCreation extends OverallFactory
{
    public UnitInterface CreateUnit(String Type, JLabel SpawnArea)
    {
        switch(Type)
        {
            case "Marine":
                return new Marine(SpawnArea);
            case "Firebat":
                return new Firebat(SpawnArea);
            case "Medic":
                return new Medic(SpawnArea);
            case "Ghost":
                return new Ghost(SpawnArea);
            default:
                return null;
        }
    }
}
