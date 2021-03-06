/*
 * This file is part of JEngine.
 *
 * Copyright (C) 2013 Victor Burlakov
 *
 * JEngine is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JEngine is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JEngine.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jengine.ui.form;


import com.jengine.ui.Widget;

import javax.portlet.PortletRequest;

public class Range extends Widget {
    private Widget from;
    private Widget to;

    public Range(String name, String title, PortletRequest request, Widget from, Widget to) {
        this(name, title, null, request, from, to);
    }

    public Range(String name, String title, Widget parent, PortletRequest request, Widget from, Widget to) {
        super(name, title, parent, request);
        this.from = from;
        this.to = to;
    }
}
