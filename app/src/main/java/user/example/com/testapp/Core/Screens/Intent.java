package user.example.com.testapp.Core.Screens;

import user.example.com.testapp.Core.Game;

/**
 * Created by User on 12/24/2016.
 */
public abstract class Intent {
    private Screen screenFrom;
    private Screen screenTo;
    protected Game game;
    private float currentValue;
    private float velocity;
    private boolean isStep;
    private boolean isIntent;

    public Intent(Game game) {
        this.game = game;
        setVelocity(0);
        setCurrentValue(0);
    }
    public abstract void render();
    public abstract void step();

    public Intent create(Screen screenFrom, Screen screenTo, float startValue, float velocity) {
        setScreenFrom(screenFrom);
        setScreenTo(screenTo);
        setCurrentValue(startValue);
        setVelocity(velocity);

        return this;
    }

    public void start(boolean isIntent) {
        setStep(true);
        setEnableIntent(isIntent);
    }

    public Screen getScreenFrom() {
        return screenFrom;
    }

    public Screen getScreenTo() {
        return screenTo;
    }

    public void setScreenFrom(Screen screenFrom) {
        this.screenFrom = screenFrom;
    }

    public void setScreenTo(Screen screenTo) {
        this.screenTo = screenTo;
    }

    public boolean isIntent() {
        return isIntent;
    }

    public void setEnableIntent(boolean intent) {
        isIntent = intent;
    }

    public boolean isStep() {
        return isStep;
    }

    public void setStep(boolean step) {
        isStep = step;
    }

    public float getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(float currentValue) {
        this.currentValue = currentValue;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }
}
