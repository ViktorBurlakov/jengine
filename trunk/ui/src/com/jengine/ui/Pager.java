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


import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;


public class Pager extends Widget {
    private int currentPage = 1;
    private int delta = 20;
    private int total;

    public Pager(String name, String title, PortletRequest request) {
        this(name, title, null, request);
    }

    public Pager(String name, String title, Widget parent, PortletRequest request) {
        super(name, title, parent, request);
        this.currentPage = ParamUtil.getInteger(request, "cur", this.currentPage);
        this.delta = ParamUtil.getInteger(request, "delta", this.delta);
    }

    public int getStart() {
        return (currentPage - 1) * delta;
    }
    public int getEnd() {
        /*int end = getStart() + delta;
 return end > total ? total : end;*/
        return getStart() + delta;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Map getPageMap() {
        return map("start", getStart(), "end", getEnd());
    }
}
