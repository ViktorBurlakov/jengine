package com.cetus.jengine.orm.ext.liferay.testportlet.service.messaging;

import com.cetus.jengine.orm.ext.liferay.testportlet.service.ClpSerializer;
import com.cetus.jengine.orm.ext.liferay.testportlet.service.SAuthorLocalServiceUtil;
import com.cetus.jengine.orm.ext.liferay.testportlet.service.SAuthorServiceUtil;
import com.cetus.jengine.orm.ext.liferay.testportlet.service.SBookLocalServiceUtil;
import com.cetus.jengine.orm.ext.liferay.testportlet.service.SBookServiceUtil;
import com.cetus.jengine.orm.ext.liferay.testportlet.service.SLibraryLocalServiceUtil;
import com.cetus.jengine.orm.ext.liferay.testportlet.service.SLibraryServiceUtil;
import com.cetus.jengine.orm.ext.liferay.testportlet.service.SMemberLocalServiceUtil;
import com.cetus.jengine.orm.ext.liferay.testportlet.service.SMemberServiceUtil;
import com.cetus.jengine.orm.ext.liferay.testportlet.service.STransactionLocalServiceUtil;
import com.cetus.jengine.orm.ext.liferay.testportlet.service.STransactionServiceUtil;
import com.cetus.jengine.orm.ext.liferay.testportlet.service.TestLocalServiceUtil;
import com.cetus.jengine.orm.ext.liferay.testportlet.service.TestServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            SAuthorLocalServiceUtil.clearService();

            SAuthorServiceUtil.clearService();
            SBookLocalServiceUtil.clearService();

            SBookServiceUtil.clearService();
            SLibraryLocalServiceUtil.clearService();

            SLibraryServiceUtil.clearService();
            SMemberLocalServiceUtil.clearService();

            SMemberServiceUtil.clearService();
            STransactionLocalServiceUtil.clearService();

            STransactionServiceUtil.clearService();
            TestLocalServiceUtil.clearService();

            TestServiceUtil.clearService();
        }
    }
}
