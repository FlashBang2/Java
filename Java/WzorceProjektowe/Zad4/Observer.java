public interface Observer
{
    void Transfer (Display[] displayArray);
    void ResumeClock();
    void StopClock();
    void Update(Display[] DisplayArray);
}
