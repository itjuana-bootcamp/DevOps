const request = require('supertest');
const app = require('../index');

describe('GET /', () => {
  test('It should respond with: Hello and happy Friday!', async () => {
    const response = await request(app).get('/');
    expect(response.status).toBe(200);
    expect(response.text).toBe('Hello and happy Friday!');
  });
});
