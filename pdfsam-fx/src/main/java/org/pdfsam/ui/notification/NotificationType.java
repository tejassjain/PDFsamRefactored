/* 
 * This file is part of the PDF Split And Merge source code
 * Created on 10/apr/2014
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
package org.pdfsam.ui.notification;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.utils.FontAwesomeIconFactory;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.utils.MaterialDesignIconFactory;
import javafx.scene.Node;

/**
 * Type of notifications
 * 
 * @author Andrea Vacondio
 *
 */
public enum NotificationType {
    INFO {
        @Override
        public Node getGraphic() {
            return MaterialDesignIconFactory.get().createIcon(MaterialDesignIcon.INFORMATION, DEFAULT_ICON_SIZE);
        }

        @Override
        public String getStyleClass() {
            return "notification-info";
        }
    },
    WARN {
        @Override
        public Node getGraphic() {
            return MaterialDesignIconFactory.get().createIcon(MaterialDesignIcon.ALERT, DEFAULT_ICON_SIZE);
        }

        @Override
        public String getStyleClass() {
            return "notification-warn";
        }
    },
    ERROR {
        @Override
        public Node getGraphic() {
            return MaterialDesignIconFactory.get().createIcon(MaterialDesignIcon.CLOSE_CIRCLE, DEFAULT_ICON_SIZE);
        }

        @Override
        public String getStyleClass() {
            return "notification-error";
        }
    },
    GO_PRO {
        @Override
        public Node getGraphic() {
            return FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.HEART_ALT, DEFAULT_ICON_SIZE);
        }

        @Override
        public String getStyleClass() {
            return "notification-pro";
        }
    },
    SHARE {
        @Override
        public Node getGraphic() {
            return FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.SHARE_ALT, DEFAULT_ICON_SIZE);
        }

        @Override
        public String getStyleClass() {
            return "";
        }
    };

    private static final String DEFAULT_ICON_SIZE = "32.0";

    public abstract Node getGraphic();

    public abstract String getStyleClass();
}
