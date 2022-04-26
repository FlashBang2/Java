package Starport;
import Main.UnitInterface;
import javax.swing.*;
public class UnitCreation
{
    public UnitInterface CreateUnit(String type, JLabel SpawnArea)
    {
        switch (type)
        {
            case "Wraith":
                return new Wraith(SpawnArea);
            case "Dropship":
                return new Dropship(SpawnArea);
            case "ScienceVessel":
                return new ScienceVessel(SpawnArea);
            case "Valkyrie":
                return new Valkyrie(SpawnArea);
            case "Battlecruiser":
                return new Battlecruiser(SpawnArea);
            default:
                return null;
        }
    }
}
