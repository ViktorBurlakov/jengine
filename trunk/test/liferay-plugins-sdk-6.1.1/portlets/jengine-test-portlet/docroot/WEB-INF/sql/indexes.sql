create index IX_DF74B317 on WL_WLEntry (entryDate);
create index IX_DB2B862D on WL_WLEntry (taskId);
create index IX_586A3 on WL_WLEntry (taskId, entryDate);

create index IX_3B8C7DCA on WL_WLProject (groupId);
create index IX_259E41E on WL_WLProject (groupId, companyId);
create index IX_EF998EC4 on WL_WLProject (groupId, companyId, automaticallyAssign);
create index IX_F063D52A on WL_WLProject (groupId, companyId, defaultProject);
create index IX_15995428 on WL_WLProject (title);

create index IX_ABD0A85B on WL_WLProjectUser (groupId, companyId, projectId);
create index IX_707C9403 on WL_WLProjectUser (groupId, companyId, userId);
create index IX_387640E1 on WL_WLProjectUser (groupId, companyId, userId, projectId);
create index IX_F192F8D9 on WL_WLProjectUser (projectId);
create index IX_62DA6813 on WL_WLProjectUser (projectId, userId);
create index IX_15BA4445 on WL_WLProjectUser (userId);

create index IX_9AF7BAC4 on WL_WLProjectUserRole (groupId, companyId, roleId);
create index IX_14279EE on WL_WLProjectUserRole (projectUserId);
create index IX_F9144B53 on WL_WLProjectUserRole (projectUserId, roleId);
create index IX_EED49206 on WL_WLProjectUserRole (roleId);

create index IX_8958F7F2 on WL_WLTask (ownerId, groupId, companyId);
create index IX_4D92C1AA on WL_WLTask (ownerId, groupId, companyId, subject);
create index IX_314FCA4D on WL_WLTask (ownerId, groupId, companyId, subject, externalId, projectId, workerId);
create index IX_B094D4DA on WL_WLTask (ownerId, groupId, companyId, subject, projectId);
create index IX_82653247 on WL_WLTask (ownerId, groupId, companyId, subject, projectId, workerId);
create index IX_95BD5B17 on WL_WLTask (ownerId, groupId, companyId, subject, workerId);
create index IX_394F60C5 on WL_WLTask (subject, workerId, projectId);