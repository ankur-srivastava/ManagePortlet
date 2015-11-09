create table AL_AdCategory (
	categoryId LONG not null primary key,
	categoryName VARCHAR(75) null,
	categoryStatus BOOLEAN,
	createdDate DATE null
);

create table AL_AdCity (
	cityId LONG not null primary key,
	cityName VARCHAR(75) null,
	stateName VARCHAR(75) null,
	cityStatus BOOLEAN,
	popular BOOLEAN,
	createdDate DATE null
);

create table AL_AdCountry (
	countryId LONG not null primary key,
	countryName VARCHAR(75) null,
	countryStatus BOOLEAN,
	createdDate DATE null
);

create table AL_AdListing (
	adId LONG not null primary key,
	adTitle VARCHAR(150) null,
	adDescription STRING null,
	adCatId LONG,
	adServiceType VARCHAR(75) null,
	adCountryId LONG,
	adCityId LONG,
	userId LONG,
	adUserName VARCHAR(75) null,
	adUserEmail VARCHAR(75) null,
	adUserPhone VARCHAR(75) null,
	adStatus BOOLEAN,
	createdDate DATE null,
	modifiedDate DATE null,
	companyId LONG,
	groupId LONG
);

create table AL_AdResponseTracker (
	artId LONG not null primary key,
	adId LONG,
	userId LONG,
	name VARCHAR(75) null,
	email VARCHAR(75) null,
	phone VARCHAR(75) null,
	comments STRING null,
	userIP VARCHAR(75) null,
	createdDate DATE null
);

create table AL_AdStatsTracker (
	adId LONG not null primary key,
	adCount LONG,
	createdDate DATE null,
	lastAccessedDate DATE null
);