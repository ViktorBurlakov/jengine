/*
 *  This file is part of JEngine.
 *  *
 *  * Copyright (C) 2013-2014 Cetus (http://cs1.com.ua/). All rights reserved.
 *  *
 *  * JEngine is free software: you can redistribute it and/or modify
 *  * it under the terms of the GNU General Public License as published by
 *  * the Free Software Foundation, either version 3 of the License, or
 *  * (at your option) any later version.
 *  *
 *  * JEngine is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 *  *
 *  * You should have received a copy of the GNU General Public License
 *  * along with JEngine.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jengine.orm.model.query.filter;


import antlr.RecognitionException;
import antlr.TokenStreamException;
import com.jengine.orm.db.filter.SQLStringFilter;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.multi.field.MultiModelField;
import com.jengine.orm.model.query.BaseQuery;
import com.jengine.orm.model.query.ModelQuery;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.cetus.jengine.utils.commons.CollectionUtil.toList;


public class StringFilter {
    private SQLStringFilter stringFilter;
    private List<MultiModelField> multiModelFields = new ArrayList<MultiModelField>();
    private String source;
    private List params = new ArrayList();


    public StringFilter(String source, Object ... params) throws TokenStreamException, RecognitionException, UnsupportedEncodingException {
        this(source, toList(params));
    }

    public StringFilter(String source, List params) throws TokenStreamException, RecognitionException, UnsupportedEncodingException {
        this.source = source;
        this.params.addAll(toList(params));
    }

    public void config(BaseQuery query) throws TokenStreamException, RecognitionException, UnsupportedEncodingException {
        List sqlParams = new ArrayList();
        for (Object param : this.params) {
            sqlParams.add(param instanceof ModelQuery ? ((ModelQuery) param).toSQL() : param);
        }
        stringFilter = new SQLStringFilter(this.source, sqlParams);
        List<String> columns = stringFilter.findColumns();
        for (int index = 0; index < columns.size(); index++) {
            MultiModelField multiModelField = query.getMultiModel().getField(columns.get(index));
            multiModelFields.add(multiModelField);
            stringFilter.setColumnSQLName(index, multiModelField.getSQLName());
        }
    }

    public void setSQL(SQLQuery query) {
        query.addStringFilter(stringFilter);
    }

}
