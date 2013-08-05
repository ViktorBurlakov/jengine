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

package com.jenginetest.builder.service.impl;

import com.jenginetest.builder.service.base.TestLocalServiceBaseImpl;
import com.jenginetest.custom.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;

/**
 * The implementation of the test local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.jenginetest.builder.service.TestLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.jenginetest.builder.service.base.TestLocalServiceBaseImpl
 * @see com.jenginetest.builder.service.TestLocalServiceUtil
 */
public class TestLocalServiceImpl extends TestLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.jenginetest.builder.service.TestLocalServiceUtil} to access the test local service.
	 */
    public void clearData() throws SystemException {
        // remove all db
        Map context = getServiceContext();

        CWork.manager.remove(context);
        CTask.manager.remove(context);
        CProject.manager.remove(context);
        CProjectMember.manager.remove(context);
        CProjectMemberRole.manager.remove(context);
    }

    public void loadData() throws SystemException, PortalException {
        Map context = getServiceContext();

        // adding new objects
        CProject project1 = new CProject(1, context);
        CProject project2 = new CProject(2, context);
        CProject project3 = new CProject(3, context);
        project1.setValues(map("title", "Project 1", "groupId", 1, "companyId", 1, "startDate", "2013-04-05", "status", 1));
        project2.setValues(map("title", "Project 2", "groupId", 1, "companyId", 1, "startDate", "2013-04-03", "status", 2));
        project3.setValues(map("title", "Project 3", "groupId", 1, "companyId", 1, "startDate", "2013-04-04", "status", 1));
        project1.save();
        project2.save();
        project3.save();

        CUser user = CUser.cls.get(10196, context);
        CTask task1 = new CTask(1, context);
        CTask task2 = new CTask(2, context);
        CTask task3 = new CTask(3, context);
        task1.setValues(map("subject", "Design", "groupId", 1, "companyId", 1, "project", project1, "worker", user, "owner", user));
        task2.setValues(map("subject", "Design", "groupId", 1, "companyId", 1, "project", project2, "worker", user, "owner", user));
        task3.setValues(map("subject", "Testing", "groupId", 1, "companyId", 1, "project", project1, "worker", user, "owner", user));
        task1.save();
        task2.save();
        task3.save();

    }

    /**
     * Clearing data test
     */
    public void test1() throws SystemException, PortalException {
        System.out.println("** Test1: Clearing data test");

        Map context = getServiceContext();

        clearData();
        // checking
        check(CWork.cls.count(context) == 0);
        check(CTask.cls.count(context) == 0);
        check(CProject.cls.count(context) == 0);
        check(CProjectMember.cls.count(context) == 0);
        check(CProjectMemberRole.cls.count(context) == 0);
    }

    /**
     *  Object creation test
     */
    public void test2() throws SystemException, PortalException {
        System.out.println("** Test2: Object creation test");

        clearData();
        loadData();
    }

    /**
     * Selection test
     */
    public void test3() throws SystemException, PortalException {
        System.out.println("** Test3: Object selection test");
        Map context = getServiceContext();

        clearData();
        loadData();

        // get testing
        CProject.cls.get(1, context).getTitle().equals("Project 1");
        CTask.cls.get(1, context).getProject().getTitle().equals("Project 1");

        // filter
        check(CProject.cls.select(map("status", 1)).list(context).size() == 2);
        check(CProject.cls.select(map("status", 2)).<CProject>one(context).getTitle().equals("Project 2"));
        check(CTask.cls.select(map("project", CProject.cls.get(1, context))).<CTask>list(context).size() == 2);
        check(CTask.cls.select(map("project.title__like", "Pro%2")).<CTask>list(context).size() == 1);
        check(CTask.cls.select(map("project.projectId", 3)).<CTask>list(context).size() == 0);
    }

    /**
     * Sub query test
     */
    public void test4() throws SystemException, PortalException {
        System.out.println("** Test4: Sub Query test");
        Map context = getServiceContext();

        clearData();
        loadData();

        check(CTask.cls.select(map("project", CProject.cls.select().field("projectId")
                .filter(map("title__like", "%1")))).<CTask>list(context).size() == 2);
    }


    private void check(boolean value) throws PortalException {
        if (value) {
            return;
        } else {
            throw new PortalException("Value is false!!!");
        }
    }

    private Map getServiceContext() {
        return map(
                "WLTask", map("persistence", wlTaskPersistence, "service", wlTaskLocalService, "finder", null),
                "WLEntry", map("persistence", wlEntryPersistence, "service", wlEntryLocalService, "finder", null),
                "WLProject", map("persistence", wlProjectPersistence, "service", wlProjectLocalService, "finder", null),
                "WLProjectUser", map("persistence", wlProjectUserPersistence, "service", wlProjectUserLocalService, "finder", null),
                "WLProjectUserRole", map("persistence", wlProjectUserRolePersistence, "service", wlProjectUserRoleLocalService, "finder", null),
                "WLEventLog", map("persistence", wlEventLogPersistence, "service", wlEventLogLocalService, "finder", null),
                "User", map("persistence", userPersistence, "service", userLocalService, "finder", null)
        );
    }
}