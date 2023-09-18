public class Car { //exam07에서 씀 class Car {식으로 public을 없애면 한 파일에서 사용 가능
    String color;
    int speed = 0;
    int getSpeed() {
        return speed;
        }
    void upSpeed(int value) {
        if (speed + value >= 200)
        speed = 200;
        else
        speed = speed + value;
    }
    void downSpeed(int value) {
        if (speed - value <= 0)
        speed = 0;
        else
        speed = speed - value;
        }
    String getColor() {
        return color;
        
    }
    
}
