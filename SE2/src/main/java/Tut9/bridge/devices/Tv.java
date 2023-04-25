package Tut9.bridge.devices;

public class Tv implements Device {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    //TODO: Implement getVolume() method
    @Override
    public int getVolume() {
        return volume;
    }

    //TODO: Implement setVolume() method
    @Override
    public void setVolume(int volume) {
        //use 'if-elseif-else' structure to limit the volume from 0 to 100
        //outside the range is invalid
        if (0 <= volume && volume <= 100) {
            this.volume = volume;
        }

    }

    //TODO: Implement getChannel() method
    @Override
    public int getChannel() {
        return channel;
    }

    //TODO: Implement setChannel() method
    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void printStatus() {
        //Show the current device is TV
        System.out.println("Current device: [ TV ]");
        //Show the current status: enabled or disabled
        if (on) {
            System.out.println("TV's status: enabled");
            //Show the current volume
            System.out.println("TV's volume: " + getVolume());
            //Show the current channel
            System.out.println("TV's channel: " + getChannel());
        } else {
            System.out.println("TV's status: disabled");
        }
    }
}
