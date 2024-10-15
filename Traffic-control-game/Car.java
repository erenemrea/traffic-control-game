//Hüseyin Aksoy 150122010
//Eren Emre Aycibin 150122054
//Kerim Ak 150123515

import javafx.animation.PathTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;

public class Car extends Rectangle {
    public double key = 0;
    private PathTransition pathTransition;
    private boolean isStopped = false;
    private boolean shouldStop = false;
    private boolean isOnLight = false;
    private Path selectedPath;
    public Car(Path selectedPath,PathTransition pathTransition) {
        super(16, 8);
        this.pathTransition = pathTransition;
        this.selectedPath = selectedPath;
        setFill(Color.BLACK); 
    }

    public void move() {
        pathTransition.play(); 
        set_stopped(false);
    }

    public void stop() {
        pathTransition.pause(); 
        set_stopped(true);
    }
    public boolean get_stopped()
    {
        return isStopped;
    }
    public void set_stopped(boolean var)
    {
        isStopped = var;
    }
    public void set_shouldStop(boolean var)
    {
        shouldStop = var;
    }
    public boolean get_shouldStop()
    {
        return shouldStop;
    }
    public PathTransition get_transition()
    {
        return pathTransition;
    }
    public void set_key(double var)
    {
        key = var;
    }
    public double get_key()
    {
        return key;
    }
    public void set_isOnLight(boolean var)
    {
        isOnLight = var;
    }
    public boolean get_isOnLight()
    {
        return isOnLight;
    }
    public void set_path(Path var)
    {
        selectedPath = var;
    }
    public Path get_path()
    {
        return selectedPath;
    }
}