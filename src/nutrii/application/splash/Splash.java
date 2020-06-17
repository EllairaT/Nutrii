package nutrii.application.splash;

/**
 * Show splash image and loading bar when program starts up
 *
 * something to make the program look at least a little more professional :)
 * Splash image and all backgrounds are made by me.
 * @author Ellaira
 */
public class Splash {

    public Splash() {
        SplashFrame sf = new SplashFrame();
        sf.setVisible(true);

        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(20);
                sf.percentage.setText(i + "%");
                sf.progressBar.setValue(i);
            }
            sf.dispose();
        } catch (Exception e) {
            System.err.println("something went wrong");
        }
    }
}
