
let ListFeedback = []
$(document).ready(async function () {
    await loadDataFeedback();
    createTableFeedback(ListFeedback);

    // Thêm lắng nghe sự kiện cho mỗi hàng
    $('#feedback-table').on('click', 'tr', function() {
        // Lấy dữ liệu hàng
        const rowData = ListFeedback[$(this).index() ];

        // Đổ dữ liệu hàng vào các trường form
        document.getElementById('feedbackId').value = rowData.feedbackId;
        document.getElementById('userId').value = rowData.accountE.userId;
        document.getElementById('comment').value = rowData.comment;
    });
});

function createTableFeedback(addToTable) {
    let bodyTableListFeedbackString = '<form id="feedback-form">';
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
        let response = await axios.get(`/home/feedback-api/getAllFeedback`);
        ListFeedback = response.data.data;
        console.log(ListFeedback);
    } catch (error) {
        console.error(error);
    }
}
