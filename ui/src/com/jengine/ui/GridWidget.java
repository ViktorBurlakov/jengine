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

package com.jengine.ui;


import javax.portlet.PortletRequest;
import java.util.*;

public class GridWidget extends Widget{
    private LinkedHashMap<String, Map<String, Object>> fields = new LinkedHashMap<String, Map<String, Object>>();
    private List<String> visibleFields = new ArrayList<String>();
    private List<Object> values = new ArrayList<Object>();

    public GridWidget(String name, String title, PortletRequest request) {
        this(name, title, null, request);
    }

    public GridWidget(String name, String title, Widget parent, PortletRequest request) {
        super(name, title, parent, request);

    }

    public void init(List<Map<String, Object>> fields) {
        for (Map<String, Object> field : fields) {
            this.fields.put((String) field.get("name"), field);
            boolean visible = (Boolean)field.get("visible");
            if (visible) {
                visibleFields.add((String) field.get("name"));
            }
        }
    }

    public void load(List<Object> values) {
        this.values = values;
    }

    public List<Object> getValues() {
        return values;
    }
}
