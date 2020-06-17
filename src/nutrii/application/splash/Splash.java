package nutrii.application.splash;

/**
 *
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
