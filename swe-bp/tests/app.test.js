const request = require('supertest');
const app = require('../index.js');

describe('GET /', () => {
    it('should respond with Hello, ITJaguars', async () => {
        const response = await request(app).get('/');
        expect(response.statusCode).toBe(200);
        expect(response.text).toBe('Hello, ITJaguars');
    });
});

describe('GET /nonexistent', () => {
    it('should respond with 404', async () => {
        const response = await request(app).get('/nonexistent');
        expect(response.statusCode).toBe(404);
    });
});