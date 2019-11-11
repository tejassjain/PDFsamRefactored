/* 
 * This file is part of the PDF Split And Merge source code
 * Created on 07/ott/2014
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

import static org.sejda.eventstudio.StaticStudio.eventStudio;

import javax.inject.Inject;

import org.pdfsam.module.ClearUsageController;
import org.sejda.eventstudio.annotation.EventListener;
import org.sejda.injector.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller for the {@link StageService}
 * 
 * @author Andrea Vacondio
 *
 */
@Auto
public class StageServiceController {
    private static final Logger LOG = LoggerFactory.getLogger(ClearUsageController.class);

    private StageService service;

    @Inject
    public StageServiceController(StageService service) {
        this.service = service;
        eventStudio().addAnnotatedListeners(this);
    }

    @EventListener
    public void requestStageStatus(SetLatestStageStatusRequest event) {
        LOG.debug("Setting latest statge status to: {}", event.getStatus());
        service.save(event.getStatus());
    }

}
