# Quail server

This is a simple node express REST api for testing purpuses.

# Setup

Make sure you have `node` and `yarn` installed, then run to following commands in the servers root directory.

- `yarn install`

# Development

- `yarn start:dev` to pack and start server.
- `yarn run:dev` to run instantly.

The server will listen on port `3000` by default.

# Test

To execute the unit tests run this command.

- `yarn test`

# Production build

Run this command the pack and minify everything into a single js file. The final output will be at `build/index.js`.
- `yarn webpack`

 You can run this in production environment with the following command.

- `node index.js`
