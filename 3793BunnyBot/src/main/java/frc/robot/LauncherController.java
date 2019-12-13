package frc.robot;

import edu.wpi.first.wpilibj.*;

public class LauncherController {
    private Servo launchServo;
    private boolean hasFired = false;
    private long fireStartTime = 0;
    private boolean setOnce = false;
    private int firedAngle = 0;
    private int loadedAngle = 90;

    LauncherController(Servo launchServo) {
        this.launchServo = launchServo;
    }

    public void load(){
        launchServo.setAngle(loadedAngle);
        hasFired = false;
    }

    public void fire() {
        launchServo.setAngle(firedAngle);
        hasFired = true;
    }

    public boolean hasFired() {
        return hasFired;
    }

}