create table SB_SAuthor (
	authorId LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null
);

create table SB_SBook (
	bookId LONG not null primary key,
	libraryId LONG,
	title VARCHAR(75) null
);

create table SB_SLibrary (
	libraryId LONG not null primary key,
	name VARCHAR(75) null,
	address VARCHAR(75) null
);

create table SB_SMember (
	memberId LONG not null primary key,
	libraryId LONG,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null
);

create table SB_STransaction (
	transactionId LONG not null primary key,
	bookId LONG,
	memberId LONG,
	tdate DATE null
);