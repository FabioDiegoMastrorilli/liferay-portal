export default function({
	namespace
}) {
    const form = document.getElementById(`${namespace}fm`);

    function fulfillCommerceChannelIds() {
        const values = Liferay.Util.listCheckedExcept(
            form,
            `${namespace}allRowIds`
        );
    
        form[`${namespace}commerceChannelIds`].value = values;
    }

    fulfillCommerceChannelIds();

    document.querySelectorAll('.channel-id-input').forEach(input => {
        input.addEventListener('change', fulfillCommerceChannelIds)
    })
}

