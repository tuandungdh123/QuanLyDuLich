
let ListFeedback = []
$(document).ready(async function () {
    await loadDataFeedback();
    createTableFeedback(ListFeedback);
});
function createTableFeedback(addToTable) {
    let bodyTableListFeedbackString = '<table id="feedback-table">';
    addToTable.forEach(function (e, index) {
        bodyTableListFeedbackString +=
            `<tr>` +
            `<td>${index + 1}</td>` +
            `<td>${e.accountE.userId}</td>` +
            `<td>${e.comment}</td>` +
            `</tr>`;
    });
    bodyTableListFeedbackString += '</table>';
    $("#feedback-table").html(bodyTableListFeedbackString);
}

async function loadDataFeedback() {
    try {
        let response = await axios.get(`/feedback-api/getAllFeedback`);
        ListFeedback = response.data.data;
        console.log(ListFeedback);
    } catch (error) {
        console.error(error);
    }
}
