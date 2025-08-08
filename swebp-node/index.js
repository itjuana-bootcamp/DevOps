const express = require('express')
const app = express();
const port = process.env.PORT || 3000;

app.get('/', (req, res) => {
    res.send('Hello ITJ')
})

if (require.main === module) {
    app.listen(port, () => {
        console.log(`Server is listening at http://localhost:${port}`)
    })
}

module.exports = app;