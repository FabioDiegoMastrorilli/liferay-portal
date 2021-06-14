export default function({
	companyId,
	countryTwoLettersISOCode,
	commerceRegionCode,
	namespace
}) {
	new Liferay.DynamicSelect([
		{
			select: `${namespace}countryTwoLettersISOCode`,
			selectData: (callback) => {
				Liferay.Service(
					'/country/get-company-countries',
					{
						active: true,
						companyId,
					},
					callback
				);
			},
			selectDesc: 'nameCurrentValue',
			selectId: 'a2',
			selectSort: true,
			selectVal: countryTwoLettersISOCode,
		},
		{
			select: `${namespace}commerceRegionCode`,
			selectData: (callback, selectKey) => {
				Liferay.Service(
					'/region/get-regions',
					{
						a2: selectKey,
						active: true,
						companyId,
					},
					callback
				);
			},
			selectDesc: 'name',
			selectId: 'regionCode',
			selectVal: commerceRegionCode,
		},
	]);
}
