package interfacePkg.sec02;

public class Audio implements IRemoteControl {

    // member fields
    private int volume;
    private boolean mute;

    @Override
    public void turnOn() {
        System.out.println("Audio를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("Audio를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if (volume > IRemoteControl.MAX_VOLUME) {
            this.volume = IRemoteControl.MAX_VOLUME;
        } else if (volume < IRemoteControl.MIN_VOLUME) {
            this.volume = IRemoteControl.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
    }

    @Override
    public int getVolume() {
        return 0;
    }
}
