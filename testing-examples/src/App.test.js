import { render, screen } from '@testing-library/react';
import App from './App';

test('Feature 1 💀', () => {
  render(<App />);
  const linkElement = screen.getByText(/Feature 1 💀/i);
  expect(linkElement).toBeInTheDocument();
});

// test('Feature 2 👾', () => {
//   render(<App />);
//   const linkElement = screen.getByText(/Feature 2 👾/i);
//   expect(linkElement).toBeInTheDocument();
// });

// test('Feature 3 👽', () => {
//   render(<App />);
//   const linkElement = screen.getByText(/Feature 3 👽/i);
//   expect(linkElement).toBeInTheDocument();
// });


// test('Feature 4 🤖', () => {
//   render(<App />);
//   const linkElement = screen.getByText(/Feature 4 🤖/i);
//   expect(linkElement).toBeInTheDocument();
// });


// test('Feature 5 💩', () => {
//   render(<App />);
//   const linkElement = screen.getByText(/Feature 5 💩/i);
//   expect(linkElement).toBeInTheDocument();
// });

// test('Feature 6 👀', () => {
//   render(<App />);
//   const linkElement = screen.getByText(/Feature 5 👀/i);
//   expect(linkElement).toBeInTheDocument();
// });
