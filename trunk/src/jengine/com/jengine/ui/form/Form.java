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
import java.util.*;

public class Form extends Widget {
/*
    public static Map<String, Class> widgetMap = new HashMap<String, Class>();
    static {
        widgetMap.put("java.lang.Long", Widget.class);
        widgetMap.put("java.lang.String", Widget.class);
        widgetMap.put("java.util.Date", Widget.class);
    }
*/
    private LinkedHashMap<String, Map<String, Object>> modelFields = new LinkedHashMap<String, Map<String, Object>>();
    private LinkedHashMap<String, FormField> formFields = new LinkedHashMap<String, FormField>();

    public Form(String name, String title, PortletRequest request) {
        this(name, title, null, request);
    }

    public Form(String name, String title, Widget parent, PortletRequest request) {
        super(name, title, parent, request);
    }

    public void init(List<Map<String, Object>> fields, FormField[] formFields) {
        for (Map<String, Object> field : fields) {
            String name = (String) field.get("name");
            this.modelFields.put(name, field);
//            formFields.put(name, map(field));
        }
        for (FormField formField : formFields) {
             this.formFields.put(formField.getName(), formField);
        }
    }

    public Widget getWidget(String fieldName) {
        return formFields.get(fieldName).getWidget();
    }
    public List<FormField> getFieldList() {
        return new ArrayList<FormField>(formFields.values());
    }

    public LinkedHashMap<String, FormField> getFields() {
        return formFields;
    }

    /*
        protected FormField map(Map<String, Object> modelField) {
            Widget widget = widgetMap.get(modelField.get("name"));
            return new FormField(modelField.get("name"), widget);
        }
    */

}
