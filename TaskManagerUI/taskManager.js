
document.addEventListener("DOMContentLoaded", function() {
    // Define Tabulator columns
    var tableColumns = [
        { title: "ID", field: "id" },
        { title: "Title", field: "title" },
        { title: "Description", field: "description" },
        { title: "Created At", field: "createdAt" },
        { title: "Completed", field: "completed", formatter: "tickCross" },
        { title: "TaskNote", field: "taskNote" }
    ];

    // Initialize Tabulator
    var table = new Tabulator("#example-table", {
        columns: tableColumns,
        layout: "fitColumns",
        placeholder: "Loading data...", // Optional loading message
        ajaxURL: "http://localhost:2323/taskManager/getAllTasks", // Your backend API URL
        ajaxConfig: "GET", // HTTP method (GET by default)
        ajaxParams: {}, // Optional additional parameters for the API request
        ajaxContentType: "json", // Content type for AJAX request
        ajaxResponse: function(url, params, response) { // Process the data returned by the server
            return response; // Assume response is already in the correct format
        },
        ajaxError: function(error) { // Handle AJAX error
            console.error("Error fetching data:", error);
        }
    });
});
