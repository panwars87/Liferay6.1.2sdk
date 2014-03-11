create table Inventory_Manufacturer (
	manufId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	name VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	website VARCHAR(75) null,
	phoneNumber VARCHAR(75) null
);

create table Inventory_Parts (
	partId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	manufId LONG,
	name STRING null,
	partNumber VARCHAR(75) null,
	reorderDate DATE null,
	quantity INTEGER
);