create index IX_E2B60C14 on FragmentCollection (groupId, ctCollectionId);
create unique index IX_7FA4CEC9 on FragmentCollection (groupId, fragmentCollectionKey[$COLUMN_LENGTH:75$], ctCollectionId);
create index IX_4F415D53 on FragmentCollection (groupId, name[$COLUMN_LENGTH:75$], ctCollectionId);
create index IX_B34B88C6 on FragmentCollection (uuid_[$COLUMN_LENGTH:75$], companyId, ctCollectionId);
create index IX_F197401E on FragmentCollection (uuid_[$COLUMN_LENGTH:75$], ctCollectionId);
create unique index IX_3244548 on FragmentCollection (uuid_[$COLUMN_LENGTH:75$], groupId, ctCollectionId);

create index IX_A86D5F3B on FragmentComposition (fragmentCollectionId, ctCollectionId);
create index IX_6588F8A8 on FragmentComposition (groupId, ctCollectionId);
create index IX_5F3FEBA5 on FragmentComposition (groupId, fragmentCollectionId, ctCollectionId);
create index IX_50F8C24 on FragmentComposition (groupId, fragmentCollectionId, name[$COLUMN_LENGTH:75$], ctCollectionId);
create index IX_1918190A on FragmentComposition (groupId, fragmentCollectionId, name[$COLUMN_LENGTH:75$], status, ctCollectionId);
create index IX_5EF5678B on FragmentComposition (groupId, fragmentCollectionId, status, ctCollectionId);
create unique index IX_3F7591A1 on FragmentComposition (groupId, fragmentCompositionKey[$COLUMN_LENGTH:75$], ctCollectionId);
create index IX_2B7782B2 on FragmentComposition (uuid_[$COLUMN_LENGTH:75$], companyId, ctCollectionId);
create index IX_C3A441B2 on FragmentComposition (uuid_[$COLUMN_LENGTH:75$], ctCollectionId);
create unique index IX_B39DCA34 on FragmentComposition (uuid_[$COLUMN_LENGTH:75$], groupId, ctCollectionId);

create index IX_18964A03 on FragmentEntry (fragmentCollectionId, ctCollectionId);
create index IX_3E323417 on FragmentEntry (fragmentCollectionId, head, ctCollectionId);
create index IX_C25228E0 on FragmentEntry (groupId, ctCollectionId);
create index IX_96DEA1DD on FragmentEntry (groupId, fragmentCollectionId, ctCollectionId);
create index IX_30ABC071 on FragmentEntry (groupId, fragmentCollectionId, head, ctCollectionId);
create index IX_CEAAB85C on FragmentEntry (groupId, fragmentCollectionId, name[$COLUMN_LENGTH:75$], ctCollectionId);
create index IX_66C6BBB0 on FragmentEntry (groupId, fragmentCollectionId, name[$COLUMN_LENGTH:75$], head, ctCollectionId);
create index IX_49BF8D42 on FragmentEntry (groupId, fragmentCollectionId, name[$COLUMN_LENGTH:75$], status, ctCollectionId);
create index IX_72C5CC16 on FragmentEntry (groupId, fragmentCollectionId, name[$COLUMN_LENGTH:75$], status, head, ctCollectionId);
create index IX_2E7665C3 on FragmentEntry (groupId, fragmentCollectionId, status, ctCollectionId);
create index IX_60FE7FD7 on FragmentEntry (groupId, fragmentCollectionId, status, head, ctCollectionId);
create index IX_2A7A0DD4 on FragmentEntry (groupId, fragmentCollectionId, type_, ctCollectionId);
create index IX_A8EE1728 on FragmentEntry (groupId, fragmentCollectionId, type_, head, ctCollectionId);
create index IX_9F7DEABA on FragmentEntry (groupId, fragmentCollectionId, type_, status, ctCollectionId);
create index IX_71762F8E on FragmentEntry (groupId, fragmentCollectionId, type_, status, head, ctCollectionId);
create index IX_67941F11 on FragmentEntry (groupId, fragmentEntryKey[$COLUMN_LENGTH:75$], ctCollectionId);
create unique index IX_F5386A5 on FragmentEntry (groupId, fragmentEntryKey[$COLUMN_LENGTH:75$], head, ctCollectionId);
create index IX_C1D0B934 on FragmentEntry (groupId, head, ctCollectionId);
create unique index IX_A7F77355 on FragmentEntry (headId, ctCollectionId);
create index IX_5615117A on FragmentEntry (uuid_[$COLUMN_LENGTH:75$], companyId, ctCollectionId);
create index IX_7445464E on FragmentEntry (uuid_[$COLUMN_LENGTH:75$], companyId, head, ctCollectionId);
create index IX_D2EC1FEA on FragmentEntry (uuid_[$COLUMN_LENGTH:75$], ctCollectionId);
create index IX_4606AFC on FragmentEntry (uuid_[$COLUMN_LENGTH:75$], groupId, ctCollectionId);
create unique index IX_E5D3F650 on FragmentEntry (uuid_[$COLUMN_LENGTH:75$], groupId, head, ctCollectionId);
create index IX_6FD3C0BE on FragmentEntry (uuid_[$COLUMN_LENGTH:75$], head, ctCollectionId);

create index IX_6AFFBB89 on FragmentEntryLink (fragmentEntryId, ctCollectionId);
create index IX_932B7FDB on FragmentEntryLink (groupId, classNameId, classPK, ctCollectionId);
create index IX_7AB5A586 on FragmentEntryLink (groupId, ctCollectionId);
create index IX_B7BFD778 on FragmentEntryLink (groupId, fragmentEntryId, classNameId, classPK, ctCollectionId);
create index IX_4C1EB947 on FragmentEntryLink (groupId, fragmentEntryId, classNameId, ctCollectionId);
create index IX_25790E3 on FragmentEntryLink (groupId, fragmentEntryId, ctCollectionId);
create index IX_1A46116E on FragmentEntryLink (groupId, fragmentEntryId, plid, ctCollectionId);
create index IX_7D730C77 on FragmentEntryLink (groupId, originalFragmentEntryLinkId, plid, ctCollectionId);
create index IX_FF5CDFD1 on FragmentEntryLink (groupId, plid, ctCollectionId);
create index IX_56DF5B4 on FragmentEntryLink (groupId, segmentsExperienceId, classNameId, classPK, ctCollectionId);
create index IX_BB1027AA on FragmentEntryLink (groupId, segmentsExperienceId, plid, ctCollectionId);
create index IX_95663C5E on FragmentEntryLink (groupId, segmentsExperienceId, plid, rendererKey[$COLUMN_LENGTH:200$], ctCollectionId);
create index IX_28F091A8 on FragmentEntryLink (rendererKey[$COLUMN_LENGTH:200$], ctCollectionId);
create index IX_577C6F94 on FragmentEntryLink (uuid_[$COLUMN_LENGTH:75$], companyId, ctCollectionId);
create index IX_83328E10 on FragmentEntryLink (uuid_[$COLUMN_LENGTH:75$], ctCollectionId);
create unique index IX_145C8796 on FragmentEntryLink (uuid_[$COLUMN_LENGTH:75$], groupId, ctCollectionId);

create index IX_646748B7 on FragmentEntryVersion (fragmentCollectionId, ctCollectionId);
create index IX_DC8A5E2D on FragmentEntryVersion (fragmentCollectionId, version, ctCollectionId);
create index IX_E487E5AF on FragmentEntryVersion (fragmentEntryId, ctCollectionId);
create unique index IX_E87ED835 on FragmentEntryVersion (fragmentEntryId, version, ctCollectionId);
create index IX_64C555AC on FragmentEntryVersion (groupId, ctCollectionId);
create index IX_36EEEDA9 on FragmentEntryVersion (groupId, fragmentCollectionId, ctCollectionId);
create index IX_BD8DFB28 on FragmentEntryVersion (groupId, fragmentCollectionId, name[$COLUMN_LENGTH:75$], ctCollectionId);
create index IX_70C9440E on FragmentEntryVersion (groupId, fragmentCollectionId, name[$COLUMN_LENGTH:75$], status, ctCollectionId);
create index IX_342834B6 on FragmentEntryVersion (groupId, fragmentCollectionId, name[$COLUMN_LENGTH:75$], status, version, ctCollectionId);
create index IX_5336DADC on FragmentEntryVersion (groupId, fragmentCollectionId, name[$COLUMN_LENGTH:75$], version, ctCollectionId);
create index IX_F194258F on FragmentEntryVersion (groupId, fragmentCollectionId, status, ctCollectionId);
create index IX_9C0C7455 on FragmentEntryVersion (groupId, fragmentCollectionId, status, version, ctCollectionId);
create index IX_17FF2488 on FragmentEntryVersion (groupId, fragmentCollectionId, type_, ctCollectionId);
create index IX_59AB0D6E on FragmentEntryVersion (groupId, fragmentCollectionId, type_, status, ctCollectionId);
create index IX_FDC2F756 on FragmentEntryVersion (groupId, fragmentCollectionId, type_, status, version, ctCollectionId);
create index IX_868E3D7C on FragmentEntryVersion (groupId, fragmentCollectionId, type_, version, ctCollectionId);
create index IX_EBC8297B on FragmentEntryVersion (groupId, fragmentCollectionId, version, ctCollectionId);
create index IX_9FDA30DD on FragmentEntryVersion (groupId, fragmentEntryKey[$COLUMN_LENGTH:75$], ctCollectionId);
create unique index IX_32C340C7 on FragmentEntryVersion (groupId, fragmentEntryKey[$COLUMN_LENGTH:75$], version, ctCollectionId);
create index IX_A18314D8 on FragmentEntryVersion (groupId, version, ctCollectionId);
create index IX_EF98A2E on FragmentEntryVersion (uuid_[$COLUMN_LENGTH:75$], companyId, ctCollectionId);
create index IX_2A14D296 on FragmentEntryVersion (uuid_[$COLUMN_LENGTH:75$], companyId, version, ctCollectionId);
create index IX_619C0FB6 on FragmentEntryVersion (uuid_[$COLUMN_LENGTH:75$], ctCollectionId);
create index IX_C5B380B0 on FragmentEntryVersion (uuid_[$COLUMN_LENGTH:75$], groupId, ctCollectionId);
create unique index IX_937B0E54 on FragmentEntryVersion (uuid_[$COLUMN_LENGTH:75$], groupId, version, ctCollectionId);
create index IX_9C7C060E on FragmentEntryVersion (uuid_[$COLUMN_LENGTH:75$], version, ctCollectionId);