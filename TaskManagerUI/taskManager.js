
$(document).ready(function() {
    var table = $('#myTable').DataTable({
        ajax: {
            url: 'http://localhost:2323/taskManager/getAllTasks',
            dataSrc: ''
        },
        columns: [
            { data: 'id', title: 'ID' },
            { data: 'title', title: 'Title' },
            { data: 'description', title: 'Description' },
            { data: 'createdAt', title: 'Created At' },
            { data: 'completed', title: 'Completed' }
        ],

        paging: true,
        searching: true,
        ordering: true,
        // Customization example:
        language: {
            emptyTable: "No data available in table"
        },
        // Handle loading message
        initComplete: function () {
            $('#loadingMessage').hide();
        }
    });
});

