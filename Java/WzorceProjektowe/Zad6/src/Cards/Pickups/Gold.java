package Cards.Pickups;

public class Gold extends Foundation
{
    public Gold ()
    {
        setName("Gold");
        DisplayValue.setBounds(164,242,250,50);
    }

    @Override
    public void UpdateValue(int Additive)
    {
        super.UpdateValue(Additive);
        if (Value>=10)
            DisplayValue.setBounds(154,242,250,50);
    }
}
