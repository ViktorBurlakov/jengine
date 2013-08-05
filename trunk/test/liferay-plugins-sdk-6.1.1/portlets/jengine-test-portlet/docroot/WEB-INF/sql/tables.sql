create table WL_WLEntry (
	entryId LONG not null primary key,
	createUserId LONG,
	createUserName VARCHAR(75) null,
	createDate DATE null,
	modifiedUserId LONG,
	modifiedUserName VARCHAR(75) null,
	modifiedDate DATE null,
	start_ DATE null,
	startTime LONG,
	finishTime LONG,
	entryDate DATE null,
	entryTime LONG,
	timezone INTEGER,
	length LONG,
	taskId LONG
);

create table WL_WLEventLog (
	groupId LONG,
	companyId LONG,
	eventLogId LONG not null primary key,
	userId LONG,
	logDate DATE null,
	event VARCHAR(75) null,
	title VARCHAR(75) null,
	modelName VARCHAR(75) null,
	modelPK LONG,
	description VARCHAR(75) null
);

create table WL_WLProject (
	projectId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createUserId LONG,
	createUserName VARCHAR(75) null,
	createDate DATE null,
	modifiedUserId LONG,
	modifiedUserName VARCHAR(75) null,
	modifiedDate DATE null,
	startDate DATE null,
	title VARCHAR(75) null,
	status INTEGER,
	description VARCHAR(75) null,
	color VARCHAR(75) null,
	lockEnable BOOLEAN,
	lockPeriodType VARCHAR(75) null,
	lockDeferment INTEGER,
	automaticallyAssign BOOLEAN,
	defaultProject BOOLEAN,
	externalUrl VARCHAR(75) null,
	externalMandatory BOOLEAN
);

create table WL_WLProjectUser (
	groupId LONG,
	companyId LONG,
	projectUserId LONG not null primary key,
	userId LONG,
	projectId LONG
);

create table WL_WLProjectUserRole (
	groupId LONG,
	companyId LONG,
	projectUserRoleId LONG not null primary key,
	projectUserId LONG,
	roleId LONG
);

create table WL_WLTask (
	taskId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createUserId LONG,
	createUserName VARCHAR(75) null,
	createDate DATE null,
	modifiedUserId LONG,
	modifiedUserName VARCHAR(75) null,
	modifiedDate DATE null,
	subject VARCHAR(75) null,
	projectId LONG,
	ownerId LONG,
	workerId LONG,
	externalId VARCHAR(75) null
);

create table WL_WLTaskOption (
	optionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createUserId LONG,
	createUserName VARCHAR(75) null,
	createDate DATE null,
	modifiedUserId LONG,
	modifiedUserName VARCHAR(75) null,
	modifiedDate DATE null,
	taskId LONG,
	name VARCHAR(75) null,
	data_ VARCHAR(75) null
);