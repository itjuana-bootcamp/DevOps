const request = require('supertest');
const app = require('../index');

describe('GET /', () => {
  test('It should respond with "Hello, World!"', async () => {
    const response = await request(app).get('/');
    expect(response.status).toBe(200);
    expect(response.text).toBe('Hello, World!');
  });
});

// Clean up the Jest cache after each test
afterEach(() => {
    jest.resetModules();
  });