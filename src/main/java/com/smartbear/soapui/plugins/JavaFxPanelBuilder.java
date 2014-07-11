package com.smartbear.soapui.plugins;

import com.eviware.soapui.impl.EmptyPanelBuilder;
import com.eviware.soapui.impl.wsdl.WsdlProjectPro;
import com.eviware.soapui.plugins.auto.PluginPanelBuilder;
import com.eviware.soapui.ui.desktop.DesktopPanel;

/**
 * Created by ole on 05/07/14.
 */

@PluginPanelBuilder(targetModelItem = WsdlProjectPro.class)
public class JavaFxPanelBuilder extends EmptyPanelBuilder<WsdlProjectPro> {

    @Override
    public boolean hasDesktopPanel() {
        return true;
    }

    @Override
    public DesktopPanel buildDesktopPanel(WsdlProjectPro modelItem) {
        return new JavaFxDesktopPanel(modelItem);
    }
}
