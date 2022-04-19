import javax.swing.*;
public class Display extends JLabel implements  SubjectOfObserver
{
    final int StartingHours=23,StartingFirstDigitMinutes=5,StartingSecondDigitMinutes=8,LastMinuteSecondDigit=9,LastMinuteFirstDigit=5,LastDigitHours=23;
    int CurrentHours=StartingHours,CurrentFirstDigitMinutes=StartingFirstDigitMinutes,CurrentSecondDigitMinutes=StartingSecondDigitMinutes;
    Display ()
    {
        this.setText(StartingHours+":"+StartingFirstDigitMinutes+StartingSecondDigitMinutes);
    }
    public void Change()
    {
        if (CurrentHours==LastDigitHours && CurrentFirstDigitMinutes==LastMinuteFirstDigit && CurrentSecondDigitMinutes==LastMinuteSecondDigit)
            {
                CurrentHours=0;
                CurrentFirstDigitMinutes=0;
                CurrentSecondDigitMinutes=0;
            }
        else if (CurrentFirstDigitMinutes==LastMinuteFirstDigit && CurrentSecondDigitMinutes==LastMinuteSecondDigit)
            {
                CurrentFirstDigitMinutes=0;
                CurrentSecondDigitMinutes=0;
                CurrentHours++;
            }
        else if (CurrentSecondDigitMinutes==LastMinuteSecondDigit)
            {
                CurrentSecondDigitMinutes=0;
                CurrentFirstDigitMinutes++;
            }
        else
            CurrentSecondDigitMinutes++;
        this.setText(CurrentHours+":"+CurrentFirstDigitMinutes+CurrentSecondDigitMinutes);
    }
}
