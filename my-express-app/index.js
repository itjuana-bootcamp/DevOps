const express = require('express');
const app = express();
const port = process.env.PORT || 3000;

// Define a route
app.get('/', (req, res) => {
  res.send('Hello ITJers and happy Friday!');
});

// Start the server
if (require.main === module) {
  app.listen(port, () => {
    console.log(`Server is listening at http://localhost:${port}`);
  });
}

module.exports = app; // Export the app object