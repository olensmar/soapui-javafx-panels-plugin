package com.smartbear.soapui.plugins;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.WsdlProjectPro;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.ui.support.ModelItemDesktopPanel;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;

/**
 * Created by ole on 05/07/14.
 */
public class JavaFxDesktopPanel extends ModelItemDesktopPanel<WsdlProjectPro> {
    private JFXPanel fxPanel;
    private final JPanel panel;

    public JavaFxDesktopPanel(WsdlProjectPro modelItem) {
        super(modelItem);

        fxPanel = new JFXPanel();
        panel = UISupport.createEmptyPanel(10, 10, 10, 10);
        panel.add(fxPanel);
        panel.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
        });
    }

    @Override
    public JComponent getComponent() {
        return panel;
    }

    private static void initFX(JFXPanel fxPanel) {

        try {
            Parent root = FXMLLoader.load(JavaFxPanelBuilder.class.getResource("/fxml/test.fxml"));
            Scene scene = new Scene(root, 300, 275);
            fxPanel.setScene(scene);

        } catch (Throwable e) {
            SoapUI.logError(e);
        }
    }

    private static void initAndShowGUI() {
        // This method is invoked on Swing thread
        JFrame frame = new JFrame("FX");
        frame.setSize(600,400);
        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initAndShowGUI();
            }
        });
    }
}
