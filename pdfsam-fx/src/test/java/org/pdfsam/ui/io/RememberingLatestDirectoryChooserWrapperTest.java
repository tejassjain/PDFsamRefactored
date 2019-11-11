/* 
 * This file is part of the PDF Split And Merge source code
 * Created on 15/lug/2014
 * Copyright 2017 by Sober Lemur S.a.s. di Vacondio Andrea (info@pdfsam.org).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as 
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.pdfsam.ui.io;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.pdfsam.test.ClearEventStudioRule;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Andrea Vacondio
 *
 */
@Ignore
public class RememberingLatestDirectoryChooserWrapperTest extends ApplicationTest {
    @Rule
    public ClearEventStudioRule clearStudio = new ClearEventStudioRule();

    @Override
    public void start(Stage stage) {
        RememberingLatestDirectoryChooserWrapper victim = new RememberingLatestDirectoryChooserWrapper();
        victim.setTitle("Browse folders");
        Button button = new Button("Click me");
        button.getStyleClass().add("aButton");
        button.setOnAction(e -> victim.showDialog(button.getScene().getWindow()));
        Scene scene = new Scene(new HBox(button));
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void hasTitle() {
        clickOn(".aButton");
        assertTrue(window("Browse folders") != null);
    }

}
