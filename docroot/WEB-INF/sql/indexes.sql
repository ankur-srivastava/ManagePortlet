create index IX_17972F7F on AL_AdCategory (categoryStatus);

create index IX_CD01A432 on AL_AdCity (cityName);
create index IX_74224299 on AL_AdCity (cityStatus);
create index IX_EAC9AEA1 on AL_AdCity (popular);

create index IX_CEC69873 on AL_AdCountry (countryStatus);

create index IX_5DA0940B on AL_AdListing (adCatId);
create index IX_FF6B8CE8 on AL_AdListing (adCatId, adCityId);
create index IX_33903334 on AL_AdListing (adCatId, adCityId, adServiceType);
create index IX_3CC510 on AL_AdListing (adCityId);
create index IX_86314289 on AL_AdListing (adServiceType);
create index IX_B70BD36D on AL_AdListing (userId);
create index IX_B3C0BC2B on AL_AdListing (userId, groupId, companyId);

create index IX_86AB4A38 on AL_AdResponseTracker (adId);
create index IX_F0B2BBE0 on AL_AdResponseTracker (userId);