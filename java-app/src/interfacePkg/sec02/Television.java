package interfacePkg.sec02;

public class Television implements IRemoteControl{
    // member fields
    private int volume;
    private boolean mute;

    @Override
    public void turnOn() {
        System.out.println("Television을 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("Television을 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if(volume > IRemoteControl.MAX_VOLUME) {
            this.volume = IRemoteControl.MAX_VOLUME;
        } else if(volume < IRemoteControl.MIN_VOLUME) {
            this.volume = IRemoteControl.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("현재 볼륨: " + this.volume);
    }

    @Override
    public void setMute(boolean mute) {
        this.mute = mute;
        if (mute) {
            System.out.println("음소거 기능이 켜졌습니다.");
        } else {
            System.out.println("음소거 기능이 꺼졌습니다.");
        }
    }

    @Override
    public int getVolume() {
        return 0;
    }
}
