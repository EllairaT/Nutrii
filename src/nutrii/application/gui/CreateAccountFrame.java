package nutrii.application.gui;

/**
 *
 * @author Ellaira
 */
public class CreateAccountFrame extends javax.swing.JFrame {

    /**
     * Creates new form CreateAccountFrame
     */
    private CreateAccountPnl createAccountPnl;
    public CreateAccountFrame() {
        initComponents();
        createAccountPnl = new CreateAccountPnl();
        this.add(createAccountPnl);
        createAccountPnl.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nutrii Account Creation");
        setPreferredSize(new java.awt.Dimension(800, 900));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
