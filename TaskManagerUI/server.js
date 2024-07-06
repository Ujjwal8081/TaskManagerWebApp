const express = require('express');
const cors = require('cors');
const path = require('path'); // Node.js module for working with file and directory paths
const app = express();
const PORT = 8080;

// Enable CORS for all requests
app.use(cors());

// Serve static files from the project directory
app.use(express.static(path.join(__dirname, '/')));

// Serve taskManager.html specifically
app.get('/taskManager.html', (req, res) => {
  res.sendFile(path.join(__dirname, 'taskManager.html'));
});

// Handle root URL ("/") by serving taskManager.html
app.get('/', (req, res) => {
  res.redirect('/taskManager.html');
});

// Start server
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
