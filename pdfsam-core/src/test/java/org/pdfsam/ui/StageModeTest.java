/* 
 * This file is part of the PDF Split And Merge source code
 * Created on 08/ott/2014
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
package org.pdfsam.ui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.pdfsam.NoHeadless;
import org.pdfsam.test.InitializeAndApplyJavaFxThreadRule;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Andrea Vacondio
 *
 */
@Category(NoHeadless.class)
public class StageModeTest {
    @Rule
    public InitializeAndApplyJavaFxThreadRule javaFxThread = new InitializeAndApplyJavaFxThreadRule();

    @Test
    public void valueForMaximized() {
        Stage stage = new Stage();
        Scene scene = new Scene(new HBox());
        stage.setScene(scene);
        stage.setMaximized(true);
        assertEquals(StageMode.MAXIMIZED, StageMode.valueFor(stage));
    }

    @Test
    public void valueForDefault() {
        Stage stage = new Stage();
        Scene scene = new Scene(new HBox());
        stage.setScene(scene);
        stage.setMaximized(false);
        stage.setIconified(false);
        assertEquals(StageMode.DEFAULT, StageMode.valueFor(stage));
    }

    @Test
    public void restoreDefault() {
        Stage stage = new Stage();
        Scene scene = new Scene(new HBox());
        stage.setScene(scene);
        StageMode.DEFAULT.restore(stage);
        assertFalse(stage.isIconified());
        assertFalse(stage.isMaximized());
    }

    @Test
    public void restoreMaximized() {
        Stage stage = new Stage();
        Scene scene = new Scene(new HBox());
        stage.setScene(scene);
        StageMode.MAXIMIZED.restore(stage);
        assertFalse(stage.isIconified());
        assertTrue(stage.isMaximized());
    }
}
