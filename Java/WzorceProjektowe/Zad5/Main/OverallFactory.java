package Main;
import javax.swing.*;
public abstract class OverallFactory
{
    public abstract UnitInterface CreateUnit(String type, JLabel SpawnArea);
}
